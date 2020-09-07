package com.example.cricze;

import android.annotation.SuppressLint;
import android.content.Context;
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

public class TournamentsActivityAdapter extends RecyclerView.Adapter<TournamentsActivityAdapter.ViewHolder>{
    private static final String TAG = "TournamentsActivityAdapter";

    private ArrayList<String> mtournamertname = new ArrayList<>();
    private ArrayList<String> mformat = new ArrayList<>();
    private ArrayList<String> mdescription = new ArrayList<>();
    private ArrayList<String> mwinner = new ArrayList<>();
    private ArrayList<String> mrunnerup= new ArrayList<>();
    private ArrayList<String> mhost = new ArrayList<>();
    private ArrayList<String> mmostruns= new ArrayList<>();
    private ArrayList<String> mmostwickets = new ArrayList<>();
    private ArrayList<String> mplayeroftournamnet = new ArrayList<>();
    private Context mcontext;

    public  TournamentsActivityAdapter(Context context,ArrayList<String> tournamentname , ArrayList<String> format, ArrayList<String> description ,ArrayList<String> winnner,
                                   ArrayList<String> runnerup , ArrayList<String> host, ArrayList<String> mostruns ,ArrayList<String> mostwickets,ArrayList<String> playeroftournament  ){
        mtournamertname = tournamentname;
        mformat =format;
        mdescription=description;
        mwinner=winnner;
        mrunnerup=runnerup;
        mhost=host;
        mmostruns=mostruns;
        mmostwickets=mostwickets ;
        mplayeroftournamnet =playeroftournament;
        mcontext=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_tournaments_layout, parent, false);
        TournamentsActivityAdapter.ViewHolder holder=new TournamentsActivityAdapter.ViewHolder(itemView);
        return holder;

    }

    @SuppressLint("LongLogTag")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Toast.makeText(mcontext,"hold  "+holder,Toast.LENGTH_SHORT).show();

        holder.tournamentName.setText(mtournamertname.get(position));
        holder.tformat.setText(mformat.get(position));
        holder.tdescription.setText(mdescription.get(position));
        holder.twinner.setText(mwinner.get(position));
        holder.trunnerup.setText(mrunnerup.get(position));
        holder.thost.setText(mhost.get(position));
        holder.tmostwickets.setText(mmostwickets.get(position));
        holder.tmostruns.setText(mmostruns.get(position));
        holder.tplayeroftour.setText(mplayeroftournamnet.get(position));

    }

    @Override
    public int getItemCount() {
        return mtournamertname.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView tournamentName,tformat,tdescription,twinner,trunnerup,thost,tmostruns,tmostwickets,tplayeroftour;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tournamentName =itemView.findViewById(R.id.tournaments_item_name);
            tformat =itemView.findViewById(R.id.tournaments_item_format);
            tdescription =itemView.findViewById(R.id.tournaments_item_decription);
            twinner =itemView.findViewById(R.id.tournaments_item_winner);
            trunnerup =itemView.findViewById(R.id.tournaments_item_runnerup);
            thost =itemView.findViewById(R.id.tournaments_item_host);
            tmostruns =itemView.findViewById(R.id.tournaments_item_mostruns);
            tmostwickets =itemView.findViewById(R.id.tournaments_item_mostwicket);
            tplayeroftour =itemView.findViewById(R.id.tournaments_item_playeroftournament);
            parentLayout = itemView.findViewById(R.id.tournament_layout_view);
        }
    }
}
