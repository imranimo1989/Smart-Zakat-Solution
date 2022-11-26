package com.iqrastudio.smartzakatsolution;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class User_Zakat_Application_Form extends AppCompatActivity {

    EditText editTextName, editTextNameEnglish, editTextFaterName, editTextMotherName,
            editTextIdCardNo, editTextMobile, editTextPresentAddress, editTextCountry,
            editTextDistrict, editTextDivision, editTextThana, editTextVillage, editTextWard,
            editTextSpouse, editTextSpouseMobile, editTextFamilyMember,
            editTextEducation, editTextOccupation, editTextAge, editTextland, editTextSelfDes;


    RadioGroup radioGroupGender, radioGroupMaritalStatus, radioGroupOwnHouse, radioGroupPrvZakHis;


    private static final int CAMERA_REQUEST = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;


    ImageView imgZakatReceiver;

    ProgressBar progressBarSubmit;


    RadioButton radioButtonMarried, radioButtonUnMarried, radioButtonMar, radioButtonUnMar, radioButtonOwnPropertyYes, radioButtonOwnPropertyNo, radioButtonZakatHistoryYes, radioButtonZakatHistoryNo;
    LinearLayout layMaritalStatus, laySubmitApplication;
    Button btPicUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_zakat_application_form);


        //editText
        editTextName = findViewById(R.id.etName);
        editTextNameEnglish = findViewById(R.id.etNameEng);
        editTextFaterName = findViewById(R.id.etNameFather);
        editTextMotherName = findViewById(R.id.etNameMother);
        editTextMobile = findViewById(R.id.etUserMobile);
        editTextIdCardNo = findViewById(R.id.etIdNo);
        editTextPresentAddress = findViewById(R.id.etAddresPresent);
        editTextCountry = findViewById(R.id.etAddressCountry);
        editTextDistrict = findViewById(R.id.etAddressDistrict);
        editTextDivision = findViewById(R.id.etAddressDivision);
        editTextThana = findViewById(R.id.etAddressThana);
        editTextVillage = findViewById(R.id.etAddressVillage);
        editTextWard = findViewById(R.id.etAddressWard);

        editTextSpouse = findViewById(R.id.etSpouseName);
        editTextSpouseMobile = findViewById(R.id.etSpouseMobile);
        editTextFamilyMember = findViewById(R.id.etFamilyMember);


        editTextEducation = findViewById(R.id.etEduQualification);
        editTextOccupation = findViewById(R.id.etProfession);
        editTextAge = findViewById(R.id.etAge);
        editTextland = findViewById(R.id.etOwnProperty);
        editTextSelfDes = findViewById(R.id.etOwnStory);


        laySubmitApplication = findViewById(R.id.layoutSubmitApplication);
        progressBarSubmit = findViewById(R.id.progresSubmit);
        btPicUpload = findViewById(R.id.btPicUpload);


        //radioGroun and Radio Button
        radioGroupMaritalStatus = findViewById(R.id.radioGroupMaritalStatus);
        radioButtonMarried = findViewById(R.id.rbMarried);
        radioButtonUnMarried = findViewById(R.id.rbUnmarried);

        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupOwnHouse = findViewById(R.id.radioGroupOwnHouse);
        radioGroupPrvZakHis = findViewById(R.id.radioGroupPrvZakHis);


        imgZakatReceiver = findViewById(R.id.imgZakatReceiver);
        layMaritalStatus = findViewById(R.id.layMaritalStatus);


        progressBarSubmit.setVisibility(View.GONE);

        //Marital status interactivity..............
        radioButtonMarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layMaritalStatus.setVisibility(View.VISIBLE);
            }
        });

        radioButtonUnMarried.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layMaritalStatus.setVisibility(View.GONE);
            }
        });
        //=======================================


