package com.example.vikalp.hackathon.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.vikalp.hackathon.R;

public class FixMatch extends AppCompatActivity {

    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fix_match);
//        initializeCalendar();


        CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.fix_layout);
        Snackbar snack = Snackbar.make(layout,"Schedule Match",Snackbar.LENGTH_INDEFINITE).setAction("Proceed", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FixMatch.this,ScheduledMatch.class));
            }
        });

        snack.show();

        final RadioButton button = (RadioButton) findViewById(R.id.radio1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.getBackground().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
            }
        });
    }

   /* private void initializeCalendar() {
        calendar = (CalendarView) findViewById(R.id.calendar);
        calendar.setShowWeekNumber(false);
        calendar.setFirstDayOfWeek(2);


    }*/



}
