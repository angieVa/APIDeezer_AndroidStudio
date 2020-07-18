package com.maps.reto2apps.modelo;

import java.io.Serializable;

public class Album implements Serializable {

    private String title;
    private String cover_big;

    public Album(String title, String cover_big) {
        this.title = title;
        this.cover_big = cover_big;
    }

    public Album() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover_big() {
        return cover_big;
    }

    public void setCover_big(String cover_big) {
        this.cover_big = cover_big;
    }
}
