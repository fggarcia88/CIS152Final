package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Customer;

/**************************************************************
* Name        : Final
* Author      : Fernando Garcia
* Created     : Dec 5, 2021
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 10
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program overall description here
*               Input:  list and describe
*               Output: list and describe
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

/**
 * Describe the class
 * @author Fernando Garcia
 * @version
 */

public class CustomerPanel extends JPanel{
	PriorityQueue<Customer> customerList = new PriorityQueue<Customer>();
	String priorityList[] = {"1","2","3"};
	
	private	JLabel firstNameLabel = new JLabel("First Name:");
	private JTextField firstNameField = new JTextField(20);
	
	private	JLabel lastNameLabel = new JLabel("Last Name:");
	private JTextField lastNameField = new JTextField(20);
	
	private	JLabel addressLabel = new JLabel("Address:     ");
	private JTextField addressField = new JTextField(20);
	
	private	JLabel priorityLabel = new JLabel("Priority Level:");
	private JComboBox priorityField = new JComboBox(priorityList);
	
	private JButton submitButton = new JButton("Submit");
	private JButton clearButton = new JButton("Clear");
	
	private JLabel nextCustomerLabel = new JLabel("-------------------Next Delivery-------------------");
	private JLabel blankLine = new JLabel("                   ");
	private JTextArea nextCustomerInfo = new JTextArea(5,20);
	
	public CustomerPanel() {
		
		add(firstNameLabel);
		add(firstNameField);
		
		add(lastNameLabel);
		add(lastNameField);
		
		add(addressLabel);
		add(addressField);
		
		add(priorityLabel);
		add(priorityField);
		
		SubmitButtonListener submitButtonListener = new SubmitButtonListener();
		submitButton.addActionListener(submitButtonListener);		
		add(submitButton);
		
		ClearButtonListener clearButtonListener = new ClearButtonListener();
		clearButton.addActionListener(clearButtonListener);		
		add(clearButton);
		
		add(nextCustomerLabel);
		add(nextCustomerInfo);
		

//		WithdrawClickListener w = new WithdrawClickListener();
//		withdrawButton.addActionListener(w);		
	}
	
	class SubmitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			// TryCatch will handle input validation in case of bad user input.
			try {
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String address = addressField.getText();				
				int priority = Integer.parseInt((String)priorityField.getSelectedItem());
				// Construct object with user input
				Customer c = new Customer(firstName, lastName, address, priority);
				customerList.add(c);
				popUp(firstName, lastName);
				// customerPriorityList.remove().getCustomerDetails()
				updateNextCustomer();
				clearFields();
			// Clear fields if NumberFormatException 
			} catch (NumberFormatException ex) {
				clearFields();
			}			
		}		
	}
	
	class ClearButtonListener implements ActionListener {
		@Override
		// Clear button will clear all fields and reset program
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			clearFields();
		}		
	}
	
	public void popUp(String firstName, String lastName) {
		JOptionPane.showMessageDialog(null, firstName + " " + lastName + " added to customer list.", "Alert", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void clearFields() {
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		priorityField.setSelectedItem("");
	}
	
	public void updateNextCustomer() {
		nextCustomerInfo.setText(customerList.peek().toString());
	}

}
