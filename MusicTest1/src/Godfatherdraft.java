import javax.sound.midi.*;

public class Godfatherdraft {
	
	

	public static void main(String[] args) {
		try {
			 int[] notes1  = {55,60,63,62,60,63,60,62,60,56,58,55}; // G C D# D C D# C D C G# A# G
			 int[] notes2  = {55,60,63,62,60,63,60,62,60,55,54,53}; // G C D# D C D# C D C G F# F
			 int[] notes3  = {53,56,59,62}; // F G# B D
			 int[] notes4  = {53,56,59,60}; // F G# B C
			 int[] notes5  = {48,51,58,56,55,58,56,   56,55,55,71,72}; // C D# A# G# G A# G# G#  F G
			 int[] notes5b = {56,55,55,71,72}; 
			/* int[] notes6  = {60,59,58,62,58,55,58,56,56,54,55}; // C B A# D A# G A# G# G# F# G
			 int[] notes7  = {55,60,63,62,60,63,60,62,60,56,58,55}; // G C D# D C D# C D C G# A# G
			 int[] notes8  = {55,60,63,62,60,63,60,62,60,55,54,53}; // G C D# D C D# C D C G F# F
			*/
			 Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
		     midiSynth.open();
		        
		     MidiChannel[] mChannels = midiSynth.getChannels();
		     
		     Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
		     
		     Instrument piano = instr[1];
		     if(piano==null) {System.out.println("Couldn't find piano."); System.exit(0);}
		     
		     Patch pianoPatch = piano.getPatch();
		        
		     mChannels[0].programChange(pianoPatch.getBank(), pianoPatch.getProgram());
		     
		     //notes1
		     for (int i=0; i<notes1.length; i++) {
		    	 mChannels[0].noteOn(notes1[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes1[i], 100);
			     notes1[i]++;
		     }
		     try { Thread.sleep(1500); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		     
		     //notes2
		     for (int i=0; i<notes2.length; i++) {
		    	 mChannels[0].noteOn(notes2[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes2[i], 100);
			     notes2[i]++;
		     }
		     try { Thread.sleep(1500); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		     
		     //notes3
		     for (int i=0; i<notes3.length; i++) {
		    	 mChannels[0].noteOn(notes3[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes3[i], 100);
			     notes3[i]++;
		     }
		     try { Thread.sleep(1000); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		     
		   //notes4
		     for (int i=0; i<notes4.length; i++) {
		    	 mChannels[0].noteOn(notes4[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes4[i], 100);
			     notes4[i]++;
		     }
		     try { Thread.sleep(1000); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		     
		   //notes5
		     for (int i=0; i<notes5.length; i++) {
		    	 mChannels[0].noteOn(notes5[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes5[i], 100);
			     notes5[i]++;
			     
		     }
		     try { Thread.sleep(100); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		    /* 
		   //notes5b
		     for (int i=0; i<notes5b.length; i++) {
		    	 mChannels[0].noteOn(notes5b[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes5b[i], 100);
			     notes5b[i]++;
			     
		     }
		     try { Thread.sleep(100); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		        
		    */
		   /*  
		   //notes6
		     for (int i=0; i<notes6.length; i++) {
		    	 mChannels[0].noteOn(notes6[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes6[i], 100);
			     notes6[i]++;
		     }
		     try { Thread.sleep(800); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		     
		   //notes7
		     for (int i=0; i<notes7.length; i++) {
		    	 mChannels[0].noteOn(notes7[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes7[i], 100);
			     notes7[i]++;
		     }
		     try { Thread.sleep(800); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		     
		     
		   //notes8
		     for (int i=0; i<notes8.length; i++) {
		    	 mChannels[0].noteOn(notes8[i], 100);
		    	 try { Thread.sleep(500); 
			        } catch( InterruptedException e ) {
			            e.printStackTrace();
			        }
			     mChannels[0].noteOff(notes8[i], 100);
			     notes8[i]++;
		     }
		     try { Thread.sleep(800); 
		        } catch( InterruptedException e ) {
		            e.printStackTrace();
		        }
		        */
		    
		} catch(MidiUnavailableException e) {e.printStackTrace();}
	}

}
