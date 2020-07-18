package com.maps.reto2apps.control;

import android.util.Log;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.maps.reto2apps.modelo.Playlist;
import com.maps.reto2apps.modelo.Track;
import com.maps.reto2apps.util.Constants;
import com.maps.reto2apps.util.HTTPSWebUtilDomi;
import com.maps.reto2apps.view.ListaCancionesActivity;

import java.util.ArrayList;

public class LsitaCancionesController implements HTTPSWebUtilDomi.OnResponseListener{

    private ListaCancionesActivity activity;
    private Playlist playlist;
    private ArrayList<Track> tracks;
    private HTTPSWebUtilDomi utilDomi;
    private ListRAdapter adapter;


    public LsitaCancionesController(ListaCancionesActivity activity) {
        this.activity = activity;
        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);
        tracks = new ArrayList<>();
        adapter = new ListRAdapter(tracks, activity);
        activity.getCancionesRV().setAdapter(adapter);
        activity.getCancionesRV().setLayoutManager(new LinearLayoutManager(activity));

        long play = (long)activity.getIntent().getExtras().getSerializable("playlist");

        new Thread(
                () ->{
                    String entrada = "https://api.deezer.com/playlist/"+ play;
                    Log.e(">>>", entrada);
                    utilDomi.GETrequest(Constants.PLAYLIST_CALLBACK, entrada);

                }
        ).start();



    }


    @Override
    public void onResponse(int callbackID, String response) {

        switch (callbackID) {
            case Constants.PLAYLIST_CALLBACK:
                Gson gson = new Gson();
                playlist = gson.fromJson(response, Playlist.class);
                activity.runOnUiThread(
                        () -> {

                            Glide.with(activity).load(
                playlist.getPicture_big()
                ).centerCrop().into(activity.getPlaylistiIV());
                activity.getNomPlaylistTV().setText(playlist.getTitle());
                activity.getCantCancTV().setText(String.valueOf(playlist.getNb_tracks()));
                activity.getCantFansTV().setText(String.valueOf(playlist.getFans()));
                activity.getDescripcionTV().setText(playlist.getDescription());

                        }
                );

                ListTracks();
                break;
            case Constants.TRACK_CALLBACK:

                Gson gson2 = new Gson();
                Track tra = gson2.fromJson(response, Track.class);
                activity.runOnUiThread(
                        () -> {
                            adapter.addTrack(tra);

                        }
                );

//                tracks.add(track);
//                if(tracks.size() == playlist.getTracks().getData().size()){
//                    activity.runOnUiThread(
//                            () -> {
//                              adapter.setListTrack(tracks);
//
//                            }
//                    );
//                }

                break;
        }

    }

    private void ListTracks() {

        new Thread(
                () ->{

                    for(int i = 0; i < playlist.getTracks().getData().size(); i++){

                        String entrada = "https://api.deezer.com/track/" + playlist.getTracks().getData().get(i).getId();
                        utilDomi.GETrequest(Constants.TRACK_CALLBACK, entrada);
                    }

                }
        ).start();


    }
}
