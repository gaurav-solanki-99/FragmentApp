package com.example.fragmentapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class UserApi {

     private static  UserApiInterface userApiInterface;

     public static UserApiInterface getUserApiInstance()
     {
       if(userApiInterface==null)
       {
           Retrofit retrofit = new Retrofit.Builder()
                   .baseUrl(ServerAddress.BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
           userApiInterface=retrofit.create(UserApiInterface.class);


       }



         return userApiInterface;
     }



     public interface UserApiInterface
     {
         @FormUrlEncoded
         @POST("/partylive/api/get_friend_list")
         Call<ResponseBody> sendId(@Field("user_id") int user_id);

     }

}

