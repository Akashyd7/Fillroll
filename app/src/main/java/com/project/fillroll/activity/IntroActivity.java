package com.project.fillroll.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.project.fillroll.R;

public class IntroActivity extends AppCompatActivity {
Context context;
LinearLayout signUp,login;
TextView filroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        context=IntroActivity.this;
        signUp = findViewById(R.id.signUp);
        login = findViewById(R.id.login);
        filroll = findViewById(R.id.filroll);


        Shader textShader = new LinearGradient(0, 0,1, filroll.getTextSize(),
                new int[]{
                        Color.parseColor("#DB8DFF"),
                        Color.parseColor("#7205FF"),
                }, null, Shader.TileMode.CLAMP);
        filroll.getPaint().setShader(textShader);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SignUpActivity.class);
                startActivity(intent);
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}