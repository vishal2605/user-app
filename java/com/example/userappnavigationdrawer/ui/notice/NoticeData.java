package com.example.userappnavigationdrawer.ui.notice;

public class NoticeData {
    String Title,Image,date,time,key;

    public NoticeData() {
    }

    public NoticeData(String title, String image, String date, String time, String key) {
        Title = title;
        Image = image;
        this.date = date;
        this.time = time;
        this.key = key;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}