//Picture upload

        btPicUpload.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                } else {
                    Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(cameraIntent, CAMERA_REQUEST);
                }


            }
        });
        //end button upload=======================================


        //Registration Process
        laySubmitApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nameBan = editTextName.getText().toString();
                String nameEng = editTextNameEnglish.getText().toString();
                String fatherName = editTextFaterName.getText().toString();
                String motherName = editTextMotherName.getText().toString();
                String mobile = editTextMobile.getText().toString();
                String nidNo = editTextIdCardNo.getText().toString();

                String presentAddress = editTextPresentAddress.getText().toString();
                String country = editTextCountry.getText().toString();
                String division = editTextDivision.getText().toString();
                String district = editTextDistrict.getText().toString();
                String thana = editTextThana.getText().toString();
                String village = editTextVillage.getText().toString();
                String ward = editTextWard.getText().toString();

                String spouse = editTextSpouse.getText().toString();
                String spouseMobile = editTextSpouseMobile.getText().toString();
                String familyMember = editTextFamilyMember.getText().toString();

                String education = editTextEducation.getText().toString();
                String occupation = editTextOccupation.getText().toString();
                String age = editTextAge.getText().toString();
                String land = editTextland.getText().toString();
                String selfDes = editTextSelfDes.getText().toString();


                //Check empty editText input data validation
                if (nameBan.isEmpty() || nameEng.isEmpty() || fatherName.isEmpty() || motherName.isEmpty() ||
                        mobile.isEmpty() || nidNo.isEmpty() || presentAddress.isEmpty() || country.isEmpty() || division.isEmpty() ||
                        district.isEmpty() || thana.isEmpty() || village.isEmpty() || ward.isEmpty() || education.isEmpty()
                        || occupation.isEmpty() || age.isEmpty() || land.isEmpty() || selfDes.isEmpty()
                        || radioGroupGender.getCheckedRadioButtonId() == -1 || radioGroupMaritalStatus.getCheckedRadioButtonId() == -1
                        || radioGroupOwnHouse.getCheckedRadioButtonId() == -1 || radioGroupPrvZakHis.getCheckedRadioButtonId() == -1
                ){
                    if (layMaritalStatus.getVisibility() == View.VISIBLE){

                    }

                    new AlertDialog.Builder(User_Zakat_Application_Form.this)
                            .setTitle("Registration Error!")
                            .setMessage("Sorry! Please fill up all fields!")
                            .setIcon(R.drawable.ic_error)
                            .show();

                } else {

                    //checking Marital Status
                    if ( {

                        if (spouse.isEmpty() || spouseMobile.isEmpty() || familyMember.isEmpty()) {

                            new AlertDialog.Builder(User_Zakat_Application_Form.this)
                                    .setTitle("Registration Error!")
                                    .setMessage("Sorry! Please fill up all fields!")
                                    .setIcon(R.drawable.ic_error)
                                    .show();
                        } else {


                            progressBarSubmit.setVisibility(View.VISIBLE);

                            // String url = "http://blazeincorporation.com/zakat_solution_app/zakat-registration.php?name=" + nameBan + "&name_eng=" + nameEng + "&father_name=" + fatherName + "&mother_name=" + motherName + "&mobile_no=" + mobile + "&nid_no=" + nidNo;
                            String url2 = "https://blazeincorporation.com/zakat_solution_app/zakat-application.php?name="
                                    + nameBan + "&name_eng=" + nameEng + "&father_name=" + fatherName + "&mother_name=" + motherName + "&mobile_no=" + mobile + "&nid_no=" + nidNo
                                    + "&full_add=" + presentAddress + "&country=" + country + "&division=" + division + "&district=" + district + "&thana=" + thana + "&village=" + village + "&ward=" + ward
                                    + "&spouse=" + spouse + "&spouse_mob=" + spouseMobile + "&family_mem=" + familyMember
                                    + "&education=" + education + "&occupation=" + occupation + "&age=" + age + "&land=" + land + "&own_description=" + selfDes;

                            // Request a string response from the provided URL.
                            StringRequest stringRequest = new StringRequest(Request.Method.GET, url2,
                                    new Response.Listener<String>() {
                                        @Override
                                        public void onResponse(String response) {
                                            // Display the first 500 characters of the response string.
                                            progressBarSubmit.setVisibility(View.GONE);

                                            new AlertDialog.Builder(User_Zakat_Application_Form.this)
                                                    .setTitle("Registration Success!")
                                                    .setMessage("Congratulations!, Your application has been summited")
                                                    .setIcon(R.drawable.ic_check_circle)
                                                    .show();

                                        }
                                    }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    progressBarSubmit.setVisibility(View.GONE);
                                    Toast.makeText(User_Zakat_Application_Form.this, "Your Submission Error", Toast.LENGTH_SHORT).show();
                                }
                            });

                            // Add the request to the RequestQueue.
                            RequestQueue queue = Volley.newRequestQueue(User_Zakat_Application_Form.this);
                            queue.add(stringRequest);

                        }   //===============end else statement=========


                    } //===============end if statement=========


                }//end if statement===================================


            }
        });
        //end button reg=======================================


    }
    //============================================End OnCreate Bundle================================


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    //=======================================
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgZakatReceiver.setImageBitmap(photo);
            imgZakatReceiver.setVisibility(View.VISIBLE);
        }
    }
//=======================================


}



