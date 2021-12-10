package model;

/**
 * PriorityList class holds customer object and priority for PriorityQueue data structure
 * @author Fernando Garcia
 * @version 1.0
 */

public class PriorityList implements Comparable<PriorityList>{
	// Variables for class
	public Customer customer;
	private int priority;
	// Default no arg-constructor
	public PriorityList () {}

	/**
	 * @param customer
	 * @param priority
	 * Used when adding entries to PriorityQueue
	 */
	public PriorityList(Customer customer, int priority) {
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
	 * @param customer to set
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
	 * @return string of int priority
	 */
	public String getPriorityValue() {
		String s = String.valueOf(priority);
		return s;
	}

	/**
	 * @param priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	// Compare priority using implement for Customer class for Priority Queue
	@Override
	public int compareTo(PriorityList p) {
		return p.priority < this.priority? 1: -1;
	}
}
