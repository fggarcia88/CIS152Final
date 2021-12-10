package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Customer;
import model.PriorityList;

/**
 * AdminPanel class houses Admin tab of program
 * @author Fernando Garcia
 * @version 1.0
 */

public class AdminPanel extends JPanel{
	// Variable to hold index of LinkedList position for scrolling through entries
	static int listPosition = 0;
	// Define GUI elements for Admin Panel
	private JButton nextButton = new JButton("Next");
	private JButton prevButton = new JButton("Prev");
	private JButton deleteButton = new JButton("Delete");	
	private JLabel adminViewLabel = new JLabel("-------------------Admin View-------------------");
	private static JTextArea adminViewInfo = new JTextArea(5,25);	
	private JLabel editLabel = new JLabel("------------------------Edit Values------------------------");
//	private static JLabel positionLabel = new JLabel("------------------------List Position: " + listPosition +"------------------------");
	private	JLabel firstNameLabel = new JLabel("First Name:");
	private static JTextField firstNameField = new JTextField(20);	
	private	JLabel lastNameLabel = new JLabel("Last Name:");
	private static JTextField lastNameField = new JTextField(20);	
	private	JLabel addressLabel = new JLabel("Address:     ");
	private static JTextField addressField = new JTextField(20);	
	private	JLabel priorityLabel = new JLabel("Priority Level:");
	private static JComboBox priorityField = new JComboBox(MainPanel.priorityList);	
	private JButton editButton = new JButton("Edit");
	
