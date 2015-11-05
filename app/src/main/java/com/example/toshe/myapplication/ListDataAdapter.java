package com.example.toshe.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by toshe on 4.11.2015 г..
 */
public class ListDataAdapter extends ArrayAdapter {

     List list = new ArrayList();
    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
    TextView WORD_EN, WORD_BG;
    }

    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return  list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        View row = convertView;
        LayoutHandler layoutHandler;
        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.WORD_EN = (TextView)row.findViewById(R.id.textWordEn);
            layoutHandler.WORD_BG = (TextView)row.findViewById(R.id.textWordBg);
            row.setTag(layoutHandler);
        }
        else{
            layoutHandler = (LayoutHandler)row.getTag();
            }

        DataProvider dataProvider = (DataProvider)this.getItem(position);
        layoutHandler.WORD_EN.setText(dataProvider.getWordEn().toString());
        layoutHandler.WORD_BG.setText(dataProvider.getWordBg().toString());

        return row;
    }
}
