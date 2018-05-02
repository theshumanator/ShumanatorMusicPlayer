package com.example.fatoumeh.shumanatormusicplayer;

import android.app.ActionBar;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MusicPlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private SongCountDownTimer songCountDown;
    private TextView songDuration;
    private Button playButton;
    private Button stopButton;
    private boolean isSongPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        /**
         * I am using this instead because any of the song categories could
         * bring us here. see the onOptionsItemSelected override for more inf
         */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String rcvdSongName="";
        String rcvdSongArtist="";
        String rcvdSongCategory="";
        int rcvdSongDuration=0;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            rcvdSongName = extras.getString("MusicPlayerSongName");
            rcvdSongArtist = extras.getString("MusicPlayerSongArtist");
            rcvdSongCategory = extras.getString("MusicPlayerSongCategory");
            rcvdSongDuration = Integer.parseInt(extras.getString("MusicPlayerSongDuration"));

            songDuration = (TextView) findViewById(R.id.playerSongDuration);
            playButton = (Button) findViewById(R.id.playerPlay);
            stopButton = (Button) findViewById(R.id.playerStop);
            playButton.setEnabled(true);
            stopButton.setEnabled(false);

            playButton.setOnClickListener(this);
            stopButton.setOnClickListener(this);

            TextView songName = (TextView) findViewById(R.id.playerSongName);
            songName.setText(rcvdSongName);

            TextView songArtist = (TextView) findViewById(R.id.playerSongArtist);
            songArtist.setText(rcvdSongArtist);

            ImageView songIcon = (ImageView)findViewById(R.id.playerSongCategory);
            songIcon.setImageResource(getImgSrc(rcvdSongCategory));



            songCountDown = new SongCountDownTimer(rcvdSongDuration * 1000, 1000);
            songCountDown.start();
        }
    }

    public void onClick(View v) {
        //if song is playing then the stop button must have been clicked. we need to stop music
        if (isSongPlaying) {
            playButton.setEnabled(true);
            stopButton.setEnabled(false);
            isSongPlaying=false;
            songDuration.setText("Music has been stopped");
            songCountDown.cancel();
        } else {
            //if song is not playing then we need to play it
            playButton.setEnabled(false);
            stopButton.setEnabled(true);
            isSongPlaying=true;
            songCountDown.start();


        }
    }

    public int getImgSrc(String category) {

        int imgSrc=R.drawable.runningnote;

        switch (category) {
            case "Jazz": imgSrc=R.drawable.sax;
                break;
            case "Rock n Roll": imgSrc=R.drawable.rock;
                break;
            case "Pop": imgSrc=R.drawable.runningnote;
                break;
            case "Rap/Hip Hop": imgSrc=R.drawable.rap;
                break;
            case "Reggae": imgSrc=R.drawable.reggae;
                break;
            case "Random": imgSrc=R.drawable.random;
                break;
            default: imgSrc=R.drawable.runningnote;
                break;

        }
        return imgSrc;

    }

    public class SongCountDownTimer extends CountDownTimer {
        int millSeconds;
        int interval;

        public SongCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            songDuration.setText("Song time remaining: " +new SimpleDateFormat("mm:ss").format(new Date( millisUntilFinished)));
            playButton.setEnabled(false);
            stopButton.setEnabled(true);
            isSongPlaying=true;
        }

        @Override
        public void onFinish() {
            songDuration.setText("Press play if you wish to repeat the song");
            playButton.setEnabled(true);
            stopButton.setEnabled(false);
            isSongPlaying=false;
        }
    }

    //This was taken from an answer in stackoverflow
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}


