package org.eduardo.todolist.repositories;

import java.util.List;
import java.util.UUID;

import org.eduardo.todolist.models.TaskModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaksRepository extends JpaRepository<TaskModel, UUID>{
    List<TaskModel> findByIdUser(UUID uuid);
}
