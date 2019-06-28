package com.example.heszrave.touristguide.dropdownListFood;

import java.io.Serializable;

public class Food implements Serializable{
    private String name;
    private int price;
    private String details;
    private String image;
    private FoodType foodType;
    private boolean isFavorite;

    public Food(String name, int price,String details, String image, FoodType foodType, boolean isFavorite) {
        this.name = name;
        this.price = price;
        this.details = details;
        this.image = image;
        this.foodType = foodType;
        this.isFavorite = isFavorite;
    }

    public String getName() {
        return name;
    }

    public int getPrice() { return price; }

    public String getDetails() { return details; }

    public String getImage() {
        return image;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public boolean isFavorite() {
        return isFavorite;
    }
}
