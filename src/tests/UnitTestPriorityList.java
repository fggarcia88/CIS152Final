package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

import model.*;

/**
 * Tester for PriorityList class
 * @author Fernando Garcia
 * @version 1.0
 */
public class UnitTestPriorityList {
	@Test
	void testCreatePriorityQueue() {
		// ARRANGE
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		boolean actual;
		// ACT
		actual = customerPriorityList.isEmpty();
		// ASSERT
		assertTrue(actual);
	}
	
	@Test
	void testIsEmptyTrue() {
		// ARRANGE
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		boolean actual;
		// ACT
		actual = customerPriorityList.isEmpty();
		// ASSERT
		assertTrue(actual);
	}

	@Test
	void testIsEmptyFalse() {
		// ARRANGE
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		PriorityList p = new PriorityList();		
		boolean actual;
		// ACT
		customerPriorityList.add(p);
		actual = customerPriorityList.isEmpty();
		// ASSERT
		assertFalse(actual);
	}
	
	@Test
	void testAdd() {
		// ARRANGE
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		Customer c = new Customer("Fernando", "Garcia", "123 Fake St");
		PriorityList p = new PriorityList(c, 1);
		String actual, expected;
		expected = "Fernando";
		// ACT
		customerPriorityList.add(p);
		actual = customerPriorityList.peek().customer.getFirstName();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testAddRemove() {
		// ARRANGE
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		Customer c1 = new Customer("Fernando", "Garcia", "123 Fake St");
		Customer c2 = new Customer("Sarah", "Garcia", "123 Fake St");	
		Customer c3 = new Customer("John", "Doe", "456 Fake St");
		PriorityList p1 = new PriorityList(c1, 3);
		PriorityList p2 = new PriorityList(c2, 1);
		PriorityList p3 = new PriorityList(c3, 2);
		String actual, expected;
		expected = "Sarah";
		// ACT
		customerPriorityList.add(p1);
		customerPriorityList.remove();
		customerPriorityList.add(p2);
		customerPriorityList.add(p3);
		actual = customerPriorityList.peek().customer.getFirstName();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetPriorityValue() {
		// ARRANGE
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		Customer c = new Customer("Fernando", "Garcia", "123 Fake St");
		PriorityList p = new PriorityList(c, 2);
		String actual, expected;
		expected = "2";
		// ACT
		customerPriorityList.add(p);
		actual = customerPriorityList.peek().getPriorityValue();
		// ASSERT
		assertEquals(expected, actual);
	}
	
	@Test
	void testCompareTo() {
		// ARRANGE
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		Customer c1 = new Customer("Fernando", "Garcia", "123 Fake St");
		Customer c2 = new Customer("Sarah", "Garcia", "123 Fake St");	
		PriorityList p1 = new PriorityList(c1, 3);
		PriorityList p2 = new PriorityList(c2, 1);
		int actual, expected;
		expected = -1;
		// ACT
		customerPriorityList.add(p1);
		customerPriorityList.add(p2);
		actual = customerPriorityList.peek().compareTo(p2);
		// ASSERT
		assertEquals(expected, actual);
	}

}
