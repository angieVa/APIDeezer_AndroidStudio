package com.maps.reto2apps.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maps.reto2apps.R;
import com.maps.reto2apps.modelo.Track;

public class CancionActivity extends AppCompatActivity {

    private ImageView albumIV;
    private TextView nomCancionTV;
    private  TextView NomArtistaTV;
    private  TextView NomAlbumTV;
    private  TextView DuracionCancTV;
    private Button EscucharBT;
    private Track track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancion);

        albumIV = findViewById(R.id.albumIV);
        nomCancionTV = findViewById(R.id.nomCancionTV);
        NomArtistaTV = findViewById(R.id.NomArtistaTV);
        NomAlbumTV = findViewById(R.id.NomAlbumTV);
        DuracionCancTV = findViewById(R.id.DuracionCancTV);
        EscucharBT = findViewById(R.id.EscucharBT);

        track = (Track)getIntent().getExtras().get("track");
        Glide.with(this).load(
                track.getAlbum().getCover_big()
        ).centerCrop().into(albumIV);
        nomCancionTV.setText(track.getTitle());
        NomArtistaTV.setText(track.getArtist().getName());
        NomAlbumTV.setText(track.getAlbum().getTitle());
        int min = Integer.valueOf(track.getDuration())/60;
        int seg = Integer.valueOf(track.getDuration()) - (min*60);
        DuracionCancTV.setText(String.valueOf(min)+":"+String.valueOf(seg)+ " min");

        EscucharBT.setOnClickListener(new View.OnClickListener() {
                 @Override
                  public void onClick(View v) {
                        Uri uri = Uri.parse(track.getLink());
                        Intent i = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(i);
                  }
            }

        );

    }
}
