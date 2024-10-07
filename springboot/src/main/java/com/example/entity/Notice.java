package com.example.entity;

import java.io.Serializable;

public class Notice implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 公告id
    private String title; // 公告标题
    private String content; // 公告内容
    private String time; // 公告时间
    private String user; // 公告发表者

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
