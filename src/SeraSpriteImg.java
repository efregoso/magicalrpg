import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class SeraSpriteImg {
	
	static BufferedImage sprite = null;
	
	public static BufferedImage seraAngry() {
		try {
			sprite = ImageIO.read(new File("C:\\Users\\Chrissy\\Google Drive (emf65@case.edu)\\Code\\Java\\MagicalRPG\\src\\RPGDemo\\seraspritebeta.png"));
		}
		catch (IOException i){
			System.out.println("seraAngry did not load.");
		};
		return sprite;
	}
}
