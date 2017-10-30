package com.rsComponent.custom;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private WebElement element;
    private List<Category> subCategories;


    public Category(String name, WebElement element) {
        this.name = name;
        this.element = element;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WebElement getElement() {
        return element;
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    public List<Category> getSubCategories() {
        if(subCategories == null) {
            subCategories = new ArrayList<Category>();
        }

        return subCategories;
    }

    public void setSubCategories(List<Category> subCategories) {
        this.subCategories = subCategories;
    }
}
