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
	
	private JLabel editLabel = new JLabel("------------------------Edit Value------------------------");
	private static JLabel positionLabel = new JLabel("------------------------List Position: " + listPosition +"------------------------");
	
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
		add(positionLabel);
		
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
				updateAdminView(listPosition);
//				updateEditFields(listPosition);
				updateListPositionField();
				
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
				updateAdminView(listPosition);
//				updateEditFields(listPosition);
				updateListPositionField();
				
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
					System.out.println("Min List");
					return;
				}
				if (listPosition + 1 == MainPanel.customerList.size()) {
					deleteCustomerListPrev();
					System.out.println("Max List");
					return;
				}
				deleteCustomerList();				
			// Clear fields if NumberFormatException 
			} catch (IndexOutOfBoundsException ex) {
					listPosition--;
					adminViewInfo.setText("");
					MainPanel.updateMainView();
					clearFields();
			}
		}		
	}
	
	class EditButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TryCatch will handle input validation in case of bad user input.
			try {
				String firstName = firstNameField.getText();
				String lastName = lastNameField.getText();
				String address = addressField.getText();				
				int priority = Integer.parseInt((String)priorityField.getSelectedItem());
				MainPanel.customerList.get(listPosition).setFirstName(firstName);
				MainPanel.customerList.get(listPosition).setLastName(lastName);
				MainPanel.customerList.get(listPosition).setAddress(address);
				
				
			// Clear fields if NumberFormatException 
			} catch (NumberFormatException ex) {
				//TODO
			}			
		}		
	}
	
	public static void deleteCustomerListNext() {
		listPosition++;		
		updateAdminView(listPosition);
		MainPanel.updateMainView();
		updateListPositionField();
		listPosition = 0;
		deleteCustomerEntry();
		updateListPositionField();
		MainPanel.updateMainView();

	}
	
	public static void deleteCustomerListPrev() {
		listPosition--;		
		updateAdminView(listPosition);
		MainPanel.updateMainView();
		updateListPositionField();
		listPosition++;
		deleteCustomerEntry();
		MainPanel.updateMainView();
		listPosition--;
	}
	
	public static void deleteCustomerEntry() {
		try {
			Customer c = MainPanel.customerList.get(listPosition);
			
			PriorityList p = new PriorityList();
			for (PriorityList o : MainPanel.customerPriorityList) {
				if (c.equals(o.customer)) {
					p = o;
				}
			}
			MainPanel.customerPriorityList.remove(p);
			MainPanel.customerList.remove(c);
			
		// Clear fields if NumberFormatException 
		} catch (IndexOutOfBoundsException ex) {
				listPosition--;
				adminViewInfo.setText("");
				MainPanel.updateMainView();
				clearFields();
		}
	}
	
	public static void deleteCustomerList() {
		try {
			Customer c = MainPanel.customerList.get(listPosition);
			
			PriorityList p = new PriorityList();
			for (PriorityList o : MainPanel.customerPriorityList) {
				if (c.equals(o.customer)) {
					p = o;
				}
			}
			MainPanel.customerPriorityList.remove(p);
			MainPanel.customerList.remove(c);
			updateAdminView(listPosition);
			MainPanel.updateMainView();
//			updateEditFields(listPosition);
			updateListPositionField();
			
		// Clear fields if NumberFormatException 
		} catch (IndexOutOfBoundsException ex) {
				listPosition--;
				adminViewInfo.setText("");
				MainPanel.updateMainView();
				clearFields();
		}
	}
	
	public static void updateAdminView(int p) {
		adminViewInfo.setText(MainPanel.customerList.get(p).toString());
		firstNameField.setText(MainPanel.customerList.get(p).getFirstName());
		lastNameField.setText(MainPanel.customerList.get(p).getLastName());
		addressField.setText(MainPanel.customerList.get(p).getAddress());
		priorityField.setSelectedItem(MainPanel.customerList.get(p).getFirstName());
	}
	
//	public static void updateEditFields(int p) {
//		firstNameField.setText(MainPanel.customerList.get(p).getFirstName());
//		lastNameField.setText(MainPanel.customerList.get(p).getLastName());
//		addressField.setText(MainPanel.customerList.get(p).getAddress());
//		priorityField.setSelectedItem(MainPanel.customerList.get(p).getFirstName());
//	}
	
	public static void updateListPositionField() {
		positionLabel.setText("------------------------List Position: " + listPosition +"------------------------");
	}
	
	public static void clearFields() {
		firstNameField.setText("");
		lastNameField.setText("");
		addressField.setText("");
		priorityField.setSelectedItem("");
	}
	
	public static void clearAdminView() {
		adminViewInfo.setText("");		
	}

}
