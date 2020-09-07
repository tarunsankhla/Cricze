package com.example.cricze;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NotificationActivity extends AppCompatActivity {

    private static final String TAG = "NotificationActivity";

    Button buttonNoti, buttonEmail;
    TextView yteam1name,yteam2name ,ywinner,ymanofmatch ,ybowler,yfielder ,ysummmary ;
    ImageView  yteam1image,yteam2image;

    String winner,manofmatch, bowlerofmatch, bestfielder,    summary;
    private  NotificationHelper notificationHelper;
    EditText email_text;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        //mail text and bbutton
        email_text=(EditText)findViewById(R.id.match_view_email);
        buttonEmail=(Button)findViewById(R.id.match_view_email_button);
        buttonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailID =email_text.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,new String[]{emailID});
                intent.putExtra(Intent.EXTRA_SUBJECT,winner);
                intent.putExtra(Intent.EXTRA_TEXT,summary);

                //*This is used to create intents that only specify a type and not data, for example to indicate the type of data to return.
                //This method automatically clears any data that was previously set *//
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent,"Choose an email client :"));
            }
        });

        //notification button
        buttonNoti = (Button)findViewById(R.id.matches_view_noti_button);
        notificationHelper = new NotificationHelper(this) ;
        buttonNoti.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 startnoti(winner,manofmatch);
             }
         });

        getincomingIntent();


    }


    private void getincomingIntent(){
        if(getIntent().hasExtra("mteam1image") && getIntent().hasExtra("mteam1name") &&getIntent().hasExtra("mteam2image") &&getIntent().hasExtra("mteam2name")
        && getIntent().hasExtra("mwinner") && getIntent().hasExtra("mmanofmatch") &&getIntent().hasExtra("mbowler")
                &&getIntent().hasExtra("mfielder") &&getIntent().hasExtra("msummary"))
        {
            String team1image =getIntent().getStringExtra("mteam1image");
            String team1name =getIntent().getStringExtra("mteam1name");
            String team2image= getIntent().getStringExtra("mteam2image");
            String team2name = getIntent().getStringExtra("mteam2name");
            winner =getIntent().getStringExtra("mwinner");
            manofmatch =getIntent().getStringExtra("mmanofmatch");
            bowlerofmatch= getIntent().getStringExtra("mbowler");
            bestfielder = getIntent().getStringExtra("mfielder");
            summary = getIntent().getStringExtra("msummary");



            setcontent( team1image,team1name ,team2image,team2name,winner,manofmatch,bowlerofmatch,bestfielder,summary);
        }

    }

    private void setcontent(String xteam1image,String xteam1name ,String xteam2image,String xteam2name,String xwinnner,String xmanofmatch ,String xbowler,String xfielder,String xsummary){


        yteam1name =(TextView)findViewById(R.id.matches_view_team1_score);
        yteam1name.setText(xteam1name);
        yteam2name =(TextView)findViewById(R.id.matches_view_team2_score);
        yteam2name.setText(xteam2name);
        ywinner =(TextView)findViewById(R.id.matches_view_winner);
        ywinner.setText(xwinnner);
        ymanofmatch =(TextView)findViewById(R.id.matches_view_manofmatch);
        ymanofmatch.setText(xmanofmatch);
        ybowler =(TextView)findViewById(R.id.matches_view_bowlerofmatch);
        ybowler.setText(xbowler);
        yfielder =(TextView)findViewById(R.id.matches_view_bestfielder);
        yfielder.setText(xfielder);
        ysummmary =(TextView)findViewById(R.id.matches_view_matchsummary);
        ysummmary.setText(xsummary);


        yteam1image=(ImageView)findViewById(R.id.matches_view_team1_image);
        yteam2image=(ImageView)findViewById(R.id.matches_view_team2_image);
        Glide.with(this).asBitmap().load(xteam1image).into(yteam1image);
        Glide.with(this).asBitmap().load(xteam2image).into(yteam2image);





    }
    public void startnoti(String title,String Test){
//        String title = "New Message ";
//        String Test = "Tomorrow is a match at 7pm";
         NotificationCompat.Builder nb= notificationHelper.getChannel1Notification(title,Test);
         notificationHelper.getManager().notify(1,nb.build());

     }
}