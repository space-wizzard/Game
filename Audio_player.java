package gameProject;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio_player {
	private Clip clip;

	public Audio_player(String filePath) {

		try {
			File audioFile = new File(filePath);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}

	}

	public void play() {
		if (clip != null) {
			clip.start();
			// clip.loop(Clip.LOOP_CONTINUOUSLY); // Loop the clip continuously
		}
	}

	public void stop() {
		if (clip != null && clip.isRunning()) {
			clip.stop();
		}
	}
}
