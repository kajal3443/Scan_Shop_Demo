package com.example.mojojojo.loginform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Regestration extends AppCompatActivity {


    EditText e1;
    EditText p1;
    EditText p2;
    EditText e5;
    EditText e6;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration);
        getSupportActionBar().hide();
        e1 = (EditText) findViewById(R.id.firstname);
        p1 = (EditText) findViewById(R.id.password);
        p2 = (EditText) findViewById(R.id.chanpassword);
        e5 = (EditText) findViewById(R.id.email);
        e6 = (EditText) findViewById(R.id.phonenum);
        b1 = (Button) findViewById(R.id.okbtn);
        t1 = (TextView) findViewById(R.id.textview2);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(Regestration.this, login.class);
                startActivity(i1);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (regvalidtion()) {
                    Intent i2 = new Intent(Regestration.this, navigation.class);
                    startActivity(i2);
                }
            }
        });
    }


    private boolean regvalidtion() {
        if (CommonUtil.isNullString(e1.getText().toString())   ) {
            e1.setError("check your first name");
        }else if (CommonUtil.isNullString(e5.getText().toString()) || !CommonUtil.checkEmail(e5.getText().toString())) {
            e5.setError("Check your Email");
        } else if (CommonUtil.isNullString(p1.getText().toString()) || !CommonUtil.checkPassword(p1.getText().toString())) {
            p1.setError("Check your password");
        } else if (CommonUtil.isNullString(p2.getText().toString()) || !CommonUtil.checkPassword(p2.getText().toString())) {
            p2.setError("Check your confiram password");
        } else if (!(p1.getText().toString().equals(p2.getText().toString()))){
            p1.setError("Mismatch password");
        } else if (e6.length() < 10 || e6.length()> 10) {
            e6.setError("Check your Phone number");
        } else {
            return true;
        }
        return false;
    }

}
