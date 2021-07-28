package com.example.fragmentapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.fragmentapp.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    FragmentManager manager;
    MyPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(LayoutInflater.from(this));

        setContentView(binding.getRoot());

        getSupportActionBar().hide();

//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tab1"));
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tab2"));
//        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Tab3"));
//
//        manager=getSupportFragmentManager();
//        FragmentTransaction transaction =manager.beginTransaction();
//        transaction.replace(R.id.ll,new Tab1());
//        transaction.commit();
//        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//                String tabSelected = tab.getText().toString();
//                FragmentTransaction transaction1 = manager.beginTransaction();
//                if(tabSelected.equalsIgnoreCase("Tab1"))
//                {
//                  transaction1.replace(R.id.ll,new Tab1());
//                }
//                else if(tabSelected.equalsIgnoreCase("Tab2"))
//                {
//                    transaction1.replace(R.id.ll,new Tab1());
//
//                }
//                else if(tabSelected.equalsIgnoreCase("Tab3"))
//                {
//                    transaction1.replace(R.id.ll,new Tab1());
//
//                }
//
//                transaction1.commit();
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });


        adapter=new MyPagerAdapter(getSupportFragmentManager());
       binding.pager1.setAdapter(adapter);
       binding.tabLayout.setupWithViewPager(binding.pager1);





    }

    class  MyPagerAdapter extends FragmentPagerAdapter
    {


        public MyPagerAdapter(@NonNull FragmentManager manager) {
            super(manager);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            if(position==0)
            {
              fragment=new Tab1();
            }
            else if(position==1)
            {
              fragment=new Tab2();
            }else if(position==2)
            {
             fragment=new Tab3();
            }

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Nullable

        @Override
        public CharSequence getPageTitle(int position) {
            String tabtile="";

            if(position==0)
            {
                tabtile="Tab1";
            }
            else if(position==1)
            {
               tabtile="Tab2";
            }else if(position==2)
            {
               tabtile="Tab3";
            }

            return tabtile;

        }
    }
}