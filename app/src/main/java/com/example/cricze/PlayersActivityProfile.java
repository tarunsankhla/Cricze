package com.example.cricze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PlayersActivityProfile extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    TextView yplayername,yteam ,yborn,ydescription ,ytournaments,ybatting ,ybowling,yrole ;
    ImageView yplayerimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_profile);

        getincomingPlayerIntent();
    }

    ///* getting data by intent*///
    private void getincomingPlayerIntent() {
        if(getIntent().hasExtra("mplayerimage") && getIntent().hasExtra("mplayername") &&getIntent().hasExtra("mteam")
                &&getIntent().hasExtra("mborn")
                && getIntent().hasExtra("mplayerdescription") && getIntent().hasExtra("mplayerstournamnents")
                &&getIntent().hasExtra("mbatting")
                &&getIntent().hasExtra("mbowling") &&getIntent().hasExtra("mrole"))
        {
            String playeeimage =getIntent().getStringExtra("mplayerimage");
            String playername =getIntent().getStringExtra("mplayername");
            String team= getIntent().getStringExtra("mteam");
            String born = getIntent().getStringExtra("mborn");
            String description =getIntent().getStringExtra("mplayerdescription");
            String tournamnets =getIntent().getStringExtra("mplayerstournamnents");
            String batting= getIntent().getStringExtra("mbatting");
            String bowling = getIntent().getStringExtra("mbowling");
            String role = getIntent().getStringExtra("mrole");

            setcontent( playeeimage,playername ,team,born,description,tournamnets,batting,bowling,role);
        }
    }

    ///* setting data by intent to views*///
    private void setcontent(String playeeimage, String playername, String team, String born, String description, String tournamnets, String batting, String bowling, String role) {

        yplayerimage=(ImageView)findViewById(R.id.players_profile_image);
        Glide.with(this).asBitmap().load(playeeimage).into(yplayerimage);

        yplayername =(TextView)findViewById(R.id.players_profile_name);
        yplayername.setText(playername);
        yteam =(TextView)findViewById(R.id.players_team);
        yteam.setText(team);
        yborn =(TextView)findViewById(R.id.players_born);
        yborn.setText(born);
        ydescription=(TextView)findViewById(R.id.players_description);
        ydescription.setText(description);
        ytournaments =(TextView)findViewById(R.id.players_tournaments);
        ytournaments.setText(tournamnets);
        ybatting =(TextView)findViewById(R.id.players_batting);
        ybatting.setText(batting);
        ybowling=(TextView)findViewById(R.id.players_bowling);
        ybowling.setText(bowling);
        yrole=(TextView)findViewById(R.id.players_role);
        yrole.setText(role);
    }
}