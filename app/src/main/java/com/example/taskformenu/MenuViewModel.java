package com.example.taskformenu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuViewModel extends ViewModel {
    private MutableLiveData<List<MenuItem>> menuData = new MutableLiveData<List<MenuItem>>();
    private MenuApiService menuApiService;

    public MenuViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://inventory.fablocdn.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        menuApiService = retrofit.create(MenuApiService.class);
        fetchMenuData();
    }

    public LiveData<List<MenuItem>> getMenuData() {
        return menuData;
    }

    void fetchMenuData() {
        Call<MenuResponse> call = menuApiService.getMenuData();
        call.enqueue(new Callback<MenuResponse>() {
            @Override
            public void onResponse(Call<MenuResponse> call, Response<MenuResponse> response) {
                if (response.isSuccessful()) {
                    MenuResponse menuResponse = response.body();
                    if (menuResponse != null) {
                        List<MenuItem> menuItems = menuResponse.getItems();
                        // Now you can organize menuItems as needed in your UI
                        menuData.postValue(menuItems);
                    }
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<MenuResponse> call, Throwable t) {
                // Handle network or request failure
            }
        });
    }
}


