package com.example.mojojojo.loginform;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends AppCompatActivity {

    TextView t1;
    EditText e1;
    EditText e2;
    Button b1;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        e1 = (EditText) findViewById(R.id.ed_1);
        e2 = (EditText) findViewById(R.id.ed_2);
        b1 = (Button) findViewById(R.id.bt1);
        b2 = (Button) findViewById(R.id.bt2);
        t1 = (TextView) findViewById(R.id.text);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor shaerdpre = getSharedPreferences("email", MODE_PRIVATE).edit();
                shaerdpre.putString("email", e1.getText().toString());
                shaerdpre.apply();
                // String s1= e1.getText().toString();
                String s2 = e2.getText().toString();
                Intent i1 = new Intent(login.this, mainpage.class);
                startActivity(i1);

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (reglogin()) {
                    Intent i1 = new Intent(login.this, Regestration.class);
                    startActivity(i1);
                }
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2 = new Intent(login.this, forgot_pass.class);
                startActivity(i2);
            }
        });


    }

    private boolean reglogin() {
        if (CommonUtil.isNullString(e1.getText().toString()) || !CommonUtil.checkEmail(e1.getText().toString())) {
            e1.setError("check your email");
        } else if (CommonUtil.isNullString(e2.getText().toString()) || !CommonUtil.checkPassword(e2.getText().toString())) {
            e2.setError("Check your pasword");
        } else {
            return true;
        }
        return false;
    }
}
