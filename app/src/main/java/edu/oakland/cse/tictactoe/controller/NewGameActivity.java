package edu.oakland.cse.tictactoe.controller;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.oakland.cse.tictactoe.R;
import edu.oakland.cse.tictactoe.models.Player;

public class NewGameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

    }

    @Override
    public void onStart(){
        super.onStart();
        addButtonListeners();
    }

    public void addButtonListeners(){
        Button okButton=(Button)findViewById(R.id.newGameOkButton);
        Button cancelButton=(Button)findViewById(R.id.newGameCancelButton);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startGame();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void startGame(){
        Player player1=createPlayer1();
        Player player2=createPlayer2();
        Intent intent=new Intent(this,GameActivity.class);
        intent.putExtra("player1",player1);
        intent.putExtra("player2",player2);
        finish();
        startActivity(intent);

    }

    public Player createPlayer1(){
        TextView firstNameField=(TextView)findViewById(R.id.p1_first_name);
        TextView lastNameField=(TextView)findViewById(R.id.p1_last_name);
        Player player=new Player(firstNameField.getText().toString(),lastNameField.getText().toString());
        player.setIsComputer(getIntent().getBooleanExtra("game_mode",false));
        return player;
    }

    public Player createPlayer2(){
        TextView firstNameField=(TextView)findViewById(R.id.p2_first_name);
        TextView lastNameField=(TextView)findViewById(R.id.p2_last_name);
        Player player=new Player(firstNameField.getText().toString(),lastNameField.getText().toString());
        player.setIsComputer(false);
        return  player;
    }

}
