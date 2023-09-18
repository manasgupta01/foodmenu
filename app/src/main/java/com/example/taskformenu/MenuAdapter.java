package com.example.taskformenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    private List<MenuItem> menuItems;

    public MenuAdapter(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // Define the ViewHolder class and methods here

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate your item layout XML and return a new ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        // Bind data to the ViewHolder's views based on the item type (category, subcategory, or product)
        MenuItem menuItem = menuItems.get(position);
        holder.category_name.setText(menuItem.getCategoryName()); // Update this to display the correct data

        // Customize the binding logic based on your data structure
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        // Update the dataset with the new menu items
        this.menuItems = menuItems;
        notifyDataSetChanged(); // Notify the adapter that the dataset has changed
    }

    // Define your ViewHolder class here

    public class MenuViewHolder extends RecyclerView.ViewHolder {

        private TextView category_name;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            category_name = itemView.findViewById(R.id.category_name);
        }

        // Define setters for your ViewHolder views here
    }
}
