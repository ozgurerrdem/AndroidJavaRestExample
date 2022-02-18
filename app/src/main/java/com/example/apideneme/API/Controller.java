package com.example.apideneme.API;

import com.example.apideneme.API.GET.Get;
import com.example.apideneme.API.GET.GetResponse;
import com.example.apideneme.API.POST.Post;
import com.example.apideneme.API.POST.PostRequest;
import com.example.apideneme.API.POST.PostResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {
    private final String BASE_URL = "http://192.168.43.8:44335/api/";

    Get get = createRetrofit().create(Get.class);
    Post post = createRetrofit().create(Post.class);

    public void Get(final Callback<GetResponse> responseCallback){
        Call<GetResponse> res = get.GetResponse();
        res.enqueue(new Callback<GetResponse>() {
            @Override
            public void onResponse(Call<GetResponse> call, Response<GetResponse> response) {
                responseCallback.onResponse(call,response);
            }

            @Override
            public void onFailure(Call<GetResponse> call, Throwable t) {
                responseCallback.onFailure(call, t);
            }
        });
    }

    public void Post(PostRequest postRequest, final Callback<PostResponse> responseCallback){
        Call<PostResponse> res = post.Post(postRequest);
        res.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                responseCallback.onResponse(call, response);
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                responseCallback.onFailure(call, t);
            }
        });
    }

    public Retrofit createRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
