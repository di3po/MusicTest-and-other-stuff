import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

public class MiniMidiMusicApp2 implements ControllerEventListener{ //+*added this event

	public static void main(String[] args) {//+*added 
		
		MiniMidiMusicApp2 mini = new MiniMidiMusicApp2();
		mini.go();
		}
		
		public void go() {
		try {
	
			Sequencer sequencer = MidiSystem.getSequencer();//get sequencer and open it
			sequencer.open();
			
			int[] eventsIWant = {127};//+*
			sequencer.addControllerEventListener(this, eventsIWant);//+*
			
			Sequence seq = new Sequence(Sequence.PPQ, 4);//make sequence
			Track track = seq.createTrack();//and make track
			
			for (int i = 5; i<61; i+=4) {//make bunch of events from note 5 to note 61
				track.add(makeEvent(144, 2, i, 100, i));
				
				track.add(makeEvent(176, 1, 127, 0, i));
				
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
	
	
	public void controlChange(ShortMessage event) {//+*
		System.out.println("la");
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

