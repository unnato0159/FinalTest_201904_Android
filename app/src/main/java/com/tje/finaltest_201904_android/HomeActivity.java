package com.tje.finaltest_201904_android;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.tje.finaltest_201904_android.ServerUtil.adapters.MainViewPagerAdapter;
import com.tje.finaltest_201904_android.databinding.ActivityHomeBinding;

public class HomeActivity extends BaseActivity {

    ActivityHomeBinding act;
    MainViewPagerAdapter mvpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        act.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(act.tabLayout));


        act.tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(act.viewPager));



        /*act.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                act.viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });*/

    }

    @Override
    public void setValues() {
        act.tabLayout.addTab(act.tabLayout.newTab().setText("상세정보"));
        act.tabLayout.addTab(act.tabLayout.newTab().setText("공지사항목록"));

        mvpa = new MainViewPagerAdapter(getSupportFragmentManager(),2);
        act.viewPager.setAdapter(mvpa);


    }



    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this,R.layout.activity_home);

    }
}
