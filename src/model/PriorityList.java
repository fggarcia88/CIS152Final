/**************************************************************
* Name        : CIS152Final
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

package model;

/**
 * Describe the class
 * @author Fernando Garcia
 * @version
 */

public class PriorityList implements Comparable<PriorityList>{
	public Customer customer;
	private int priority;
	
	public PriorityList () {}

	/**
	 * @param customer
	 * @param priority
	 * Describe default constructor
	 */
	public PriorityList(Customer customer, int priority) {
		super();
		this.customer = customer;
		this.priority = priority;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return "\nPriority level: " + this.priority;
	}
	
	/**
	 * @return the priority
	 */
	public String getPriorityValue() {
		String s = String.valueOf(priority);
		return s;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	// Compare priority using implement for Customer class for Priority Queue
	@Override
	public int compareTo(PriorityList p) {
		// TODO Auto-generated method stub
		return p.priority < this.priority? 1: -1;
	}
}
