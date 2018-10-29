package com.example.hritik.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.goodiebag.pinview.Pinview;

/**
 * Created by Mandy on 10/17/2018.
 */

public class joincircle extends Fragment {

    SharedPreferences join;
    private Pinview pinview;
    String enter_code = null;
    private Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.joincircle,container,false);
        pinview = view.findViewById(R.id.pinview);
        btn = view.findViewById(R.id.button9);


        pinview.setPinViewEventListener(new Pinview.PinViewEventListener() {
            @Override
            public void onDataEntered(Pinview pinview, boolean b) {
                enter_code = pinview.getValue();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),MapsActivity.class);

                if(enter_code == null)
                {
                    Toast.makeText(getActivity(), "Cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    join = getActivity().getSharedPreferences("codeshare",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = join.edit();
                    editor.putString("code",enter_code);
                    editor.putBoolean("issharing",true);
                    editor.commit();
                    startActivity(i);
                }
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Join circle");
    }
}
