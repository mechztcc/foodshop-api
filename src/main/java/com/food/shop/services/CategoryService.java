package com.food.shop.services;

import com.food.shop.domain.Category;
import com.food.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }
}
