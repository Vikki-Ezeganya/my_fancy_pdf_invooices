package com.vikki.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    public String handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        return "Sorry, that was not quite right: " + exception.getMessage();
    }


    public String handleConstraintViolation(ConstraintViolationException exception) {
        return "Sorry, that was not quite right: " +  exception.getMessage();
    }

}
