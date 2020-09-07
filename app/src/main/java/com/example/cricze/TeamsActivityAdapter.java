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

public class TeamsActivityAdapter extends RecyclerView.Adapter<TeamsActivityAdapter.ViewHolder> {


    private static final String TAG = "TeamsActivityAdapter";

    private ArrayList<String> mteamimage = new ArrayList<>();
    private ArrayList<String> mteamname = new ArrayList<>();
    private ArrayList<String> mowner = new ArrayList<>();
    private ArrayList<String> mcaptain = new ArrayList<>();
    private ArrayList<String> mdescription = new ArrayList<>();
    private ArrayList<String> mtournamnents = new ArrayList<>();
    private ArrayList<String> mwin_no = new ArrayList<>();
    private ArrayList<String> mlose_no = new ArrayList<>();
    private ArrayList<String> mstadium = new ArrayList<>();
    private Context mcontext;

    public  TeamsActivityAdapter(Context context,ArrayList<String> teamimage , ArrayList<String> teamname, ArrayList<String> owner ,ArrayList<String> captain,
                                   ArrayList<String> description , ArrayList<String> tournamnents, ArrayList<String> win_no ,ArrayList<String> lose_no,ArrayList<String> stadium  ){
        mteamimage = teamimage;
        mteamname =teamname;
        mowner=owner;
        mcaptain=captain;
        mdescription =description;
        mtournamnents=tournamnents;
        mwin_no=win_no;
        mlose_no=lose_no;
        mstadium=stadium ;
        mcontext=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_teams_layout,parent,false);
        TeamsActivityAdapter.ViewHolder holder = new TeamsActivityAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG,"Recyclerview onbind"+holder+"  positon :"+position );
        Toast.makeText(mcontext,"hold  "+holder,Toast.LENGTH_SHORT).show();

        Glide.with(mcontext)
                .asBitmap()
                .load(mteamimage.get(position))
                .into(holder.teamImage);
        holder.teamName.setText(mteamname.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG,"onclick"+mteamname.get(position));
                Toast.makeText(mcontext,mteamname.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mcontext,TeamsActivityProfile.class);
                intent.putExtra("mteamimage",mteamimage.get(position));
                intent.putExtra("mteamname",mteamname.get(position));
                intent.putExtra("mowner",mowner.get(position));
                intent.putExtra("mcaptain",mcaptain.get(position));
                intent.putExtra("mdescription",mdescription.get(position));
                intent.putExtra("mtournamnents",mtournamnents.get(position));
                intent.putExtra("mwin_no",mwin_no.get(position));
                intent.putExtra("mlose_no",mlose_no.get(position));
                intent.putExtra("mstadium",mstadium.get(position));

                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mteamname.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{
        CircleImageView teamImage;
        TextView teamName;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            teamImage = itemView.findViewById(R.id.teams_list_image);
            teamName =itemView.findViewById(R.id.teams_list_name);
            parentLayout = itemView.findViewById(R.id.activity_teams_layout);
        }
    }
}
