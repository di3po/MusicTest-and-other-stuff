import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class TestJPanelElements1 extends JPanel{

	JLabel label;
	JTextArea text;
	JPanel panelbut;
	
	public static void main(String[] args) {
		TestJPanelElements1 test = new TestJPanelElements1();
		test.go();
	}

	public void go() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JCheckBox cbox = new JCheckBox("Show where to click");
		cbox.addItemListener(new cbox1());
		
		JCheckBox menu = new JCheckBox("MENU", new ImageIcon("/home/user2/Pictures/menuicon.png"), true);
		menu.setSize(10,10);
		menu.addItemListener(new cbox1());
		
		JPanel panella = new JPanel();
		panella.setBackground(Color.orange);
		panella.setLayout(new BoxLayout(panella, BoxLayout.X_AXIS));
		
		JPanel paneltxt = new JPanel();
		paneltxt.setBackground(Color.orange);
		paneltxt.setLayout(new BoxLayout(paneltxt, BoxLayout.Y_AXIS));
		paneltxt.setSize(10, 50);
		
		panelbut = new JPanel();
		panelbut.setVisible(false);
		panelbut.setBackground(Color.orange);
		panelbut.setLayout(new BoxLayout(panelbut, BoxLayout.Y_AXIS));
		
		JButton button = new JButton("Click me!");
		button.addActionListener(new button1());
		button.setBackground(Color.green);
		
		JButton button2 = new JButton("Don't click me!");
		button2.addActionListener(new button2());
		button2.setBackground(Color.red);
		
		label = new JLabel("Click or not click? \n");
		label.setForeground(Color.blue);
		
		text = new JTextArea(10, 10);
		text.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(text);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		panella.add(label);
		panella.setAlignmentX(CENTER_ALIGNMENT);
		panelbut.add(button);
		panelbut.add(button2);
		paneltxt.add(scroller);
		
		frame.getContentPane().add(BorderLayout.NORTH, panella);
		frame.getContentPane().add(BorderLayout.NORTH, menu);
		frame.getContentPane().add(BorderLayout.WEST, panelbut);
		frame.getContentPane().add(paneltxt);
		frame.getContentPane().add(BorderLayout.SOUTH, cbox);
		
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
	
	class cbox1 implements ItemListener{
		@Override
		public void itemStateChanged(ItemEvent ev) {
			if (ev.getStateChange() == 1) {
				panelbut.setVisible(true);
			} else {
				panelbut.setVisible(false);
			}
		}
	}
	
	class button1 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			text.append("Button clicked! \n");
			text.setForeground(Color.green);
		}
	}
	
	class button2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			text.append("I said don't click it! \n");
			text.setForeground(Color.red);
		}
	}
}
