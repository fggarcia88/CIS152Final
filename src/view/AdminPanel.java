/**************************************************************
* Name        : CIS152Final
* Author      : Fernando Garcia
* Created     : Dec 6, 2021
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

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Customer;
import model.PriorityList;
import view.MainPanel.ClearButtonListener;
import view.MainPanel.DeliveredButtonListener;
import view.MainPanel.SubmitButtonListener;

/**
 * Describe the class
 * @author Fernando Garcia
 * @version
 */

public class AdminPanel extends JPanel{	
	static int listPosition = 0;
	
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
		add(adminViewLabel);
		add(adminViewInfo);
		
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
	
	class NextButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TryCatch will handle input validation in case of bad user input.			
			try {
				listPosition++;
				updateAdminView();
//				updateListPositionField();				
			// Clear fields if NumberFormatException 
			} catch (IndexOutOfBoundsException ex) {
				listPosition--;
			}			
		}		
	}
	
	class PrevButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TryCatch will handle input validation in case of bad user input.
			try {
				listPosition--;
				updateAdminView();
//				updateListPositionField();				
			// Clear fields if NumberFormatException 
			} catch (IndexOutOfBoundsException ex) {
				listPosition++;
			}			
		}		
	}
	
	class DeleteButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TryCatch will handle input validation in case of bad user input.

			try {
				if (listPosition == 0) {
					deleteCustomerListNext();
					return;
				}
				else if (listPosition + 1 == MainPanel.customerList.size()) {
					deleteCustomerListPrev();
					return;
				}
				deleteCustomerEntry();				
			// Clear fields if NumberFormatException 
			} catch (IndexOutOfBoundsException ex) {
					listPosition = 0;
					deleteCustomerEntry();
					adminViewInfo.setText("");
					MainPanel.updateMainView();
					clearAdminFields();
			}
		}		
	}
	
	class EditButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TryCatch will handle input validation in case of bad user input.
			Customer c = MainPanel.customerList.get(listPosition);				
			PriorityList p = findPriorityListCustomer(c);			
			c.setFirstName(firstNameField.getText());
			c.setLastName(lastNameField.getText());
			c.setAddress(addressField.getText());
			MainPanel.customerPriorityList.remove(p);				
			p.setPriority(Integer.parseInt((String)priorityField.getSelectedItem()));
			MainPanel.customerPriorityList.add(p);
			MainPanel.updateMainView();
			updateAdminView();			
		}		
	}
	
	public static void deleteCustomerListNext() {
		listPosition++;		
		MainPanel.updateMainView();
		updateAdminView();
//		updateListPositionField();
		listPosition--;
		deleteCustomerEntry();
//		updateListPositionField();
		MainPanel.updateMainView();
	}
	
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
	
	public static void deleteCustomerEntry() {
		try {
			Customer c = MainPanel.customerList.get(listPosition);			
			PriorityList p = findPriorityListCustomer(c);
			MainPanel.customerPriorityList.remove(p);
			MainPanel.customerList.remove(c);			
		// Clear fields if NumberFormatException 
		} catch (IndexOutOfBoundsException ex) {
			listPosition--;
			adminViewInfo.setText("");
			MainPanel.updateMainView();
			clearAdminFields();
		}
	}
	
	public static void updateAdminView() {
		
		Customer c = MainPanel.customerList.get(listPosition);		
		PriorityList p = findPriorityListCustomer(c);
		
		adminViewInfo.setText(MainPanel.customerList.get(listPosition).toString() + p.getPriority());
		firstNameField.setText(MainPanel.customerList.get(listPosition).getFirstName());
		lastNameField.setText(MainPanel.customerList.get(listPosition).getLastName());
		addressField.setText(MainPanel.customerList.get(listPosition).getAddress());
		priorityField.setSelectedItem(p.getPriorityValue());
	}
	// Helper function used with program troubleshooting. Method not implemented in main release
//	public static void updateListPositionField() {
//		positionLabel.setText("------------------------List Position: " + listPosition +"------------------------");
//	}
	
	public static PriorityList findPriorityListCustomer (Customer c) {
		PriorityList p = new PriorityList();
		for (PriorityList i : MainPanel.customerPriorityList) {
			if (c.equals(i.customer)) {
				p = i;
			}
		}
		return p;
	}
	
	public static void clearAdminFields() {
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		priorityField.setSelectedItem("");
	}
	
	public static void clearAdminView() {
		adminViewInfo.setText("");		
	}

}
