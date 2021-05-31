package com.food.shop.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -4107140683055737547L;


    private String name;

    private Double price;

    private String img;

    private Integer categoryId;

    public ProductDTO(String name) {

    }

    public ProductDTO(String name, Double price, String img, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.img = img;
        this.categoryId = categoryId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
