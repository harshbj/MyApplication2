package com.example.hritik.myapplication;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;

public class InviteCodeActivity extends AppCompatActivity {

    String name, email, password, date, issharing;
    String code;
    Uri imageUri;
    ProgressDialog progressDialog;
    TextView t1;
    FirebaseAuth auth;
    String userId;
    FirebaseUser user;
    StorageReference storageReference;
    DatabaseReference reference;
    String dbreference;
    SharedPreferences sharedpref;
   public static final String text = "realnameis";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_code);
        t1 = (TextView) findViewById(R.id.textView);
        auth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);



        Intent myIntent = getIntent();


        reference = FirebaseDatabase.getInstance().getReference("Users");
        storageReference = FirebaseStorage.getInstance().getReference().child("user_Image");




        if (myIntent != null) {
            name = myIntent.getStringExtra("name");
            email = myIntent.getStringExtra("email");
            password = myIntent.getStringExtra("password");
            code = myIntent.getStringExtra("code");
            //issharing = myIntent.getStringExtra("isSharing");
            issharing = "false";
            imageUri = myIntent.getParcelableExtra("imageUri");
            dbreference = email.substring(0,email.indexOf("@"));
            savedata(name,password,email,code,issharing);
        }

        t1.setText(code);
    }

    private void savedata(String name,String password,String email,String codedata,String issharing) {

        sharedpref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("password",password);
        editor.putString("code",codedata);
        editor.putString("issharing",issharing);
        editor.commit();
        Toast.makeText(this,"saved", Toast.LENGTH_LONG).show();
    }

    public void registerUser(View v) {
        progressDialog.setMessage("Please Wait We're Creating Account");
        progressDialog.show();


        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    user = auth.getCurrentUser();
                    String id = reference.push().getKey();
                    CreateUser createUser = new CreateUser(name, email, password, code, "false", "na", "na");
                    reference.child(code).setValue(createUser);



                   /* reference.child(userId).setValue(createUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {


                                 for Image saving
                                StorageReference sr = storageReference.child(user.getUid() + ".jpg");
                                sr.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                        if (task.isSuccessful()) {



                                            /*may be .getdownload url
                                            String download_img_path = task.getResult().getTask().toString();
                                            reference.child(user.getUid()).child("imageUrl").setValue(download_img_path).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()) { */


                    progressDialog.dismiss();

                    //Toast.makeText(getApplicationContext(), "User Registered Successfully", Toast.LENGTH_SHORT).show();

                    finish();
                    Intent myIntent = new Intent(InviteCodeActivity.this, homepage.class);
                    if(name != null)
                    myIntent.putExtra(text,"name");
                    else
                        Toast.makeText(getApplicationContext(),"name is empty",Toast.LENGTH_LONG).show();

                    startActivity(myIntent);


                } else {
                    progressDialog.dismiss();

                    Toast.makeText(getApplicationContext(), "Could Not Register", Toast.LENGTH_SHORT).show();

                }
            }

        });
                                      /*  }
                                    }


                                });


                            }/* else {
                                progressDialog.dismiss();

                                Toast.makeText(getApplicationContext(), "Could Not Register", Toast.LENGTH_SHORT).show();

                            }*/
    }
}
                   // });


               // }


           // }
      //  });

   // }

