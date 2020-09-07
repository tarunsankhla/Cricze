package com.example.cricze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VenueListDataPump {
    private static final String TAG = "VenueListDataPump";

    public static HashMap<String, List<String>> getData(){

        HashMap<String, List<String>>  expandableListDetails = new  HashMap<String, List<String>>();

        List<String> Mumbai = new ArrayList<String>();
        Mumbai.add("Seating Capacity: 80,000");
        Mumbai.add("Match Hosted: 233");
        Mumbai.add("Located: Mumbai,India");
        Mumbai.add("Made in: 1914");

        List<String> Sydney = new ArrayList<String>();
        Sydney.add("Seating Capacity: 1,20,000");
        Sydney.add("Match Hosted: 283");
        Sydney.add("Located: Sydnet,Austrailia");
        Sydney.add("Made in: 1933");

        List<String> Manchester = new ArrayList<String>();
        Manchester.add("Seating Capacity: 87,000");
        Manchester.add("Match Hosted: 313");
        Manchester.add("Located: Manchester,England");
        Manchester.add("Made in: 1878");

        List<String> Bangalore = new ArrayList<String>();
        Bangalore.add("Seating Capacity: 92,000");
        Bangalore.add("Match Hosted: 199");
        Bangalore.add("Located: Bangalore,India");
        Bangalore.add("Made in: 1933");

        List<String> Ahmedabad = new ArrayList<String>();
        Ahmedabad.add("Seating Capacity: 1,10,000");
        Ahmedabad.add("Match Hosted: 180");
        Ahmedabad.add("Located: Ahmedabad,India");
        Ahmedabad.add("Made in: 1982 Repaired in 2020");

        List<String> Melbourne = new ArrayList<String>();
        Melbourne.add("Seating Capacity: 1,00,454");
        Melbourne.add("Match Hosted: 219");
        Melbourne.add("Located: Melbourne,Austrailia");
        Melbourne.add("Made in: 1853");

        List<String> Kolkata = new ArrayList<String>();
        Kolkata.add("Seating Capacity: 66,349");
        Kolkata.add("Match Hosted: 269");
        Kolkata.add("Located: Kolkata,India");
        Kolkata.add("Made in: 1853");

        List<String> Adelaide = new ArrayList<String>();
        Adelaide.add("Seating Capacity: 53,583");
        Adelaide.add("Match Hosted: 189");
        Adelaide.add("Located: Adelaide ,Austrailia");
        Adelaide.add("Made in: 1871");

        expandableListDetails.put("Wankhede Stadium (Mumbai)",Mumbai);
        expandableListDetails.put("Sydney Stadium (Austrailia)",Sydney);
        expandableListDetails.put("Lords (England)",Manchester);
        expandableListDetails.put("Chinaswamy Stadium (Banglore)",Bangalore);
        expandableListDetails.put("Sardar Patel Stadium (Gujarat)",Ahmedabad);
        expandableListDetails.put("Melbourine Cricket Ground (Austrailia)",Melbourne);
        expandableListDetails.put("Eden Gardens (Kolkata)",Kolkata);
        expandableListDetails.put("Adelaide Oval (Adelaide)",Adelaide);

        return expandableListDetails;

    }
}
