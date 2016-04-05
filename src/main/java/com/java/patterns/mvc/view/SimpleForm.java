package com.java.patterns.mvc.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.patterns.mvc.controller.SampleAppController;

public class SimpleForm extends JPanel{
		private SampleAppController baseController;
		private JLabel nameLabel, userLabel, emailLabel;
		private JTextField nameField, userField, emailField;
		private JButton btnSignUp;
		
		public SimpleForm(SampleAppController baseController){
			this.baseController = baseController;
			
			nameLabel = new JLabel("Name: ");
			userLabel = new JLabel("User");
			emailLabel = new JLabel("Email");
			nameField = new JTextField(15);
			userField = new JTextField(15);
			emailField = new JTextField(15);

			btnSignUp = new JButton("Sign Up");

			setupPanel();
			setupLayout();
			setupListners();
		}

		private void setupPanel() {
			// TODO Auto-generated method stub
			
		}

		private void setupLayout() {
			// TODO Auto-generated method stub
			
		}

		private void setupListners() {
			// TODO Auto-generated method stub
			
		}

}
