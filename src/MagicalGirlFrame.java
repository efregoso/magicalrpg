import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MagicalGirlFrame{
	
	static JFrame frame = new JFrame("Magical RPG");
	static JTextArea text = new JTextArea();
	static JButton button = new JButton("Hello");
	static JSplitPane pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	static JSplitPane pane2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, text, button);
	static ScrollingTextboxComp scrolltextbox = new ScrollingTextboxComp();
	static JPanel panel = new JPanel();
	//static OverlayLayout paneloverlay = new OverlayLayout(panel);
	//^^ layout for overlapping elements onto each other.
	//find out if java will take transparent imgs

	public static void main(String[] args){
		text.setMinimumSize(new Dimension(700, 50));
		text.setLineWrap(true);
		text.setEditable(false);
		text.setRows(3);
		panel.setMinimumSize(new Dimension(900, 500));
		pane.add(panel, null, -1);
		pane.add(pane2, null, -1);
		frame.add(pane);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:/Users/Elizabeth/Pictures/temp/RPGDemo/01.jpg"));
		}
		catch (IOException i) {
			System.out.println("Image did not load.");
		};
		panel.add(new JLabel(new ImageIcon(img)));
		frame.setSize(900, 700);
		frame.setVisible(true);
		img = SeraSpriteImg.seraAngry();
		panel.add(new JLabel(new ImageIcon(img)));
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}
	
	public void actionPerformed(ActionEvent e){
	//do something. move onto the next dialogue.	
	}
	
}
