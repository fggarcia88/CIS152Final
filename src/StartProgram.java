import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import view.AdminPanel;
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
*               Input:  Input is through Javax.Swing gui, program takes fields in 
*               Main or Admin tab to add, remove or update user information
*               Output: Output shows in views for Main and Admin panels
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/

/**
 * Main driver class that runs program 
 * @author Fernando Garcia
 * @version 1.0
 */

public class StartProgram {
	public static void main(String[] args) {
		// Define frame, panels and tabbed pane view
		JFrame frame = new JFrame("Newspaper Tracker");
		MainPanel panelMain = new MainPanel();
		AdminPanel panelAdmin = new AdminPanel();		
		JTabbedPane tabbedPane = new JTabbedPane();
		// Add panels to pane
		tabbedPane.add("Main", panelMain);  
		tabbedPane.add("Admin", panelAdmin);
		// Add pane to frame
		frame.add(tabbedPane);		
		// Set frame parameters
		frame.setSize(325,355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
