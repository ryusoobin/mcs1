package com.example.mcs1;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainLogin extends AppCompatActivity {
    EditText usernameLogin;
    EditText passwordLogin;
    Button BtnLogin;
    Button BtnRegister;
    Button BtnFind;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        usernameLogin = (EditText) findViewById(R.id.usernameLogin);
        passwordLogin = (EditText) findViewById(R.id.passwordLogin);
        BtnLogin = (Button) findViewById(R.id.BtnLogin);
        BtnRegister = (Button) findViewById(R.id.BtnRegister);
        BtnFind = (Button) findViewById(R.id.BtnFind);

        BtnLogin.setOnClickListener(new View.OnClickListener() { // 로그인 버튼 눌렀을 때 정보가 맞으면 마이페이지로 이동
            @Override
            public void onClick(View v) {
                String name = usernameLogin.getText().toString();
                System.out.println(name);
                String pass = passwordLogin.getText().toString();
                System.out.println(pass);

                Intent intent = new Intent(getApplicationContext(), MainMypage.class);
                startActivity(intent);
            }
        });

        BtnRegister.setOnClickListener(new View.OnClickListener() { // 회원가입 버튼을 눌렀을 때 회원가입 페이지로 이동
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MainRegister.class);
                startActivity(intent);
            }
        });

        BtnFind.setOnClickListener(new View.OnClickListener() { // 아이디/비밀번호 버튼을 눌렀을 때 이메일로 찾기 페이지 이동
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InformationFindActivity.class);
                startActivity(intent);

            }
        });

        ImageButton BtnHome = (ImageButton) findViewById(R.id.BtnHome);
        BtnHome.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ImageButton BtnUser = (ImageButton) findViewById(R.id.BtnUser);
        BtnUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
            }
        });

        ImageButton BtnReservation = (ImageButton) findViewById(R.id.BtnReservation);
        BtnReservation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainReservation.class);
                startActivity(intent);
            }
        });

        ImageButton BtnMap = (ImageButton) findViewById(R.id.BtnMap);
        BtnMap.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainEct.class);
                startActivity(intent);
            }
        });

        ImageButton BtnEct = (ImageButton) findViewById(R.id.BtnEct);
        BtnEct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainEct.class);
                startActivity(intent);
            }
        });
    }
}