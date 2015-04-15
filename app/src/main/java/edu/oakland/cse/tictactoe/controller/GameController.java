package edu.oakland.cse.tictactoe.controller;

import android.widget.Button;

/**
 * Created by kusu on 4/14/15.
 */
public interface GameController {

     void restartGame();

      void play(int i, int j,Button button);
}
