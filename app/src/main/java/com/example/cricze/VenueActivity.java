package com.example.cricze;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VenueActivity extends AppCompatActivity {
    private static final String TAG = "VenueActivity";

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String,List<String>> expandableListDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);

        expandableListView =(ExpandableListView)findViewById(R.id.expandable_list_Venue);
        expandableListDetails = VenueListDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetails.keySet());
        expandableListAdapter = new VenueCustomExpandableAdapter(this,expandableListTitle,expandableListDetails);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener(){

            @Override
            public void onGroupCollapse(int i) {
                Toast.makeText(getApplicationContext(),expandableListTitle.get(i)+"List Collapsed",Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long id) {
                Toast.makeText(getApplicationContext(),expandableListTitle.get(groupPosition)+"List "+expandableListDetails.get(expandableListTitle.get(groupPosition)).get(childPosition),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}