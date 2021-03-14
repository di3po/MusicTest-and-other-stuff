import java.io.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MiniMidiMusicApp3{ 

	static JFrame frame = new JFrame("My First Midi Video");
	static drawingPanel drp;
	
	public static void main(String[] args) {//+*added 
		
		MiniMidiMusicApp3 mini = new MiniMidiMusicApp3();
		mini.go();
		}
		
		public void setUpGui() {
			drp = new drawingPanel();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setContentPane(drp);
			frame.setBounds(30, 30, 300, 300);
			frame.setVisible(true);
		}
	
		public void go() {
		setUpGui();
			
		try {
	
			Sequencer sequencer = MidiSystem.getSequencer();//get sequencer and open it
			sequencer.open();
			sequencer.addControllerEventListener(drp, new int[] {127});//+*			
			Sequence seq = new Sequence(Sequence.PPQ, 4);//make sequence
			Track track = seq.createTrack();//and make track
			
			int r = 0;	
			for (int i = 0; i<60; i+=4) {//make bunch of events from note 5 to note 61
				
				r = (int)((Math.random()*50)+1);				
				track.add(makeEvent(144, 1, r, 100, i));				
				track.add(makeEvent(176, 1, 127, 0, i));				
				track.add(makeEvent(128, 1, r, 100, i+2));/*pair of tracks 
														   (NOTE ON & NOTE OFF) 
															got from makeEvent's messages and events
															as result*/
			}
			sequencer.setSequence(seq);
			sequencer.start();
			sequencer.setTempoInBPM(120);	
			
		    } catch(Exception ex) { ex.printStackTrace();}
	}
	
	
	
	public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);
		} catch(Exception ex) { }
				return event;
		}
	
class drawingPanel extends JPanel implements ControllerEventListener{
	
	boolean msg = false;
	
	public void controlChange(ShortMessage event) {//+*
		msg = true;
		repaint();
	}
	
	public void paintComponent(Graphics g) {
	
	if (msg) {	
		
		Graphics2D g1 = (Graphics2D) g;
		
		//g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		int red = (int)(Math.random()*250);
		int green = (int)(Math.random()*250);
		int blue = (int)(Math.random()*250);
		
		g.setColor(new Color(red, green, blue));
		
		int height = (int)((Math.random()*120)+10);
		int width = (int)((Math.random()*120)+10);
		int x = (int)((Math.random()*40)+10);
		int y = (int)((Math.random()*40)+10);
		g.fillRect(x, y, height, width);
		msg = false;
	}
}
}

}

