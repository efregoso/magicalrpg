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
  
  static MagicalGirlFrame mainframe = new MagicalGirlFrame("Magical RPG");
  
  public static void main(String[] args) {
    beginGame();
  }
  
  
  public void actionPerformed(ActionEvent e) {
   //advance to the next text box.
    
    
    
  }

  public static void beginGame() {
    mainframe.setVisible(true);
    mainframe.scrolltextbox.scrollText(readerDemo.returnNextLine());
  }
 
  
  
}