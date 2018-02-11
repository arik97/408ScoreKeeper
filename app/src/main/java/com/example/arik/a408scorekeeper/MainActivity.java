package com.example.arik.a408scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int _team1Score = 0;
    private int _team2Score = 0;
    private ProgressBar team1Progress,team2Progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team1Progress = (ProgressBar) findViewById(R.id.team1Progress);
        team2Progress = (ProgressBar) findViewById(R.id.team2Progress);

    }

    public void team1two(View v){
        _team1Score += 2;
        validateScores();

    }

    public void team1three(View v){
        _team1Score += 3;
        validateScores();

    }

    public void team2two(View v){
        _team2Score += 2;
        validateScores();

    }

    public void team2three(View v){
        _team2Score += 3;
        validateScores();

    }

    public void validateScores(){
        if (_team1Score > 21){
            _team1Score = 14;
            Toast.makeText(MainActivity.this,"Team 1 score reset to 14!",Toast.LENGTH_LONG).show();
        }
        if (_team2Score > 21){
            _team2Score = 14;
            Toast.makeText(MainActivity.this,"Team 2 score reset to 14!",Toast.LENGTH_LONG).show();
        }
        if(_team1Score == 21){
            _team1Score = 0;
            _team2Score = 0;
            Toast.makeText(MainActivity.this,"Team 1 has won the game!",Toast.LENGTH_LONG).show();
        }
        if(_team2Score == 21){
            _team1Score = 0;
            _team2Score = 0;
            Toast.makeText(MainActivity.this,"Team 2 has won the game!",Toast.LENGTH_LONG).show();
        }
        TextView team1Score = (TextView)findViewById(R.id.score1);
        team1Score.setText(Integer.toString(_team1Score));
        TextView team2Score = (TextView)findViewById(R.id.score2);
        team2Score.setText(Integer.toString(_team2Score));
        team1Progress.setProgress(_team1Score);
        team2Progress.setProgress(_team2Score);

    }

    public void teamCreator(View V){
        startActivity(new Intent(this,TeamRandomizer.class));
    }
}
