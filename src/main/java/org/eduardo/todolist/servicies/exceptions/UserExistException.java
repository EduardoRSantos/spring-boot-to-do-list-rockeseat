package org.eduardo.todolist.servicies.exceptions;

import java.util.UUID;

public class UserExistException extends RuntimeException {

    public UserExistException(String message,UUID id) {
        super(message + " " + id);
    }
}
