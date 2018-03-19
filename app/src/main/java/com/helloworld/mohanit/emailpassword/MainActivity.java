package com.helloworld.mohanit.emailpassword;

        import android.app.ProgressDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.text.TextUtils;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button2;
    private EditText email1;
    private EditText editText;
    private TextView text;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;



    private static final String TAG = "EmailPassword";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth=FirebaseAuth.getInstance();
    button2= (Button) findViewById(R.id.button2);
    email1=(EditText) findViewById(R.id.email1);
    editText=(EditText) findViewById(R.id.editText);
    text=(TextView)findViewById(R.id.text);
        button2.setOnClickListener(this);
        text.setOnClickListener(this);
        progressDialog= new ProgressDialog(this);

    }
    private void registeruser() {
        String email=email1.getText().toString().trim();
        String pass=editText.getText().toString().trim();
        if(TextUtils.isEmpty(email)) {
            Toast.makeText(this,"enter the email",Toast.LENGTH_LONG).show();

    }
    if(TextUtils.isEmpty(pass)){
        Toast.makeText(this,"enter the password",Toast.LENGTH_LONG).show();

    }
    progressDialog.setMessage("process is loading....");
    progressDialog.show();
    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this,new OnCompleteListener<AuthResult>()
        {

            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"successfullyregistered",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, secondActivity1.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(MainActivity.this,"registration not successfull",Toast.LENGTH_LONG).show();
                }
            }
        });

}

    @Override
    public void onClick(View view) {
        if(view==button2){
            registeruser();
        }

        if(view==text){
            
        }
    }
}
