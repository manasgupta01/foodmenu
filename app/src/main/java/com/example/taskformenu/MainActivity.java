package com.example.taskformenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MenuViewModel menuViewModel;
    private MenuAdapter menuAdapter;

    List<MenuItem> menuItems = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create the ViewModel
        menuViewModel = new ViewModelProvider(this).get(MenuViewModel.class);

        // Initialize the RecyclerView Adapter
        menuAdapter = new MenuAdapter(menuItems);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(menuAdapter);

        // Observe the LiveData from the ViewModel and update the UI
        menuViewModel.getMenuData().observe(this, menuItems -> {
            // Log the menuItems to check the data
            for (MenuItem menuItem : menuItems) {
                Log.d(TAG, "Category: " + menuItem.getCategoryName());
                // Add additional logging for subcategories and products if needed
            }

            // Update the RecyclerView adapter with the hierarchical menu data
            menuAdapter.setMenuItems(menuItems);
        });

        // Fetch menu data
        menuViewModel.fetchMenuData();
    }
}
