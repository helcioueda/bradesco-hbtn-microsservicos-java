package com.example.demo.exception;

public class UserIdException extends RuntimeException {


	private static final long serialVersionUID = 5727329807937055246L;

	public UserIdException(String message) {
        super(message);
    }
}