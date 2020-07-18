package com.maps.reto2apps.control;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.Gson;
import com.maps.reto2apps.R;
import com.maps.reto2apps.modelo.Lista;
import com.maps.reto2apps.modelo.Playlist;
import com.maps.reto2apps.modelo.Track;
import com.maps.reto2apps.util.Constants;
import com.maps.reto2apps.util.HTTPSWebUtilDomi;
import com.maps.reto2apps.view.ListaCancionesActivity;
import com.maps.reto2apps.view.MainActivity;

import java.util.ArrayList;

public class MainController implements View.OnClickListener, HTTPSWebUtilDomi.OnResponseListener{

    private MainActivity mainActivity;
    private HTTPSWebUtilDomi utilDomi;
    private Playlist playlist;
    private ArrayList<Track> tracks;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        this.mainActivity.getBuscarBT().setOnClickListener(this);
        utilDomi = new HTTPSWebUtilDomi();
        utilDomi.setListener(this);
        tracks = new ArrayList<>();



        mainActivity.getPlaylistLV().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                 Playlist p = (Playlist) mainActivity.getAdapter().getItem(i);
                new Thread(
                        () ->{

//                            tracks.clear();
                            Intent intent = new Intent(mainActivity, ListaCancionesActivity.class);
                            intent.putExtra("playlist", p.getId());
//                              i.putExtra("tracks", tracks);
                            Log.e(">>>", "inicioIntent");
                               mainActivity.startActivity(intent);


//                            Log.e(">>>PlayList", String.valueOf(d.getId()));
//                            utilDomi.GETrequest(Constants.PLAYLIST_CALLBACK, String.valueOf(d.getId()));

                        }
                ).start();

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.buscarBT:
                Log.e(">>>", "buscarBT");
                String namePlaylist = mainActivity.getPlaylistET().getText().toString();
                Log.e(">>>", namePlaylist);

                new Thread(
                        () ->{
                            String entrada = "https://api.deezer.com/search/playlist?q="+ namePlaylist;
                            Log.e(">>>", entrada);
                            utilDomi.GETrequest(Constants.SEARCH_CALLBACK, entrada);

                        }
                ).start();


                break;


        }
    }

    @Override
    public void onResponse(int callbackID, String response) {
        switch (callbackID){
            case Constants.SEARCH_CALLBACK:
               Gson gson = new Gson();
               Lista lista = gson.fromJson(response, Lista.class);
               mainActivity.runOnUiThread(
                       ()->{
                           mainActivity.getAdapter().delete();
                           mainActivity.getAdapter().setPlaylist(lista.getData());
//                           for(int i = 0; i < lista.getData().size(); i++){
//                               mainActivity.getAdapter().addPlayList(lista.getData().get(i));
//                           }
                       }
               );
               break;
//               case Constants.PLAYLIST_CALLBACK:
//                   Log.e(">>>", "entro "+ tracks.size());
//                   Gson gson3 = new Gson();
//                    playlist = gson3.fromJson(response, Playlist.class);
//                   mainActivity.runOnUiThread(
//                           ()->{
//                              Intent i = new Intent(mainActivity, ListaCancionesActivity.class);
//                              i.putExtra("Playlist", playlist);
//                              i.putExtra("tracks", tracks);
//                              Log.e(">>>", "inicioIntent");
//                               mainActivity.startActivity(i);
//                           }
//                   );
//                   break;
//            case Constants.TRACKS_CALLBACK:
//                   Gson gson1 = new Gson();
//                   TrackList listaT = gson1.fromJson(response, TrackList.class);
//
//                new Thread(
//                        () ->{
//                            for(int i = 0; i < listaT.getData().length; i++){
//
////                                Log.e(">>>", entrada);
//                                utilDomi.GETrequest(Constants.TRACK_CALLBACK, "https://api.deezer.com/track/"+ listaT.getData()[i].getId());
//                                if(i == listaT.getData().length-1){
//                                    Log.e(">>>PlayList", String.valueOf(d.getId()));
//                                    utilDomi.GETrequest(Constants.PLAYLIST_CALLBACK, "https://api.deezer.com/playlist/"+String.valueOf(d.getId()));
//                                }
//                            }
//                        }
//                ).start();
//                break;
//            case Constants.TRACK_CALLBACK:
//                Gson gson2 = new Gson();
//                Track track = gson2.fromJson(response, Track.class);
//                tracks.add(track);
//                break;


        }
    }
}
