package gps2db;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class mainClassGPS{
	
	public static void main(String args[]) {
		 try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } catch (Exception ex) {
		        ex.printStackTrace();
		    }
		 
		 SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
            	 
         		gui go = new gui();
        		go.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        		go.setMinimumSize(new Dimension(640,560));
        		go.setSize(new Dimension(640,560));
        		go.setVisible(true);
        		go.setResizable(false);
         
             }
 });      

		           
		 
	}

}
