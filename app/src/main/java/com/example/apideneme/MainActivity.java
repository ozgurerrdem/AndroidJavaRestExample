package com.example.apideneme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import android.widget.Toast;

import com.example.apideneme.API.Controller;
import com.example.apideneme.API.GET.GetResponse;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private String url = "https://menuluximagedb.blob.core.windows.net/imagecontainer/1637777610174041977_595bbcf0-d6ed-4219-b103-cf3c4e2d5501.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Controller controller = new Controller();

        controller.Get(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                System.out.println("BAŞARILI");
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                System.out.println("HATA\n"+t.getMessage());
            }
        });
        /*OkHttpClient client = new OkHttpClient();

        String url = "http://10.0.2.2:5001/api/database";

        Request request = new Request.Builder()
                .url(url)
                .header("Connection", "close")
                /*.header("Accept","application/json")
                .header("Content-Type","application/json")
                .header("Cache-Control","no-cache")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                System.out.println("HATAKE\n"+e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                System.out.println("BAŞARILIKE");
            }
        });*/
        img = findViewById(R.id.image);
        LoadImageFromUrl(url);
    }

    private void LoadImageFromUrl(String url) {
        Picasso.with(this).load(url).into(img, new com.squareup.picasso.Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                Toast.makeText(getApplicationContext(),"Resim yüklenemedi!",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void GetRequest() {


    }

}

