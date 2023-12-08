package com.example.demo.exception;


public class StudenNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    public StudenNotFoundException(String message)
    {
    	super(message);
    }
}
