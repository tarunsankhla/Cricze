package com.example.cricze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TeamsActivityProfile extends AppCompatActivity {

    private static final String TAG = "TeamsActivityProfile";

    TextView yteamname,yowner ,ycaptian,ydescription ,ytournaments,ywin_no ,ylose_no,ystadium ;
    ImageView yteamimage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_profile);

        getteamIntent();
    }

    private void getteamIntent() {
        if(getIntent().hasExtra("mteamimage") && getIntent().hasExtra("mteamname") &&getIntent().hasExtra("mowner")
                &&getIntent().hasExtra("mcaptain")
                && getIntent().hasExtra("mdescription") && getIntent().hasExtra("mtournamnents") &&getIntent().hasExtra("mwin_no")
                &&getIntent().hasExtra("mlose_no") &&getIntent().hasExtra("mstadium"))
        {
            String teamimage =getIntent().getStringExtra("mteamimage");
            String teamname =getIntent().getStringExtra("mteamname");
            String owner= getIntent().getStringExtra("mowner");
            String captain = getIntent().getStringExtra("mcaptain");
            String description =getIntent().getStringExtra("mdescription");
            String tournamnets =getIntent().getStringExtra("mtournamnents");
            String win_no= getIntent().getStringExtra("mwin_no");
            String lose_no = getIntent().getStringExtra("mlose_no");
            String stadium = getIntent().getStringExtra("mstadium");

            setcontent( teamimage,teamname ,owner,captain,description,tournamnets,win_no,lose_no,stadium);
        }

    }

    //* set intent data to views*//
    private void setcontent(String teamimage, String teamname, String owner, String captain, String description, String tournamnets, String win_no, String lose_no, String stadium)
    {
        yteamimage=(ImageView)findViewById(R.id.team_profile_image);
        Glide.with(this).asBitmap().load(teamimage).into(yteamimage);

        yteamname =(TextView)findViewById(R.id.team_profile_name);
        yteamname.setText(teamname);
        yowner =(TextView)findViewById(R.id.team_view_owner);
        yowner.setText(owner);
        ycaptian =(TextView)findViewById(R.id.team_view_captain);
        ycaptian.setText(captain);
        ydescription=(TextView)findViewById(R.id.team_view_description);
        ydescription.setText(description);
        ytournaments =(TextView)findViewById(R.id.team_view_winner_tournament);
        ytournaments.setText(tournamnets);
        ylose_no =(TextView)findViewById(R.id.team_view_losing_number);
        ylose_no.setText(lose_no);
        ywin_no=(TextView)findViewById(R.id.team_view_winner_number);
        ywin_no.setText(win_no);
        ystadium=(TextView)findViewById(R.id.team_view_Stadium);
        ystadium.setText(stadium);
    }
}