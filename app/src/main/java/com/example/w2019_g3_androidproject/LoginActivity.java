package com.example.w2019_g3_androidproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.PatternMatcher;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.w2019_g3_androidproject.Models.Customer;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private TextView txtMsg;

    private Customer customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        customer = new Customer();

        edtUserEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        txtMsg = findViewById(R.id.lblMessage);

        btnLogin = findViewById(R.id.btnSignIn);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtUserEmail.getText().toString();
                String pwd = edtPassword.getText().toString();

                //Check for empty and show error message

                if (email.trim().length() == 0 || TextUtils.isEmpty(email)) {
                    edtUserEmail.setError("Enter Email Id of user");
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    edtUserEmail.setError("Enter Valid Email Id");
                    return;
                }

                if (email.equals("admin@123.com") && pwd.equals("123")) {
                    txtMsg.setText("Login Success");
                    txtMsg.setTextColor(Color.GREEN);

                    customer.set_custName("Arthur");
                    customer.set_email("admin@123.com");
                    customer._shoppingCart = new ArrayList<>();



                    //Navigate to NEXT Activity
                    Intent mIntent = new Intent(LoginActivity.this, MainActivity.class);
                    //Set value to pass on next activity

                    mIntent.putExtra("customer", customer);
                    startActivity(mIntent);

                } else {
                    txtMsg.setText("Email/Password invalid");
                    txtMsg.setTextColor(Color.RED);
                }

                //Toast.makeText(LoginActivity.this, email, Toast.LENGTH_SHORT).show();
            }
        });

    }

}

/*
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}
*/