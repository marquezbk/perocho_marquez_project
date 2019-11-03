package com.example.rick.perocho_marquez_project;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends Activity {

    private static final String TAG = "GameActivity";
    PatternTimer patternTimer;
    TextView txtScore;
    ArrayList<Integer> pattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        pattern = new ArrayList<>();
        ImageButton btnPause = findViewById(R.id.ibtn_pause);
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnStart = findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patternTimer = new PatternTimer();
                patternTimer.execute((long)1000);
            }
        });

        txtScore = findViewById(R.id.txt_score);
        Log.i(TAG, "OnCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (patternTimer != null){
            patternTimer.cancel(false);
        }
        Log.i(TAG, "OnStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause");
    }

    // TODO: create timer async task. task should call functions from GameActivity class.
    private class PatternTimer extends AsyncTask<Long, Integer, Void>{
        @Override
        protected void onPreExecute() {
            pattern.clear();
        }

        @Override
        protected Void doInBackground(Long... values) {
            for(int i = 0; i < 10; i++){
                try {
                    pattern.add(new Random().nextInt(8));
                    Thread.sleep(values[0]);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                publishProgress(pattern.get(i));
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            txtScore.setText(String.format("%d", values[0]));
        }
    }
    // TODO: generatePattern(int patternSize)
    // TODO: patternStep(int index) index should be async-timer-local-variable
    // TODO: create functions for timer to call
}
