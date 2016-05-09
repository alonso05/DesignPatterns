package com.java.swing.errorvalidation;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ValidationTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ErrorHandler errorHandler = new ErrorHandler();
		Validator validator = new Validator(errorHandler);
		
		HashMap<String, HashMap<String, String>> rules = new HashMap<String, HashMap<String, String>>();
		
		HashMap<String, String> userRules = new HashMap<String, String>();
		userRules.put("required", "true");
		userRules.put("maxlength", "30");
		userRules.put("email", "true");
		
		HashMap<String, String> passwordRules = new HashMap<String, String>();
		passwordRules.put("required", "true");
		passwordRules.put("minlength", "3");
		
		rules.put("user", userRules);
		rules.put("password", passwordRules);
		
		
		HashMap<String, String> post = new HashMap<String, String>();
		post.put("user", "alonso05@gmail.com");
		post.put("password","a");
		
		if(validator.check(post, rules).fails())
			System.out.println("There are errors");
		else
			System.out.println("No errors");

	}

}
