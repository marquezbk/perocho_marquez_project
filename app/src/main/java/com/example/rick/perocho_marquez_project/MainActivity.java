package com.example.rick.perocho_marquez_project;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Formatter;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setButtonListeners();
        displayCurrentPlayer();
    }

    private void setButtonListeners(){

        Button btnPlay = findViewById(R.id.btn_play);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gameIntent = new Intent(getApplicationContext(), GameActivity.class);
                startActivity(gameIntent);
            }
        });

        Button btnQuit = findViewById(R.id.btn_quit);
        btnQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton btnLeaderboards = findViewById(R.id.ibtn_leaderboards);
        btnLeaderboards.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: go to leaderboards activity
            }
        });

        ImageButton btnOptions = findViewById(R.id.ibtn_options);
        btnOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: go to options activity
            }
        });
    }

    private void displayCurrentPlayer(){
        TextView txtCurrentPlayer = findViewById(R.id.txt_current_player);
        String playerDisplayFormat = getString(R.string.player_format);

        // TODO: find current player from sharedpreferences and update current player
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.SHARED_PREFERENCES_ID), MODE_PRIVATE);
        String currentPlayer = sharedPreferences.getString(getString(R.string.CURRENT_USER_ID), null);

        txtCurrentPlayer.setText(String.format(playerDisplayFormat, currentPlayer));
    }
}
