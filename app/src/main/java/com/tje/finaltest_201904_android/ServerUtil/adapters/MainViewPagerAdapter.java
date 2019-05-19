package com.tje.finaltest_201904_android.ServerUtil.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.tje.finaltest_201904_android.ServerUtil.fragments.DetailViewFragment;
import com.tje.finaltest_201904_android.ServerUtil.fragments.NoticeFragment;

public class MainViewPagerAdapter  extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public MainViewPagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        mNumOfTabs= numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fr = null ;

        if (position == 0) {
            fr = new DetailViewFragment();
        }
        else if (position == 1) {
            fr = new NoticeFragment();
        }


        return fr;


    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
