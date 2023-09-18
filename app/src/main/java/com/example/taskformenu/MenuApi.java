package com.example.taskformenu;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuApi {
    @GET("menu/full/2e00aba32138")
    Call<MenuResponse> getMenuData();
}

