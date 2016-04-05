package com.java.patterns.mvc.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.java.patterns.mvc.controller.SampleAppController;

public class LoadValuesPanel extends JPanel{

	private SampleAppController baseController;
	private JLabel nameLabel, descriptionLabel;
	private JTextField whatsitCount, widgetCount;
	private JButton btnFetchValues, btnReturn;

	public LoadValuesPanel(SampleAppController baseController){
		this.baseController = baseController;
		
		nameLabel = new JLabel("Whatlists");
		descriptionLabel = new JLabel("Widgets");
		whatsitCount = new JTextField(15);
		widgetCount = new JTextField(15);
	
		setupPanel();
		setupLayout();
		setupListners();
	}

	private void setupPanel() {
		this.setSize(500, 500);
		this.setLayout(null);
		this.add(nameLabel);
		this.add(descriptionLabel);
		
		this.add(whatsitCount);
		this.add(widgetCount);
		
		btnReturn = new JButton("Return to Update");
		btnReturn.setBounds(165, 327, 159, 23);
		add(btnReturn);
		
		btnFetchValues = new JButton("Fetch Values");
		btnFetchValues.setBounds(165, 257, 159, 23);
		add(btnFetchValues);
	}
	
	private void setupLayout() {
		nameLabel.setBounds(44, 81, 126, 14);
		descriptionLabel.setBounds(274, 81, 174, 14);
		whatsitCount.setBounds(44, 125, 126, 20);
		widgetCount.setBounds(274, 125, 126, 20);
		
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
		btnReturn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent click) {
				baseController.getAppFrame().layout.show(baseController.getAppFrame().pane, "basePanel");
			}
		});
		
		btnFetchValues.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				whatsitCount.setText(String.valueOf(baseController.getAppFactory().getWhatsitResourceCount()));
				widgetCount.setText(String.valueOf(baseController.getAppFactory().getWidgetResourceCount()));
				
				//whatsitCount.setText(baseController.getAppFrame().basePanel.sizeField.getText());
				//widgetCount.setText(baseController.getAppFrame().basePanel.weightField.getText());
				
			}
			
		});
	}
}
