/// Rectangle Calculator (Perimeter and Area)
/// By: Nicholas Hioe
/// ICS4U1
/// Version 1.0
/// 2021-11-03
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class RectangleGUI implements ActionListener, ChangeListener{
	/// Properties
	// Frame
	JFrame frame = new JFrame("Rectangle Perimeter and Area");
	// 48 FPS
	Timer timer = new Timer(1000/48, this);
	// Panels
	RPanel panel = new RPanel();
	HelpPanel hpanel = new HelpPanel();
	AboutPanel apanel = new AboutPanel();
	
	// Length / Width / Perimeter / Area (Bars, Labels)
	JSlider lengthbar = new JSlider(SwingConstants.HORIZONTAL, 1, 10, 1);
	JSlider widthbar = new JSlider(SwingConstants.HORIZONTAL, 1, 10, 1);
	JLabel lengthtitle = new JLabel("Length:");
	JLabel widthtitle = new JLabel("Width:");
	JLabel lengthlabel = new JLabel("1 unit(s)");
	JLabel widthlabel = new JLabel("1 unit(s)");
	JLabel perimeterlabel = new JLabel("Perimeter: 4 unit(s)");
	JLabel arealabel = new JLabel("Area: 1 square unit(s)");
	
	// Options Overhead Menu
	JMenuBar menubar = new JMenuBar();
	JMenu menu = new JMenu("Options");
	JMenuItem menucalc = new JMenuItem("Calculator");
	JMenuItem menuhelp = new JMenuItem("Help");
	JMenuItem menuabout = new JMenuItem("Acknowledgements");
	
	JLabel title = new JLabel("Rectangle Perimeter/Area Calculator");
	
	/// Methods
	public void actionPerformed(ActionEvent evt){
		// Timer
		if(evt.getSource() == timer){
			panel.repaint();
		// Upon Pressing Help Menu
		}else if(evt.getSource() == menuhelp){
			hpanel.setLayout(null);
			hpanel.setPreferredSize(new Dimension(960, 540));
			frame.setContentPane(hpanel);
			frame.pack();
			hpanel.add(menubar);
			hpanel.repaint();
		// Upon Pressing Acknowledgements Menu 
		}else if(evt.getSource() == menuabout){
			apanel.setLayout(null);
			apanel.setPreferredSize(new Dimension(960, 540));
			frame.setContentPane(apanel);
			frame.pack();
			apanel.add(menubar);
			apanel.repaint();		
		// Upon Pressing Calculations Menu
		}else if(evt.getSource() == menucalc){
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(960, 540));
			frame.setContentPane(panel);
			frame.pack();
			panel.add(menubar);
			panel.repaint();
		}
	}

	public void stateChanged(ChangeEvent evt){
		
		// Change length/width/perimeter/area values depending on slider
		int intL = lengthbar.getValue();
		int intW = widthbar.getValue();
		// Get Length
		if(evt.getSource() == lengthbar){
			intL = lengthbar.getValue();
			panel.intX = intL;
			lengthlabel.setText(intL+" unit(s)");	
		// Get Width
		}else if(evt.getSource() == widthbar){
			intW = widthbar.getValue();
			panel.intY = intW;
			widthlabel.setText(intW+" unit(s)");
		}
		// Perimeter and Area Calculation
		int intPerimeter = (intL + intW) * 2;
		int intArea = intL * intW;
		perimeterlabel.setText("Perimeter: "+intPerimeter+" unit(s)");
		arealabel.setText("Area: "+intArea+" square unit(s)");
	}

	/// Constructor
	public RectangleGUI(){
		// Panel
		panel.setLayout(null);
		panel.setPreferredSize(new Dimension(960, 540));
		
		// Frame
		frame.setContentPane(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		
		// Length Components	
		lengthbar.setSize(200, 50);
		lengthbar.setLocation(85, 305);
		lengthbar.addChangeListener(this);
		panel.add(lengthbar);
		
		lengthlabel.setSize(200, 50);
		lengthlabel.setLocation(285, 300);
		panel.add(lengthlabel);	
		
		lengthtitle.setSize(200, 50);
		lengthtitle.setLocation(35, 300);
		panel.add(lengthtitle);		
		
		// Width Components
		widthbar.setSize(200, 50);
		widthbar.setLocation(85, 355);
		widthbar.addChangeListener(this);
		panel.add(widthbar);
		
		widthlabel.setSize(200, 50);
		widthlabel.setLocation(285, 350);
		panel.add(widthlabel);
		
		widthtitle.setSize(200, 50);
		widthtitle.setLocation(35, 350);
		panel.add(widthtitle);	
		
		// Perimeter Components
		perimeterlabel.setSize(200, 50);
		perimeterlabel.setLocation(35, 400);
		panel.add(perimeterlabel);	
		
		// Area Components
		arealabel.setSize(200, 50);
		arealabel.setLocation(35, 450);
		panel.add(arealabel);	
		
		// Title
		title.setSize(400, 50);
		title.setLocation(620, 35);
		panel.add(title);
		
		// Menu Components
		menubar.setSize(960, 25);
		menubar.setLocation(0, 0);
		menubar.add(menu);	
		menu.setSize(200, 25);
		menu.add(menuhelp);
		menu.add(menuabout);
		menu.add(menucalc);
		menuhelp.addActionListener(this);
		menuabout.addActionListener(this);
		menucalc.addActionListener(this);
		panel.add(menubar);

		timer.start();
	}
	
	/// Main Program
	public static void main(String[] args){
		new RectangleGUI();
	}

}
