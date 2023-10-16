package org.eduardo.todolist.controllers;

import org.eduardo.todolist.models.UserModel;
import org.eduardo.todolist.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserControler {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserModel> create(@RequestBody UserModel userModel){
        var user = userService.saveUser(userModel);
        return ResponseEntity.ok().body(user);
    }
    
}
