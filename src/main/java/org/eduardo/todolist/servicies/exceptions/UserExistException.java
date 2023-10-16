package org.eduardo.todolist.servicies.exceptions;

public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}
