package transaction_processing_system;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Includes the Main Menu
 * 
 * Database contains the rooms owned by the user and their status
 * 
 * Main Menu contents:
 * 	-View rooms
 * 		-Update room status
 * 			-Change to Available/Occupied/For maintenance
 * 				-When changing a room to Occupied, a receipt is generated
 * 		-Available
 * 			-Display Price, Location
 * 			-Ready for rent
 * 		-Occupied
 * 			-Until xx date/Paid until xx date
 * 			-Overdue
 * 		-For maintenance
 * 			-Things to maintain: Amenities
 * 			-Finish maintenance
 * 	-Add room
 * 	-Remove room
 * 
 */

/*
 * How could this work? We can have the different scenes exist in different panels.
 */

public class GUI {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initializeWindows() {
		
		/****************************************
		 * Constants
		 ****************************************/
		int windowWidth = 960;
		int windowHeight = 720;
		
		/****************************************
		 * Window components
		 ****************************************/
		JFrame mainWindow = new JFrame();
		
			mainWindow.setSize(windowWidth, windowHeight);
			mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainWindow.setLocationRelativeTo(null);
			mainWindow.getContentPane().setLayout(null);
			mainWindow.setResizable(false);
		
		JPanel mainMenuPanel = new JPanel();
			JLabel selectedRoom = new JLabel("Selected room index: " + Database.highlightedRoomIndex);
			mainMenuPanel.setSize(windowWidth, windowHeight);
			mainMenuPanel.setLayout(null);
			mainMenuPanel.setBackground(Color.gray);
			
			JPanel roomPanel = new JPanel(new GridLayout(3, 3));
				int roomPanelWidth = 960;
				
				//Decorative
				roomPanel.setBounds(windowWidth/2 - (roomPanelWidth/2), 0, roomPanelWidth, windowHeight - 150);
				roomPanel.setBackground(Color.BLUE);
				
				//Layout
				String imagePath;
				for (int i = 1; i < Database.roomCount; i++) {
					JLabel label = new JLabel("");
					imagePath = "/transaction_processing_system/roomImage (" + (i) + ").jpg";

					final int currentIndex = i;
					
					label.setIcon(new ImageIcon(GUI.class.getResource(imagePath)));
					
					label.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							Database.highlightedRoomIndex = currentIndex - 1;
							System.out.println(currentIndex);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							Database.highlightedRoomIndex = -1;
							System.out.println(currentIndex);
						}
						public void mouseClicked(MouseEvent e) {
							selectedRoom.setText("Selected room index: " + Database.highlightedRoomIndex);
						}
						
					});
					
					roomPanel.add(label);
				}
				
			JPanel buttonPanel = new JPanel();
				buttonPanel.setBounds(0, roomPanel.getHeight(), windowWidth, 150);
				buttonPanel.setBackground(Color.orange);
			
			mainMenuPanel.add(roomPanel);
			
			mainMenuPanel.add(buttonPanel);
			
			JButton btnNewButton = new JButton("Update room status");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			buttonPanel.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Add room");
			buttonPanel.add(btnNewButton_1);
			
			JButton btnNewButton_2 = new JButton("Remove room");
			buttonPanel.add(btnNewButton_2);
			
			buttonPanel.add(selectedRoom);
			
		
		//Main Window component additions
			mainWindow.getContentPane().add(mainMenuPanel);
			mainWindow.setVisible(true);
		
	}
	
	public void goto_MainMenu() {
		
	}

}
