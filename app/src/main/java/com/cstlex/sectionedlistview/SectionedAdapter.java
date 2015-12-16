package com.cstlex.sectionedlistview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by minsoo on 2015. 12. 15..
 */
public abstract class SectionedAdapter extends BaseAdapter {

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
        int row = 0;
        while (position > getNumRows(section)){
            position -= getNumRows(section);
            section++;
        }
        row = position;
        int[] index = {section, row};
        return index;
    }

    public abstract View getView(int section, int row, View view, ViewGroup parent);

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        int[] index = positionToIndex(position);
        return getView(index[0], index[1], view, parent);
    }
}
