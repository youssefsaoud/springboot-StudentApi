package com.youssef.springboot_learning.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException(String message){
        super (message);
    }
}
