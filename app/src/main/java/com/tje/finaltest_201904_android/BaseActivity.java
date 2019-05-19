package com.tje.finaltest_201904_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext = this;


    public abstract  void setupEvents();
    public abstract  void setValues();
    public abstract  void bindViews();

}
