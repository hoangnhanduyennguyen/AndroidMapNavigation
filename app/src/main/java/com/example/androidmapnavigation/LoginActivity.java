package com.example.androidmapnavigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    //initialize the 2 editTexts
    private void initialize(){
         editTextEmail = findViewById(R.id.editTextEmail);
         editTextPassword = findViewById(R.id.editTextPassword);
    }

    // static method cannot be overridden
    // return whether a string, string buffer, etc is empty
    public static boolean isEmpty(CharSequence target){
        return TextUtils.isEmpty((target));
    }

    // return whether an email is valid
    public static boolean isValidEmail(CharSequence target) {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    // onClick method of the button Login
    public void login(View view){
        String email = editTextEmail.getText().toString();
        String pwd = editTextPassword.getText().toString();

        //Validate edit texts
        if (isEmpty(email)){
            Toast.makeText(this,"Please enter your email !!!",Toast.LENGTH_SHORT).show();
            editTextEmail.requestFocus();
        }else if (isEmpty(pwd)){
            Toast.makeText(this,"Please enter your password !!!",Toast.LENGTH_LONG).show();
            editTextPassword.requestFocus();
        }else if (!isValidEmail(email)){
            Toast.makeText(this,"Please enter a valid email address !!!",Toast.LENGTH_SHORT).show();
            editTextEmail.requestFocus();
        }
        else{
            // "It can be used with startActivity to launch an Activity, broadcastIntent to send it
            // to any interested BroadcastReceiver components, and Context.startService(Intent) or
            // Context.bindService(Intent, ServiceConnection, int) to communicate with a background Service."
            Intent intent = new Intent(this, WelcomeActivity.class);
            //send data from this activity to another one
            intent.putExtra("email",email);
            startActivity(intent);
        }
    }
}