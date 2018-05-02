package com.example.fatoumeh.shumanatormusicplayer;

/**
 * Created by fatoumeh on 25/02/2018.
 */

public class Song {

    private String songName, artist, category;
    private int duration;

    public Song (String songName, String artist, String category, int duration) {
        this.songName=songName;
        this.artist=artist;
        this.category=category;
        this.duration=duration;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

}
