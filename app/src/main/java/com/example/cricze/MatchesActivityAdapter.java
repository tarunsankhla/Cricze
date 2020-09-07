package com.example.cricze;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import de.hdodenhof.circleimageview.CircleImageView;

public class MatchesActivityAdapter extends  RecyclerView.Adapter<MatchesActivityAdapter.ViewHolder>{
    private static final String TAG = "MatchesActivityAdapter";

    private ArrayList<String> mteam1image = new ArrayList<>();
    private ArrayList<String> mteam1name = new ArrayList<>();
    private ArrayList<String> mteam2image = new ArrayList<>();
    private ArrayList<String> mteam2name = new ArrayList<>();
    private ArrayList<String> mwinnner = new ArrayList<>();
    private ArrayList<String> mmanofmatch = new ArrayList<>();
    private ArrayList<String> mBestFielder = new ArrayList<>();
    private ArrayList<String> mBowlerofmatch = new ArrayList<>();
    private ArrayList<String> mMatchSummary = new ArrayList<>();
    private Context mcontext;

    public  MatchesActivityAdapter(Context context,ArrayList<String> team1image , ArrayList<String> team1name, ArrayList<String> team2image ,ArrayList<String> team2name,
                                   ArrayList<String> winnner , ArrayList<String> manofmatch, ArrayList<String> bowlerofmatch ,ArrayList<String> bestfielder,ArrayList<String> matchsummary ){
        mteam1image = team1image;
        mteam1name =team1name;
        mteam2image=team2image;
        mteam2name=team2name;
        mwinnner =winnner;
        mmanofmatch=manofmatch;
        mBowlerofmatch=bowlerofmatch;
        mBestFielder=bestfielder;
        mMatchSummary=matchsummary;
        mcontext=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_matches_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"Recyclerview onbind"+holder+position );
        Toast.makeText(mcontext,"hold  "+holder,Toast.LENGTH_SHORT).show();

        Glide.with(mcontext)
                .asBitmap()
                .load(mteam1image.get(position))
                .into(holder.team1Image);
        holder.team1Name.setText(mteam1name.get(position));
        Glide.with(mcontext)
                .asBitmap()
                .load(mteam2image.get(position))
                .into(holder.team2Image);
        holder.team2Name.setText(mteam2name.get(position));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onclick"+mteam1name.get(position));
                Toast.makeText(mcontext,mteam1name.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mcontext,NotificationActivity.class);
                intent.putExtra("mteam1image",mteam1image.get(position));
                intent.putExtra("mteam1name",mteam1name.get(position));
                intent.putExtra("mteam2image",mteam2image.get(position));
                intent.putExtra("mteam2name",mteam2name.get(position));
                intent.putExtra("mwinner",mwinnner.get(position));
                intent.putExtra("mmanofmatch",mmanofmatch.get(position));
                intent.putExtra("mbowler",mBowlerofmatch.get(position));
                intent.putExtra("mfielder",mBestFielder.get(position));
                intent.putExtra("msummary",mMatchSummary.get(position));

                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mteam1name.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
         CircleImageView team1Image,team2Image;
         TextView team1Name,team2Name;
         LinearLayout parentLayout;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             team1Image = itemView.findViewById(R.id.matches_list_team1_image);
             team1Name =itemView.findViewById(R.id.matches_list_team1_score);
             team2Image=itemView.findViewById(R.id.matches_list_team2_image);
             team2Name = itemView.findViewById(R.id.matches_list_team2_score);
             parentLayout = itemView.findViewById(R.id.activity_match_layout);
         }
     }
}
