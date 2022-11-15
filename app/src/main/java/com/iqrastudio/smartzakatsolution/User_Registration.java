package com.iqrastudio.smartzakatsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class User_Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);


        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final RadioButton rbZakatReceiver = findViewById(R.id.rbZakatApply);
        final RadioButton rbZakatDonate = findViewById(R.id.rbZakatDonate);

        final EditText etUserMobile = findViewById(R.id.etUserPhone);
        final EditText etUserPw = findViewById(R.id.etUserPass);
        final EditText etUserConPw = findViewById(R.id.etUserConPw);

        final Button btRegistration = findViewById(R.id.btReg);


        //to register a user
        btRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //User Validation error check
                //if user not selected radio button
                if (rbZakatReceiver.isChecked() || rbZakatDonate.isChecked()) {

                    if (etUserMobile.getText().toString().isEmpty()) {
                        etUserMobile.setError("Please fill up this filled");

                    } else if (etUserPw.getText().toString().isEmpty()) {
                        etUserPw.setError("Please fill up this filled");

                    } else if (etUserConPw.getText().toString().isEmpty()) {
                        etUserConPw.setError("Please fill up this filled");


                    }

                    //check even below 4 digit pin
                    else if (etUserPw.getText().length() < 4 || etUserConPw.length() < 4) {
                        alertDialog("Required minimum 4 digit PIN");
                    }

                    //check even equal pin
                    else if (!etUserPw.getText().toString().equals(etUserConPw.getText().toString())) {
                        etUserConPw.setError("Password did not match");
                    } else {
                        //declare variable to get form data
                        String userMobile = etUserMobile.getText().toString();
                        String userPin = etUserPw.getText().toString();
                        String userConPin = etUserConPw.getText().toString();

                        //get radio button text from user selection.
                        int userType = radioGroup.getCheckedRadioButtonId();
                        RadioButton userTypeText = findViewById(userType);
                        String rbUserType = userTypeText.getText().toString();


                        String url = "https://blazeincorporation.com/zakat_solution_app/user_data.php?" +
                                "type=" + rbUserType + "&mobile=" + userMobile + "&pw=" + userPin + "&conpw=" + userConPin;


                        // Request a string response from the provided URL.
                        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        // Display the first 500 characters of the response string.


                                        showToast("Your Registration has been successful.");

                                        Intent intent = new Intent(User_Registration.this, Login_User.class);

                                        //to receive value for login activity user id pass
                                        intent.putExtra("user_mob",userMobile);
                                        intent.putExtra("user_pin",userPin);


                                        startActivity(intent);
                                       // overridePendingTransition(R.anim.slide_in_left,R.anim.slide_in_right);




                                       /* new AlertDialog.Builder(Registration_User.this)
                                                .setIcon(R.drawable.ic_error)
                                                .setTitle("ServerResponse")
                                                .setMessage(response)
                                                .show();*/
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                                alertDialog("Server Error, Something Went Wrong");


                            }
                        });

                        // Add the request to the RequestQueue.
                        RequestQueue queue = Volley.newRequestQueue(User_Registration.this);
                        queue.add(stringRequest);

                    }


                } else {
                    alertDialog("Please fill up all field");
                }

            }
        });


        //spinner
       /* final Spinner spinner = findViewById(R.id.spinner);

        // Spinner click listener
      //  spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Why do you register?");
        categories.add("Apply for Zakat");
        categories.add("Donate for Zakat.");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);


        */


    }


    //Create a custom Toast
    private void showToast(String toast) {

        Toast.makeText(getApplicationContext(), "" + toast, Toast.LENGTH_SHORT).show();
    }


    private void alertDialog(String dialog) {
        new AlertDialog.Builder(User_Registration.this)
                .setTitle("Error")
                .setMessage(dialog)
                .show();
    }


}