package com.example.nursery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;

import com.android.volley.toolbox.NetworkImageView;
import com.example.nursery.constants.Urls;
import com.example.nursery.network.ImageRequester;
import com.example.nursery.network.account.AccountService;
import com.example.nursery.network.account.dto.LoginDTO;
import com.example.nursery.network.account.dto.LoginResultDTO;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String url = Urls.BASE_URL + "/images/1.jpg";

        imageRequester = ImageRequester.getInstance();
        myImage = findViewById(R.id.myImage);
        imageRequester.setImageFromUrl(myImage, url);
    }

    public void onClickLogin(View view) {
        final TextInputLayout emailLayout = findViewById(R.id.inputLayoutEmail);
        final TextInputLayout passwordLayout = findViewById(R.id.inputLayoutPassword);
        final TextInputEditText email = findViewById(R.id.textFieldEmail);
        final TextInputEditText password = findViewById(R.id.textFieldPassword);

        LoginDTO model = new LoginDTO(
                email.getText().toString(),
                password.getText().toString()
        );

        AccountService.getInstance()
                .getJSONApi()
                .login(model)
                .enqueue(new Callback<LoginResultDTO>() {
                    @Override
                    public void onResponse(Call<LoginResultDTO> call, Response<LoginResultDTO> response) {
                        LoginResultDTO result = response.body();
                        Log.d("Good request", result.getToken());
                    }

                    @Override
                    public void onFailure(Call<LoginResultDTO> call, Throwable t) {

                    }
                });
    }
}