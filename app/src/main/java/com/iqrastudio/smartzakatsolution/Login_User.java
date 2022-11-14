package com.iqrastudio.smartzakatsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Login_User extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);


        final EditText etLoginUserMob = findViewById(R.id.etLoginUserMobile);
        final EditText etLoginUserPin = findViewById(R.id.etLoginPin);

        final TextView tvResetPw = findViewById(R.id.tvDontRememberBt);

        final Button btUserLogin = findViewById(R.id.btLogin);
        final Button btUserReg = findViewById(R.id.btReg);


        // get Registered User Mobile Number via intent from Registration Activity

        String loginId = getIntent().getStringExtra("user_mob");
        String loginpw = getIntent().getStringExtra("user_pin");

        etLoginUserMob.setText(loginId);


        //===============================================================
            tvResetPw.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Login_User.this, Forgot_Password.class);
                    startActivity(intent);

                }
            });

        //===============================================================

        btUserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etLoginUserMob.getText().toString().isEmpty()||etLoginUserPin.getText().toString().isEmpty()){

                        new AlertDialog.Builder(Login_User.this)
                                .setTitle("Login Error!")
                                .setMessage("Sorry! You missed something!")
                                .setIcon(R.drawable.ic_error)
                                .show();

                }


               else if (etLoginUserMob.getText().toString().equals(loginId)&&etLoginUserPin.getText().toString().equals(loginpw))

                {
                    Intent intent = new Intent(Login_User.this, ProfileUserDashboard.class);
                    startActivity(intent);

                }else {
                    new AlertDialog.Builder(Login_User.this)
                            .setTitle("Login Error!")
                            .setMessage("Sorry! Your Input Mobile no. or Pin Wrong")
                            .setIcon(R.drawable.ic_error)
                            .show();
                }

            }
        });



        //================================================================

        btUserReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //showRegistrationPopup();



                Intent intent = new Intent(getApplicationContext(), Registration_User.class);
                startActivity(intent);
                //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);

            }
        });

        //===================================================================

        String url ="";


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(Login_User.this);
        requestQueue.add(stringRequest);





    }
    //======================================================================

   /* public void showRegistrationPopup() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Login_User.this);

        final View myView = getLayoutInflater().inflate(R.layout.registration_user, null);

        builder.setView(myView);

        AlertDialog dialog = builder.create();
        dialog.show();

    }*/
}