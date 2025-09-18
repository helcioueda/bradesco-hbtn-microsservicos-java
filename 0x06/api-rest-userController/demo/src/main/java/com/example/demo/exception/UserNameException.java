package com.example.demo.exception;

public class UserNameException extends RuntimeException {

	private static final long serialVersionUID = 7553007180691160325L;

	public UserNameException(String message) {
        super(message);
    }
}