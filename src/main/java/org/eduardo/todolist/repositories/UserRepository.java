package org.eduardo.todolist.repositories;

import java.util.UUID;

import org.eduardo.todolist.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<UserModel, UUID>{
    UserModel findByUsername(String username);
}
