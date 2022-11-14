package com.iqrastudio.smartzakatsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Forgot_Password extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        final EditText etMobileNumner = findViewById(R.id.etMobileNumber);
        final Button btGenOTP = findViewById(R.id.btGenOtp);
        ImageView imageBackButton = findViewById(R.id.imageBackForget);

        //================================================================

        btGenOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Forgot_Password.this, OTP.class);
                startActivity(intent);

            }
        });

        //================================================================
        imageBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login_User.class));
            }
        });






        //================================================================
    }



}