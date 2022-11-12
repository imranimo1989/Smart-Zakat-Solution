package com.iqrastudio.smartzakatsolution;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login_User extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);


        final EditText etLoginUserMob = findViewById(R.id.etLoginUserMobile);
        final EditText etLoginUserPin = findViewById(R.id.etLoginPin);

        final TextView tvResetPw = findViewById(R.id.tvDontRemberBt);

        final Button btUserLogin = findViewById(R.id.btLogin);
        final Button btUserReg = findViewById(R.id.btReg);


        //String getUserMob = getIntent().getExtras().getString("user_mob");
      //  etLoginUserMob.setText(getUserMob);
        // on below line we are setting our message to our text view.
        etLoginUserMob.setText(getIntent().getStringExtra("user_mob"));



        btUserReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //showRegistrationPopup();



                Intent intent = new Intent(getApplicationContext(), Registration_User.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);

            }
        });
    }

   /* public void showRegistrationPopup() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Login_User.this);

        final View myView = getLayoutInflater().inflate(R.layout.registration_user, null);

        builder.setView(myView);

        AlertDialog dialog = builder.create();
        dialog.show();

    }*/
}