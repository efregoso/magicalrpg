import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import java.awt.*;


public class DemoContainer {

	public static void main (String[] args){
		BufferedImage img = null;
		JFrame f = new JFrame();
		try {
			//all graphics must be 200 x 300 to fit in the box.
			img = ImageIO.read(new File("C:/Users/Elizabeth/Pictures/temp/01.jpg"));
			f.getContentPane().setLayout(new FlowLayout());
			f.getContentPane().add(new JLabel(new ImageIcon(img)));
		}
		catch (IOException e){
			System.out.println("Image didn't load.");
		}
		f.pack();
		f.setSize(200, 300);
		f.setVisible(true);
	}
	
	
}
