package com.roshanaryal.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //0:for yello and 1 for red 2:empty

    int[] gameState={2,2,2,2,2,2,2,2,2};

    int[][] winningPosition={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activeplayer =0;
    boolean gameActive=true;

    public void dropIn(View view){
        ImageView counter= (ImageView)view;
        int counterState=Integer.parseInt(counter.getTag().toString());

        if (gameState[counterState]==2&&gameActive) {
            gameState[counterState] = activeplayer;

            counter.setTranslationY(-1500);
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activeplayer = 0;

            }
            for (int[] winningPosition : winningPosition) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    gameActive=false;
                    String winningplayer = "";
                    if (activeplayer == 1) {
                        winningplayer = "Yello";

                    } else {
                        winningplayer = "Red";
                    }



                    TextView winnerTextView=(TextView)findViewById(R.id.winnerText);
                    Button playAgainButton=(Button)findViewById(R.id.button);

                   winnerTextView.setText(winningplayer + " player won!!");
                    playAgainButton.setVisibility(View.VISIBLE);
                    winnerTextView.setVisibility(View.VISIBLE);


                }


            }

            counter.animate().translationYBy(1500).rotationBy(360).setDuration(300);
        }


    }
    public void playAgain(View view){
        TextView winnerTextView=(TextView)findViewById(R.id.winnerText);
        Button playAgainButton=(Button)findViewById(R.id.button);

        playAgainButton.setVisibility(View.INVISIBLE);
        winnerTextView.setVisibility(View.INVISIBLE);
        androidx.gridlayout.widget.GridLayout myGridView = (androidx.gridlayout.widget.GridLayout)findViewById(R.id.myGridView);

        for(int i=0; i<myGridView.getChildCount(); i++) {
            ImageView counter = (ImageView) myGridView.getChildAt(i);
            counter.setImageDrawable(null);
            // d
        }
        for (int i=0;i<gameState.length;i++) {
            gameState[i] =2;
        }

         activeplayer =0;
         gameActive=true;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
