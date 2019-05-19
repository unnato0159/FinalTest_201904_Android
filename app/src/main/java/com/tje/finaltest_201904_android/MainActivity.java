package com.tje.finaltest_201904_android;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.tje.finaltest_201904_android.ServerUtil.ContextUtil;
import com.tje.finaltest_201904_android.ServerUtil.ServerUtil;

import com.tje.finaltest_201904_android.databinding.ActivityMainBinding;


import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends BaseActivity {

    ActivityMainBinding act;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {

        act.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputId = act.idEdt.getText().toString();
                String inputPw = act.pwEdt.getText().toString();


                ServerUtil.postRequestSignIn(mContext, inputId, inputPw, new ServerUtil.JsonResponseHandler() {
                    @Override
                    public void onResponse(JSONObject json) {

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    int code = json.getInt("code");

                                    if (code == 200) {
                                        JSONObject data = json.getJSONObject("data");
                                        String token = data.getString("token");

//                                SharedPreference에 token을 저장

                                        ContextUtil.setUserToken(mContext, token);

                                        Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                                        startActivity(intent);





                                    }
                                    else {
                                        Toast.makeText(mContext, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show();
                                    }


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });



                    }
                });

            }
        });

    }

    @Override
    public void setValues() {

    }

    @Override
    public void bindViews() {

        act = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }
}