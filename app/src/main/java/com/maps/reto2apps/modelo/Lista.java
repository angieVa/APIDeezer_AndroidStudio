package com.maps.reto2apps.modelo;

import java.util.ArrayList;

public class Lista {

    private ArrayList<Playlist> data;

    public Lista(ArrayList<Playlist> data) {
        this.data = data;
    }

    public Lista() {
    }

    public ArrayList<Playlist> getData() {
        return data;
    }

    public void setData(ArrayList<Playlist> data) {
        this.data = data;
    }
}
