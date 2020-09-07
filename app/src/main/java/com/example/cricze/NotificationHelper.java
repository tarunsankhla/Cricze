package com.example.cricze;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {

    private static final String TAG = "NotificationHelper";
    public  static  final  String channelID="Channel 1";
    public  static  final  String channelName="Channel name";
    private NotificationManager notificationManager;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public NotificationHelper(Context base) {
        super(base);
        createChannels();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createChannels() {


        //* NotificationManager.IMPORTANCE_DEFAULT means it will have an icon and sound *//
        NotificationChannel channel1 =new NotificationChannel(channelID,channelName, NotificationManager.IMPORTANCE_DEFAULT);
        channel1.enableLights(true);
        channel1.enableVibration(true);
        channel1.setLightColor(R.color.colorPrimary);
        channel1.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);

        getManager().createNotificationChannel(channel1);
    }

    public  NotificationManager getManager(){
        if(notificationManager == null){
            notificationManager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return  notificationManager;
    }
    public NotificationCompat.Builder getChannel1Notification(String title,String message ){
        Intent resultintent = new Intent(this,NotificationActivity.class);

        //* PendingIntent.FLAG_UPDATE_CURRENT means if intent already exist and we create new one it will update the last one wihth new vlaue*//
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this,1,resultintent,PendingIntent.FLAG_UPDATE_CURRENT);

        return  new NotificationCompat.Builder(getApplicationContext(),channelID)
                .setContentText(message)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_baseline_sports_handball_24)
                .setContentIntent(resultPendingIntent)
                .setAutoCancel(true);
    }
}
