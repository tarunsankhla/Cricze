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

public class PlayersActivityAdapter extends  RecyclerView.Adapter<PlayersActivityAdapter.ViewHolder> {

    private static final String TAG = "PlayersActivityAdapter";
    private ArrayList<String> mplayerimage = new ArrayList<>();
    private ArrayList<String> mplayername = new ArrayList<>();
    private ArrayList<String> mteam = new ArrayList<>();
    private ArrayList<String> mborn = new ArrayList<>();
    private ArrayList<String> mdescription = new ArrayList<>();
    private ArrayList<String> mtournamnents = new ArrayList<>();
    private ArrayList<String> mbatting= new ArrayList<>();
    private ArrayList<String> mbowling = new ArrayList<>();
    private ArrayList<String> mrole = new ArrayList<>();
    private Context mcontext;

    public  PlayersActivityAdapter(Context context,ArrayList<String> playerimage , ArrayList<String> playername, ArrayList<String> team ,ArrayList<String> born,
                                 ArrayList<String> description , ArrayList<String> tournamnents, ArrayList<String> batting ,ArrayList<String> bowling,ArrayList<String> role  ){
        mplayerimage = playerimage;
        mplayername =playername;
        mteam=team;
        mborn=born;
        mdescription =description;
        mtournamnents=tournamnents;
        mbatting=batting;
        mbowling=bowling;
        mrole=role ;
        mcontext=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_players_layout,parent,false);
        PlayersActivityAdapter.ViewHolder holder = new PlayersActivityAdapter.ViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        Glide.with(mcontext)
                .asBitmap()
                .load(mplayerimage.get(position))
                .into(holder.playerImage);
        holder.playerName.setText(mplayername.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onclick"+mplayername.get(position));
                Toast.makeText(mcontext,mplayername.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mcontext,PlayersActivityProfile.class);
                intent.putExtra("mplayerimage",mplayerimage.get(position));
                intent.putExtra("mplayername",mplayername.get(position));
                intent.putExtra("mteam",mteam.get(position));
                intent.putExtra("mborn",mborn.get(position));
                intent.putExtra("mplayerdescription",mdescription.get(position));
                intent.putExtra("mplayerstournamnents",mtournamnents.get(position));
                intent.putExtra("mbatting",mbatting.get(position));
                intent.putExtra("mbowling",mbowling.get(position));
                intent.putExtra("mrole",mrole.get(position));

                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mplayername.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        CircleImageView playerImage;
        TextView playerName;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            playerImage = itemView.findViewById(R.id.players_list_image);
            playerName =itemView.findViewById(R.id.players_list_name);
            parentLayout = itemView.findViewById(R.id.activity_players_layout);
        }
    }
}
