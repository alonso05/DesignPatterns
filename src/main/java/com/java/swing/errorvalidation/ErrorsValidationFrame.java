package com.java.swing.errorvalidation;

import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorsValidationFrame extends JFrame{

	private LoginPanel panelLogin;
	protected Container pane;
	protected CardLayout layout;

	public ErrorsValidationFrame(ErrorsValidationController baseController){
		
		panelLogin = new LoginPanel(this, baseController);
		setupFrame();
		
	}

	private void setupFrame() {

		this.setSize(500,500);
		this.setVisible(true);
		this.setBounds(500, 500, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.getContentPane().setLayout(null);
		
		//lblUser = new JLabel("User");
		//lblUser.setBounds(75, 55, 46, 14);
		//frame.getContentPane().add(lblUser);
	}
}
