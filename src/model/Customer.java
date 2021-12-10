package model;

/**
 * Customer class holds user information
 * @author Fernando Garcia
 * @version 1.0
 */

public class Customer {
	// Variables for class
	private String firstName;
	private String lastName;
	private String address;
	private int customerId;
	// Variable to assign a unique ID to customer
	private static int currentId = 1;
	// Default no arg-constructor
	public Customer() {}
	/**
	 * Used when adding entries to LinkedList
	 */
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
	 * @param firstName to set
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
	 * @param lastName to set
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
	 * @param address to set
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
	 * @param customerId to set
	 */
	public void setCustomerId(int currentId) {
		this.customerId = currentId;
	}
	
	// Helper function to get customer values and output into views
	@Override
	public String toString() {
		return "Customer ID: " + customerId + "\n" + firstName + " " + lastName + "\n" + address;
	}




}
