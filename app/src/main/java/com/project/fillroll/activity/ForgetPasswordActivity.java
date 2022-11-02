package com.project.fillroll.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.project.fillroll.R;

public class ForgetPasswordActivity extends AppCompatActivity {
    Context context;
    LinearLayout send_code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        context=ForgetPasswordActivity.this;
        send_code = findViewById(R.id.send_code);
        send_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, GmailOtpActivity.class);
                startActivity(intent);
            }
        });

    }
}