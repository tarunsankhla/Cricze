package com.example.cricze;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class VenueCustomExpandableAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "VenueCustomExpandableAdapter";
    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String,List<String>> expandableListDetails;

    public VenueCustomExpandableAdapter(Context context,List<String> expandableListTitle,HashMap<String,List<String>> expandableListDetails ){
        this.context = context;
        this.expandableListDetails =expandableListDetails;
        this.expandableListTitle= expandableListTitle;
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int position) {
        return this.expandableListDetails.get(this.expandableListTitle.get(position)).size();
    }

    @Override
    public Object getGroup(int position) {
        return this.expandableListTitle.get(position);
    }

    @Override
    public Object getChild(int position, int position1) {
        return this.expandableListDetails.get(this.expandableListTitle.get(position)).get(position1);
    }

    @Override
    public long getGroupId(int position) {
        return position;
    }

    @Override
    public long getChildId(int position, int position1) {
        return position1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View convertview, ViewGroup parent) {
        String listTitle =(String)getGroup(listPosition);
        if(convertview ==null) {
            LayoutInflater layoutInflater =(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = layoutInflater.inflate(R.layout.activity_venue_list_group,null);
        }
        TextView listTitleTextView =(TextView)convertview.findViewById(R.id.venue_listtitle);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);
        return convertview;
    }

    @Override
    public View getChildView(int listPosition,final int expandedListPosition, boolean isLastChild, View convertview, ViewGroup parent) {
        final String expandedListText = (String)getChild(listPosition,expandedListPosition);
        if(convertview == null){
            LayoutInflater layoutInflater =(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = layoutInflater.inflate(R.layout.activity_venue_list_item,null);
        }
        TextView expandedListTextView = (TextView)convertview.findViewById((R.id.expandable_listitem));
        expandedListTextView.setText(expandedListText);
        return convertview;
    }

    @Override
    public boolean isChildSelectable(int position, int position1) {
        return true;
    }
}
