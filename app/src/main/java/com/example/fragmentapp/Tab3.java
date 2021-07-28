package com.example.fragmentapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentapp.databinding.Tab3Binding;

public class Tab3 extends Fragment
{
    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        Tab3Binding binding =Tab3Binding.inflate(LayoutInflater.from(getActivity()));


        return binding.getRoot();


    }
}
