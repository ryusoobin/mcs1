package com.example.mcs1;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainLogin extends AppCompatActivity {

    EditText name, password; // db에 저장된 id, pw를 나타낸 것
    String username; // 마이페이지에 사용자 이름을 받아올 변수
    Button sign_in, sign_up;
    ImageButton BtnUser = (ImageButton)findViewById(R.id.BtnUser);
    ImageButton BtnReservation = (ImageButton) findViewById(R.id.BtnReservation);
    ImageButton BtnPay = (ImageButton)findViewById(R.id.BtnPay);
    ImageButton BtnEct = (ImageButton)findViewById(R.id.BtnEct);

    char result2;
    private static String IP_ADDRESS = "10.0.2.2:81";
    private static String TAG = "db";
    //private UsersAdapter mAdapter;
    //private ArrayList<PersonalData> mArrayList;
    //private RecyclerView mRecyclerView;
    //private String mJsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        name = findViewById(R.id.ID);
        password = findViewById(R.id.PW);

        //mRecyclerView = (RecyclerView) findViewById(R.id.listView_main_list);
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mTextViewResult.setMovementMethod(new ScrollingMovementMethod());

        //mArrayList = new ArrayList<>();

        //mAdapter = new UsersAdapter(this, mArrayList);
        //mRecyclerView.setAdapter(mAdapter);

       // mArrayList = new ArrayList<>();

        //mAdapter = new ReviewAdapter(this, mArrayList);
        //mRecyclerView.setAdapter(mAdapter);

        //GetData task = new GetData();
        //task.execute( "http://" + IP_ADDRESS + "/ReviewDownload.php", name);

        sign_in = (Button)findViewById(R.id.sign_in);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String NAME = name.getText().toString();
                String PASSWORD = password.getText().toString();

                InsertData task = new InsertData();
                task.execute("http://" + IP_ADDRESS + "/login.php", NAME,PASSWORD);
                Log.d("qq",NAME+PASSWORD);

                Intent intent = getIntent();
                username = intent.getExtras().getString("name");
            }
        });

        sign_up = (Button)findViewById(R.id.sign_up);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainLogin.this, MainRegister.class);
                startActivity(intent);
            }
        });

        BtnUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainLogin.class);
                startActivity(intent);
            }
        });

        BtnReservation.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainReservation.class);
                startActivity(intent);
            }
        });

        BtnPay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainPay.class);
                startActivity(intent);
            }
        });

        BtnEct.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainEct.class);
                startActivity(intent);
            }
        });
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(MainLogin.this,
                    "Please Wait", null, true, true);
        }
        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            Log.d("qq","\n\n"+result);
            progressDialog.dismiss();
            result2 = result.toString().charAt(0);
            Log.d("qq","\n\n"+result2);
            if(result2=='1')
            {
                Toast.makeText(getApplicationContext(), "로그인 성공", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainLogin.this, MainMypage.class);

                startActivity(intent);
            }
            else
            {
                Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 다릅니다. ", Toast.LENGTH_LONG).show();
            }
            Log.d(TAG, "POST response  - " + result);
        }
        @Override
        protected String doInBackground(String... params) {
            String ID = (String)params[1];
            String PW = (String)params[2];

            String serverURL = (String)params[0];
            serverURL = serverURL+"?" + "NAME=" + ID + "&PASSWORD=" + PW ;
            try {
                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();

                int responseStatusCode = httpURLConnection.getResponseCode();
                Log.d(TAG, "GET response code - " + responseStatusCode);

                InputStream inputStream;
                if(responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                }
                else{
                    inputStream = httpURLConnection.getErrorStream();
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while((line = bufferedReader.readLine()) != null){
                    sb.append(line);
                }
                bufferedReader.close();
                return sb.toString();

            } catch (Exception e) {
                Log.d(TAG, "InsertData: Error ", e);
                return new String("Error: " + e.getMessage());
            }
        }
    }
}