package com.maps.reto2apps.modelo;

import java.io.Serializable;

public class Artist implements Serializable {

    private String name;

    public Artist(String name) {
        this.name = name;
    }

    public Artist() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
