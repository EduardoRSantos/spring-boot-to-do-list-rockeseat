package org.eduardo.todolist.controllers;

import java.util.List;
import java.util.UUID;

import org.eduardo.todolist.models.TaskModel;
import org.eduardo.todolist.servicies.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/tasks")
public class TaksController {

    @Autowired
    private TaskService TaskService;

    // Esta recuperando o id do usuário pelo request que foi setado no filter.
    @PostMapping("/")
    public ResponseEntity<TaskModel> create(@RequestBody TaskModel taskModel, HttpServletRequest request) {
        var task = TaskService.create(taskModel, request);
        return ResponseEntity.ok().body(task);
    }

    @GetMapping("/")
    public ResponseEntity<List<TaskModel>> getAll(HttpServletRequest request) {
        var tasks = TaskService.getAllTasks(request);
        return ResponseEntity.ok().body(tasks);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> update(@PathVariable UUID id, @RequestBody TaskModel taskModel,
            HttpServletRequest request) {
        var task = TaskService.update(id, taskModel);
        return ResponseEntity.ok().body(task);
    }
}
