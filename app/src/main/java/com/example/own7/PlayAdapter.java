package com.example.own7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PlayAdapter extends ArrayAdapter {
    private final int resourceId;
    public PlayAdapter(Context context, int textViewResourceId, List<Media_Play> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View covertView, ViewGroup parent){
        Media_Play media_play = (Media_Play) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);//实例化一个对象,使用Inflater对象来将布局文件解析成一个View

        TextView Playtitle = view.findViewById(R.id.title);
        TextView Playdisplay = view.findViewById(R.id.displayname);
        TextView Playduration = view.findViewById(R.id.duration);
        Playtitle.setText(media_play.getTitle());
        Playdisplay.setText(media_play.getDisplayname());
        Long num = new Long(media_play.getDuration());
        String duration_String = num.toString();
        Playduration.setText(duration_String);//没有适用于long的方法，需要转化为String
        return view;
    }
}
