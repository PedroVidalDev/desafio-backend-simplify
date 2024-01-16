package com.pedro.simplify.infrastructure.exceptions;

public class TaskValidation extends RuntimeException{
    public TaskValidation(String s){
        super(s);
    }
}
