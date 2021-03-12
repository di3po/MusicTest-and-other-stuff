import javax.swing.*;
import java.awt.*;

public class paintCompImg extends JPanel{
	
	public void paintComponent(Graphics g) {
		
		Image i = new ImageIcon("/home/user2/Pictures/1.jpg").getImage();
		g.drawImage(i,  0,  0,  this);
				
		/*super.paintComponent(g);
		ImageIcon image = new ImageIcon("/home/user2/Pictures/1.jpg");
		image.paintIcon(this, g, 70, 70);*/
	}
	
	public static void main(String[] args) {
		paintCompImg t = new paintCompImg();
		JFrame f = new JFrame();
		
		f.add(t);
		f.setSize(300, 300);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
