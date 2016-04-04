package com.java.patterns.mvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import com.java.patterns.mvc.controller.SampleAppController;

public class SamplePanel extends JPanel{
	
	private SampleAppController baseController;
	private JLabel nameLabel, descriptionLabel, weightLabel, sizeLabel;
	private JTextField nameField, descriptionField, sizeField, weightField;
	private JButton createWidgetButton, createWhatlistButton;
	private SpringLayout baseLayout;
	
	
	public SamplePanel(SampleAppController baseController){
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
		
		baseLayout = new SpringLayout();

		setupPanel();
		setupLayout();
		setupListners();
	}
	
	private void setupLayout(){
		baseLayout.putConstraint(SpringLayout.NORTH, createWhatlistButton, 0, SpringLayout.NORTH, createWidgetButton);
		baseLayout.putConstraint(SpringLayout.WEST, createWhatlistButton, 0, SpringLayout.WEST, sizeLabel);
		baseLayout.putConstraint(SpringLayout.SOUTH, weightField, -210, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, descriptionField, 58, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, createWidgetButton, 60, SpringLayout.SOUTH, weightField);
		baseLayout.putConstraint(SpringLayout.WEST, createWidgetButton, 0, SpringLayout.WEST, descriptionLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, sizeField, 0, SpringLayout.NORTH, weightField);
		baseLayout.putConstraint(SpringLayout.WEST, sizeField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, sizeLabel, 0, SpringLayout.NORTH, weightLabel);
		baseLayout.putConstraint(SpringLayout.EAST, sizeLabel, 0, SpringLayout.EAST, nameLabel);
		baseLayout.putConstraint(SpringLayout.WEST, weightField, 85, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, weightLabel, -277, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, weightLabel, 47, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, 22, SpringLayout.SOUTH, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, descriptionField, 0, SpringLayout.NORTH, nameField);
		baseLayout.putConstraint(SpringLayout.EAST, nameField, 0, SpringLayout.EAST, nameLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, nameLabel, 0, SpringLayout.NORTH, descriptionLabel);
		baseLayout.putConstraint(SpringLayout.EAST, nameLabel, -62, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, descriptionLabel, 83, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, descriptionLabel, 66, SpringLayout.WEST, this);
	}
	
	private void setupPanel(){
		this.setSize(500, 500);
		this.setLayout(baseLayout);
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
		
	}
}
