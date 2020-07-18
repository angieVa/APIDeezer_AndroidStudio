package com.maps.reto2apps.control;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.maps.reto2apps.R;
import com.maps.reto2apps.modelo.Track;
import com.maps.reto2apps.view.CancionActivity;
import com.maps.reto2apps.view.ListaCancionesActivity;

import java.util.ArrayList;

public class ListRAdapter extends RecyclerView.Adapter<ListRAdapter.HolderTrack> {

    private ArrayList<Track> ListTrack;
    private ListaCancionesActivity activity;

    public ListRAdapter(ArrayList<Track> listTrack, ListaCancionesActivity activity) {
        ListTrack = listTrack;
        this.activity = activity;
    }

    @NonNull
    @Override
    public HolderTrack onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater .from(parent.getContext()).inflate(R.layout.cancionesitems, null, false);

        return new HolderTrack(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderTrack holder, int position) {
        holder.NombreCancionTV.setText(ListTrack.get(position).getTitle());
        holder.NombreArtistaTV.setText("Artista: "+ListTrack.get(position).getArtist().getName());
        holder.LanzamientoTV.setText("Lanzamiento: "+ListTrack.get(position).getRelease_date());

        Glide.with(holder.itemView).load(
                ListTrack.get(position).getAlbum().getCover_big()
        ).centerCrop().into(holder.imageView3);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, CancionActivity.class);
                i.putExtra("track", ListTrack.get(position));
                activity.startActivity(i);
            }
        });

    }

    public void addTrack(Track track){
        ListTrack.add(track);
        notifyDataSetChanged();

    }

    public ArrayList<Track> getListTrack() {
        return ListTrack;
    }

    public void setListTrack(ArrayList<Track> listTrack) {
        ListTrack = listTrack;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return ListTrack.size();
    }

    public class HolderTrack extends RecyclerView.ViewHolder {

        ImageView imageView3;
        TextView NombreCancionTV;
        TextView NombreArtistaTV;
        TextView LanzamientoTV;


        public HolderTrack(@NonNull View itemView) {
            super(itemView);

            imageView3 = itemView.findViewById(R.id.imageView3);
            NombreCancionTV = itemView.findViewById(R.id.NombreCancionTV);
            NombreArtistaTV = itemView.findViewById(R.id.NombreArtistaTV);
            LanzamientoTV = itemView.findViewById(R.id.LanzamientoTV);

        }


    }
}
