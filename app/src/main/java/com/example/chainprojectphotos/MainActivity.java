package com.example.chainprojectphotos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.wifi.hotspot2.pps.HomeSp;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {
    EditText txtEmail, txtPassword;
    TextView register;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        register = findViewById(R.id.register);
        btnLogin = findViewById(R.id.btnLogin);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivityRegister.class);
                startActivity(intent);
            }
        });
    }

    private boolean checkEmail() {
        String email = txtEmail.getText().toString().trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (!email.matches(emailPattern)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkPassword() {
        String password = txtPassword.getText().toString();

        if (password.length() < 4 ) {
            return false;
        } else {
            return true;
        }
    }

    void bindComponent () {
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);

        btnLogin.setOnClickListener(v -> {

            boolean formOK = true;

            if (!checkEmail()){
                Toast.makeText(MainActivity.this, "Invalid Email!", Toast.LENGTH_SHORT).show();
                formOK = false;
            }

            if (!checkPassword()) {
                Toast.makeText(MainActivity.this, "Password didn't meet requirement", Toast.LENGTH_SHORT).show();
                formOK = false;
            }

            if (formOK) {
                Intent keHome = new Intent(MainActivity.this, Home.class);
                startActivity(keHome);
            }
        });


//    private boolean validateEmail() {
//
//
//        if (emailInput.isEmpty()) {
//            txtEmail.setError("Email must be filled!");
//            return false;
//        } else {
//            txtEmail.setError(null);
//            return true;
//        }
//
//    }
//
//    private boolean validatePassword() {
//
//
//        if (passwordInput.isEmpty()) {
//            txtPassword.setError("Password must be filled!");
//            return false;
//        } else {
//            txtEmail.setError(null);
//            return true;
//        }
//    }


//    public void confirmInput (View v) {
//        if (!validateEmail() | !validatePassword()) {
//            return;
//        }
//        String input = "Email:" + txtEmail.getText().toString();
//        input += "\n";
//        input += "Password:" + txtPassword.getText().toString();
//
//        Toast.makeText(this,input, Toast.LENGTH_SHORT).show();


    }
}
