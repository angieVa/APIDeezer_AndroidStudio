package com.maps.reto2apps.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maps.reto2apps.R;
import com.maps.reto2apps.control.ListRAdapter;
import com.maps.reto2apps.control.LsitaCancionesController;
import com.maps.reto2apps.modelo.Playlist;
import com.maps.reto2apps.modelo.Track;

import java.util.ArrayList;

public class ListaCancionesActivity extends AppCompatActivity {

    private ImageView PlaylistiIV;
    private TextView NomPlaylistTV;
    private TextView cantCancTV;
    private TextView DescripcionTV;
    private RecyclerView cancionesRV;
    private TextView cantFansTV;
//    private ArrayList<Track> tracks;
    private LsitaCancionesController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_canciones);

        PlaylistiIV = findViewById(R.id.PlaylistiIV);
        NomPlaylistTV = findViewById(R.id.NomPlaylistTV);
        cantCancTV = findViewById(R.id.cantCancTV);
        cancionesRV = findViewById(R.id.cancionesRV);
        cantFansTV = findViewById(R.id.cantFansTV);
        DescripcionTV = findViewById(R.id.DescripcionTV);
//        tracks = new ArrayList<>();
//        adapter = new ListRAdapter(tracks, this);
//        cancionesRV.setAdapter(adapter);
//        cancionesRV.setLayoutManager(new LinearLayoutManager(this));

        controller = new LsitaCancionesController(this);


    }

    public ImageView getPlaylistiIV() {
        return PlaylistiIV;
    }

    public void setPlaylistiIV(ImageView playlistiIV) {
        PlaylistiIV = playlistiIV;
    }

    public TextView getNomPlaylistTV() {
        return NomPlaylistTV;
    }

    public void setNomPlaylistTV(TextView nomPlaylistTV) {
        NomPlaylistTV = nomPlaylistTV;
    }

    public TextView getCantCancTV() {
        return cantCancTV;
    }

    public void setCantCancTV(TextView cantCancTV) {
        this.cantCancTV = cantCancTV;
    }

    public TextView getDescripcionTV() {
        return DescripcionTV;
    }

    public void setDescripcionTV(TextView descripcionTV) {
        DescripcionTV = descripcionTV;
    }

    public RecyclerView getCancionesRV() {
        return cancionesRV;
    }

    public void setCancionesRV(RecyclerView cancionesRV) {
        this.cancionesRV = cancionesRV;
    }

    public TextView getCantFansTV() {
        return cantFansTV;
    }

    public void setCantFansTV(TextView cantFansTV) {
        this.cantFansTV = cantFansTV;
    }


    public LsitaCancionesController getController() {
        return controller;
    }

    public void setController(LsitaCancionesController controller) {
        this.controller = controller;
    }
}
