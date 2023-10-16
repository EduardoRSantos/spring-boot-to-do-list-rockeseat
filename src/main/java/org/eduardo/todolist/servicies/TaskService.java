package org.eduardo.todolist.servicies;

import org.eduardo.todolist.models.TaskModel;
import org.eduardo.todolist.repositories.TaksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    @Autowired
    private TaksRepository taskRepository;

    public TaskModel create(TaskModel taskModel) {
        return taskRepository.save(taskModel);
    }
}
