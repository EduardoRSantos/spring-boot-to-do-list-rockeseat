package org.eduardo.todolist.controllers.exceptions;

import java.time.Instant;

import org.eduardo.todolist.servicies.exceptions.DateTimeException;
import org.eduardo.todolist.servicies.exceptions.ExistException;
import org.eduardo.todolist.servicies.exceptions.NotFoudException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    

    @ExceptionHandler(ExistException.class)
    public ResponseEntity<StandarError> exists(ExistException e, HttpServletRequest request){

        String erro = "User Exist!";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarError err = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(NotFoudException.class)
    public ResponseEntity<StandarError> notFound(NotFoudException e, HttpServletRequest request){
        String erro = "Not Found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DateTimeException.class)
    public ResponseEntity<StandarError> notFound(DateTimeException e, HttpServletRequest request){
        String erro = "Incorrect date or time";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarError err = new StandarError(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }

}
