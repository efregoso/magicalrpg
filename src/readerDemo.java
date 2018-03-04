import javax.swing.*;
import java.io.*;
import java.util.*;

public class readerDemo {

	static JTextArea textbox = new JTextArea();
	static Scanner sc = null;
	static JFrame frame = new JFrame();
	public static int mostRecentLineLength;
	
	public static void readFileDemo(){
		try {
			sc = new Scanner(new File("C:/Users/Elizabeth/OneDrive/Documents/Eclipse Projects/javaReaderDemo.txt"));
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
		}
		textbox.setEditable(false);
		textbox.setLineWrap(true);
		frame.add(textbox);
		frame.setSize(500, 500);
		frame.setVisible(true);
		for (int i = 0; sc.hasNextLine() != false; ) {
			String nextLine = sc.nextLine();
			textbox.insert(nextLine + "\n", i);
			i += nextLine.length() + 1;
		}
		sc.close();
	}
	
	public static void main(String[] args){
		readFileDemo();
	}
	
	public static String returnNextLine(){
		if (sc == null){
			try {
				sc = new Scanner(new File("C:/Users/Elizabeth/OneDrive/Documents/Eclipse Projects/javaReaderDemo.txt"));
			}
			catch (FileNotFoundException e){
				System.out.println("File not found.");
			}
		}
		if (sc.hasNextLine() != false){
			String s = sc.nextLine();
			mostRecentLineLength = s.length();
			return s;
		}
		else {
			return "Did not work.";
		}
	}
	
	public static int getMostRecentLength() {
		return mostRecentLineLength;
	}
	
	
}
