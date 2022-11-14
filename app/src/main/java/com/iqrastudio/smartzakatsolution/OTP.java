package com.iqrastudio.smartzakatsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class OTP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.otp);

        final LinearLayout otpVerification = findViewById(R.id.otpVerification);
        final ImageView imageBack = findViewById(R.id.imageBackOtp);
        final ProgressBar progressBarOtp = findViewById(R.id.progressBarOtp);

        progressBarOtp.setVisibility(View.GONE);

        //====================================================
        otpVerification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OTP.this, Rest_Password.class);
                startActivity(intent);

            }
        });
        //====================================================
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OTP.this, Forgot_Password.class);
                startActivity(intent);

            }
        });



        //========================================
    }
}