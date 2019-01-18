package com.example.harpal.exp_listview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String>langs;
    View _lastColored;
    Map<String,List<String>>topics;
    ExpandableListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView=(ExpandableListView)findViewById(R.id.expandablelistview);
        fillData();
        listAdapter=new MyExListAdapter(this,langs,topics);
        expandableListView.setAdapter(listAdapter);
       // expandableListView.setTranscriptMode(ExpandableListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
              //  v.setBackgroundColor(Color.GRAY);

                if(_lastColored != null)
                {
                    _lastColored.setBackgroundColor(Color.TRANSPARENT);
                    _lastColored.invalidate();
                }
                _lastColored = v;
                v.setBackgroundColor(Color.rgb(214, 214, 214));

                Toast.makeText(MainActivity.this,langs.get(groupPosition)+" : "+topics.get(langs.get(groupPosition)).get(childPosition),Toast.LENGTH_LONG).show();

                return false;
            }
        });

    }

    public void fillData()
    {
        langs=new ArrayList<>();
        topics=new HashMap<>();

        langs.add("MI");
        langs.add("MOTOROLA");
        langs.add("SAMSUNG");
        langs.add("ASUS");
        langs.add("NOKIA");
        langs.add("SPICE");
        langs.add("LENOVO");
        langs.add("ACER");
        langs.add("APPLE");
        langs.add("BLACKBERRY");
        langs.add("GIONEE");


        List<String>MI=new ArrayList<>();
        List<String>MOTOROLA=new ArrayList<>();
        List<String>SAMSUNG=new ArrayList<>();
        List<String>ASUS=new ArrayList<>();
        List<String>NOKIA=new ArrayList<>();
        List<String>SPICE=new ArrayList<>();
        List<String>LENOVO=new ArrayList<>();
        List<String>ACER=new ArrayList<>();
        List<String>APPLE=new ArrayList<>();
        List<String>BLACKBERRY=new ArrayList<>();
        List<String>GIONEE=new ArrayList<>();



        MI.add("Redmi Note 5 PRo");
        MI.add("Redmi 6A");
        MI.add("Redmi 6 Pro");

        MOTOROLA.add("One Power");
        MOTOROLA.add("Moto G5 Plus");
        MOTOROLA.add("Moto M");

        SAMSUNG.add("Galaxy A7");
        SAMSUNG.add("Galaxy J6");
        SAMSUNG.add("Galaxy S8");

        ASUS.add("Zenfone Max Pro M1");
        ASUS.add("Zenfone Max M1 ZB556KL");
        ASUS.add("Zenfone Lite L1");

        NOKIA.add("Nokia 5.1 Plus");
        NOKIA.add("Nokia 6.1 Plus");
        NOKIA.add("Nokia 7.1 Plus");

        SPICE.add("Spice V801");
        SPICE.add("Spice F305");
        SPICE.add("Spice K601");

        LENOVO.add("Lenovo K9 Note");
        LENOVO.add("Lenovo K8 Plus");
        LENOVO.add("Lenovo K8 Note");

        ACER.add("Acer Liquid X2");
        ACER.add("Acer Liquid Zest");
        ACER.add("Acer Liquid Zest Plus");

        APPLE.add("iPhone XS");
        APPLE.add("iPhone 7");
        APPLE.add("iPhone X");

        BLACKBERRY.add("Blackberry Evolve");
        BLACKBERRY.add("Blackberry Evolve X");
        BLACKBERRY.add("Blackberry Key2");

        GIONEE.add("Gionee S11");
        GIONEE.add("Gionee A1 Lite");
        GIONEE.add("Gionee A1");


        topics.put(langs.get(0),MI);
        topics.put(langs.get(1),MOTOROLA);
        topics.put(langs.get(2),SAMSUNG);
        topics.put(langs.get(3),ASUS);
        topics.put(langs.get(4),NOKIA);
        topics.put(langs.get(5),SPICE);
        topics.put(langs.get(6),LENOVO);
        topics.put(langs.get(7),ACER);
        topics.put(langs.get(8),APPLE);
        topics.put(langs.get(9),BLACKBERRY);
        topics.put(langs.get(10),GIONEE);

    }
}

