package com.example.cricze;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    GridLayout mainGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        //Set Event
        setSingleEvent(mainGrid);
//      setToggleEvent(mainGrid);
    }

    //*toggle event ot change background *//
    private void setToggleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (cardView.getCardBackgroundColor().getDefaultColor() == -1) {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#f0e6ff"));
                        Toast.makeText(MainActivity.this, "State : True", Toast.LENGTH_SHORT).show();

                    } else {
                        //Change background color
                        cardView.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
                        Toast.makeText(MainActivity.this, "State : False", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }


    ///*direct to grid click screens method *///
    @SuppressLint("ClickableViewAccessibility")
    private void setSingleEvent(GridLayout mainGrid) {
        //Loop all child item of Main Grid
        Log.d("ehll","sdf"+mainGrid);
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            final CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;

            ///*onclick on grid card view *///
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("onclick","onclick"+view + " final " + finalI);
                    Toast.makeText(getApplicationContext(),"sdf"+view  + finalI,Toast.LENGTH_LONG).show();
                    if(finalI ==0){
                        Intent intent = new Intent(MainActivity.this,TeamsActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }else if(finalI ==1){
                        Intent intent = new Intent(MainActivity.this,PlayersActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }else if(finalI ==2){
                        Intent intent = new Intent(MainActivity.this,MatchesActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }else if(finalI ==3){
                        Intent intent = new Intent(MainActivity.this,VenueActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }else if(finalI ==4){
                        Intent intent = new Intent(MainActivity.this,ResultsActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }else if(finalI ==5){
                        Intent intent = new Intent(MainActivity.this,TournamentsActivity.class);
//                        intent.putExtra("info","This is activity from card item index  "+finalI);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}