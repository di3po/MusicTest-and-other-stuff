import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class MyDrawPanel extends JPanel{

	JButton redbutton;
	JButton orangebutton;
	JButton greenbutton;

	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(getWidth()/4+10, getHeight()/4, 120, 200);
		g.setColor(Color.red);
		g.fillOval(120, getHeight()/4+10, 55, 55);
		g.setColor(Color.orange);
		g.fillOval(120, getHeight()/4+75, 55, 55);
		g.setColor(Color.green);
		g.fillOval(120, getHeight()/4+140, 55, 55);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton redbutton = new JButton("RED");
		redbutton.setSize(70, 20);
		redbutton.setLocation(20,  10);
		//redbutton.addActionListener(this);
		/*redbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event, Graphics g) {
				g.setColor(Color.red);
				g.fillOval(125, 45, 55, 55);}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});*/
		
		JButton orangebutton = new JButton("YELLOW");
		orangebutton.setSize(170, 20);
		orangebutton.setLocation(100, 10);
		//orangebutton.addActionListener(this);
		
		JButton greenbutton = new JButton("GREEN");
		greenbutton.setSize(250, 20);
		greenbutton.setLocation(20, 40);
		//greenbutton.addActionListener(this);
		
		MyDrawPanel s = new MyDrawPanel();
		
		frame.add(redbutton);
		frame.add(orangebutton);
		frame.add(greenbutton);
		frame.add(s);
		frame.setSize(300, 500);
	    frame.setVisible(true);	
		}
	}	

	
	
	
	


