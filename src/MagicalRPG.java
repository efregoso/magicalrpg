/*
The fabled Magical Girl game!
It's my first attempt at making an RPG.
My plan is this:
1. Initialize a JFrame.
2. Figure out what containers are, as I think I will need multiple of those to hold different things like the textbox & background image and others.
3. Use a test image & try to make a background
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MagicalRPG implements ActionListener{
  
  static JFrame mainframe = new JFrame("Magical RPG");
  static JPanel panel = new JPanel();
  static JButton moveOn = new JButton("Next");
  
  
  public static void main(String[] args) {
    
    mainframe.getContentPane().add(panel, "Center");
    mainframe.getContentPane().add(moveOn, "");
    mainframe.setSize(600, 800);
    mainframe.setVisible(true);
    
  }
  
  
  public void actionPerformed(ActionEvent e) {
   //advance to the next text box.
    
    
    
  }
 
  
  
}