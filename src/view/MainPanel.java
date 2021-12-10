package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Customer;
import model.PriorityList;

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
 * MainPanel class houses Main tab of program
 * @author Fernando Garcia
 * @version 1.0
 */

public class MainPanel extends JPanel{
	// Data structures used to hold user information
	static LinkedList<Customer> customerList = new LinkedList<Customer>();
	static PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
	static String priorityList[] = {"1","2","3"};
	// Define GUI elements for Main Panel
	private JLabel nextCustomerLabel = new JLabel("-------------------Next Delivery-------------------");
	private static JTextArea mainViewInfo = new JTextArea(5,25);	
	private static JLabel deliveriesLeft = new JLabel("-------------------No deliveries in queue.-------------------");
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
	private JButton deliveredButton = new JButton("Delivery Complete");	
	
	public MainPanel() {
		// Add GUI elements and button listeners for Main Panel
		add(nextCustomerLabel);
		add(mainViewInfo);
		// Make Main View non editable
		mainViewInfo.setEditable(false);
		DeliveredButtonListener deliveredButtonListener = new DeliveredButtonListener();
		deliveredButton.addActionListener(deliveredButtonListener);		
		add(deliveredButton);		
		add(deliveriesLeft);		
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
	}
	// Add user entered information to data structures for program use/storage
	class SubmitButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Customer c = new Customer(firstNameField.getText(), lastNameField.getText(), addressField.getText());
			customerList.add(c);
			PriorityList p = new PriorityList(c, Integer.parseInt((String)priorityField.getSelectedItem()));
			customerPriorityList.add(p);
			// Update panel views after adding information
			updateMainView();
			AdminPanel.updateAdminView();
			// Clear fields after submission
			clearMainFields();
		}		
	}
	// Clear main fields on button press
	class ClearButtonListener implements ActionListener {
		@Override
		// Clear button will clear all fields and reset program
		public void actionPerformed(ActionEvent e) {
			clearMainFields();
		}		
	}
	// Remove entries from data structures when delivery is completed
	class DeliveredButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// Get and remove top of priority list, remove defined customer from customerList
				PriorityList p = customerPriorityList.remove();
				Customer c = p.customer;
				customerList.remove(c);				
				// Update Admin and Main View after removal
				updateMainView();
				// When customerPriorityList is empty, reset program and notify user
				if (customerPriorityList.isEmpty()) {
					AdminPanel.listPosition = 0;
					AdminPanel.clearAdminFields();
					popUp();
					return;
				}
				AdminPanel.updateAdminView();
			/* Used as fallback when customerPriorityList is empty, but data structures fall out of sync 
			*  will update deliveriesLeft appropriately
			**/ 
			} catch (NullPointerException ex) {
				mainViewInfo.setText("");
				deliveriesLeft.setText("-------------No deliveries in queue.-------------");
			// Used when user tries to press submit button when list is empty	
			} catch (java.util.NoSuchElementException ex) {
				mainViewInfo.setText("");
			}			
		}		
	}
	// Helper function to alert user that deliveries are completed
	public void popUp() {
		JOptionPane.showMessageDialog(null, "All Deliveries Complete!", "Alert", JOptionPane.INFORMATION_MESSAGE);
	}
	// Helper function to clear text fields for Main View
	public void clearMainFields() {
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		priorityField.setSelectedItem("1");
	}
	// Helper function to clear fields from Main View
	public static void clearMainView() {
		mainViewInfo.setText("");		
	}
	// Updates Main View with values from data structures
	public static void updateMainView() {
		// Checks if customerList is empty, and will update views to empty, and update deliveriesLeft label
		if (customerPriorityList.isEmpty()) {
			clearMainView();
			AdminPanel.clearAdminView();
			deliveriesLeft.setText("-------------------No deliveries in queue.-------------------");
			return;
		}
		// Update main view with information from data structures
		mainViewInfo.setText(customerPriorityList.peek().customer.toString() + customerPriorityList.peek().getPriority());
		deliveriesLeft.setText("-------------------Deliveries left: " + customerPriorityList.size() + "-------------------");
	}

}
