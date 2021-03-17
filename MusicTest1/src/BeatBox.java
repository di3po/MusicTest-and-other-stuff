import java.awt.*;
import javax.swing.*;
import javax.sound.midi.*;
import java.util.*;
import java.awt.event.*;

public class BeatBox {

	JPanel mainPanel;
	ArrayList<JCheckBox> checkBoxList;
	Sequencer sequencer;
	Sequence sequence;
	Track track;
	JFrame frame;
	
	String[] instrumentsName = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustic Snare",
								"Crash Cymbal", "Hand Clap", "High Tom", "High Bongo",
								"Maracas", "Whistle", "Low Conga", "Cowbell",
								"Vibraslap", "Low-mid Tom", "High Agogo", "Nylon Guitar"
								};
	int[] instrumentsNum = {35, 42, 46, 38, 
							49, 39, 50, 60, 
							70, 72, 64, 56, 
							58, 47, 67, 25
							};
	
	public static void main(String[] args) {
		new BeatBox().buildGui();
	}
	
	public void buildGui() {
		frame = new JFrame("my music");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BorderLayout layout = new BorderLayout();
		JPanel background = new JPanel(layout);
		background.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		background.setBackground(Color.pink);
		
		checkBoxList = new ArrayList<JCheckBox>();
		Box buttonBox = new Box(BoxLayout.Y_AXIS);
		
		JButton start = new JButton("start");
		start.addActionListener(new StartListener());
		start.setBackground(new Color(0,255,127));
		start.setForeground(Color.black);
		buttonBox.add(start);
		
		JButton stop = new JButton("stop");
		stop.addActionListener(new StopListener());
		stop.setBackground(new Color(255,51,51));
		stop.setForeground(Color.white);
		buttonBox.add(stop);
		
		JButton up = new JButton("up(+)");
		up.addActionListener(new UpListener());
		up.setBackground(Color.DARK_GRAY);
		up.setForeground(Color.white);
		buttonBox.add(up);
		
		JButton down = new JButton("down(-)");
		down.addActionListener(new DownListener());
		down.setBackground(Color.LIGHT_GRAY);
		down.setForeground(Color.white);
		buttonBox.add(down);
		
		Box nameBox = new Box(BoxLayout.Y_AXIS);
		for (int i=0; i<16; i++) {
			nameBox.add(new Label(instrumentsName[i]));
		}
	
		background.add(BorderLayout.EAST, buttonBox);
		background.add(BorderLayout.WEST, nameBox);
		
		frame.getContentPane().add(background);
		
		GridLayout grid = new GridLayout(16,16);
		grid.setVgap(1);
		grid.setHgap(2);
		mainPanel = new  JPanel(grid);
		mainPanel.setBackground(Color.gray);
		background.add(BorderLayout.CENTER, mainPanel);
		
		for (int i=0; i<256; i++) {
			JCheckBox c = new JCheckBox();
			c.setSelected(false);
			checkBoxList.add(c);
			mainPanel.add(c);
		}
		
		setUpMidi();
		
		frame.setBounds(50,50,300,300);
		frame.pack();
		frame.setVisible(true);	
	}
	
		public void setUpMidi() {
			try {
				sequencer = MidiSystem.getSequencer();
				sequencer.open();
				sequence = new Sequence(Sequence.PPQ, 4);
				track = sequence.createTrack();
				sequencer.setTempoInBPM(120);
			} catch(Exception ex) {ex.printStackTrace();}
		}
	
		public void buildTrackAndStart() {
			int[] trackList = null;
			
			sequence.deleteTrack(track);
			track = sequence.createTrack();
			
			for (int i=0; i<16; i++) {
				trackList = new int[16];
				int key = instrumentsNum[i];
				
				for (int j=0; j<16; j++) {
					JCheckBox jcb = (JCheckBox) checkBoxList.get(j+(16*i));
					
					if (jcb.isSelected()) {
						trackList[j] = key;
					} else {
						trackList[j] = 0;
					}
				}
				
				makeTracks(trackList);
				track.add(makeEvent(176,1,127,0,16));
			}
			track.add(makeEvent(192, 9, 1, 0, 15));
			try {
				sequencer.setSequence(sequence);
				sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
				sequencer.start();
				sequencer.setTempoInBPM(120);
			} catch(Exception ex) {ex.printStackTrace();}	
		}
		
		class StartListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				buildTrackAndStart();
			}			
		}
		class StopListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				sequencer.stop();
			}			
		}
		class UpListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				float tempoFactor = sequencer.getTempoFactor();
				sequencer.setTempoFactor((float)(tempoFactor * 1.03));
			}			
		}
		class DownListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent e) {
				float tempoFactor = sequencer.getTempoFactor();
				sequencer.setTempoFactor((float)(tempoFactor * .97));
			}			
		}
		
		public void makeTracks(int[] list) {
			for (int i=0; i<16; i++) {
				int key = list[i];
				if (key!=0) {
					track.add(makeEvent(144,9,key,100,i));
					track.add(makeEvent(128,9,key,100,i+1));
				}
			}
		}
	
		public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
			MidiEvent event = null;
			try {
				ShortMessage a = new ShortMessage();
				a.setMessage(comd, chan, one, two);
				event = new MidiEvent(a, tick);
			} catch(Exception ex) {ex.printStackTrace();}
			return event;
			
		}
}










