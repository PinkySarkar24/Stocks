package com.example.stocks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView.OnEditorActionListener;


public class FirstActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Name=(EditText)findViewById(R.id.name);
        Password=(EditText)findViewById(R.id.pass);
        Login=(Button)findViewById(R.id.btnLogin);
        Login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity(Name.getText().toString(), Password.getText().toString());

            }
        });

    }
    private void openMainActivity(String Username, String Password){
        if((Username.equals("Admin")) && (Password.equals("1234"))){
            Intent intent=new Intent(FirstActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
