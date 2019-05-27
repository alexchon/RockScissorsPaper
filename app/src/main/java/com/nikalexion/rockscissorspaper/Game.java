package com.nikalexion.rockscissorspaper;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class Game extends AppCompatActivity {
    int random,opp;
    int scoreYou = 0;
    int scoreAI = 0;
    Random r = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        if (savedInstanceState != null){
            TextView you = findViewById(R.id.you);
            TextView ai = findViewById(R.id.ai);
            //Do whatever you need with the string here, like assign it to variable.
            scoreYou = savedInstanceState.getInt("yourScore");
            scoreAI = savedInstanceState.getInt("AIScore");
            you.setText("You: " + scoreYou);
            ai.setText("AI: " + scoreAI);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("yourScore", scoreYou);
        savedInstanceState.putInt("AIScore", scoreAI);
        //declare values before saving the state
        super.onSaveInstanceState(savedInstanceState);
    }


    public void exiter(View view) {
        finish();
    }

    public void xarti(View view) {
        TextView you = findViewById(R.id.you);
        TextView ai = findViewById(R.id.ai);
        final Button petra2 = findViewById(R.id.petra2);
        final Button psalidi2 = findViewById(R.id.psalidi2);
        final Button xarti2 = findViewById(R.id.xarti2);
        petra2.setEnabled(false);
        xarti2.setEnabled(false);
        psalidi2.setEnabled(false);
        opp = antipalos();

        petra2.setVisibility(View.INVISIBLE);
        psalidi2.setVisibility(View.INVISIBLE);
        anim(view);
        if (opp == 0){
            scoreYou++;
            you.setText("You: " + scoreYou);
        }
        else if (opp == 1){
            scoreAI++;
            ai.setText("AI: " + scoreAI);
        }
        else{

        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1.5s = 1500ms
                petra2.setVisibility(View.VISIBLE);
                psalidi2.setVisibility(View.VISIBLE);
                petra2.setEnabled(true);
                xarti2.setEnabled(true);
                psalidi2.setEnabled(true);
            }
        }, 1500);
    }

    public void psalidi(View view) {
        TextView you = findViewById(R.id.you);
        TextView ai = findViewById(R.id.ai);
        final Button petra2 = findViewById(R.id.petra2);
        final Button psalidi2 = findViewById(R.id.psalidi2);
        final Button xarti2 = findViewById(R.id.xarti2);
        petra2.setEnabled(false);
        xarti2.setEnabled(false);
        psalidi2.setEnabled(false);
        opp = antipalos();

        petra2.setVisibility(View.INVISIBLE);
        xarti2.setVisibility(View.INVISIBLE);
        anim(view);
        if (opp == 0){
            scoreAI++;
            ai.setText("AI: " + scoreAI);
        }
        else if (opp == 1){
        }
        else{
            scoreYou++;
            you.setText("You: " + scoreYou);
        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1.5s = 1500ms
                petra2.setVisibility(View.VISIBLE);
                xarti2.setVisibility(View.VISIBLE);
                petra2.setEnabled(true);
                xarti2.setEnabled(true);
                psalidi2.setEnabled(true);
            }
        }, 1500);
    }

    public void petra(View view) {
        TextView you = findViewById(R.id.you);
        TextView ai = findViewById(R.id.ai);
        final Button petra2 = findViewById(R.id.petra2);
        final Button psalidi2 = findViewById(R.id.psalidi2);
        final Button xarti2 = findViewById(R.id.xarti2);
        petra2.setEnabled(false);
        xarti2.setEnabled(false);
        psalidi2.setEnabled(false);
        opp = antipalos();

        xarti2.setVisibility(View.INVISIBLE);
        psalidi2.setVisibility(View.INVISIBLE);
        anim(view);
        if (opp == 0){

        }
        else if (opp == 1){
            scoreYou++;
            you.setText("You: " + scoreYou);
        }
        else{
            scoreAI++;
            ai.setText("AI: " + scoreAI);
        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1.5s = 1500ms
                psalidi2.setVisibility(View.VISIBLE);
                xarti2.setVisibility(View.VISIBLE);
                petra2.setEnabled(true);
                xarti2.setEnabled(true);
                psalidi2.setEnabled(true);
            }
        }, 1500);
    }
    public int antipalos(){
        final Button petra1 = findViewById(R.id.petra);
        final Button psalidi1 = findViewById(R.id.psalidi);
        final Button xarti1 =  findViewById(R.id.xarti);

        random = r.nextInt(3);
        if (random == 0){
            anim(petra1);
            psalidi1.setVisibility(View.INVISIBLE);
            xarti1.setVisibility(View.INVISIBLE);
        }
        else if(random == 1){
            anim(psalidi1);
            petra1.setVisibility(View.INVISIBLE);
            xarti1.setVisibility(View.INVISIBLE);
        }
        else{
            anim(xarti1);
            petra1.setVisibility(View.INVISIBLE);
            psalidi1.setVisibility(View.INVISIBLE);
        }
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 1.5s = 1500ms
                petra1.setVisibility(View.VISIBLE);
                psalidi1.setVisibility(View.VISIBLE);
                xarti1.setVisibility(View.VISIBLE);
            }
        }, 1500);

        return random;
    }
    void anim(View imageView){
        Display display = getWindowManager().getDefaultDisplay();
        Point point=new Point();
        display.getSize(point);
        final int height = point.y; // screen width
        final float halfW = height/2.0f; // half the width or to any value required,global to class
        ObjectAnimator lftToRgt,rgtToLft; // global to class
        // translationX to move object along x axis
        // next values are position value
        lftToRgt = ObjectAnimator.ofFloat( imageView,"Y",imageView.getY(),halfW )
                .setDuration(700); // to animate left to right
        rgtToLft = ObjectAnimator.ofFloat( imageView,"Y",halfW,imageView.getY() )
                .setDuration(700); // to animate right to left

        AnimatorSet s = new AnimatorSet();//required to set the sequence
        s.play( lftToRgt ).before( rgtToLft ); // manage sequence
        s.start(); // play the animation
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Button psalidi1 = findViewById(R.id.psalidi);
        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(500,500);
            layoutParams.setMargins(0,40,0,0);
            psalidi1.setLayoutParams(layoutParams);
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            psalidi1.setY(psalidi1.getY() - 150);
        }
    }
}
