/// Rectangle Calculator (Perimeter and Area)
/// By: Nicholas Hioe
/// ICS4U1
/// Version 1.0
/// 2021-11-03
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/// About Panel
public class AboutPanel extends JPanel{
	/// Properties
	BufferedImage aboutpage = null;
	/// Methods
	// Clear and display acknowledgements panel
	public void paintComponent(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 960, 540);
		g.setColor(Color.BLACK);
		g.drawImage(aboutpage, 0, 0, null);
	}
	
	/// Constructor
	public AboutPanel(){
		super();
		try{
			aboutpage = ImageIO.read(new File("about.png"));
		}catch(IOException e){
			System.out.println("Unable to load image.");
		}
	}
	
}
