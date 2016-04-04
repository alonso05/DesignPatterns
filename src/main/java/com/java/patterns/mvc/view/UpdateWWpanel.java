package com.java.patterns.mvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.patterns.mvc.controller.SampleAppController;

public class UpdateWWpanel extends JPanel{

	private SampleAppController baseController;
	private JLabel nameLabel, descriptionLabel, weightLabel, sizeLabel;
	protected JTextField nameField, descriptionField, sizeField, weightField;
	private JButton createWidgetButton, createWhatlistButton, btnCheckValues;

	public UpdateWWpanel(SampleAppController baseController){
		this.baseController = baseController;
		
		nameLabel = new JLabel("Type the name of the Whatlist");
		descriptionLabel = new JLabel("Describe the widget");
		weightLabel = new JLabel("Enter the weight of the widget");
		sizeLabel = new JLabel ("Enter the size of the whatlist");
		nameField = new JTextField(15);
		descriptionField = new JTextField(15);
		weightField = new JTextField(10);
		sizeField = new JTextField(10);
		createWidgetButton = new JButton("Make a Widget!!");
		createWhatlistButton = new JButton("Make a Whatlist!!");
	
		setupPanel();
		setupLayout();
		setupListners();
	}

	private void setupPanel() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.add(nameLabel);
		this.add(descriptionLabel);
		this.add(weightLabel);
		this.add(sizeLabel);
		
		this.add(nameField);
		this.add(descriptionField);
		this.add(weightField);
		this.add(sizeField);
		
		this.add(createWidgetButton);
		this.add(createWhatlistButton);
		
		btnCheckValues = new JButton("Check Values");
		btnCheckValues.setBounds(162, 413, 159, 23);
		add(btnCheckValues);
	}
	
	private void setupLayout() {
		nameLabel.setBounds(24, 81, 181, 14);
		descriptionLabel.setBounds(274, 81, 174, 14);
		weightLabel.setBounds(274, 196, 174, 14);
		nameField.setBounds(44, 125, 126, 20);
		sizeLabel.setBounds(32, 196, 191, 14);
		descriptionField.setBounds(274, 125, 126, 20);
		weightField.setBounds(289, 255, 86, 20);
		sizeField.setBounds(88, 255, 86, 20);
		createWidgetButton.setBounds(289, 331, 159, 23);
		createWhatlistButton.setBounds(44, 331, 161, 23);
		
	}
	
	private boolean checkInteger(String currentInput){
		boolean isInteger = false;
		try{
			Integer.parseInt(currentInput);
			isInteger = true;
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Plese type an integer in the size field", "Weight", JOptionPane.ERROR_MESSAGE);
		}
		return isInteger;
	}
	
	private boolean checkDouble(String currentInput){
		boolean isDouble = false;
		try{
			Double.parseDouble(currentInput);
			isDouble = true;
		}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "Plese type an double in the weight field", "Weight", JOptionPane.ERROR_MESSAGE);
		}
		return isDouble;
	}
	
	private void setupListners(){
		createWidgetButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				String description = descriptionField.getText();
				double currentWeight = 0.0;
				if(checkDouble(weightField.getText())){
					currentWeight = Double.parseDouble(weightField.getText());
					
					
					if(baseController.getAppFactory().makeWidget(currentWeight, description)){
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "Congrats you made a Widget!");
					}
					else{
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "Sorry not enough resources to make a widget");
					}
					
					//Widget tempWidget = new Widget(currentWeight, description);
					//baseController.getAppFactory().getWidgetList().add(tempWidget);
				}

			}
			
		});
		
		createWhatlistButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				String name = nameField.getText();
				int size = 0;
				if(checkInteger(sizeField.getText())){
					size = Integer.parseInt(sizeField.getText());
					
					if(baseController.getAppFactory().makeWhatsit(size, name)){
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "Congrats you made a Whatlist!");
					}
					else{
						JOptionPane.showMessageDialog(baseController.getAppFrame(), "Sorry not enough resources to make a whatlist");
					}
					
					//baseController.getAppFactory().getWhatsitList().add(new Whatsit(size, name));
				}

				
			}
			
		});
		
		
		btnCheckValues.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				baseController.getAppFrame().layout.show(baseController.getAppFrame().pane, "fetchPanel");
			}
		});
		
	}
}
