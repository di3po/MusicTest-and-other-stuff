import javax.sound.midi.*;

public class MTest1 {

	public void play() {
		try {
		Sequencer sequencer = MidiSystem.getSequencer();
		System.out.println("We got a sequencer");
		} catch (MidiUnavailableException ex) {
			System.out.println("Bummer");
		}
		//Sequencer player = MidiSystem.getSequencer();
		//player.open();
		
		//Sequence seq = new Sequence(timing, 4);
		//Track t = seq.createTrack();
		//t.add(myMidiEvent1);
		//player.setSequence(seq);
		//player.start();
	}
	    
	public static void main(String[] args) {
		MTest1 mt = new MTest1();
		mt.play();
		
	}
}
