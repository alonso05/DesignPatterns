package com.java.swing.errorvalidation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ErrorHandler {
	
	public HashMap<String, List<String>> errors = new HashMap<String, List<String>>();
	
	public HashMap<String, List<String>> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String, List<String>> errors) {
		this.errors = errors;
	}

	public void addError(String error, String key){
		if(key != null){
			errors.get(key).add(error);
		}
		else{
			errors.get("uncategorized").add(error);
		}
		
	}
	
	public boolean hasErrors(){
		return (this.all(null).size() > 0) ? true : false;
	}
	
	public boolean has(String key){
		return !errors.get(key).isEmpty();
	}
	
	public List<String> all(String key){
		if(key != null){
			return errors.get(key);
		}
		else{
			List<String> allErrors = new ArrayList<String>();
			for(Map.Entry<String, List<String>> error : errors.entrySet()){
				for(String msg : error.getValue()){
					allErrors.add(msg);
				}
			}
			return allErrors;
		}
	}
}
