package edu.oakland.cse.tictactoe.models;

import java.util.Observable;

/**
 * Created by kusu on 4/14/15.
 */
public class Board extends Observable {
    private int[][] boardMatrix;
    private int[][] score;
    private int filled;

    public Board() {
        boardMatrix = new int[3][3];
        score = new int[3][3];
    }

    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardMatrix[i][j] = 0;
                score[i][j]=0;
            }
        }
        filled = 0;
    }

    public void fillWithX(int i, int j) {
        boardMatrix[i][j] = -1;
        filled++;
        updateScore();

    }

    public void fillWithZero(int i, int j) {
        boardMatrix[i][j] = 1;
        updateScore();
        filled++;
    }

    public boolean isGameOver() {
        return isDraw() || isGameComplete();
    }

    public boolean isDraw() {
        return (filled == 9) && (getWinner() == 0);
    }

    public boolean isGameComplete() {
        return (getWinner() == -1) || (getWinner() == 1);
    }

    public int getWinner() {

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (score[i][j] == 3) {
                    return 1;
                } else if (score[i][j] == -3) {
                    return -1;
                }
            }

        }
        //draw
        return 0;
    }

    public void updateScore() {

        int diag1 = 0;
        int diag2 = 0;
        for (int j = 0; j < 3; j++) {
            int row = 0;
            int col = 0;
            for (int i = 0; i < 3; i++) {
                row += boardMatrix[j][i];
                col += boardMatrix[i][j];


            }
            diag1 += boardMatrix[j][j];
            diag2 += boardMatrix[j][2 - j];
            score[0][j] = row;
            score[1][j] = col;
        }

        score[2][0] = diag1;
        score[2][1] = diag2;
        score[2][2] = 0;

    }

    public void checkGameOver() {
        if (isGameOver()) {
            setChanged();
            notifyObservers(getWinner());
        }
    }

}
