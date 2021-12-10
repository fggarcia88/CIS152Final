package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import model.*;
import view.*;

/**
 * Tester for Customer class
 * @author Fernando Garcia
 * @version 1.0
 */

public class UnitTestCustomer {
	
	@Test
	void testCreateLinkedList() {
		// ARRANGE
		LinkedList<Customer> customerList = new LinkedList<Customer>();
		boolean actual;
		// ACT
		actual = customerList.isEmpty();
		// ASSERT
		assertTrue(actual);
	}
	
	@Test
	void testIsEmptyTrue() {
		// ARRANGE
		LinkedList<Customer> customerList = new LinkedList<Customer>();
		boolean actual;
		// ACT
		actual = customerList.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyFalse() {
		// ARRANGE
		LinkedList<Customer> customerList = new LinkedList<Customer>();
		Customer c = new Customer();		
		boolean actual;
		// ACT
		customerList.add(c);
		actual = customerList.isEmpty();
		// ASSERT
		assertFalse(actual);
	}
	
	@Test
	void testAdd() {
		// ARRANGE
		LinkedList<Customer> customerList = new LinkedList<Customer>();
		Customer c = new Customer("Fernando", "Garcia", "123 Fake St");		
		String actual, expected;
		expected = "Fernando";
		// ACT
		customerList.add(c);
		actual = customerList.peek().getFirstName();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testAddRemove() {
		// ARRANGE
		LinkedList<Customer> customerList = new LinkedList<Customer>();
		Customer c1 = new Customer("Fernando", "Garcia", "123 Fake St");
		Customer c2 = new Customer("Sarah", "Garcia", "123 Fake St");	
		Customer c3 = new Customer("John", "Doe", "456 Fake St");	
		String actual, expected;
		expected = "John";
		// ACT
		customerList.add(c1);
		customerList.add(c2);
		customerList.remove();
		customerList.remove();
		customerList.add(c3);
		actual = customerList.peek().getFirstName();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testToString() {
		// ARRANGE
		LinkedList<Customer> customerList = new LinkedList<Customer>();
		Customer c = new Customer("Fernando", "Garcia", "123 Fake St");
		String actual, expected;
		expected = "Customer ID: 2\nFernando Garcia\n123 Fake St";
		// ACT
		customerList.add(c);
		actual = customerList.peek().toString();
		// ASSERT
		assertEquals(expected, actual);
	}	
}
