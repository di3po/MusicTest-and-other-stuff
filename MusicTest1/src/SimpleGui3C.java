import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class SimpleGui3C implements ActionListener{

	JFrame frame;
	
	
	public static void main(String[] args) {
		SimpleGui3C gui = new SimpleGui3C();
		gui.go();
	}
	
	public void go() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		randomrawing r = new randomrawing();
		
		JButton bn = new JButton("Change colors");
		bn.addActionListener(this);
		bn.setSize(50,20);
		
		frame.getContentPane().add(BorderLayout.EAST, bn);
		frame.getContentPane().add(BorderLayout.CENTER, r);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		frame.repaint();	
	}
}
	
	
	class randomrawing extends JPanel{

		public void paintComponent(Graphics g) {
			g.fillRect(0, 0, this.getWidth(), this.getHeight());//black background
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			Color randomColor = new Color(red, green, blue);
			g.setColor(randomColor);
			g.fillOval(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2);
		}
}


