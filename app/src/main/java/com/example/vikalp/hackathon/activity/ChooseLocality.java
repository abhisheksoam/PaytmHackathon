package com.example.vikalp.hackathon.activity;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.vikalp.hackathon.R;

public class ChooseLocality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_locality);
        CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.main_layout_choose);
        Snackbar make = Snackbar.make(layout," ",Snackbar.LENGTH_INDEFINITE).setAction("Save", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText State = (EditText)findViewById(R.id.email);
                String state = State.getText().toString();
                TextInputLayout layout1 = (TextInputLayout) findViewById(R.id.input_layout_email_register);

                EditText City = (EditText)findViewById(R.id.mobile);
                String city = City.getText().toString();

                EditText Add = (EditText)findViewById(R.id.password);
                String add = Add.getText().toString();

                EditText Pin = (EditText)findViewById(R.id.op_password);
                String pin = Pin.getText().toString();

                if(state.length()<4){
                    layout1.setError("Fill this field");

                }else{
                    startActivity(new Intent(ChooseLocality.this,FixMatch.class));
                }


            }
        });
        make.show();

    }
}
