package com.maps.reto2apps.modelo;

import java.io.Serializable;
import java.util.ArrayList;

public class Playlist implements Serializable {

    private String title;
    private String description;
    private int nb_tracks;
    private int fans;
    private String picture_big;
    private long id;
    private User user;
    private User creator;
    private TrackList tracks;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public TrackList getTracks() {
        return tracks;
    }

    public void setTracks(TrackList tracks) {
        this.tracks = tracks;
    }

    public Playlist(String title, int nb_tracks, int fans, String picture_big, long id, User user) {
        this.title = title;
        this.nb_tracks = nb_tracks;
        this.fans = fans;
        this.picture_big = picture_big;
        this.id = id;
        this.user = user;
    }

    public Playlist(String title, String description, int nb_tracks, int fans, String picture_big, long id, User creator, TrackList tracks) {
        this.title = title;
        this.description = description;
        this.nb_tracks = nb_tracks;
        this.fans = fans;
        this.picture_big = picture_big;
        this.id = id;
        this.creator = creator;
        this.tracks = tracks;
    }

    public Playlist() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_tracks() {
        return nb_tracks;
    }

    public void setNb_tracks(int nb_tracks) {
        this.nb_tracks = nb_tracks;
    }

    public int getFans() {
        return fans;
    }

    public void setFans(int fans) {
        this.fans = fans;
    }

    public String getPicture_big() {
        return picture_big;
    }

    public void setPicture_big(String picture_big) {
        this.picture_big = picture_big;
    }
}
