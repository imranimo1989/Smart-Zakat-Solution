package com.iqrastudio.smartzakatsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Login_User extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);


        final EditText etLoginUserMob = findViewById(R.id.etLoginUserMobile);
        final EditText etLoginUserPin = findViewById(R.id.etLoginPin);

        final TextView tvResetPw = findViewById(R.id.tvDontRememberBt);

        LinearLayout layoutLoginButton = findViewById(R.id.layoutLogin);
        LinearLayout layoutRegButton = findViewById(R.id.layoutReg);

        ProgressBar progressBarLogin = findViewById(R.id.progresLogin);
        ProgressBar progressBarReg = findViewById(R.id.progresReg);

        progressBarLogin.setVisibility(View.GONE);
        progressBarReg.setVisibility(View.GONE);


        // get Registered User Mobile Number via intent from Registration Activity

        String loginMob = getIntent().getStringExtra("user_mob");
        etLoginUserMob.setText(loginMob);

        RequestQueue requestQueue = Volley.newRequestQueue(Login_User.this);


        //===============================================================

        //===============================================================
        tvResetPw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_User.this, Forgot_Password.class);
                startActivity(intent);

            }
        });


        //===============================================================

        layoutLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(Login_User.this, User_Profile_Dashboard.class);
                startActivity(intent);



             /*   //First Check Blank input check
                if (etLoginUserMob.getText().toString().isEmpty() || etLoginUserPin.getText().toString().isEmpty()) {

                    new AlertDialog.Builder(Login_User.this)
                            .setTitle("Login Error!")
                            .setMessage("Sorry! You missed something!")
                            .setIcon(R.drawable.ic_error)
                            .show();
                }else {



                    progressBarLogin.setVisibility(View.VISIBLE);
                    String queryLoginNum = "https://blazeincorporation.com/zakat_solution_app/query_user_mobile.php?user_mob=" + etLoginUserMob.getText().toString() + "user_pw" + etLoginUserPin.getText().toString();
*/
/*
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, queryLoginNum, null, new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {

                            progressBarLogin.setVisibility(View.GONE);

                            for (int i =0; 0<response.length();i++)

                            JSONObject jsonObject = new JSONObject(response);

                            String loginId = jsonObject.getString("user_mobile");
                            String loginPin = jsonObject.getString("user_pw");

                            Toast.makeText(Login_User.this, ""+response, Toast.LENGTH_SHORT).show();


                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {


                            Toast.makeText(getApplicationContext(),"Server Response Error",Toast.LENGTH_SHORT).show();

                        }
                    });*/


                /*
                    StringRequest stringRequest = new StringRequest(Request.Method.GET, queryLoginNum, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            progressBarLogin.setVisibility(View.GONE);
                            Log.d("ServerRes", response);

                            try {

                                JSONObject jsonObject = new JSONObject(response);

                                String loginId = jsonObject.getString("user_mobile");
                                String loginPin = jsonObject.getString("user_pw");

                                Toast.makeText(Login_User.this, ""+response, Toast.LENGTH_SHORT).show();




                                if (etLoginUserMob.getText().toString().equals(loginId) & etLoginUserPin.getText().toString().equals(loginPin)) {


                                    Intent intent = new Intent(Login_User.this, User_Profile_Dashboard.class);
                                    startActivity(intent);

                                } else {

                                    new AlertDialog.Builder(Login_User.this)
                                            .setTitle("Login Error!")
                                            .setMessage("Sorry! Your Mobile number or Pin Code Wrong")
                                            .setIcon(R.drawable.ic_error)
                                            .show();
                                }



                            } catch(JSONException e){
                                e.printStackTrace();
                            }





                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(getApplicationContext(),"Server Response Error",Toast.LENGTH_SHORT).show();

                        }
                    });*/
                 //   requestQueue.add(jsonArrayRequest);










                /*}

                }
        });
        //===============================================================

*/


















      /*  layoutLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                //First Check Blank input check
                if (etLoginUserMob.getText().toString().isEmpty() || etLoginUserPin.getText().toString().isEmpty()) {

                    new AlertDialog.Builder(Login_User.this)
                            .setTitle("Login Error!")
                            .setMessage("Sorry! You missed something!")
                            .setIcon(R.drawable.ic_error)
                            .show();

                } else {


                    progressBarLogin.setVisibility(View.VISIBLE);
                    String queryLoginNum = "https://blazeincorporation.com/zakat_solution_app/query_user_mobile.php?user_mob=" + etLoginUserMob.getText().toString() + "user_pw" + etLoginUserPin.getText().toString();

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, queryLoginNum, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {


                            try {

                                JSONObject jsonObject = new JSONObject(response);

                                String loginId = jsonObject.getString("user_mobile");
                                String loginPin = jsonObject.getString("user_pw");


                                if (etLoginUserMob.getText().toString().equals(loginId) & etLoginUserPin.getText().toString().equals(loginPin)) {


                                    Intent intent = new Intent(Login_User.this, User_Profile_Dashboard.class);
                                    startActivity(intent);

                                } else {

                                    new AlertDialog.Builder(Login_User.this)
                                            .setTitle("Login Error!")
                                            .setMessage("Sorry! Your Mobile number or Pin Code Wrong")
                                            .setIcon(R.drawable.ic_error)
                                            .show();
                                }



                    } catch(JSONException e){
                        e.printStackTrace();
                    }


                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(stringRequest);




    }
*/

        //================================================================

/*
     layoutRegButton.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){

        //showRegistrationPopup();


        Intent intent = new Intent(getApplicationContext(), User_Registration.class);
        startActivity(intent);
        //overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);
*/
    }
    });


        //===================================================================


//======================================================================

   /* public void showRegistrationPopup() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Login_User.this);

        final View myView = getLayoutInflater().inflate(R.layout.registration_user, null);

        builder.setView(myView);

        AlertDialog dialog = builder.create();
        dialog.show();

    }*/

    }
}


