package com.example.fragmentapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fragmentapp.databinding.SinglesUserItemBinding;

import java.util.ArrayList;

public class  UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>
{
    Context context;
    ArrayList<User> al;

    public UserAdapter(Context context,ArrayList<User> al)
    {
        this.context =context;
        this.al=al;
    }

    @NonNull

    @Override
    public UserViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        SinglesUserItemBinding binding =SinglesUserItemBinding.inflate(LayoutInflater.from(context),parent,false);

        return new UserViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull  UserAdapter.UserViewHolder holder, int position) {

        User user = al.get(position);

        holder.binding.tvUsername.setText(user.getUserName());
        Glide.with(context).load(user.getUserImage()).into(holder.binding.userImage);



    }

    @Override
    public int getItemCount() {
        return al.size();
    }


    class UserViewHolder extends RecyclerView.ViewHolder
    {
        SinglesUserItemBinding binding;

        public  UserViewHolder(SinglesUserItemBinding binding)
        {
            super(binding.getRoot());
            this.binding=binding;

        }
    }
}
