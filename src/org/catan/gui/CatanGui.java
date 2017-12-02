package org.catan.gui;
//incldue package

import org.catan.cards.*;
import org.catan.map.*;
import org.catan.players.*;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class CatanGui extends JFrame
{
	private Map map;
	private JMenuBar menuBar;
	private JMenu options;
	
	//Options submenus
	
	private JMenuItem optionClose;
	private JMenuItem optionRules;
	private JMenuItem optionCredits;
	private JButton b1;
	private JComboBox cb;
	private int playernumber;
	private ArrayList<Player>players;
	
	
	public CatanGui()
	{
		super("Catan");
		
		map = new Map();//creates the map
		
		setSize(500,500); // size
		setLayout(new FlowLayout(FlowLayout.CENTER));//Layout
		JPanel comboBoxPane = new JPanel();// create the 
		String comboBoxItems[] = { "2", "3", "4"};
		this.cb =new JComboBox(comboBoxItems);
		cb.setEditable(false);
		comboBoxPane.add(cb);
		this.getContentPane().add(comboBoxPane);
		
	    b1 = new JButton("Start");
	    b1.addActionListener(new MenuListener());
	    JTextField players = new JTextField(10);
		JPanel panel = new JPanel(new CardLayout());
		
		panel.add(b1);
		panel.add(new JLabel("Number of Players"));
		panel.add(players);
		this.getContentPane().add(panel);
		
		add(new JLabel("<HTML><center>Welcome to Catan!</center><HTML>" ));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		buildGUI();
		setVisible(true);
		//Panels will be built here
		//There will be a switch in 
	}
	
	public void buildGUI()
	{
		menuBar = new JMenuBar();
		
		options = new JMenu("Options");
		optionClose = new JMenuItem("Close");
		optionRules = new JMenuItem("Rules");
		optionCredits = new JMenuItem("Credits");
		
		optionClose.addActionListener(new MenuListener ());
		optionRules.addActionListener(new MenuListener ());
		optionCredits.addActionListener(new MenuListener ());
		
		options.add(optionClose);
		options.add(optionRules);
		options.add(optionCredits);
		
		menuBar.add(options);
		
		setJMenuBar(menuBar);
	}
	
	private class MenuListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			//JMenuItem source = (JMenuItem)(e.getSource());
			
			if(e.getSource() == optionClose ){
				System.exit(0);
			}
			else if(e.getSource() == optionRules) {
				handleRules();
			}
			else if(e.getSource() == optionCredits) {
				handleCredits();
			}
			else if(e.getSource() == b1) {
				handleStart();
			}
	//		else if(e.getSource() == action){
			//  handleFunction();}include handlers here
			//in the handler there will be the pop up windows/turning on and off the Panels
		}
		private void handleRules() {
			JTextArea textArea = new JTextArea(50,50);
			textArea.setText("Rules");
			textArea.setEditable(false);
			
			JScrollPane scrollPane = new JScrollPane(textArea);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
			
			
			JOptionPane.showMessageDialog(null, scrollPane, "Catan Rules" ,JOptionPane.PLAIN_MESSAGE );
		}
		
		private void handleCredits ( ) {}
		//private void handleFunction() {}
		private void handleStart() {
			
			ArrayList<String> playernames = new ArrayList<String>();
			JTextField player1 = new JTextField(10);
		    JTextField player2 = new JTextField(10);
		    JTextField player3 = new JTextField(10);
		    JTextField player4 = new JTextField(10);
			
			JPanel myPanel = new JPanel();
			myPanel.setLayout(new GridLayout(6,6));
			
		playernumber =	Integer.parseInt((String)cb.getSelectedItem());//gets the number of players from the combo box
			if (playernumber > 1) {//2 players enter names
				  myPanel.add(new JLabel("Player 1:"),BorderLayout.WEST);
				  myPanel.add(player1, BorderLayout.EAST);
				  myPanel.add(new JLabel("Player 2:"),BorderLayout.WEST);
				  myPanel.add(player2, BorderLayout.EAST);
				  //playernames.add(player1.getText());
				  //System.out.println("Hit");
				  //playernames.add(player2.getText());
			}
			if (playernumber > 2) {//3 
				  myPanel.add(new JLabel("Player 3:"),BorderLayout.WEST);
				  myPanel.add(player3, BorderLayout.EAST);
				  //playernames.add(player3.getText());
			}
			if (playernumber > 3) {//4
				 myPanel.add(new JLabel("Player 4:"),BorderLayout.WEST);
				 myPanel.add(player4, BorderLayout.EAST);
				// playernames.add(player4.getText());
			}
			int result = JOptionPane.showConfirmDialog(null, myPanel, "Add Course", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (result == JOptionPane.OK_OPTION) {
				if (playernumber > 1) {
					  playernames.add(player1.getText());
					  playernames.add(player2.getText());
				}
				if (playernumber> 2) {
					playernames.add(player3.getText());
				}
				if (playernumber > 3) {
					playernames.add(player4.getText());
				}
				
				players = Start.createPlayers(playernumber, playernames);//returns arraylist of players
			}
		}
		
	}
}