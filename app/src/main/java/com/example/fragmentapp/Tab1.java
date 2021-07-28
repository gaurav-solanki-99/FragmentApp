package com.example.fragmentapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.fragmentapp.databinding.Tab1Binding;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  Tab1  extends Fragment
{
    @Nullable

    Tab1Binding binding;
    ArrayList<User> al;
    UserAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
      binding =Tab1Binding.inflate(LayoutInflater.from(getActivity()));



        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=Integer.parseInt(""+binding.etId.getText().toString());


                Call<ResponseBody> call = UserApi.getUserApiInstance().sendId(id);
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                        ProgressDialog pd = new ProgressDialog(getActivity());
                        pd.setMessage("Loading");
                        pd.show();


                        String apiResponse="";
                        if(response.code()==200)
                        {
                          al=new ArrayList<>();


                            System.out.println("Status is >>>>>>>>>"+response.code());

//
                            try {
//                                System.out.println("Json  >>  "+response.body().string());
                                String abc = "Parag          = "+response.body().string();


                                String[] arrOfStr = abc.split("Parag          = ");

                                for (String a : arrOfStr)
                                {
                                    apiResponse=""+a;
                                }


                                JSONObject obj = new JSONObject(apiResponse);

                                System.out.println(obj.toString());

                                 JSONArray arr =  obj.getJSONArray("data");
                                 System.out.println("Array Lenfht "+arr.length());

                                 for(int i=0;i<arr.length();i++)
                                 {
                                     JSONObject obj2 = arr.getJSONObject(i);

                                     JSONObject obj3 = obj2.getJSONObject("userdetails");


                                     String name = obj3.optString("name");
                                     String image=obj3.optString("profile_image");

                                     User user = new User(name,"http://shivakshgroup.com/partylive/"+image);
                                     al.add(user);

                                 }
                                 pd.dismiss();


                                 adapter = new UserAdapter(getContext(),al);
                                binding.rvUser.setLayoutManager(new LinearLayoutManager(getContext()));
                                binding.rvUser.setAdapter(adapter);








//                                JSONObject obj = new JSONObject(response.body().string());
                            } catch (Exception e) {
                                pd.dismiss();
                                e.printStackTrace();
                            }
                        }
                        else
                        {
                            pd.dismiss();
                            System.out.println("Error Status is >>>>>>>>>"+response.code());


                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        System.out.println("Error is >>>>>>>>>"+t.getMessage());

                    }
                });

            }
        });










        return binding.getRoot();






    }
}
