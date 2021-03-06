package com.ChallengeJava.exception;

public class ClientNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID = 1L;

	public ClientNotFoundException() {
		super();
		
	}

	public ClientNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ClientNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ClientNotFoundException(String message) {
		super(message);
		
	}

	public ClientNotFoundException(Throwable cause) {
		super(cause);
		
	}

	
}
