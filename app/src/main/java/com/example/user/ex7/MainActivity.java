package com.example.user.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int REGISTER_REQUEST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void onRegister(View v)
    {
        Intent i = new Intent(this, Register.class);
        startActivityForResult(i, REGISTER_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String firstName = "";
        String lastName = "";
        String gender = "";


        if (requestCode == REGISTER_REQUEST) {
            if (resultCode == RESULT_OK) {
                firstName = data.getExtras().getString("FirstName");
                lastName = data.getExtras().getString("LastName");
                gender = data.getExtras().getString("Gender");
                String hello= "Hello" + " " +  gender + " " + firstName + " " + lastName;
                Toast.makeText(this, hello, Toast.LENGTH_SHORT).show();
            }
        }
    }

}