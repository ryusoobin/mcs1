package com.example.mcs1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReserveCompleteActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reserve_complete);

        TextView reserveSeat;
        reserveSeat = (TextView)findViewById(R.id.reserveSeat);

        String seat;
        Intent intent = getIntent();
        seat = intent.getStringExtra("reserveseat");

        reserveSeat.setText(seat);

        Button BtnCheck1 = (Button)findViewById(R.id.BtnCheck1);
        BtnCheck1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                startActivity(intent);
            }
        });
    }
}