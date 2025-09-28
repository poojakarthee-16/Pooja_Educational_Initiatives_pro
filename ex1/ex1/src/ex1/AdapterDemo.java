/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex1;

/**
 *
 * @author HP
 */
// Target Interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee Interfaces
interface AdvancedMediaPlayer {
    void playAdvanced(String fileName);
}

// Concrete Adaptees
class Mp4Player implements AdvancedMediaPlayer {
    public void playAdvanced(String fileName) {
        System.out.println("Playing MP4 file: " + fileName);
    }
}

class VlcPlayer implements AdvancedMediaPlayer {
    public void playAdvanced(String fileName) {
        System.out.println("Playing VLC file: " + fileName);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedPlayer;

    public MediaAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("mp4")) {
            advancedPlayer = new Mp4Player();
        } else if (audioType.equalsIgnoreCase("vlc")) {
            advancedPlayer = new VlcPlayer();
        }
    }

    public void play(String audioType, String fileName) {
        advancedPlayer.playAdvanced(fileName);
    }
}

// Client
class AudioPlayer implements MediaPlayer {
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            MediaAdapter adapter = new MediaAdapter(audioType);
            adapter.play(audioType, fileName);
        }
    }
}

// Demo
public class AdapterDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song1.mp3");
        player.play("mp4", "movie.mp4");
        player.play("vlc", "clip.vlc");
    }
}

