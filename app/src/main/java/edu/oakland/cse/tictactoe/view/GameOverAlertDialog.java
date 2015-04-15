package edu.oakland.cse.tictactoe.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import edu.oakland.cse.tictactoe.R;
import edu.oakland.cse.tictactoe.controller.GameController;

/**
 * Created by kusu on 4/14/15.
 */
public class GameOverAlertDialog extends DialogFragment {
    private  String title;
    private  String message;
    private GameController gameController;

    public static GameOverAlertDialog newInstance(String ttl,String msg,GameController controller) {
        GameOverAlertDialog dialog=new GameOverAlertDialog();
        dialog.message=msg;
        dialog.gameController=controller;
        dialog.title=ttl;
        return dialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

            return new AlertDialog.Builder(getActivity())

                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(R.string.ok_label,
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {

                                    gameController.restartGame();
                                    dialog.dismiss();
                                }
                            }
                    )

                    .create();
        }
    }