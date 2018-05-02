package com.example.fatoumeh.shumanatormusicplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView.Adapter;


import java.util.List;

/**
 * Created by fatoumeh on 25/02/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {


        public SongAdapter(@NonNull Context context, int resource, @NonNull List<Song> objects) {
            //instead of resource, we put 0 because we are not interested in a particular layout
            super(context, 0, objects);
        }

        //the convertView is the recycled view we are going to use thats why we have to inflate if it is null
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View songListView=convertView;
            if (songListView==null){
                songListView= LayoutInflater.from(getContext()).inflate(
                        R.layout.song_item, parent, false);
            }

            Song currentSong = getItem(position);

            TextView songTextView = (TextView) songListView.findViewById(R.id.songName);
            songTextView.setText(currentSong.getSongName());

            TextView artistTextView = (TextView) songListView.findViewById(R.id.songArtist);
            artistTextView.setText(currentSong.getArtist());

            TextView categoryTextView = (TextView) songListView.findViewById(R.id.songCategory);
            categoryTextView.setText(currentSong.getCategory());

            TextView durationTextView = (TextView) songListView.findViewById(R.id.songDuration);
            durationTextView.setText(""+currentSong.getDuration()+"");

            ImageView songIcon = (ImageView)songListView.findViewById(R.id.categoryIcon);
            String songCategory=currentSong.getCategory();
            switch (songCategory){
                case "Jazz": songIcon.setImageResource(R.drawable.sax);
                    break;
                case "Rock n Roll": songIcon.setImageResource(R.drawable.rock);
                    break;
                case "Pop": songIcon.setImageResource(R.drawable.runningnote);
                    break;
                case "Rap/Hip Hop": songIcon.setImageResource(R.drawable.rap);
                    break;
                case "Reggae": songIcon.setImageResource(R.drawable.reggae);
                    break;
                case "Random": songIcon.setImageResource(R.drawable.random);
                    break;
                default: songIcon.setImageResource(R.drawable.runningnote);
                    break;
            }

            return songListView;

        }



}
