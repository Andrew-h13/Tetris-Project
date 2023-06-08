import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class sound{
	private ArrayList<String> musicFiles;
	public sound(String... files) {
		musicFiles = new ArrayList<String>();
		for(String file : files)
			musicFiles.add("./resourses/audio/"+file + ".waw");
}
	public void playSound(String fileName) {
		try {
			File soundFile = new File(fileName);
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
			AudioFormat format = ais.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(ais);
			clip.start();
			
			
			
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		}
	}

