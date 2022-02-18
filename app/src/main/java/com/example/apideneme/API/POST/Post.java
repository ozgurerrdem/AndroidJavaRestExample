package com.example.apideneme.API.POST;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Post {
    @POST("database")
    Call<PostResponse> Post(@Body PostRequest request);
}
