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

public class PopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        ArrayList<Song> songs=new ArrayList<Song>();
        songs.add(new Song("Let it go", "Elsa", "Pop", 110));
        songs.add(new Song("Let is snow", "Sharkira", "Pop", 140));
        songs.add(new Song("All I want for christmas", "Shakira", "Pop", 70));
        songs.add(new Song("What is love", "Latoya Jackson", "Pop", 50));
        songs.add(new Song("Leave me alone", "Jessica Matthews", "Pop", 60));

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

                Intent playMusic = new Intent(PopActivity.this, MusicPlayerActivity.class);
                playMusic.putExtra("MusicPlayerSongName", songName);
                playMusic.putExtra("MusicPlayerSongArtist", songArtist);
                playMusic.putExtra("MusicPlayerSongCategory", songCategory);
                playMusic.putExtra("MusicPlayerSongDuration", songDuration);

                startActivity(playMusic);
            }
        });
    }
}
