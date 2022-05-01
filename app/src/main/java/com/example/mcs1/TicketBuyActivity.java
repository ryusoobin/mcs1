package com.example.mcs1;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TicketBuyActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ticket_buy);

        Button BtnBuy = (Button)findViewById(R.id.BtnBuy);
        ImageButton BtnReturn = (ImageButton) findViewById(R.id.BtnReturn);
        BtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button BtnTimeTicket1,BtnTimeTicket3, BtnTimeTicket6, BtnTimeTicket9,BtnTimeTicket12;

        final boolean[] selected = {false};
        BtnTimeTicket1 = findViewById(R.id.BtnTimeTicket1);
        BtnTimeTicket3 = findViewById(R.id.BtnTimeTicket3);
        BtnTimeTicket6 = findViewById(R.id.BtnTimeTicket6);
        BtnTimeTicket9 = findViewById(R.id.BtnTimeTicket9);
        BtnTimeTicket12 = findViewById(R.id.BtnTimeTicket12);

        BtnTimeTicket1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket1.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
                else{
                    BtnTimeTicket1.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
            }
        });

        BtnTimeTicket3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket3.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket1.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
                else{
                    BtnTimeTicket3.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket1.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
            }
        });

        BtnTimeTicket6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket6.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket1.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
                else{
                    BtnTimeTicket6.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket1.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
            }
        });

        BtnTimeTicket9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket9.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket1.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
                else{
                    BtnTimeTicket9.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket1.setSelected(false);
                    BtnTimeTicket12.setSelected(false);
                }
            }
        });

        BtnTimeTicket12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(selected[0]){
                    BtnTimeTicket12.setSelected(false);
                    selected[0] = false;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket1.setSelected(false);
                }
                else{
                    BtnTimeTicket12.setSelected(true);
                    selected[0] = true;
                    BtnTimeTicket3.setSelected(false);
                    BtnTimeTicket6.setSelected(false);
                    BtnTimeTicket9.setSelected(false);
                    BtnTimeTicket1.setSelected(false);
                }
            }
        });
        BtnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selected[0]) {
                    Intent intent = new Intent(getApplicationContext(), PayCompleteActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"결제시간을 선택하세요",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}