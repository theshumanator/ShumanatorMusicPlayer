package com.example.fatoumeh.shumanatormusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class SurpriseMeActivity extends AppCompatActivity {

    private int RANDOM_QUANTITY=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        //TODO: move to db later?
        ArrayList<Song> allSongs=new ArrayList<Song>();
        allSongs.add(new Song("Girl", "Shaggy", "Rap/Hip Hop", 110));
        allSongs.add(new Song("I am Shaggy", "Shaggy", "Rap/Hip Hop", 40));
        allSongs.add(new Song("Empire State", "Jayz", "Rap/Hip Hop", 70));
        allSongs.add(new Song("Mama", "Eminem", "Rap/Hip Hop", 60));
        allSongs.add(new Song("Smile", "Kanye West", "Rap/Hip Hop", 60));
        allSongs.add(new Song("Sunshine", "Mark Jed", "Jazz", 100));
        allSongs.add(new Song("Moonlight", "Andy T", "Jazz", 120));
        allSongs.add(new Song("Happiness", "JJ Gaye", "Jazz", 170));
        allSongs.add(new Song("New Orleans", "Latoya Johnson", "Jazz", 100));
        allSongs.add(new Song("Love", "Jessica Andrews", "Jazz", 110));
        allSongs.add(new Song("Let it go", "Elsa", "Pop", 110));
        allSongs.add(new Song("Let is snow", "Sharkira", "Pop", 140));
        allSongs.add(new Song("All I want for christmas", "Shakira", "Pop", 70));
        allSongs.add(new Song("What is love", "Latoya Jackson", "Pop", 50));
        allSongs.add(new Song("Leave me alone", "Jessica Matthews", "Pop", 60));
        allSongs.add(new Song("No woman no cry", "Bob Marley", "Reggae", 150));
        allSongs.add(new Song("Buffalo Soldiers", "Bob Marley", "Reggae", 120));
        allSongs.add(new Song("Bird", "Andy Jackson", "Reggae", 90));
        allSongs.add(new Song("Love me", "James Anderson", "Reggae", 59));
        allSongs.add(new Song("Kingston", "Bob Marley", "Reggae", 64));
        allSongs.add(new Song("We will rock you", "Queen", "Rock n Roll", 80));
        allSongs.add(new Song("Champions", "Queen", "Rock n Roll", 120));
        allSongs.add(new Song("California", "Elvis Presley", "Rock n Roll", 70));
        allSongs.add(new Song("Saturday Night", "John Legend", "Rock n Roll", 70));
        allSongs.add(new Song("Let's rock", "Queen", "Rock n Roll", 60));


        ArrayList<Song> songs=new ArrayList<Song>();
        songs=getRandomSongs(allSongs);
        SongAdapter songAdapter=new SongAdapter(this, R.layout.song_item, songs);

        ListView listView = (ListView) findViewById(R.id.songListView);
        listView.setAdapter(songAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                LinearLayout songList = (LinearLayout) view;

                TextView textViewSongName = (TextView) songList.findViewById(R.id.songName);
                String songName = textViewSongName.getText().toString();

                TextView textViewSongArtist = (TextView) songList.findViewById(R.id.songArtist);
                String songArtist = textViewSongArtist.getText().toString();

                TextView textViewSongCategory = (TextView) songList.findViewById(R.id.songCategory);
                String songCategory = textViewSongCategory.getText().toString();

                TextView textViewSongDuration = (TextView) songList.findViewById(R.id.songDuration);
                String songDuration = textViewSongDuration.getText().toString();

                Intent playMusic = new Intent(SurpriseMeActivity.this, MusicPlayerActivity.class);
                playMusic.putExtra("MusicPlayerSongName", songName);
                playMusic.putExtra("MusicPlayerSongArtist", songArtist);
                playMusic.putExtra("MusicPlayerSongCategory", songCategory);
                playMusic.putExtra("MusicPlayerSongDuration", songDuration);


                startActivity(playMusic);
            }
        });


    }

    public ArrayList<Song> getRandomSongs(ArrayList<Song> rcvdSongs) {
        ArrayList<Song> chosenSongs=new ArrayList<Song>();

        int desiredNumberOfSongs=RANDOM_QUANTITY;
        int rcvdSongsQuantity=rcvdSongs.size();
        Random randomNumberGenerator = new Random();


        while (desiredNumberOfSongs>=1) {
            int n = randomNumberGenerator.nextInt(rcvdSongsQuantity);
            chosenSongs.add(rcvdSongs.get(n));
            desiredNumberOfSongs--;
        }
        return chosenSongs;
    }
}
