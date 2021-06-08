package com.food.shop.services;

import com.food.shop.domain.Category;
import com.food.shop.dto.CategoryDTO;
import com.food.shop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

    public Category create(CategoryDTO catDTO) {
        Category cat = new Category(null, catDTO.getName());
        return cat = categoryRepository.save(cat);

    }


    public void delete(Integer id) {

        try {
            categoryRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataIntegrityViolationException("Error a o excluir categoria!");
        }
    }

}
