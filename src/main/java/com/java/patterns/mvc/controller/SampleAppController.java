package com.java.patterns.mvc.controller;

import com.java.patterns.mvc.model.MVCFactory;
import com.java.patterns.mvc.view.SampleFrame;

public class SampleAppController {
	
	private SampleFrame appFrame;
	private MVCFactory appFactory;
	
	public SampleAppController(){
		appFactory = new MVCFactory();
	}
	
	public MVCFactory getAppFactory(){
		return appFactory;
	}
	
	public SampleFrame getAppFrame(){
		return appFrame;
	}
	
	public void start(){
		appFrame = new SampleFrame(this);
	}
	
}
