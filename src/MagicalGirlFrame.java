import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MagicalGirlFrame extends JFrame{

	static ScrollingTextboxComp scrolltextbox = new ScrollingTextboxComp();
	static JSplitPane pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	static JPanel panel = new JPanel();
	//static OverlayLayout paneloverlay = new OverlayLayout(panel);
	//^^ layout for overlapping elements onto each other.
	//find out if java will take transparent imgs

	public MagicalGirlFrame(String title){
		super(title);
		panel.setMinimumSize(new Dimension(900, 500));
		pane.add(panel, null, -1);
		pane.add(scrolltextbox, null, -1);
		this.add(pane);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\Chrissy\\Google Drive (emf65@case.edu)\\Code\\Java\\MagicalRPG\\src\\RPGDemo\\01.png"));
		}
		catch (IOException i) {
			System.out.println("Image did not load.");
		};
		panel.add(new JLabel(new ImageIcon(img)));
		this.setSize(900, 700);
		//DEBUGGING: Commented out to allow user to decide when to set visible to true
		//this.setVisible(true);
		//DEBUGGING: moving this into main method
		//scrolltextbox.scrollText(readerDemo.returnNextLine());
		//img = SeraSpriteImg.seraAngry();
		//panel.add(new JLabel(new ImageIcon(img)));
		//frame.setVisible(true);
		
		this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}
	
	public void actionPerformed(ActionEvent e){
	//do something. move onto the next dialogue.	
	}
	
}
