package com.maps.reto2apps.modelo;

import java.io.Serializable;

public class Track implements Serializable {

    private String title;
    private String link;
    private int duration;
    private String release_date;
    private Artist artist;
    private Album album;
    private long id;

    public Track(String title, String link, int duration, Artist artist, Album album, long id) {
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
        this.id = id;
    }

    public Track() {
    }

    public Track(String title, String link, int duration, String release_date, Artist artist, Album album, long id) {
        this.title = title;
        this.link = link;
        this.duration = duration;
        this.release_date = release_date;
        this.artist = artist;
        this.album = album;
        this.id = id;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
