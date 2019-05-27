package com.nikalexion.rockscissorspaper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startGame(View view) {
        startActivity(new Intent(MainActivity.this, Game.class));
    }

    public void exiter(View view) {
        finish();
        System.exit(0);
    }
}
