package edu.oakland.cse.tictactoe.controller;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import edu.oakland.cse.tictactoe.R;
import edu.oakland.cse.tictactoe.models.Board;
import edu.oakland.cse.tictactoe.models.Player;

/**
 * Created by kusu on 4/14/15.
 */
public class GameManager implements GameController {
    private TableLayout gameBoard;
    private Board ttcBoard;
    private int turn;
    private int previousStart;
    private Player player1;
    private Player player2;

    public GameManager(TableLayout mainView,Board ttcBoard,Player p1, Player p2){
        this.gameBoard=mainView;
        this.ttcBoard=ttcBoard;
        this.player1=p1;
        this.player2=p2;
        TextView view=(TextView)gameBoard.findViewById(R.id.playerTurnText);
        view.setText(p1.getFirstname());
    }

    public void restartGame(){
        TextView view=(TextView)gameBoard.findViewById(R.id.playerTurnText);
        for (int i = 0; i < 3; i++) {
            View child = gameBoard.getChildAt(i);
            if (child != null && child instanceof TableRow) {
                TableRow row = (TableRow) child;


                for (int j = 0; j < 3; j++) {
                    View button = row.getChildAt(j);
                    final Button button1 = (Button) button;
                    button1.setText("");
                    button1.setEnabled(true);
                }
            }
        }
        ttcBoard.clearBoard();
        if(previousStart==0){
            turn=1;
            previousStart=1;
            if(player2!=null) {
                view.setText(player2.getFirstname());
            }
        }else{
            turn=0;
            previousStart=0;
            if(player1!=null) {
                view.setText(player1.getFirstname());
            }
        }


    }

    public void play(int i, int j,Button button){
        TextView view=(TextView)gameBoard.findViewById(R.id.playerTurnText);

        if (turn == 0) {
            ttcBoard.fillWithZero(i, j);
            turn = 1;
            button.setTextColor(Color.BLUE);
            button.setText("0");
            view.setText(player2.getFirstname());
        } else {
            ttcBoard.fillWithX(i, j);
            button.setTextColor(Color.RED);
            button.setText("X");
            turn = 0;
            view.setText(player1.getFirstname());
        }
        button.setEnabled(false);
        ttcBoard.checkGameOver();

    }
}
