package com.example.nursery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.NetworkImageView;
import com.example.nursery.network.ImageRequester;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = "http://10.0.2.2:5000/images/1.jpg";

        imageRequester = ImageRequester.getInstance();
        myImage = findViewById(R.id.myImage);
        imageRequester.setImageFromUrl(myImage, url);
    }

    public void onChange(View view) {
        final TextInputEditText email = findViewById(R.id.textFieldEmail);
        Log.d("change email", email.getText().toString());

    }

    public void onClickLogin(View view) {
        final TextInputLayout emailLayout = findViewById(R.id.inputLayoutEmail);
        final TextInputLayout passwordLayout = findViewById(R.id.inputLayoutPassword);
        final TextInputEditText email = findViewById(R.id.textFieldEmail);
        final TextInputEditText password = findViewById(R.id.textFieldPassword);
        final Button button = findViewById(R.id.buttonSave);
        if (email.getText().toString().contains("@") && password.getText() != null) {
            button.setText("Good !");
        }
        else {
            emailLayout.setError("We have error !");
            passwordLayout.setError("We have error !");
        }

//        Log.d("clickLogin", email.getText().toString().contains("@"));
    }
}