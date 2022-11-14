package com.iqrastudio.smartzakatsolution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Rest_Password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_password);

        final ImageView imageBackResetPin = findViewById(R.id.imageBackResetPin);
        final ProgressBar progressBar = findViewById(R.id.progresResetPin);
        final CardView cardViewResetButton = findViewById(R.id.resetButton);

        progressBar.setVisibility(View.GONE);

        //==============================================================
        imageBackResetPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),OTP.class));
            }
        });
        //==============================================================

        cardViewResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login_User.class));
            }
        });








    }
}