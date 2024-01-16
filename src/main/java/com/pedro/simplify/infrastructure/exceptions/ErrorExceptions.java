package com.pedro.simplify.infrastructure.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorExceptions {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity entityNotFound(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity noSuchElement(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(TaskValidation.class)
    public ResponseEntity taskValidation(TaskValidation e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
