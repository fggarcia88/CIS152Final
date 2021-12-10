import java.util.PriorityQueue;

import model.Customer;
import model.PriorityList;
import view.MainPanel;

/**************************************************************
* Name        : CIS152Final
* Author      : Fernando Garcia
* Created     : Dec 10, 2021
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

/**
 * Describe the class
 * @author Fernando Garcia
 * @version
 */

public class DriverTester {

	/**
	 * @param args
	 * Driver tester for Customer and PriorityList classes
	 */
	public static void main(String[] args) {
		// Create
		PriorityQueue<PriorityList> customerPriorityList = new PriorityQueue<PriorityList>();
		
		Customer c1 = new Customer("Fernando", "Garcia", "123 Fake St");
		Customer c2 = new Customer("Sarah", "Garcia", "123 Fake St");	
		Customer c3 = new Customer("John", "Doe", "456 Fake St");
		PriorityList p1 = new PriorityList(c1, 3);
		PriorityList p2 = new PriorityList(c2, 1);
		PriorityList p3 = new PriorityList(c3, 2);
		customerPriorityList.add(p1);
		customerPriorityList.remove();
		customerPriorityList.add(p2);
		customerPriorityList.add(p3);
		System.out.println("***Check remove in queue");
		for (PriorityList i : customerPriorityList) {
			System.out.println(i.customer.toString());
		}
		customerPriorityList.remove();
		customerPriorityList.remove();
		System.out.println("***Check if empty:");
		System.out.println(customerPriorityList.isEmpty());		
		customerPriorityList.add(p1);
		customerPriorityList.add(p2);
		customerPriorityList.add(p3);
		customerPriorityList.peek().customer.setFirstName("Patricia");
		System.out.println("***Check change for first in priority queue");
		for (PriorityList i : customerPriorityList) {
			System.out.println(i.customer.toString());
		}

	}
}
