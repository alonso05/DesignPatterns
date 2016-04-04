package com.java.patterns.mvc.controller;
/**
 * Runner Object for the MVC application
 * @author Alonso
 *
 */
public class SampleAppRunner {
	
	/**
	 * Main starter method or entry point
	 * @param args
	 */
	public static void main(String[] args) {
		SampleAppController baseApp = new SampleAppController();
		baseApp.start();
		
	}
	
}
