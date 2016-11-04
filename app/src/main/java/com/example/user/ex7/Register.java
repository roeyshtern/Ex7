package com.example.user.ex7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    RadioGroup radioGroup;
    RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
    public void onSendBack(View v)
    {
        int index = -1;
        radioGroup = (RadioGroup)findViewById(R.id.Rgroup);
        editText1 = (EditText)findViewById(R.id.editFname);
        editText2 = (EditText)findViewById(R.id.editLname);
        String firstName = editText1.getText().toString();
        String lastName = editText2.getText().toString();
        int radioInt = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton)findViewById(radioInt);
        index = radioGroup.indexOfChild(radioButton);
        if(firstName!=null && lastName!=null && index!=-1)
        {
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("FirstName",firstName);
            i.putExtra("LastName", lastName);
            i.putExtra("Gender",radioInt==R.id.Rgroup?"Mr.":"Ms.");
            setResult(RESULT_OK, i);
            finish();
        }
        else
        {
            Toast.makeText(this, R.string.ToastMessage,Toast.LENGTH_SHORT).show();
        }

    }
}
