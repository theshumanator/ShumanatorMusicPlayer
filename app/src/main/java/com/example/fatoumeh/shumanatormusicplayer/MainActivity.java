package com.example.fatoumeh.shumanatormusicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button jazz = (Button) findViewById(R.id.buttonJazz);
        jazz.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent jazzIntent=new Intent(MainActivity.this, JazzActivity.class);
                startActivity(jazzIntent);
            }
        });

        Button rocknRoll = (Button) findViewById(R.id.buttonRocknroll);
        rocknRoll.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent rocknRollIntent=new Intent(MainActivity.this, RocknRollActivity.class);
                startActivity(rocknRollIntent);
            }
        });

        Button reggae = (Button) findViewById(R.id.buttonReggae);
        reggae.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent reggaeIntent=new Intent(MainActivity.this, ReggaeActivity.class);
                startActivity(reggaeIntent);
            }
        });

        Button rapHipHop = (Button) findViewById(R.id.buttonRapHiphop);
        rapHipHop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent rapHipHopIntent=new Intent(MainActivity.this, RapHipHopActivity.class);
                startActivity(rapHipHopIntent);
            }
        });

        Button pop = (Button) findViewById(R.id.buttonPop);
        pop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent popIntent=new Intent(MainActivity.this, PopActivity.class);
                startActivity(popIntent);
            }
        });

        Button surpriseme = (Button) findViewById(R.id.buttonSurpise);
        surpriseme.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent surpriseMeIntent=new Intent(MainActivity.this, SurpriseMeActivity.class);
                startActivity(surpriseMeIntent);
            }
        });

    }
}

