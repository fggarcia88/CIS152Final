import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import view.AdminPanel;
import view.MainPanel;

/**************************************************************
* Name        : Final
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

/**
 * Describe the class
 * @author Fernando Garcia
 * @version
 */

public class StartProgram {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		MainPanel panelMain = new MainPanel();
		AdminPanel panelAdmin = new AdminPanel();		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		tabbedPane.add("Main",panelMain);  
		tabbedPane.add("Admin",panelAdmin);  

		frame.add(tabbedPane);  
		
		
		frame.setSize(325,355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
