package com.cstlex.sectionedlistadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by minsoo on 2015. 12. 15..
 */
public abstract class SectionedAdapter extends BaseAdapter {

    private Map<String, Integer> layoutIdentifiers;
    private List<String> keyList;
    private LayoutInflater inflater;

    public SectionedAdapter(Context context){
        layoutIdentifiers = new HashMap<>();
        keyList = new ArrayList<>();
        inflater = LayoutInflater.from(context);
    }

    public SectionedAdapter(Context context, String identifier, int layout){
        this(context);
        registerLayoutIdentifier(identifier, layout);
    }

    @Override
    public int getCount(){
        int count = 0;
        for (int i = 0; i < getNumSections(); i++){
            count += getNumRows(i);
        }
        return count;
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    public abstract int getNumSections();

    public abstract int getNumRows(int section);

    public Object getItem(int position){
        int[] index = positionToIndex(position);
        return getItem(index[0], index[1]);
    }

    public abstract Object getItem(int section, int row);

    public int indexToPosition(int section, int row){
        int count = 0;
        for (int i = 0; i < section; i++){
            count += getNumRows(i);
        }
        count += row;
        return count;
    }

    public int[] positionToIndex(int position){
        int section = 0;
        int row;
        while (position >= getNumRows(section)){
            position -= getNumRows(section);
            section++;
        }
        row = position;
        int[] index = {section, row};
        return index;
    }

    public void registerLayoutIdentifier(String identifier, int layout){
        layoutIdentifiers.put(identifier, layout);
        keyList.add(identifier);
    }

    public abstract String identifierForIndex(int section, int row);

    @Override
    public int getViewTypeCount(){
        return layoutIdentifiers.size();
    }

    @Override
    public int getItemViewType(int position){
        int[] index = positionToIndex(position);
        return keyList.indexOf(identifierForIndex(index[0], index[1]));
    }

    public abstract View getView(int section, int row, View view);

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        int[] index = positionToIndex(position);
        if (view == null){
            int type = getItemViewType(position);
            String identifier = keyList.get(type);
            int layout = layoutIdentifiers.get(identifier);
            view = inflater.inflate(layout, parent, false);
        }
        return getView(index[0], index[1], view);
    }
}
