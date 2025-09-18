package com.example.demo.exception;

public class CPFException extends RuntimeException {

	private static final long serialVersionUID = -8043658891548599406L;

	public CPFException(String message) {
        super(message);
    }
}