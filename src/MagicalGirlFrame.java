import javax.imageio.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MagicalGirlFrame extends JFrame{

    //next steps: make functioning action listeners, implement JTabbedPane with dialogue history tab

	static ScrollingTextboxComp scrolltextbox = new ScrollingTextboxComp();
	static JSplitPane pane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	static JPanel panel = new JPanel();
	//DEBUGGING: layout for overlapping elements onto each other
	//static OverlayLayout paneloverlay = new OverlayLayout(panel);


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
		//DEBUGGING: setting up overlaylayout for layering sprites over background
		//img = SeraSpriteImg.seraAngry();
		//paneloverlay.addLayoutComponent(new JLabel(new ImageIcon(img)), null);
		
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
