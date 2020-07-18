package com.maps.reto2apps.modelo;

import java.util.ArrayList;

public class TrackList {

    private ArrayList<Track> data;

    public TrackList() {
    }

    public TrackList(ArrayList<Track> data) {
        this.data = data;
    }

    public ArrayList<Track> getData() {
        return data;
    }

    public void setData(ArrayList<Track> data) {
        this.data = data;
    }
}
