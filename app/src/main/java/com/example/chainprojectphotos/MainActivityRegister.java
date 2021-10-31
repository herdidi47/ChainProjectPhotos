package com.example.chainprojectphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivityRegister  extends AppCompatActivity {

    EditText txtName, txtEmail, txtPassword, txtAddress, txtPhone;
    RadioGroup rg_gender;
    RadioButton rb_male, rb_female;
    CheckBox cb_terms;
    Button btn_regist;
    TextView txtDatepicker;
    DatePickerDialog.OnDateSetListener setListener;
    DatePickerDialog datePickerDialog;


    Calendar calendar = Calendar.getInstance();
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH);
    final int day = calendar.get(Calendar.DAY_OF_MONTH);

    private boolean validateName() {
        String name = txtName.getText().toString().trim();

        if (name.length() < 4 || name.length() > 15) {
            return false;
        } else {
            return true;
        }

    }
    private boolean validateEmail() {
        String email = txtEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (!email.matches(emailPattern)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validatePassword() {
        String password = txtPassword.getText().toString();

        if (password.length() < 8 ) {
            return false;
        } else {
            return true;
        }
    }

    private boolean validateGender() {
        if (rg_gender.getCheckedRadioButtonId()== -1) {
            Toast.makeText(MainActivityRegister.this, "Gender must be chosen", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            return true;
        }
    }


    private boolean validateAddress() {
        String address = txtAddress.getText().toString();

        if (address.length() < 8) {
            Toast.makeText(MainActivityRegister.this, "Address must be longer than 8 characters",
                    Toast.LENGTH_SHORT).show();
            return false;

        }
        if (!address.toString().endsWith("street")) {
            Toast.makeText(MainActivityRegister.this, "Address must ends with street",
                    Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge(){
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePickerDialog.getDatePicker().getYear();
        int ageValid =  currentYear - userAge;

        if (ageValid<18){
            return false;
        }
        else
            return true;
    }

    private boolean validateCheckbox() {
        if (cb_terms.isChecked()) {
            Toast.makeText(MainActivityRegister.this, "You must be agree to terms and condition!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }

    }



        void bindComponent () {
            txtName = findViewById(R.id.txtName);
            txtEmail = findViewById(R.id.txtEmail);
            txtPassword = findViewById(R.id.txtPassword);
            txtAddress = findViewById(R.id.txtAddress);
            txtPhone = findViewById(R.id.txtPhone);
            rg_gender = findViewById(R.id.rg_gender);
            rb_male = findViewById(R.id.rb_male);
            rb_female = findViewById(R.id.rb_female);
            cb_terms = findViewById(R.id.cb_terms);
            btn_regist = findViewById(R.id.btn_regist);
            txtDatepicker = findViewById(R.id.txtDatepicker);
            btn_regist = findViewById(R.id.btn_regist);

            txtDatepicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(
                            MainActivityRegister.this, android.R.style.Theme_Holo_Dialog_MinWidth,
                            setListener, year, month, day);
                    datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    datePickerDialog.show();

                }
            });
            setListener = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    month = month + 1;
                    String date = day + "/" + month + "/" + year;
                    txtDatepicker.setText(date);
                }
            };


        btn_regist.setOnClickListener(v -> {

            if (validateName() == false) {
                Toast.makeText(MainActivityRegister.this, "Name must be longer than 4 character", Toast.LENGTH_SHORT).show();
            } else {
                    Toast.makeText(MainActivityRegister.this, "Register Success", Toast.LENGTH_SHORT).show();
            }

            if (validateEmail()){
                Toast.makeText(MainActivityRegister.this, "Invalid Email!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityRegister.this, "Register Success", Toast.LENGTH_SHORT).show();
            }
            if (validatePassword()) {
                Toast.makeText(MainActivityRegister.this, "Register Succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityRegister.this, "Register Failed", Toast.LENGTH_SHORT).show();
            }

            if (validateGender()) {
                Toast.makeText(MainActivityRegister.this, "Register Succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityRegister.this, "Register Failed", Toast.LENGTH_SHORT).show();
            }

            if (validateAddress()) {
                Toast.makeText(MainActivityRegister.this, "Register Succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityRegister.this, "Register Failed", Toast.LENGTH_SHORT).show();
            }
            if (validateAge()) {
                Toast.makeText(MainActivityRegister.this, "You must be older than 17 years old", Toast.LENGTH_SHORT).show();
            }
            if (validateCheckbox()) {
                Toast.makeText(MainActivityRegister.this, "Register Succes", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivityRegister.this, "Register Failed", Toast.LENGTH_SHORT).show();
            }

        });
    }


            @Override
            protected void onCreate (Bundle savedInstanceState){
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main_register);
                bindComponent();

//                btn_regist.setOnClickListener(v -> {
//                    String email = txtEmail.getText().toString();
//                    String password = txtPassword.getText().toString();
//
//
//                    if (email.equals("test@gmail.com") && password.equals("abcde123")) {
//                        Intent keHome = new Intent(MainActivityRegister.this, Home.class);
//                        keHome.putExtra("Email", email);
//                        keHome.putExtra("Password", password);
//                        startActivity(keHome);
//
//                    }
//                });
//
            }


        }

