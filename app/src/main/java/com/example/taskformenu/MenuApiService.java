package com.example.taskformenu;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuApiService {
    @GET("v1/menu/full/2e00aba32138")
    Call<MenuResponse> getMenuData();
}

