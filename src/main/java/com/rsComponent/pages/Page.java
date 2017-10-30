package com.rsComponent.pages;

import com.rsComponent.custom.Category;

import java.util.ArrayList;
import java.util.List;

public class Page {

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        if(categoryList == null) {
            categoryList = new ArrayList<>();
        }
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

}
