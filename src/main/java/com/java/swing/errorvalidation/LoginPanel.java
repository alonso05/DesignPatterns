package com.java.swing.errorvalidation;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginPanel extends JPanel{

	private JFrame frame;
	private JLabel lblUser, lbPassword;
	private JTextField txtUser, txtPassword;
	private JButton btnLogin;
	private ErrorsValidationController baseController;
	private ErrorsValidationFrame globalFrame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPanel window = new LoginPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginPanel() {
		initialize();
	}

	public LoginPanel(ErrorsValidationFrame frame, ErrorsValidationController baseController) {
		this.baseController = baseController;
		this.globalFrame = frame;
		
		lblUser = new JLabel("User");
		txtUser = new JTextField();
		lbPassword = new JLabel("Password");
		txtPassword = new JTextField();
		btnLogin = new JButton("Login");
		
		setupPanel();
		setupLayout();
		setupListners();
		
	}

	private void setupListners() {
		// TODO Auto-generated method stub
		
	}

	private void setupLayout() {
		globalFrame.getContentPane().add(lblUser);
		globalFrame.getContentPane().add(txtUser);
		globalFrame.getContentPane().add(lbPassword);
		globalFrame.getContentPane().add(txtPassword);
		globalFrame.getContentPane().add(btnLogin);
	}

	private void setupPanel() {
		globalFrame.getContentPane().setSize(500, 500);
		globalFrame.getContentPane().setLayout(null);
		lblUser.setBounds(75, 55, 46, 14);
		txtUser.setBounds(171, 52, 164, 20);
		lbPassword.setBounds(75, 114, 46, 14);
		txtPassword.setColumns(10);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblUser = new JLabel("User");
		lblUser.setBounds(75, 55, 46, 14);
		frame.getContentPane().add(lblUser);
		
		txtUser = new JTextField();
		txtUser.setBounds(171, 52, 164, 20);
		frame.getContentPane().add(txtUser);
		txtUser.setColumns(10);
		
		lbPassword = new JLabel("Password");
		lbPassword.setBounds(75, 114, 46, 14);
		frame.getContentPane().add(lbPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(171, 111, 164, 20);
		frame.getContentPane().add(txtPassword);
		
		btnLogin = new JButton("Login");
		btnLogin.setBounds(137, 180, 142, 23);
		frame.getContentPane().add(btnLogin);
	}
}
