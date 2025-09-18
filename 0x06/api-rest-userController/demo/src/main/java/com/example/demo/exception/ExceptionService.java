package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserIdException err) {
        UserErrorResponse error = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), err.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNameException err) {
        UserErrorResponse error = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), err.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(CPFException err) {
        UserErrorResponse error = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), err.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}