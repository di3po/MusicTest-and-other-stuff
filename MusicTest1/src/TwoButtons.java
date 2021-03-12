import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TwoButtons {
	JFrame frame;
	JLabel la, la2;
	
	public static void main(String[] args) {
		TwoButtons tb = new TwoButtons();
		tb.run();
	}
	
	public void run() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton colbut = new JButton("Change color");
		colbut.addActionListener(new LaButton());
		//???colbut.setSize(10,10);
		
		JButton labut = new JButton("Change label");
		labut.addActionListener(new LaButton());
		//???labut.setSize(30, 130);	
		
		la = new JLabel("Hello?");
		la.setBackground(Color.RED);
		//la.setLocation(20, 20);
		
		la2 = new JLabel("Hi!");
		la2.setVisible(false);
		
		drawing colbudr = new drawing();
		
		//frame.getContentPane().add(BorderLayout.EAST, colbut);
		
		frame.getContentPane().add(BorderLayout.CENTER, colbudr);
		frame.getContentPane().add(BorderLayout.NORTH, la);
		
		frame.getContentPane().add(BorderLayout.SOUTH, labut);
		//frame.getContentPane().add(BorderLayout.SOUTH, la2);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
		
	}

	/*class ColButton implements ActionListener{
		public void actionPerformed(ActionEvent a) {
			frame.repaint();
		}
	}*/

	class LaButton implements ActionListener{
	public void actionPerformed(ActionEvent a) {
			la.setText("Hi!");
		    //la2.setVisible(true);
		    frame.repaint();
		}
    }
}

class drawing extends JPanel {
	public void paintComponent(Graphics g) {
		g.fillRect(0, 10, this.getWidth(), this.getHeight());//black background
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		g.fillRect(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2);
	}
}