	public AdminPanel() {
		// Add GUI elements and button listeners for Admin Panel 
		add(adminViewLabel);
		add(adminViewInfo);
		// Make Admin View non editable
		adminViewInfo.setEditable(false);
		PrevButtonListener prevButtonListener = new PrevButtonListener();
		prevButton.addActionListener(prevButtonListener);
		add(prevButton);		
		NextButtonListener nextButtonListener = new NextButtonListener();
		nextButton.addActionListener(nextButtonListener);
		add(nextButton);		
		DeleteButtonListener deleteButtonListener = new DeleteButtonListener();
		deleteButton.addActionListener(deleteButtonListener);
		add(deleteButton);		
		add(editLabel);
//		add(positionLabel);		
		add(firstNameLabel);
		add(firstNameField);		
		add(lastNameLabel);
		add(lastNameField);		
		add(addressLabel);
		add(addressField);
		add(priorityLabel);
		add(priorityField);		
		EditButtonListener editButtonListener = new EditButtonListener();
		editButton.addActionListener(editButtonListener);		
		add(editButton);
	}
	// Used for viewing LinkedList customerList, will update list position and updateAdminView
	class NextButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TryCatch will try to scroll next, if OutOfBoundsException, will negate change to list position		
			try {
				// Check if customerList is empty, return if true
				if (MainPanel.customerList.isEmpty()) {
					return;
				}
				listPosition++;
				updateAdminView();
//				updateListPositionField();				
			} catch (IndexOutOfBoundsException ex) {
				listPosition--;
			}			
		}		
	}
	// Used for viewing LinkedList customerList, will update list position and updateAdminView
	class PrevButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TryCatch will try to scroll next, if OutOfBoundsException, will negate change to list position		
			try {
				// Check if customerList is empty, return if true
				if (MainPanel.customerList.isEmpty()) {
					return;
				}
				listPosition--;
				updateAdminView();
//				updateListPositionField();				
			} catch (IndexOutOfBoundsException ex) {
				listPosition++;
			}			
		}		
	}
	// Checks if user is in beginning, middle or end of customerList in view, and will delete entry accordingly 
	class DeleteButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				// Check if customerList is empty, return if true
				if (MainPanel.customerList.isEmpty()) {		
					return;
				}
				else if (listPosition == 0) {
					deleteCustomerListNext();
					return;
				}
				else if (listPosition + 1 == MainPanel.customerList.size()) {
					deleteCustomerListPrev();
					return;
				}
				deleteCustomerEntry();
				updateAdminView();
				MainPanel.updateMainView();
			// Used as fallback when index is out of sync, will clear all fields and reset 
			} catch (IndexOutOfBoundsException ex) {
					listPosition = 0;
					deleteCustomerEntry();
					adminViewInfo.setText("");
					MainPanel.updateMainView();
					clearAdminFields();
			}
		}		
	}
	// Used to edit fields for user entries
	class EditButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// Check if customerList is empty, return if true
			if (MainPanel.customerList.isEmpty()) {
				return;
			}
			// Get customer and find customer in customerPriorityList
			Customer c = MainPanel.customerList.get(listPosition);				
			PriorityList p = findPriorityListCustomer(c);
			// Change customer values from text fields
			c.setFirstName(firstNameField.getText());
			c.setLastName(lastNameField.getText());
			c.setAddress(addressField.getText());
			// Update customerPriorityList by removing and readding into PriorityQueue
			MainPanel.customerPriorityList.remove(p);
			p.setPriority(Integer.parseInt((String)priorityField.getSelectedItem()));
			MainPanel.customerPriorityList.add(p);
			// Update panels views
			MainPanel.updateMainView();
			updateAdminView();			
		}		
	}
	// Used to delete customerList entries when user is viewing beginning of list
	public static void deleteCustomerListNext() {
		// Check if only one entry left in list, delete single entry them update views after
		if (MainPanel.customerList.size() == 1) {
			deleteCustomerEntry();
			listPosition--;
			MainPanel.updateMainView();
			clearAdminFields();
			return;
		}
		listPosition++;		
		MainPanel.updateMainView();
		updateAdminView();
//		updateListPositionField();
		listPosition--;
		deleteCustomerEntry();
		MainPanel.updateMainView();
	}
	// Used to delete customerList entries when user is viewing end of list
	public static void deleteCustomerListPrev() {
		listPosition--;
		MainPanel.updateMainView();
		updateAdminView();		
//		updateListPositionField();
		listPosition++;
		deleteCustomerEntry();
		MainPanel.updateMainView();
		listPosition--;
	}
	// Delete customer entry based on listPosition in view
	public static void deleteCustomerEntry() {
		try {
			Customer c = MainPanel.customerList.get(listPosition);			
			PriorityList p = findPriorityListCustomer(c);
			MainPanel.customerPriorityList.remove(p);
			MainPanel.customerList.remove(c);			
		// Used to reset view and listPosition when list is empty
		} catch (IndexOutOfBoundsException ex) {
			listPosition--;
			adminViewInfo.setText("");
			MainPanel.updateMainView();
			clearAdminFields();
		}
	}
	
	public static void updateAdminView() {
		try {
			// Get customer from customerList based on listPosition and customer from customerPriority
			Customer c = MainPanel.customerList.get(listPosition);		
			PriorityList p = findPriorityListCustomer(c);
			// Update Admin View based on retrieved values
			adminViewInfo.setText(c.toString() + p.getPriority());
			firstNameField.setText(c.getFirstName());
			lastNameField.setText(c.getLastName());
			addressField.setText(c.getAddress());
			priorityField.setSelectedItem(p.getPriorityValue());
		} catch (IndexOutOfBoundsException ex) {
			listPosition = 0;
			updateAdminView();
		}
	}
	// Helper function used with program troubleshooting. Method not implemented in main release
//	public static void updateListPositionField() {
//		positionLabel.setText("------------------------List Position: " + listPosition +"------------------------");
//	}
	// Get customer from customerPriorityList
	public static PriorityList findPriorityListCustomer (Customer c) {
		PriorityList p = new PriorityList();
		for (PriorityList i : MainPanel.customerPriorityList) {
			if (c.equals(i.customer)) {
				p = i;
			}
		}
		return p;
	}
	// Helper function to clear all Admin tab fields
	public static void clearAdminFields() {
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		priorityField.setSelectedItem("");
	}
	// Helper function to clear Admin tab view
	public static void clearAdminView() {
		adminViewInfo.setText("");		
	}

}
