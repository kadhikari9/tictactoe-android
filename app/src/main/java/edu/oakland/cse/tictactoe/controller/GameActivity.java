package edu.oakland.cse.tictactoe.controller;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

import edu.oakland.cse.tictactoe.R;
import edu.oakland.cse.tictactoe.models.Board;
import edu.oakland.cse.tictactoe.models.Player;
import edu.oakland.cse.tictactoe.view.GameOverAlertDialog;


public class GameActivity extends Activity implements Observer {
    private Player player1;
    private Player player2;
    private GameManager gameController;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ttc_board);
    }

    @Override
    public void onStart(){
        super.onStart();
        Serializable p1=getIntent().getSerializableExtra("player1");
        Serializable p2=getIntent().getSerializableExtra("player2");
        TableLayout table = (TableLayout) findViewById(R.id.tableLayout1);
        player1=(Player)p1;
        player2=(Player)p2;
        Board ttcBoard = new Board();
        gameController=new GameManager(table,ttcBoard,player1,player2);

        addListenerOnButton();


        ttcBoard.addObserver(this);
    }

    private void addListenerOnButton() {

        TableLayout table = (TableLayout) findViewById(R.id.tableLayout1);
        for (int i = 0; i < 3; i++) {
            View child = table.getChildAt(i);
            if (child != null && child instanceof TableRow) {
                TableRow row = (TableRow) child;


                for (int j = 0; j <3; j++) {
                    View button = row.getChildAt(j);
                    final Button button1 = (Button) button;
                    final int ii = i;
                    final int jj = j;
                    button1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            gameController.play(ii, jj, button1);

                        }
                    });
                }
            }
        }

    }

    public void update(Observable observable, Object data) {
        Integer winner = (Integer) data;
        String msg;
        if (winner == 1) {
            msg = "Game is Over. "+player1.getFirstname()+" wins.";
            Log.d("Game over...", "PLayer 1 Wins");

        } else if (winner == -1) {
            msg = "Game Over. "+player2.getFirstname()+" wins.";
            Log.d("Game over...", "PLayer 2 Wins");
        } else {
            msg = "Game is Over. It's a tie.";
            Log.d("Game over...", "Draw...");
        }

        DialogFragment newFragment = GameOverAlertDialog.newInstance(
                "Game Over...",msg,gameController);
        newFragment.setCancelable(false);
        newFragment.show(getFragmentManager(),"game_over");

    }

}
