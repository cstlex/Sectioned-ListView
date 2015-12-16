package com.cstlex.sectionedlistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by minsoo on 2015. 12. 15..
 */
public class SectionedListView extends ListView {

    public SectionedListView(Context context){
        super(context);
    }

    public SectionedListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SectionedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
