/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dopeAgile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Gustav
 */
public class MusicPlayer {

    private Clip clip;
    
    public MusicPlayer() {}

    public MusicPlayer(String fileName) {
        // specify the sound to play
        // (assuming the sound can be played by the audio system)
        // from a wave File
        try {
            File file = new File(fileName);

            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                // load the sound into memory (a Clip)
                clip = AudioSystem.getClip();
                clip.open(sound);
            } else {
                throw new RuntimeException("Sound: file not found: " + fileName);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }

        // play, stop, loop the sound clip
    }

    public void play() {
        clip.setFramePosition(0);  // Must always rewind!
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
    
    public void IntroMusic(int soundCount) {
        
        try {
            String fileName = "Intro.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.play();

            if (soundCount == 1) {
                sound.stop();
            }
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"Intro.wav\" could not be found." + ConsoleColors.RESET);
        }

    }
    
    public void DungeonMusic() {

        try {
            String fileName = "Scary.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.loop();
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"Scary.wav\" could not be found." + ConsoleColors.RESET);
        }

    }
    
    public void treasureSound() {

        try {
            String fileName = "treasure.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.play();
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"treasure.wav\" could not be found." + ConsoleColors.RESET);
        }

    }
    
    public void monsterSound() {

        try {
            String fileName = "Zombie.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.play();
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"Zombie.wav\" could not be found." + ConsoleColors.RESET);
        }

    }
    
    public void gameOverSound() {

        try {
            String fileName = "gameOver.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.play();
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"gameOver.wav\" could not be found." + ConsoleColors.RESET);
        }
        
    }
    
    public void choiceSound() {

        try {
            String fileName = "dun.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.play();
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"dun.wav\" could not be found." + ConsoleColors.RESET);
        }

    }
    
    public void confirmSound() {

        try {
            String fileName = "confirm.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.play();
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"confirm.wav\" could not be found." + ConsoleColors.RESET);
        }

    }
    
    public void swordSound() {

        try {
            String fileName = "Sword.wav";
            MusicPlayer sound = new MusicPlayer(fileName);
            sound.play();
        } catch (Exception e) {
            System.out.println(ConsoleColors.BOLD + "Error: Music file \"Sword.wav\" could not be found." + ConsoleColors.RESET);
        }

    }
   
}
