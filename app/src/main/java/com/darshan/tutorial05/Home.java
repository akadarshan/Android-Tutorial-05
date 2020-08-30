package com.darshan.tutorial05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView txtRegisterMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        txtRegisterMsg = findViewById(R.id.txtRegisterMsg);
        Intent intent = getIntent();
        String data ="First Name : " +intent.getStringExtra("FirstName")+"\n";
        data+="Last Name : " +intent.getStringExtra("LastName")+"\n";
        data+="Email : " +intent.getStringExtra("Email")+"\n";
        data+="Password : " +intent.getStringExtra("Password")+"\n";
        data+="Branch CE/IT : " +intent.getStringExtra("Branch")+"\n";
        data+="Gender : " +intent.getStringExtra("Gender")+"\n";
        data+="City : " +intent.getStringExtra("City")+"\n";
        data+="Status : " +intent.getStringExtra("Status");
        txtRegisterMsg.setText(data);
    }
}