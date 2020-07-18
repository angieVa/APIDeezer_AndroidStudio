package com.maps.reto2apps.control;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maps.reto2apps.R;
import com.maps.reto2apps.modelo.Playlist;

import java.util.ArrayList;

public class ListVAdapter extends BaseAdapter {

    private ArrayList<Playlist> playlist;

    public ListVAdapter() {
        playlist = new ArrayList<>();
    }

    public void delete(){
        playlist.clear();
    }

    @Override
    public int getCount() {
        return playlist.size();
    }

    @Override
    public Object getItem(int position) {
        return playlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.playlistitems, null, false);

        TextView NomPlaylistTV = v.findViewById(R.id.NomPlaylistTV);
        TextView NombreUsuarioTV = v.findViewById(R.id.NombreUsuarioTV);
        TextView CantCancionesTV = v.findViewById(R.id.CantCancionesTV);
        ImageView playIVL = v.findViewById(R.id.playIVL);

        NomPlaylistTV.setText(playlist.get(position).getTitle());
        NombreUsuarioTV.setText("Usuario: "+playlist.get(position).getUser().getName());
        CantCancionesTV.setText("Canciones: "+playlist.get(position).getNb_tracks());

        Glide.with(v).load(
                playlist.get(position).getPicture_big()
        ).centerCrop().into(playIVL);


        return v;
    }

    public void addPlayList(Playlist data){
        playlist.add(data);
        notifyDataSetChanged();
    }

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(ArrayList<Playlist> playlist) {
        this.playlist = playlist;
        notifyDataSetChanged();
    }
}
