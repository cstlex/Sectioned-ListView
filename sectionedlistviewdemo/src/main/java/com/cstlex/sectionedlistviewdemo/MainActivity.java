package com.cstlex.sectionedlistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.cstlex.sectionedlistadapter.SectionedAdapter;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.am_main_list);
        listView.setAdapter(new ListAdapter());
    }

    class ListAdapter extends SectionedAdapter {

        public ListAdapter(){
            super(MainActivity.this);
            registerLayoutIdentifier("first", R.layout.container_first_section);
            registerLayoutIdentifier("second", R.layout.container_second_section);
            registerLayoutIdentifier("third", R.layout.container_third_section);
        }

        @Override
        public int getNumSections(){
            return 3;
        }

        @Override
        public int getNumRows(int section){
            int rows;
            switch (section){
                case 0:
                    rows = 1;
                    break;
                case 1:
                    rows = 2;
                    break;
                case 2:
                    rows = 3;
                    break;
                default:
                    rows = 1;
                    break;
            }
            return rows;
        }

        @Override
        public Object getItem(int section, int row){
            return null;
        }

        @Override
        public String identifierForIndex(int section, int row){
            String identifier = "first";
            switch (section){
                case 0:
                    identifier = "first";
                    break;
                case 1:
                    identifier = "second";
                    break;
                case 2:
                    identifier = "third";
                    break;
            }
            return identifier;
        }

        @Override
        public View getView(int section, int row, View view){
            return view;
        }
    }
}
