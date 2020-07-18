package com.maps.reto2apps.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.maps.reto2apps.R;
import com.maps.reto2apps.control.ListVAdapter;
import com.maps.reto2apps.control.MainController;

public class MainActivity extends AppCompatActivity {

    private EditText playlistET;
    private ImageButton buscarBT;
    private ListView playlistLV;
    private ListVAdapter adapter;
    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playlistET = findViewById(R.id.playlistET);
        buscarBT = findViewById(R.id.buscarBT);
        playlistLV = findViewById(R.id.playlistLV);
        adapter = new ListVAdapter();
        playlistLV.setAdapter(adapter);

        mainController = new MainController(this);

    }

    public EditText getPlaylistET() {
        return playlistET;
    }

    public void setPlaylistET(EditText playlistET) {
        this.playlistET = playlistET;
    }

    public ImageButton getBuscarBT() {
        return buscarBT;
    }

    public void setBuscarBT(ImageButton buscarBT) {
        this.buscarBT = buscarBT;
    }

    public ListView getPlaylistLV() {
        return playlistLV;
    }

    public void setPlaylistLV(ListView playlistLV) {
        this.playlistLV = playlistLV;
    }

    public ListVAdapter getAdapter() {
        return adapter;
    }

    public void setAdapter(ListVAdapter adapter) {
        this.adapter = adapter;
    }

    //    public MainController getMainController() {
//        return mainController;
//    }
//
//    public void setMainController(MainController mainController) {
//        this.mainController = mainController;
//    }
}
