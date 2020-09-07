package com.example.cricze;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {
    private static final String TAG = "ResultsActivity";

    ListView listView;
    String[] Dates = {"Match date: 21/01/2019","Match date: 26/01/2019","Match date: 25/01/2019","Match date: 28/01/2019"
            ,"Match date: 27/01/2019","Match date: 01/02/2019","Match date: 02/02/2019"};
    String[] Team1 = {"IND - 301/7 (50 overs)","AUS - 319/5 (50 overs)","ENG - 187/7 (50 overs)","WI - 388/2 (50 overs)"
            ,"SL - 324/5 (50 overs)","PAK - 198/10 (50 overs)","IND - 371/4 (50 overs)"};
    String[] Team2 = {"AUS - 305/5 (49.4 overs)","IND - 319/7 (50 overs)","WI - 144/10 (30 overs)","ENG- 389/6 (49.1 overs)"
            ,"PAK - 284/8 (50 overs)","SL - 199/9 (50 overs)","AUS - 351/6 (50 overs)"};
    String[] Results = {"Austrailia won by 5 wickets","India won by 3 wickets","WI lost by 43 runs","ENG won by 4 wickets"
            ,"PAK lost by 60 runs","SL won by 1 wicket","AUS lost by 20 runs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        listView=(ListView)findViewById(R.id.list_results_item);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),Dates,Team1,Team2,Results);
        listView.setAdapter(customAdapter);

    }

    public class CustomAdapter extends BaseAdapter{
        Context context;
        String[] mdate,mteam1,mteam2,mresult;
        LayoutInflater layoutInflater;
        public CustomAdapter(Context context1,String[] mdate,String[] mteam1,String[] mteam2,String[] mresult){
            this.context= context1;
            this.mdate= mdate;
            this.mteam1 = mteam1;
            this.mteam2 = mteam2;
            this.mresult = mresult;
            layoutInflater =(LayoutInflater.from(context1));

        }
        @Override
        public int getCount() {
            return mdate.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = layoutInflater.inflate(R.layout.activity_results_layout,null);
            TextView dates = view.findViewById(R.id.results_list_date);
            TextView team1 = view.findViewById(R.id.results_list_team1);
            TextView team2 = view.findViewById(R.id.results_list_team2);
            TextView results = view.findViewById(R.id.results_list_team_winner);

            dates.setText(mdate[i]);
            team1.setText(mteam1[i]);
            team2.setText(mteam2[i]);
            results.setText(mresult[i]);
            return view;
        }
    }
}