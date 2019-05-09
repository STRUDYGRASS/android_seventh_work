package com.example.own7;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private List<Media_Play> playList;
    AlertDialog.Builder builder;
    AlertDialog ad;
    ListView listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = new ListView(this);    //搜索手机中的视频文件
        Cursor c  = this.getContentResolver()
                .query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI,
                        new String[]{MediaStore.Video.Media.TITLE,
                                MediaStore.Video.Media.DURATION,
                                MediaStore.Video.Media._ID,
                                MediaStore.Video.Media.DISPLAY_NAME ,
                                MediaStore.Video.Media.DATA},
                        null, null, null);
        if (c==null || c.getCount()==0)     //如果没有搜索到视频，显示存储列表为空...
        {
            builder = new AlertDialog.Builder(this);
            builder.setMessage("存储列表为空...").setPositiveButton("确定", null);
            ad = builder.create();
            ad.show();
        }
        else
        {
            playList = new ArrayList<Media_Play>();

            while (c.moveToNext()){
                Media_Play media_play = new Media_Play(c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE)),c.getInt(c.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION)),c.getInt(c.getColumnIndexOrThrow(MediaStore.Video.Media._ID)),c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME)),c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.DATA)));
                playList.add(media_play);
//                String title = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.TITLE));
//                long duration = c.getInt(c.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION));
//                int id = c.getInt(c.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
//                String displayname = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME));
//                String path = c.getString(c.getColumnIndexOrThrow(MediaStore.Video.Media.DATA));
            }
            PlayAdapter adapter = new PlayAdapter(MainActivity.this,R.layout.media_play,playList);
            listview = findViewById(R.id.List_View);
            listview.setAdapter(adapter);
        }
    }
}
