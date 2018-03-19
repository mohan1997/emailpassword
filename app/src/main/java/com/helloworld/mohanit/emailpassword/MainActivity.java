package com.helloworld.mohanit.emailpassword;

        import android.app.ProgressDialog;
        import android.content.Context;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.text.TextUtils;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private Button button2, button5;
    private EditText email1;
    private EditText editText;
    private TextView text;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        button2 = findViewById(R.id.button2);
        email1 = findViewById(R.id.email1);
        editText = findViewById(R.id.editText);
        text = findViewById(R.id.text);
        button5 = findViewById(R.id.button5);
        progressDialog = new ProgressDialog(this);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, sign.class);
                startActivity(i);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                registeruser();
            }
        });
    }

    private void registeruser() {
        final String email = email1.getText().toString().trim();
        final String pass = editText.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "enter the email", Toast.LENGTH_LONG).show();

        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "enter the password", Toast.LENGTH_LONG).show();

        }
        progressDialog.setMessage("process is loading....");
        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

            @Override
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "successfullyregistered", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, nav5.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "registration not successfull", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, sign.class);
                    startActivity(intent);
                }

            }
        });
    }


}




