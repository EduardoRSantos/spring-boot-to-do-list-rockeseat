package org.eduardo.todolist.servicies;

import java.io.IOException;
import java.util.Base64;

import org.eduardo.todolist.repositories.UserRepository;
import org.eduardo.todolist.servicies.exceptions.NotFoudException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String servletPath = request.getServletPath();

        if (servletPath.startsWith("/tasks/")) {

            // TODO pegar a autenticação (usuario e senha)
            var authorization = request.getHeader("Authorization");

            // .trim() remove espaço.
            var authEncoded = authorization.substring("Basic".length()).trim();

            byte[] authDecoded = Base64.getDecoder().decode(authEncoded);

            // TODO pega a senha string.
            var authString = new String(authDecoded);
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];
            
            // TODO Validar usuário
            var user = userRepository.findByUsername(username);
            if (user == null) {

                throw new NotFoudException("Not found");

            } else {

                // validar senha
                var passowordVerify = BCrypt.verifyer().verify(
                        password.toCharArray(),
                        user.getPassword().toCharArray()
                    );
                if (passowordVerify.verified) {

                    // TODO seta no request o id do usuário pra que no controller ele ser utilizado.
                    request.setAttribute("idUser", user.getId());

                    // seguir em frente
                    filterChain.doFilter(request, response);

                } else {

                    response.sendError(401);

                }
            }
        } else {

            // seguir em frente
            filterChain.doFilter(request, response);

        }

    }

}
