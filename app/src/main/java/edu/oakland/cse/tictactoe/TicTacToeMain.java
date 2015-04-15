package edu.oakland.cse.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import edu.oakland.cse.tictactoe.controller.GameActivity;
import edu.oakland.cse.tictactoe.controller.NewGameActivity;


public class TicTacToeMain extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttc_main);

    }

    @Override
    public void onStart(){
        super.onStart();
        addExitListener();
        addButtonListeners();
    }

    private void addExitListener(){
        Button exitButton=(Button)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

    }

    private void addButtonListeners(){
        Button humanVsHuman=(Button)findViewById(R.id.humanvshumanButton);
        Button humanVsComputer=(Button)findViewById(R.id.humanvscomButton);

        humanVsComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(true);
            }
        });

        humanVsHuman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame(false);
            }
        });
    }

    private void startGame(boolean isComputerPlayer){

        Intent intent=new Intent(this,NewGameActivity.class);
        intent.putExtra("game_mode",isComputerPlayer);
        startActivity(intent);

    }
}
