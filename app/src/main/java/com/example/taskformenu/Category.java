package com.example.taskformenu;

import java.util.List;

public class Category {
    private String categoryId;
    private String categoryName;
    private boolean hasSubCategory;
    private boolean hasProduct;
    private List<Category> subCategoryList;
    private List<Product> productList;

    public Category(String categoryId, String categoryName, boolean hasSubCategory, boolean hasProduct, List<Category> subCategoryList, List<Product> productList) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.hasSubCategory = hasSubCategory;
        this.hasProduct = hasProduct;
        this.subCategoryList = subCategoryList;
        this.productList = productList;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public boolean isHasSubCategory() {
        return hasSubCategory;
    }

    public void setHasSubCategory(boolean hasSubCategory) {
        this.hasSubCategory = hasSubCategory;
    }

    public boolean isHasProduct() {
        return hasProduct;
    }

    public void setHasProduct(boolean hasProduct) {
        this.hasProduct = hasProduct;
    }

    public List<Category> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<Category> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    // Constructors, getters, and setters
}
