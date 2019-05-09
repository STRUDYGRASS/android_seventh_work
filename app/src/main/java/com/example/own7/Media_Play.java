package com.example.own7;

public class Media_Play {
    private String title;
    private long duration;
    private int id;
    private String displayname;
    private String path;
    public Media_Play(String title,long duration,int id,String displayname,String path){
        this.title = title;
        this.duration=duration;
        this.id = id;
        this.displayname = displayname;
        this.path = path;
    }
    public String getTitle(){
        return title;
    }

    public long getDuration() {
        return duration;
    }

    public int getId() {
        return id;
    }

    public String getDisplayname() {
        return displayname;
    }

    public String getPath() {
        return path;
    }
}
