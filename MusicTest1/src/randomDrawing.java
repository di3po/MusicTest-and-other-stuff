import javax.swing.*;
import java.awt.*;

public class randomDrawing extends JPanel{

	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, this.getWidth(), this.getHeight());//black background
		int red = (int) (Math.random() * 255);
		int green = (int) (Math.random() * 255);
		int blue = (int) (Math.random() * 255);
		Color randomColor = new Color(red, green, blue);
		g.setColor(randomColor);
		g.fillOval(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2);
	}
	
	public static void main(String[] args) {
		randomDrawing r = new randomDrawing();
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setVisible(true);
		f.add(r);
	}	
}
