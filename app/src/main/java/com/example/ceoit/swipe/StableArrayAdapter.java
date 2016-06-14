package com.example.ceoit.swipe;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class StableArrayAdapter extends ArrayAdapter<String> {

    HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();
    View.OnTouchListener mTouchListener;
//    static float textsize;
//    static SharedPreferences sp;
    Context context;

    public StableArrayAdapter(Context context, int textViewResourceId,
            List<String> objects/*, View.OnTouchListener listener*/) {
        super(context, textViewResourceId, objects);
        this.context=context;
//        mTouchListener = listener;
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
        }
    }

    @Override
    public long getItemId(int position) {
        String item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
//        sp= context.getSharedPreferences("textsize", Context.MODE_PRIVATE);
//        textsize=sp.getFloat("textsize",0);
        if (view != convertView) {
            // Add touch listener to every new view to track swipe motion
//            view.setOnTouchListener(mTouchListener);
        }
//        ((TextView)view).setTextSize(textsize);
        return view;
    }

}