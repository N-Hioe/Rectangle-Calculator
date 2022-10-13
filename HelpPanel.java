import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/// Help Panel
public class HelpPanel extends JPanel{
	/// Properties
	BufferedImage helppage = null;
	
	/// Methods
	// Clear and display help panel
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 960, 540);
		g.setColor(Color.BLACK);
		g.drawImage(helppage, 0, 0, null);
	}
	
	/// Constructor
	public HelpPanel(){
		super();
		try{
			helppage = ImageIO.read(new File("help.png"));
		}catch(IOException e){
			System.out.println("Unable to load image.");
		}
	}
	
}
