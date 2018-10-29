package com.example.hritik.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class password extends AppCompatActivity {


    String email;
    EditText e3_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        e3_password = (EditText)findViewById(R.id.edittext3);
        Intent myIntent=getIntent();
        if (myIntent!=null){
            email = myIntent.getStringExtra("email");
        }
    }

    public void goToNamePicActivity(View v){
      /*  String passval = "(?=.*[0-9])(?=.*[a-z])(?=.*[@#$%^&+=])(?=\\\\S+$).{6,}";
        Pattern pattern = Pattern.compile(passval);*/
        if(e3_password.getText().toString().length()>6)
        {
            Intent myIntent = new Intent(password.this,Nameactivity.class);
            myIntent.putExtra("email",email);
            myIntent.putExtra("password",e3_password.getText().toString());
            startActivity(myIntent);
            finish();
        }
        else{
            Toast.makeText(getApplicationContext(),"Password Format Incorrect",Toast.LENGTH_SHORT).show();
        }


    }
}
