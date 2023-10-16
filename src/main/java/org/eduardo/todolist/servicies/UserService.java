package org.eduardo.todolist.servicies;

import org.eduardo.todolist.models.UserModel;
import org.eduardo.todolist.repositories.UserRepository;
import org.eduardo.todolist.servicies.exceptions.ExistException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService {
    

    @Autowired
    private UserRepository userRepository;

    public UserModel create(UserModel usercreated){
        var user = userRepository.findByUsername(usercreated.getUsername());
        if(user != null){
            throw new ExistException("Esse " + user.getId() + " ja existe");
        }
       var passowordHash =  BCrypt.withDefaults()
       .hashToString(12, usercreated
       .getPassword()
       .toCharArray());

       usercreated.setPassword(passowordHash);
       
        return userRepository.save(usercreated);
    }

}
