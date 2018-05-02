package com.example.fatoumeh.shumanatormusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ReggaeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        ArrayList<Song> songs=new ArrayList<Song>();
        songs.add(new Song("No woman no cry", "Bob Marley", "Reggae", 150));
        songs.add(new Song("Buffalo Soldiers", "Bob Marley", "Reggae", 120));
        songs.add(new Song("Bird", "Andy Jackson", "Reggae", 90));
        songs.add(new Song("Love me", "James Anderson", "Reggae", 59));
        songs.add(new Song("Kingston", "Bob Marley", "Reggae", 64));

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

                Intent playMusic = new Intent(ReggaeActivity.this, MusicPlayerActivity.class);
                playMusic.putExtra("MusicPlayerSongName", songName);
                playMusic.putExtra("MusicPlayerSongArtist", songArtist);
                playMusic.putExtra("MusicPlayerSongCategory", songCategory);
                playMusic.putExtra("MusicPlayerSongDuration", songDuration);

                startActivity(playMusic);
            }
        });
    }
}
