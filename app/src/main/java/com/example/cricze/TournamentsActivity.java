package com.example.cricze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

public class TournamentsActivity extends AppCompatActivity {

    private static final String TAG = "TournamentsActivity";

    private ArrayList<String> ntournamertname = new ArrayList<>();
    private ArrayList<String> nformat = new ArrayList<>();
    private ArrayList<String> ndescription = new ArrayList<>();
    private ArrayList<String> nwinner = new ArrayList<>();
    private ArrayList<String> nrunnerup= new ArrayList<>();
    private ArrayList<String> nhost = new ArrayList<>();
    private ArrayList<String> nmostruns= new ArrayList<>();
    private ArrayList<String> nmostwickets = new ArrayList<>();
    private ArrayList<String> nplayeroftournamnet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournaments);

        initTournamnetData();
        initTournamnentRecycelrview();
    }

    //*initializing turnament data*//
    private void initTournamnetData() {

        ntournamertname.add("ICC CRICKET WORLD CUP 2019");
        nformat.add("Format of the game:  One Day International");
        ndescription.add("Description:  The tournaments was contested by 10 team, with the format of tournamnet changing from single round robin group with the top four teams qualifying through tot he knockout stage after six weeks.");
        nwinner.add("Winner: England ");
        nrunnerup.add("Runners-up:  New Zealand");
        nhost.add("Host(s) England and Wales");
        nmostruns.add("Most Runs:  (India)Rohit Sharma(648)");
        nmostwickets.add("Most Wickets:  (Austrailia) Mitchell Starc(27)");
        nplayeroftournamnet.add("Player of Tournament:  (New Zealand) Kane Williamson");

        ntournamertname.add("ICC CRICKET WORLD CUP 2015");
        nformat.add("Format of the game:  One Day International");
        ndescription.add("Description:  The tournaments was contested by 10 team, with the format of tournamnet changing from single round robin group with the top four teams qualifying through tot he knockout stage after six weeks.");
        nwinner.add("Winner: England ");
        nrunnerup.add("Runners-up:  New Zealand");
        nhost.add("Host(s) England and Wales");
        nmostruns.add("Most Runs:  (India)Rohit Sharma(648)");
        nmostwickets.add("Most Wickets:  (Austrailia) Mitchell Starc(27)");
        nplayeroftournamnet.add("Player of Tournament:  (New Zealand) Kane Williamson");

        ntournamertname.add("ICC CRICKET WORLD CUP 2011");
        nformat.add("Format of the game:  One Day International");
        ndescription.add("Description:  The tournaments was contested by 10 team, with the format of tournamnet changing from single round robin group with the top four teams qualifying through tot he knockout stage after six weeks.");
        nwinner.add("Winner: England ");
        nrunnerup.add("Runners-up:  New Zealand");
        nhost.add("Host(s) England and Wales");
        nmostruns.add("Most Runs:  (India)Rohit Sharma(648)");
        nmostwickets.add("Most Wickets:  (Austrailia) Mitchell Starc(27)");
        nplayeroftournamnet.add("Player of Tournament:  (New Zealand) Kane Williamson");

        ntournamertname.add("ICC CRICKET WORLD CUP 2019");
        nformat.add("Format of the game:  One Day International");
        ndescription.add("Description:  The tournaments was contested by 10 team, with the format of tournamnet changing from single round robin group with the top four teams qualifying through tot he knockout stage after six weeks.");
        nwinner.add("Winner: England ");
        nrunnerup.add("Runners-up:  New Zealand");
        nhost.add("Host(s) England and Wales");
        nmostruns.add("Most Runs:  (India)Rohit Sharma(648)");
        nmostwickets.add("Most Wickets:  (Austrailia) Mitchell Starc(27)");
        nplayeroftournamnet.add("Player of Tournament:  (New Zealand) Kane Williamson");

    }
    private void initTournamnentRecycelrview() {

        RecyclerView recyclerView =findViewById(R.id.tournaments_recycler_item);
        TournamentsActivityAdapter tournamentsActivityAdapter = new TournamentsActivityAdapter(this,ntournamertname,nformat,ndescription,nwinner,nrunnerup,nhost,nmostruns
                ,nmostwickets,nplayeroftournamnet);
        recyclerView.setAdapter(tournamentsActivityAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }


}