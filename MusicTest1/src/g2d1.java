import javax.swing.*;
import java.awt.*;

public class g2d1 extends JPanel{

	public void paintComponent(Graphics g) {
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		Graphics2D g2D = (Graphics2D) g;
		GradientPaint gr = new GradientPaint(5, 100, Color.red, 10, 200, Color.pink);
		g2D.setPaint(gr);
		g2D.fillOval(getWidth()/4, getHeight()/4, getWidth()/2, getHeight()/2);
	}
	
	public static void main(String[] args) {
		g2d1 r = new g2d1();
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300, 300);
		f.setVisible(true);
		f.add(r);
	}
	
	
}
