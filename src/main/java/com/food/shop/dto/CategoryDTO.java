package com.food.shop.dto;

import java.io.Serializable;

public class CategoryDTO  implements Serializable {

    private String name;

    private static final long serialVersionUID = 7966389395979802060L;

    public CategoryDTO() {
    }

    public CategoryDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
