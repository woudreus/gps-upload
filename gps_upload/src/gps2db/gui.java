package gps2db;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;

import static java.util.Optional.ofNullable;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class gui extends JFrame {
	
	 JTextField username = new JTextField(30);
	 JPasswordField password = new JPasswordField(30);
	
	 JLabel usernameL = new JLabel("Username");
	 JLabel passwordL = new JLabel("Password"); 
	
	 TextField input = new TextField(38);
	
	 JLabel inputL = new JLabel("Input");
	
	 JTextField kapr = new JTextField(30);
	 JTextField vel = new JTextField(30);
	 JTextField inv = new JTextField(30);
	 JTextField stro = new JTextField(30);
	 JTextField weg = new JTextField(30);
	 JTextField gren = new JTextField(30);
	 JTextField kapv = new JTextField(30);
	 JTextField lan = new JTextField(30);
	 JTextField kam = new JTextField(30);
	
	 JLabel kaprL = new JLabel("Kapregister Controle");
	 JLabel velL = new JLabel("Veld Controle");
	 JLabel invL = new JLabel("Inventarisatie Controle");
	 JLabel stroL = new JLabel("Stroperij");
	 JLabel wegL = new JLabel("Weg Controle");
	 JLabel grenL = new JLabel("Grens Controle");
	 JLabel kapvL = new JLabel("Kapvak Controle");
	 JLabel lanL = new JLabel("Landing");
	 JLabel kamL = new JLabel("Kamp");
	
 	 JRadioButton newW = new JRadioButton("New Waypoints", true);
	 JRadioButton duplW = new JRadioButton("Duplicate Waypoints", false);
	 JRadioButton overwrW = new JRadioButton("Overwrite Waypoints", false);
	 JRadioButton skipW = new JRadioButton("Skip Waypoints", false);

	 JRadioButton newTr = new JRadioButton("New Tracks", true);
	 JRadioButton duplTr = new JRadioButton("Duplicate Tracks", false);
	 JRadioButton overwrTr = new JRadioButton("Overwrite Tracks", false);
	 JRadioButton skipTr = new JRadioButton("Skip Tracks", false);
			
	 String nameString = new String();
	 String pathString = new String();

	 JButton select = new JButton("SELECT");
	 JButton run = new JButton("RUN");
	 JButton refresh = new JButton("REFRESH");
	 
		 

	public gui(){
		
		super("GPX2DB Tool");
		
	KeyAdapter keyListener = new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
				if( (  ((c < '0') || (c > '9') ) && ((c != ':') &&
				  (c != ',')) ) && (c != KeyEvent.VK_BACK_SPACE) ){					
					e.consume();					
				}								
			}		
		};
		
		

		kapr.addKeyListener(keyListener);
		vel.addKeyListener(keyListener);
		kapv.addKeyListener(keyListener);
		lan.addKeyListener(keyListener);
		kam.addKeyListener(keyListener);
		stro.addKeyListener(keyListener);
		weg.addKeyListener(keyListener);
		inv.addKeyListener(keyListener);
		gren.addKeyListener(keyListener);
		
		ButtonGroup groupW = new ButtonGroup();
		ButtonGroup groupTr = new ButtonGroup();
		
		groupW.add(newW);
		groupW.add(duplW);
		groupW.add(overwrW);
		groupW.add(skipW);

		groupTr.add(newTr);
		groupTr.add(duplTr);
		groupTr.add(overwrTr);
		groupTr.add(skipTr);
		
	    setLocationRelativeTo(null);
	    
		JPanel parent = new JPanel();
		ImageIcon icon = new ImageIcon((getClass().getClassLoader().getResource("background1_.png")));
		JLabel label =  new JLabel(icon);
		
		//ImageIcon icon2 = new ImageIcon((getClass().getClassLoader().getResource("pleasewait.png")));
	//	JLabel label2 =  new JLabel(icon2);
		
		setContentPane(label);
		
		setLayout(new GridBagLayout());
		parent.setLayout(new GridBagLayout());
		add(parent);
		
		parent.setSize(600,500);
		parent.setOpaque(false);
			
	    GridBagConstraints constraintsParent = new GridBagConstraints();
	    constraintsParent.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsParent.insets = new Insets(2, 0, 2, 20);
	
        GridBagConstraints constraintsLogin = new GridBagConstraints();
        constraintsLogin.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsLogin.insets = new Insets(2, 0, 2, 46);
        constraintsLogin.fill = GridBagConstraints.FIRST_LINE_START;
        
        GridBagConstraints constraintsLoginL = new GridBagConstraints();
        constraintsLoginL.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsLoginL.insets = new Insets(8, 2, 2, 2);
        constraintsLoginL.fill = GridBagConstraints.FIRST_LINE_START;
        
        GridBagConstraints constraintsLoginT = new GridBagConstraints();
        constraintsLoginT.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsLoginT.insets = new Insets(5, 2, 2, 2);
        constraintsLoginT.fill = GridBagConstraints.FIRST_LINE_START;
        
        GridBagConstraints constraintsInput = new GridBagConstraints();
        constraintsInput.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsInput.insets = new Insets(2, 0, 2, 15);
        
        GridBagConstraints constraintsCtrlGrp = new GridBagConstraints();
        constraintsCtrlGrp.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsCtrlGrp.insets = new Insets(2, 0, 2, 0);
        
        GridBagConstraints constraintsLabelsCtrl = new GridBagConstraints();
        constraintsLabelsCtrl.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsLabelsCtrl.insets = new Insets(3, 2, 15, 25);
        
        GridBagConstraints constraintsTextsCtrl = new GridBagConstraints();
        constraintsTextsCtrl.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsTextsCtrl.insets = new Insets(2, 2, 11, 2);
        
        GridBagConstraints constraintsButtonGrp = new GridBagConstraints();
        constraintsButtonGrp.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsButtonGrp.insets = new Insets(30, 0, 13, 0);
        
        GridBagConstraints constraintsButtonW = new GridBagConstraints();
        constraintsButtonW.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsButtonW.insets = new Insets(2, 2, 2, 2);
        
        GridBagConstraints constraintsButtonTr = new GridBagConstraints();
        constraintsButtonTr.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsButtonTr.insets = new Insets(2, 2, 2, 20);
        
        GridBagConstraints constraintsButtons = new GridBagConstraints();
        constraintsButtons.anchor = GridBagConstraints.FIRST_LINE_START;
        constraintsButtons.insets = new Insets(2, 4, 2, 2);
        
        JPanel layoutLogin = new JPanel(new GridBagLayout());

        JPanel layoutLoginL = new JPanel(new GridBagLayout());
        
        JPanel layoutLoginT = new JPanel(new GridBagLayout());
        
        JPanel layoutInput = new JPanel(new GridBagLayout());
        
        JPanel layoutCtrlGrp = new JPanel(new GridBagLayout());
        	        
        JPanel layoutLabelsCtrl = new JPanel(new GridBagLayout());
               
        JPanel layoutTextsCtrl = new JPanel(new GridBagLayout());
        
        JPanel layoutButtonGrp = new JPanel(new GridBagLayout()); 
        
        JPanel layoutButtonW = new JPanel(new GridBagLayout());
        
        JPanel layoutButtonTr = new JPanel(new GridBagLayout());
        
        JPanel layoutButtons = new JPanel(new GridBagLayout());
		
		constraintsLoginL.gridx = 0;
		constraintsLoginL.gridy = 0;
		layoutLoginL.add(usernameL, constraintsLoginL);
		
		constraintsLoginL.gridx = 0;
		constraintsLoginL.gridy = 1;
		layoutLoginL.add(passwordL, constraintsLoginL);
		
		constraintsLoginT.gridx = 0;
		constraintsLoginT.gridy = 0;
		layoutLoginT.add(username, constraintsLoginT);
		
		constraintsLoginT.gridx = 0;
		constraintsLoginT.gridy = 1;
		layoutLoginT.add(password, constraintsLoginT);
		
		constraintsLogin.gridx = 0;
		constraintsLogin.gridy= 0;
		layoutLogin.add(layoutLoginL, constraintsLogin);
		
		constraintsLogin.gridx = 1;
		constraintsLogin.gridy= 0;
		layoutLogin.add(layoutLoginT, constraintsLogin);
			
		layoutLogin.setBorder(BorderFactory.createTitledBorder(
	               BorderFactory.createRaisedSoftBevelBorder(),"Log In", TitledBorder.CENTER, TitledBorder.CENTER,
	               new Font("sans", Font.BOLD, 12 ), new Color(255, 228, 149) ));  
		
		constraintsParent.gridx = 0;
		constraintsParent.gridy = 0;
		parent.add(layoutLogin, constraintsParent);
		

		layoutLogin.setBackground(new Color(114,93,43,150));
		layoutLoginL.setBackground(new Color(0,0,0,0));
		layoutLoginT.setBackground(new Color(0,0,0,0));
		
		constraintsInput.gridx = 0;
		constraintsInput.gridy = 0;
		layoutInput.add(inputL, constraintsInput);
		
		constraintsInput.gridx = 1;
		constraintsInput.gridy = 0;
		layoutInput.add(input, constraintsInput);
		
		constraintsInput.gridx = 2;
		constraintsInput.gridy = 0;
		layoutInput.add(select, constraintsInput);
		
		constraintsParent.gridx = 0;
		constraintsParent.gridy = 1;
		parent.add(layoutInput, constraintsParent);
		
	
		layoutInput.setBorder(BorderFactory.createTitledBorder(
	               BorderFactory.createRaisedSoftBevelBorder(), "Input GPX", TitledBorder.CENTER, TitledBorder.CENTER,
	               new Font("sans", Font.BOLD, 12 ), new Color(255, 228, 149) ));  
		
		layoutInput.setBackground(new Color(114,93,43,150));
		//
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 0;
		layoutLabelsCtrl.add(kaprL, constraintsLabelsCtrl);	
		
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 1;
		layoutLabelsCtrl.add(velL, constraintsLabelsCtrl);
		
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 2;
		layoutLabelsCtrl.add(invL, constraintsLabelsCtrl);

		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 3;
		layoutLabelsCtrl.add(kapvL, constraintsLabelsCtrl);
		
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 4;
		layoutLabelsCtrl.add(grenL, constraintsLabelsCtrl);
		
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 5;
		layoutLabelsCtrl.add(stroL, constraintsLabelsCtrl);
		
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 6;
		layoutLabelsCtrl.add(wegL, constraintsLabelsCtrl);
		
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 7;
		layoutLabelsCtrl.add(lanL, constraintsLabelsCtrl);
		
		constraintsLabelsCtrl.gridx = 0;
		constraintsLabelsCtrl.gridy = 8;
		layoutLabelsCtrl.add(kamL, constraintsLabelsCtrl);

		constraintsCtrlGrp.gridx= 0;
		constraintsCtrlGrp.gridy= 0;
		layoutCtrlGrp.add(layoutLabelsCtrl, constraintsCtrlGrp);
		
		//
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 0;
		layoutTextsCtrl.add(kapr, constraintsTextsCtrl);	
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 1;
		layoutTextsCtrl.add(vel, constraintsTextsCtrl);
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 2;
		layoutTextsCtrl.add(inv, constraintsTextsCtrl);

		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 3;
		layoutTextsCtrl.add(kapv, constraintsTextsCtrl);
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 4;
		layoutTextsCtrl.add(gren, constraintsTextsCtrl);
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 5;
		layoutTextsCtrl.add(stro, constraintsTextsCtrl);
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 6;
		layoutTextsCtrl.add(weg, constraintsTextsCtrl);
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 7;
		layoutTextsCtrl.add(lan, constraintsTextsCtrl);
		
		constraintsTextsCtrl.gridx = 0;
		constraintsTextsCtrl.gridy = 8;
		layoutTextsCtrl.add(kam, constraintsTextsCtrl);
		
		constraintsCtrlGrp.gridx= 1;
		constraintsCtrlGrp.gridy= 0;
		layoutCtrlGrp.add(layoutTextsCtrl, constraintsCtrlGrp);
		
		constraintsParent.gridx = 0;
		constraintsParent.gridy = 2;
		parent.add(layoutCtrlGrp, constraintsParent);
		
		layoutCtrlGrp.setBorder(BorderFactory.createTitledBorder(
	               BorderFactory.createRaisedSoftBevelBorder(), "Controle", TitledBorder.CENTER, TitledBorder.CENTER,
	               new Font("sans", Font.BOLD, 12 ), new Color(255, 228, 149) ));  
		
		//
		
		layoutCtrlGrp.setBackground(new Color(114,93,43,150));
		layoutTextsCtrl.setOpaque(false);
		layoutLabelsCtrl.setOpaque(false);
		
		constraintsButtons.gridx = 0;
		constraintsButtons.gridy = 0;
		layoutButtons.add(run, constraintsButtons);
		
		constraintsButtons.gridx = 1;
		constraintsButtons.gridy = 0;
		layoutButtons.add(refresh, constraintsButtons);
		
		constraintsParent.gridx = 0;
		constraintsParent.gridy = 3;
		parent.add(layoutButtons, constraintsParent);
		
		layoutButtons.setOpaque(false);
		//
		
		constraintsButtonW.gridx = 0;
		constraintsButtonW.gridy = 0;
		layoutButtonW.add(newW, constraintsButtonW);
		
		constraintsButtonW.gridx = 0;
		constraintsButtonW.gridy = 1;
		layoutButtonW.add(overwrW, constraintsButtonW);
		
		constraintsButtonW.gridx = 0;
		constraintsButtonW.gridy = 2;
		layoutButtonW.add(duplW, constraintsButtonW);
		
		constraintsButtonW.gridx = 0;
		constraintsButtonW.gridy = 3;
		layoutButtonW.add(skipW, constraintsButtonW);
				
		//
		
		constraintsButtonTr.gridx = 0;
		constraintsButtonTr.gridy = 0;
		layoutButtonTr.add(newTr, constraintsButtonTr);
		
		constraintsButtonTr.gridx = 0;
		constraintsButtonTr.gridy = 1;
		layoutButtonTr.add(overwrTr, constraintsButtonTr);
		
		constraintsButtonTr.gridx = 0;
		constraintsButtonTr.gridy = 2;
		layoutButtonTr.add(duplTr, constraintsButtonTr);
		
		constraintsButtonTr.gridx = 0;
		constraintsButtonTr.gridy = 3;
		layoutButtonTr.add(skipTr, constraintsButtonTr);
			
		constraintsButtonGrp.gridx = 0;
		constraintsButtonGrp.gridy = 0;
		layoutButtonGrp.add(layoutButtonW, constraintsButtonGrp);
		
		constraintsButtonGrp.gridx = 0;
		constraintsButtonGrp.gridy = 1;
		layoutButtonGrp.add(layoutButtonTr, constraintsButtonGrp);
		
		constraintsParent.gridx = 1;
		constraintsParent.gridy = 2;
		parent.add(layoutButtonGrp, constraintsParent);
		
		layoutButtonGrp.setBorder(BorderFactory.createTitledBorder(
	               BorderFactory.createRaisedSoftBevelBorder(), "settings", TitledBorder.CENTER, TitledBorder.CENTER,
	               new Font("sans", Font.BOLD, 12 ), new Color(255, 228, 149) ));  
		
		layoutButtonGrp.setBackground(new Color(114,93,43,150));
		layoutButtonW.setBackground(new Color(114,93,43));
		layoutButtonTr.setBackground(new Color(114,93,43));
		newW.setBackground(new Color(114,93,43));
		overwrW.setBackground(new Color(114,93,43));
		duplW.setBackground(new Color(114,93,43));
		skipW.setBackground(new Color(114,93,43));
		newTr.setBackground(new Color(114,93,43));
		overwrTr.setBackground(new Color(114,93,43));
		duplTr.setBackground(new Color(114,93,43));
		skipTr.setBackground(new Color(114,93,43));
		
		//
		
		Color brownish = new Color(212,204,166);
		select.setBackground(brownish);
		select.setContentAreaFilled(false);
		select.setOpaque(true);
		select.setFont(new Font("sans", Font.BOLD, 12) );
		select.setForeground(new Color(90,45,0));
		
		run.setBackground(brownish);
		run.setContentAreaFilled(false);
		run.setOpaque(true);
		run.setFont(new Font("sans", Font.BOLD, 12) );
		run.setForeground(new Color(90,45,0));
		
		refresh.setBackground(brownish);
		refresh.setContentAreaFilled(false);
		refresh.setOpaque(true);
		refresh.setFont(new Font("sans", Font.BOLD, 12) );
		refresh.setForeground(new Color(90,45,0));
		
		Color labelColor = new Color(250,239,192);
		Font labelFont = new Font("sans", Font.BOLD, 11);
		
		kaprL.setFont(labelFont);
		kaprL.setForeground(labelColor);
		
		velL.setFont(labelFont);
		velL.setForeground(labelColor);
		
		invL.setFont(labelFont);
		invL.setForeground(labelColor);
		
		wegL.setFont(labelFont);
		wegL.setForeground(labelColor);
		
		stroL.setFont(labelFont);
		stroL.setForeground(labelColor);
		
		kapvL.setFont(labelFont);
		kapvL.setForeground(labelColor);
		
		kamL.setFont(labelFont);
		kamL.setForeground(labelColor);
		
		lanL.setFont(labelFont);
		lanL.setForeground(labelColor);
		
		grenL.setFont(labelFont);
		grenL.setForeground(labelColor);
		
		inputL.setFont(labelFont);
		inputL.setForeground(labelColor);
		
		passwordL.setFont(labelFont);
		passwordL.setForeground(labelColor);
		
		usernameL.setFont(labelFont);
		usernameL.setForeground(labelColor);
		
		newW.setFont(labelFont);
		newW.setForeground(labelColor);
		
		newTr.setFont(labelFont);
		newTr.setForeground(labelColor);
		
		overwrW.setFont(labelFont);
		overwrW.setForeground(labelColor);
		
		overwrTr.setFont(labelFont);
		overwrTr.setForeground(labelColor);
		
		duplW.setFont(labelFont);
		duplW.setForeground(labelColor);
		
		duplTr.setFont(labelFont);
		duplTr.setForeground(labelColor);
		
		skipW.setFont(labelFont);
		skipW.setForeground(labelColor);
		
		skipTr.setFont(labelFont);
		skipTr.setForeground(labelColor);
		
	//
		
	    select.addActionListener(new ActionListener(){
	    	   public void actionPerformed(ActionEvent ae) {
	     
	    		 JFileChooser fileChooser = new JFileChooser();
	             int returnValue = fileChooser.showOpenDialog(null);
	    	     if (returnValue == JFileChooser.APPROVE_OPTION) {
	                 File selectedFile = fileChooser.getSelectedFile();
	                	  
	                  	  nameString = String.format("%s",selectedFile.getName());
	                	  pathString = String.format("\"%s\"",selectedFile.getParent());

	                
	                 	  if(nameString.endsWith("gpx") || input.equals("") ){
	                 	 	  input.setBackground(Color.white);
	                 		  input.setText(".../"+nameString);
	                   	  }else { input.setText("Invalid file format: "+ nameString);
	                 		  	  input.setBackground(Color.RED);}	  
	    	      		}    
	    	      }
	    	 }
	     );

	    
	    run.addActionListener(new ActionListener() {
	    	//   @Override
	          public void actionPerformed(ActionEvent q) {
	        	  
	      	  

	    	   nameString = String.format("\"%s\"", nameString);
		String kaprString = String.format("%s",    kapr.getText().equals("") ? "NA": kapr.getText()); 
		String veldString = String.format("%s",    vel.getText().equals("") ? "NA" : vel.getText());
		String invString = String.format("%s",     inv.getText().equals("") ? "NA" : inv.getText());
		String kapvString = String.format("%s",    kapv.getText().equals("") ? "NA" : kapv.getText());
		String grensString = String.format("%s",   gren.getText().equals("") ? "NA" : gren.getText());
		String stroperString = String.format("%s", stro.getText().equals("") ? "NA" : stro.getText());
		String wegString = String.format("%s",     weg.getText().equals("") ? "NA" : weg.getText());
		String landString = String.format("%s",    lan.getText().equals("") ? "NA" : lan.getText());
		String kampString = String.format("%s",    kam.getText().equals("") ? "NA" : kam.getText());
		
		String newWString = String.format("%S",      newW.isSelected());
		String newTrString = String.format("%S",     newTr.isSelected());
		String overwrWString = String.format("%S",   overwrW.isSelected());
		String overwrTrString  = String.format("%S", overwrTr.isSelected());
		String duplWString = String.format("%S",     duplW.isSelected());
		String duplTrString = String.format("%S",    duplTr.isSelected());
		String skipWString = String.format("%S",     skipW.isSelected());
		String skipTrString = String.format("%S",    skipTr.isSelected());
		
		String usernameString = username.getText();
		String passwordString = new String(password.getPassword());

		String RFolder1 = new String("C:\\Program Files\\R\\"); 
		String RFolder2 = new String(System.getProperty("user.home") + "\\Documents\\R\\");
		
		String command = new String();
		
//		  System.out.println(pathString);
  	   // System.out.println(nameString);
		
		//System.out.println();
		
	if(new File(RFolder1).exists()){
		
		command = String.format("%s %s\"%s%s\"", "cmd.exe", "/C ", " cd C:\\Program Files\\R\\R-3.*.*\\bin\\ & ", "Rscript C:\\gps_upload\\data\\gpsuploadV2.r "+ " "
		+ kaprString + " " + veldString + " " + kapvString + " " + stroperString + " "
		+ grensString + " " + invString + " " + wegString + " " + landString + " "
		+ kampString + " " + newWString + " " + overwrWString + " " + duplWString + " "
		+ skipWString + " " + newTrString + " " + overwrTrString + " " + duplTrString + " "
		+ skipTrString + " "+ usernameString + " " + passwordString + " " + nameString + " " + pathString);
		  
	} else if(new File(RFolder2).exists()){
		
		command = String.format("%s %s\"%s%s\"", "cmd.exe", "/C ", " cd %userprofile%\\Documents\\R\\R-3.*.*\\bin\\ & ", "Rscript C:\\gps_upload\\data\\gpsuploadV2.r "+ " "
		+ kaprString + " " + veldString + " " + kapvString + " " + stroperString + " "
		+ grensString + " " + invString + " " + wegString + " " + landString + " "
		+ kampString + " " + newWString + " " + overwrWString + " " + duplWString + " "
		+ skipWString + " " + newTrString + " " + overwrTrString + " " + duplTrString + " "
		+ skipTrString + " "+ usernameString + " " + passwordString + " " + nameString + " " + pathString);
	}
	
		try	{
		    Process process = Runtime.getRuntime().exec(command);
		    process.waitFor();

		    	    
		    
		    BufferedReader stdInput = new BufferedReader(new 
		    	     InputStreamReader(process.getInputStream()));

		    	BufferedReader stdError = new BufferedReader(new 
		    	     InputStreamReader(process.getErrorStream()));

		    	// read the output from the command
		    	System.out.println("Here is the standard output of the command:\n");
		    	String s = null;
		    	while ((s = stdInput.readLine()) != null) {
		    	    System.out.println(s);
		    	}

		    	// read any errors from the attempted command
		    	System.out.println("Here is the standard error of the command (if any):\n");
		    	while ((s = stdError.readLine()) != null) {
		    	    System.out.println(s);
		    	}
		    
		    
			} catch (IOException e)
			{  e.printStackTrace();} catch (InterruptedException e) {e.printStackTrace();} 
		
	
		
		setContentPane(label);
		setLayout(new GridBagLayout());
		
		layoutInput.setVisible(true);
	 	layoutCtrlGrp.setVisible(true);
        layoutButtonGrp.setVisible(true);
	    layoutLogin.setVisible(true);
	    layoutButtons.setVisible(true);	  	

	    pack();
	
	          }
	    });
	      
	      refresh.addActionListener(
	    		  new ActionListener(){
	   @Override
	    		  public void actionPerformed(ActionEvent h){
	    		
	    			   
	    				kapr.setText("");

	    				vel.setText("");

	    				inv.setText("");

	    				kapv.setText("");

	    				stro.setText("");

	    				weg.setText("");

	    				lan.setText("");

	    				kam.setText("");
	    	
	    				gren.setText("");

	    				input.setText(" ");

	    				newW.setSelected(true);
	    				newTr.setSelected(true);
	    				
	    				overwrW.setSelected(false);
	    				overwrTr.setSelected(false);
	    				
	    				duplW.setSelected(false);
	    				duplTr.setSelected(false); 				   
	    				
	    				skipW.setSelected(false);
	    				skipTr.setSelected(false);
	    				
	    				parent.setVisible(false);
	    				parent.setVisible(true);
	    				
	   				}
	    		   }
	    		  );
	   	}
}