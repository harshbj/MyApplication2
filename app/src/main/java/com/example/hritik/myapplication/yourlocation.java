package com.example.hritik.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by Mandy on 10/17/2018.
 */

public class yourlocation extends Fragment {

    public TextView textView;
    public TextView textViewname;
    public Button btn;
    String name;
    SharedPreferences sharedpref;
    SharedPreferences join;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       name = getArguments().getString(homepage.codename);
        View view = inflater.inflate(R.layout.yourlocation,container,false);
        textView = view.findViewById(R.id.welcome);
        textViewname = view.findViewById(R.id.welcome2);
        btn = view.findViewById(R.id.locbtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MapsActivity.class);
                startActivity(i);
            }
        });


        return view;
    }

    public void accessdata() {
        sharedpref = PreferenceManager.getDefaultSharedPreferences(getActivity());
        SharedPreferences.Editor editor = sharedpref.edit();
        String email = sharedpref.getString("email","none");
        String name = sharedpref.getString("name","");
        textViewname.setText(name);
        //Toast.makeText(getActivity(),"accesses",Toast.LENGTH_SHORT).show();
        join = getActivity().getSharedPreferences("codeshare",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor12 = join.edit();
        editor12.putString("code",null);
        editor12.putBoolean("issharing",false);
        editor.commit();
        editor12.commit();


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Your location");
        accessdata();
    }
}
