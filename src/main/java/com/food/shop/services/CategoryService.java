package com.food.shop.services;

import com.food.shop.domain.Category;
import com.food.shop.domain.Product;
import com.food.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories;
    }

    public Category findById(Integer id) {
        Optional<Category> prod = categoryRepository.findById(id);
        return prod.orElseThrow(() -> new RuntimeException("Categoria não encontrado!"));
    }
}
