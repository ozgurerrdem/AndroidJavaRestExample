package com.example.apideneme.API.GET;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Get {
    @GET("database")
    Call<GetResponse> GetResponse();
}
