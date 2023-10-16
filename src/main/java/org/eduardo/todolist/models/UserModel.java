package org.eduardo.todolist.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/* Data incapsula todos os metodos
 * getters,
 * setters,
 * AllArgs,
 * Esquals&Hash
 */
@Data
@Entity(name = "tb_users")
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(unique = true)
    private String username;
    private String name;
    private String password;


    /**
     * Quanto for criado o user e salvo automaticament
     */
    @CreationTimestamp
    private LocalDateTime createdAt;
}
