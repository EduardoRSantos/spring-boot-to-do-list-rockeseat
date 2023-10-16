package org.eduardo.todolist.controllers;

import org.eduardo.todolist.models.TaskModel;
import org.eduardo.todolist.servicies.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaksController {
    
    @Autowired
    private TaskService service;

    @PostMapping("/")
    public ResponseEntity<TaskModel> create(@RequestBody TaskModel taskModel){
        var task = service.create(taskModel);
        return ResponseEntity.ok().body(task);
    }
}
