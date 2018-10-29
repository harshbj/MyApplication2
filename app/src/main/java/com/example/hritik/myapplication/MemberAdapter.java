package com.example.hritik.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MembersViewHolder>{

    ArrayList<CreateUser> namelist;
    Context c;
    MemberAdapter(ArrayList<CreateUser> namelist, Context c){

        this.namelist=namelist;
        this.c=c;

    }


    @Override
    public int getItemCount() {
        return namelist.size();
    }


    @Override
    public MembersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        MembersViewHolder membersViewHolder = new MembersViewHolder(v,c,namelist);

        return membersViewHolder;
    }


    @Override
    public void onBindViewHolder(MembersViewHolder holder, int position) {


        CreateUser currentuserobj = namelist.get(position);
        holder.name_txt.setText(currentuserobj.name);
       // Picasso.get().load(currentuserobj.imageUri).placeholder(R.drawable.profile).into(holder.circleImageView);

    }

    public static class MembersViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView name_txt;
        CircleImageView circleImageView;
        Context c;
        ArrayList<CreateUser> nameArrayList;
        FirebaseAuth auth;
        FirebaseUser user;


        public MembersViewHolder(View itemView, Context c, ArrayList<CreateUser> nameArrayList) {
            super(itemView);

            this.c = c;
            this.nameArrayList = nameArrayList;
            itemView.setOnClickListener(this);
            auth = FirebaseAuth.getInstance();
            user = auth.getCurrentUser();

            name_txt = itemView.findViewById(R.id.item_title);
            circleImageView = itemView.findViewById(R.id.i11);

        }

        @Override
        public void onClick(View v) {


            Toast.makeText(c,"You Clicked This User",Toast.LENGTH_LONG).show();
        }
    }
}
