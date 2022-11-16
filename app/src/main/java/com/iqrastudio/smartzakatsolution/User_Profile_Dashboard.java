package com.iqrastudio.smartzakatsolution;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

public class User_Profile_Dashboard extends AppCompatActivity {

    CardView cardViewZakatApplication;

    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile_dashboard);




        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_lay);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();






        cardViewZakatApplication = findViewById(R.id.cardViewZakatApplication);

        cardViewZakatApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Zakat Registration Form
                startActivity(new Intent(getApplicationContext(), User_Zakat_Application_Form.class));
                overridePendingTransition(0, 0);

            }
        });



    }
}