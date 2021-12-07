package model;
/**************************************************************
* Name        : Final
* Author      : Fernando Garcia
* Created     : Dec 3, 2021
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
import java.util.LinkedList;
import java.util.Queue;
/**
 * Describe the class
 * @author Fernando Garcia
 * @version
 */

public class Customer {
	private String firstName;
	private String lastName;
	private String address;
	private int customerId;	
	private static int currentId = 1;
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		setCustomerId(currentId++);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}	

	/**
	 * @return the customerId
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(int currentId) {
		this.customerId = currentId;
	}

	@Override
	public String toString() {
		return "Customer ID: " + customerId + "\n" + firstName + " " + lastName + "\n" + address;
	}




}
