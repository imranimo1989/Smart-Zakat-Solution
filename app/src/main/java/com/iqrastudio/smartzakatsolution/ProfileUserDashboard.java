package com.iqrastudio.smartzakatsolution;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class ProfileUserDashboard extends AppCompatActivity {

    CardView cardViewZakatApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_dashboard);

        cardViewZakatApplication = findViewById(R.id.cardViewZakatApplication);

        cardViewZakatApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Zakat Registration Form
                startActivity(new Intent(getApplicationContext(), UserZakatApplication.class));
                overridePendingTransition(0, 0);

            }
        });



    }
}