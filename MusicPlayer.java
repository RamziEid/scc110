import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {

    private Clip clip;

    public void playMusic(String filename) {
        try {
            // Open an audio input stream from the specified file
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(filename));
            // Get a clip resource
            clip = AudioSystem.getClip();
            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
            // Start playing the music
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stopMusic() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public boolean isPlaying() {
        return clip != null && clip.isRunning();
    }
}
