package com.java.swing.errorvalidation;

public class ErrorsValidationController {
	
	protected ErrorsValidationFrame appFrame;
	
	public ErrorsValidationController(){
		
	}
	
	public void init(){
		 appFrame = new ErrorsValidationFrame(this);
	}
}
