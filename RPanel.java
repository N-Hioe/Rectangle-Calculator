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

/// Rectangle Main Calculation Panel
public class RPanel extends JPanel{
	/// Properties
	int intX = 1;
	int intY = 1;
	BufferedImage formulas = null;
	
	/// Methods
	// Clear and display main calculation panel
	public void paintComponent(Graphics g){
		g.setColor(new Color(238, 238, 238));
		g.fillRect(0, 0, 960, 540);
		g.setColor(Color.BLACK);
		g.drawRect(600, 100, intX*25, intY*25);
		
		// Width Line
		g.setColor(Color.BLUE);
		g.drawLine(590, 100, 590, 100 + intY*25);
		g.drawLine(585, 100, 595, 100); 
		g.drawLine(585, 100 + intY*25, 595, 100 + intY*25); 
		
		
		// Length Line
		g.setColor(Color.RED);
		g.drawLine(600, 90, 600 + intX*25, 90); 
		g.drawLine(600, 85, 600, 95);
		g.drawLine(600 + intX*25, 85, 600 + intX*25, 95);
		
		// Formula Visual
		g.drawImage(formulas, 25, 35, null);
		
	}
	
	/// Constructor
	public RPanel(){
		super();
		try{
			formulas = ImageIO.read(new File("rectangle1.png"));
		}catch(IOException e){
			System.out.println("Unable to load image.");
		}
		
	}
	
}
