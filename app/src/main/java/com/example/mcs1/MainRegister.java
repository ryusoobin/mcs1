package com.example.mcs1;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainRegister extends AppCompatActivity {
    Button register;
    ImageButton BtnReturn;

    //RadioGroup gender;
    //RadioButton man, woman;
    EditText username, userid, password, email, age;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);

        BtnReturn = (ImageButton)findViewById(R.id.BtnReturn);
        register = (Button) findViewById(R.id.Register);
        username = (EditText) findViewById(R.id.username);
        userid = (EditText) findViewById(R.id.userid);
        password = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        age = (EditText) findViewById(R.id.age);
        //gender = (RadioGroup) findViewById(R.id.gender);
        //man = (RadioButton) findViewById(R.id.man);
        //woman = (RadioButton) findViewById(R.id.woman);

        String edtName = username.getText().toString();
        String edtId = userid.getText().toString();
        String edtPw = password.getText().toString();
        String edtEmail = email.getText().toString();
        String edtAge = age.getText().toString();

        BtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainRegister.this,MainLogin.class);
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() { //등록 버튼 누르면 회원가입 완료 -> 로그인 페이지 이동
            public void onClick(View v) {
                if(edtId.length() !=0 && edtName.length() !=0 && edtPw.length() !=0 && edtEmail.length() !=0 && edtAge.length() !=0)
                {
                    Toast.makeText(MainRegister.this, "회원가입 성공", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(MainRegister.this,MainLogin.class);
                    startActivity(intent);
                }
                /*if(edtName.length()==0){
                    Toast.makeText(MainRegister.this, "이름을 입력해주세요.", Toast.LENGTH_LONG).show();
                    if(edtId.length()==0){
                        Toast.makeText(MainRegister.this, "아이디를 입력해주세요.", Toast.LENGTH_LONG).show();
                    }
                    if(edtPw.length()==0){
                        Toast.makeText(MainRegister.this, "비밀번호를 입력해주세요.", Toast.LENGTH_LONG).show();
                    }
                    if(edtEmail.length()==0){
                        Toast.makeText(MainRegister.this, "이메일을 입력해주세요.", Toast.LENGTH_LONG).show();
                    }
                    if(edtAge.length()==0){
                        Toast.makeText(MainRegister.this, "나이를 입력해주세요.", Toast.LENGTH_LONG).show();
                    }
                }*/
                /*else{
                    Toast.makeText(MainRegister.this,"빈 값이 있습니다.",Toast.LENGTH_SHORT).show();
                }*/
            }
        });
    }
}