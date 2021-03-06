import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ScrollingTextboxComp extends JSplitPane implements ActionListener{

	static String string = "Hopefully, I'll be printed in a scrolling animation.";
	static JTextArea textbox = new JTextArea();
	static JButton button = new JButton("Next");
	
	//make the line an array, and then print each character after 0.00001 of a second.
	//turn each char in the string into a list element
	//iterate through the list & make each character appear on the screen
	//after a certain amount of time
	
	public ScrollingTextboxComp(){
		super(JSplitPane.HORIZONTAL_SPLIT);
		button.addActionListener(this);
		textbox.setLineWrap(true);
		textbox.setEditable(false);
		textbox.setMinimumSize(new Dimension(700, 50));
		this.add(textbox, null, -1);
		this.add(button, null, -1);
		//DEBUGGING: have it scroll through Hello
		//this.scrollText(readerDemo.returnNextLine());
	}
	
	
	public static void scrollText(String string) {
		for (int i = 0; i < string.length(); i++) {
			textbox.insert(Character.toString(string.charAt(i)), i);
			for (int j = 0; j < 10000000; j++) {
				for (int k = 0; k < 10; k++){
					//idle more
				}
			}
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if (readerDemo.getMostRecentLength() != 0){
			textbox.replaceRange(null, 0, readerDemo.getMostRecentLength());
			readerDemo.mostRecentLineLength = 0;
		}
		scrollText(readerDemo.returnNextLine());
	}
	
	//public static void hurryUp() {
		//method for displaying the rest of the text when textbox clicked.
	//}
	
	/*also want a method for displaying history of text so that person can
	 * reread what happened.
	 */
	
	public static void main(String[] args){
		ScrollingTextboxComp scroller = new ScrollingTextboxComp();
		JFrame frame = new JFrame();
		frame.add(scroller);
		frame.setSize(900, 200);
		frame.setVisible(true);
		//DEBUGGING: have it scroll through Hello
		scrollText(readerDemo.returnNextLine());

		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	
}