import javax.sound.midi.*;

public class MiniMidiMusicApp1 {

	public static void main(String[] args) {
		try {
	
			Sequencer sequencer = MidiSystem.getSequencer();//get sequencer and open it
			sequencer.open();
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);//make sequence
			Track track = seq.createTrack();//and make track
			
			for (int i = 5; i<61; i+=4) {//make bunch of events from note 5 to note 61
				track.add(makeEvent(144, 2, i, 100, i));
				track.add(makeEvent(128, 2, i, 100, i+2));/*pair of tracks 
														   (NOTE ON & NOTE OFF) 
															got from makeEvent's messages and events
															as result*/
			}
			sequencer.setSequence(seq);
			sequencer.setTempoInBPM(220);
			sequencer.start();
			
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
	}

