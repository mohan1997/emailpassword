package com.helloworld.mohanit.emailpassword;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import android.view.autofill.AutofillValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import  android.content.Intent;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.view.View.AUTOFILL_TYPE_LIST;

public class sign extends AppCompatActivity {
    Button button;
    Spinner spinner;
    EditText editText1;
    EditText editText;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);
        editText1=(EditText)findViewById(R.id.edittextname);
        button=(Button)findViewById(R.id.button3);
        spinner=(Spinner)findViewById(R.id.spinnername);
        editText=(EditText)findViewById(R.id.editText2);
        databaseReference= FirebaseDatabase.getInstance().getReference("Signup");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                     adddatabase();
            }
        });
    }


    private void adddatabase(){
        String name=editText1.getText().toString().trim();
        String list=spinner.getSelectedItem().toString();
        String number=editText.getText().toString().trim();
        if(!TextUtils.isEmpty(name))
        {
              String id=databaseReference.push().getKey();
              Signup signup=new Signup(id,name,list,number);
              databaseReference.child(id).setValue(signup);
              Toast.makeText(this,"successfully stored the data",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(this,"enter the details",Toast.LENGTH_LONG).show();
        }
    }
}

