package com.java.swing.errorvalidation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	protected ErrorHandler errorHandler;
	protected HashMap<String, String> messages = new HashMap<String, String>();
	
	public Validator(ErrorHandler errorHandler){
		this.errorHandler = errorHandler;
		this.errorHandler.getErrors().put("uncategorized", new ArrayList<String>());
		messages.put("required", "The :field field is required");
		messages.put("minlength", "The :field field must be a minimum of :satisfier characters");
		messages.put("maxlength", "The :field field must be a maximum of :satisfier characters");
		messages.put("email", "This is not a valid email address");
	}
	
	public Validator check(HashMap<String, String> items, HashMap<String, HashMap<String, String>> rules) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		for(Map.Entry<String, String> item : items.entrySet()){
			System.out.printf("Key : %s and Value: %s %n", item.getKey(), item.getValue());
			HashMap<String, String> itemToValidate = new HashMap<String, String>();
			itemToValidate.put("field", item.getKey());
			itemToValidate.put("value", item.getValue());
			
			this.validate(itemToValidate, rules.get(item.getKey()));
		}
		return this;
	}
	
	public void validate(HashMap<String, String> item, HashMap<String, String> rules) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		String field = item.get("field");
		String value = item.get("value");
		
		for(Map.Entry<String, String> rule : rules.entrySet()){
			Method method = this.getClass().getDeclaredMethod(rule.getKey(), String.class, String.class, String.class);
			
			if(!errorHandler.getErrors().containsKey(field))
				errorHandler.getErrors().put(field, new ArrayList<String>());

			String satisfier = rule.getValue();
			if(!(Boolean) method.invoke(this, field, value, satisfier)){
				
				String msg = messages.get(rule.getKey()).replace(":field", field).replace(":satisfier", satisfier);
				System.out.println("Adding Error on field: " + field + " " + msg);
				errorHandler.addError(msg, field);
			}

		}
	}
	
	public boolean minlength(String field, String value, String satisfier){
		return(value.length()>=Integer.parseInt(satisfier));
	}
	
	public boolean maxlength(String field, String value, String satisfier){
		return(value.length()<=Integer.parseInt(satisfier));
	}
	
	public boolean required(String field, String value, String satisfier){
		if(Boolean.valueOf(satisfier))
			return(!value.isEmpty());
		else
			return value.isEmpty();
	}
	
	public boolean email(String field, String value, String satisfier){
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        Pattern p = java.util.regex.Pattern.compile(ePattern);
        Matcher m = p.matcher(value);
        boolean result = m.matches();
		if(Boolean.valueOf(satisfier)){
			return result;
		}
		else
			return !result;
	}
	
	public boolean fails(){
		return errorHandler.hasErrors();
	}
}
