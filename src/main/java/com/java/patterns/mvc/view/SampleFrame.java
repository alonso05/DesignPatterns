package com.java.patterns.mvc.view;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.java.patterns.mvc.controller.SampleAppController;

public class SampleFrame extends JFrame {
	//private SamplePanel basePanel;
	protected UpdateWWpanel basePanel;
	protected LoadValuesPanel fetchPanel;
	// so my actionPerformed can reference me
	protected Container pane;
	protected CardLayout layout;

	/**
	 * Create a SampleFrame object passing a reference to the AppController for use by the SampleFrame object
	 * @param baseController The reference to the AppController
	 */
	public SampleFrame(SampleAppController baseController){
		//basePanel = new SamplePanel(baseController);
		basePanel = new UpdateWWpanel(baseController);
		fetchPanel = new LoadValuesPanel(baseController);
		setupFrame();
	}
	/*
	 * Set the content pane, size, and makes it visible
	 */
	private void setupFrame(){
		//this.setContentPane(basePanel);
		layout = new CardLayout();
		setLayout(layout);
		this.pane = this.getContentPane();
		
		pane.add("basePanel", basePanel);
		pane.add("fetchPanel", fetchPanel);
		this.setSize(500,500);
		this.setVisible(true);
	}
}
