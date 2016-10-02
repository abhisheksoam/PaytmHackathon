package com.example.vikalp.hackathon.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.vikalp.hackathon.R;

public class Compete extends AppCompatActivity {

    Snackbar save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compete);

        ImageView badmin = (ImageView) findViewById(R.id.profile_image);
        ImageView tennisTable = (ImageView) findViewById(R.id.tennis);
        ImageView squash= (ImageView) findViewById(R.id.squash);
        ImageView chess = (ImageView) findViewById(R.id.chess);
        ImageView lawn = (ImageView) findViewById(R.id.lawn);

        badmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             save.setText("You Selected Badminton");
            }
        });


        tennisTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.setText("You Selected Tennis Table");
            }
        });


        squash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.setText("You Selected Squash");
            }
        });


        chess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.setText("You Selected Chess");
            }
        });


        lawn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save.setText("You Selected Lawn Tennis");
            }
        });



        CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.main_layout);
        save = Snackbar.make(layout, "Choose your favorite one", Snackbar.LENGTH_INDEFINITE).setAction("Save", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Compete.this,ChooseLocality.class));
            }
        });
        save.show();





    }
}
