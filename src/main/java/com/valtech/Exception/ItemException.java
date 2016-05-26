package com.valtech.Exception;

public class ItemException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemException(String msg) {
		super(msg);
	}

	public ItemException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
