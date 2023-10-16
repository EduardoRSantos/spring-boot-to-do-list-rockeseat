package org.eduardo.todolist.controllers.exceptions;

import java.time.Instant;

import org.eduardo.todolist.servicies.exceptions.UserExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<StandarError> UserExist(UserExistException e, HttpServletRequest request){

        String erro = "User Exist!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarError err = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
