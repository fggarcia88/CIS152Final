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

public class Customer implements Comparable<Customer>{
	private String firstName;
	private String lastName;
	private String address;
	private int priority;
	
	public Customer() {}
	
	public Customer(String firstName, String lastName, String address, int priority) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.priority = priority;
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
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + "\n" + address + "\n priority="
				+ priority;
	}

	// Compare priority using implement for Customer class for Priority Queue
	@Override
	public int compareTo(Customer o) {
		// TODO Auto-generated method stub
		return o.priority < this.priority? 1: -1;
	}


}
