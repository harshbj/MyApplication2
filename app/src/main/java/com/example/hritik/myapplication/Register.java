package com.example.hritik.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ProviderQueryResult;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    EditText e4_email;
    FirebaseAuth auth;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e4_email = (EditText) findViewById(R.id.edittext4);
        auth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
    }

    private void sendVerificationEmail() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user.sendEmailVerification()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            // email sent


                            // after email is sent just logout the user and finish this activity
                            FirebaseAuth.getInstance().signOut();
                            startActivity(new Intent(Register.this, homepage.class));
                            finish();
                        } else {
                            // email not sent, so display message and restart the activity or do whatever you wish to do

                            //restart this activity
                            overridePendingTransition(0, 0);
                            finish();
                            overridePendingTransition(0, 0);
                            startActivity(getIntent());

                        }
                    }
                });
    }


    public void goToPasswordActivity(View v) {

        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        if (pattern.matcher(e4_email.getText().toString()).matches()) {
            dialog.setMessage("Checking Email.");

            dialog.show();
            auth.fetchProvidersForEmail(e4_email.getText().toString())
                    .addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
                        @Override
                        public void onComplete(@NonNull Task<ProviderQueryResult> task) {


                            if (task.isSuccessful()) {
                                dialog.dismiss();
                                boolean check = !task.getResult().getProviders().isEmpty();


                                if (!check) {
                                    Intent myIntent = new Intent(Register.this, password.class);
                                    myIntent.putExtra("email", e4_email.getText().toString());
                                    startActivity(myIntent);
                                    finish();


                                } else {
                                    dialog.dismiss();
                                    Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
        } else {
            Toast.makeText(getApplicationContext(), "Enter correct Email", Toast.LENGTH_SHORT).show();
        }
    }
}
