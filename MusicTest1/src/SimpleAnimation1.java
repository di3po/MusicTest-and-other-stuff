import java.awt.*;
import javax.swing.*;

public class SimpleAnimation1 {
	int x = 70;
	int y = 100;
	
	public static void main(String[] args) {
		SimpleAnimation1 sa1 = new SimpleAnimation1();
		sa1.go();
	}
	
	public void go() {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		drawingPanel drp = new drawingPanel();
		
		fr.getContentPane().add(drp);
		fr.setSize(300,300);
		fr.setVisible(true);
		
		for (int i = 0; i<140; i++) {
			x++;
			y++;
			
			drp.repaint();
			
			try {
				Thread.sleep(50);
				} catch(Exception ex) {}
		}
	}



class drawingPanel extends JPanel{
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.RED);
		g.fillOval(x, y, 10, 10);
	}
}
}