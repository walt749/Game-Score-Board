package programing_Challenges;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.*;



@SuppressWarnings("serial")
public class TopGamers_GUI extends JFrame {
	
	private Top_Ten_Gamers game;
	private JTextArea listView;
	private JTextField cmdTextField;
	private JTextField resultTextField;
	

	public TopGamers_GUI() {
		// TODO Auto-generated constructor stub
		
		game = new Top_Ten_Gamers();
		listView = new JTextArea();
		  cmdTextField = new JTextField();
		  resultTextField = new JTextField();
		
		//Set font for text area and text field.
		  Font F = new Font ("Calibri", Font.PLAIN,35);
		  Font T = new Font ("Calibri", Font.PLAIN,30);
		 Font R = new Font ("Calibri", Font.PLAIN, 15);
		  
		  resultTextField.setForeground(Color.RED);
		  resultTextField.setFont(R);
		  listView.setFont(F);
		  cmdTextField.setFont(T);
		  
		  
		  setPreferredSize(new Dimension(400, 600));
		  
		  
		  ///create a panel for result field.
		  JPanel resultPanel = new JPanel(new GridLayout(1,2));
		  resultPanel.add(new JLabel("Command Result"));
		  resultPanel.add(resultTextField);
		  resultTextField.setEditable(false);
		  add(resultPanel, BorderLayout.NORTH);
		  
		  ///put the textArea in the center of the frame.
		  add(listView);
		  listView.setEditable(false);
		  listView.setBackground(Color.WHITE);
		  
		  
		  
		  //create a panel and a label for the command text field.
		  JPanel cmdPanel = new JPanel(new GridLayout(1,2));
		  cmdPanel.add(new JLabel("Command: "));
		  cmdPanel.add(cmdTextField);
		  add(cmdPanel, BorderLayout.SOUTH);
		  cmdTextField.addActionListener(new CmTextListener());
		  
		  
		  //Set up the frame.
		  setTitle("Top gamers list");
		  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  pack();
		  setVisible(true);
		  
		
	}
	
	private class CmTextListener implements ActionListener{
		
		public void actionPerformed(ActionEvent evt){
			
			String cmdText = cmdTextField.getText();
			
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(cmdText);
			
			String cmd = sc.next();
			
			if(cmd.equals("add")|| cmd.equals("Add")){
				
				
					String name = sc.next();
					
					int score = sc.nextInt();
					game.add(name , score);
					
				
				
				listView.setText(game.toString());
				
				pack();
				return;
				
				
			}
			
			if(cmd.equals("remove")){
				
				if(sc.hasNext()){
					
					String name = sc.next();
					
					boolean res = game.remove(name);
					String resText = String.valueOf(res);
					resultTextField.setText(resText);
					
					
				}
				listView.setText(game.toString());
				pack();
				return;
				
			}
			
			if(cmd.equals("isempty") || cmd.equals("isEmpty")){
				
				String resText = String.valueOf(game.isEmpty());
				resultTextField.setText(resText);
				return;
			
			}
             
			 if(cmd.equals("size") || cmd.equals("Size")){
				 
				 String resText = String.valueOf(game.size());
				 resultTextField.setText(resText);
				 return;
				 
			 }
		}

		
	}

	public static void main(String[] args) {

		new TopGamers_GUI();
		
	}

}
