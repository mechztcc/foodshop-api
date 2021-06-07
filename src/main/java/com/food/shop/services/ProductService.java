package com.food.shop.services;


import com.food.shop.domain.Category;
import com.food.shop.domain.Product;
import com.food.shop.dto.ProductDTO;
import com.food.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryService categoryService;

    public List<Product> findAll() {
        List<Product> prods = productRepository.findAll();
        return prods;
    }

    public Product findById(Integer id) {
        Optional<Product> prod = productRepository.findById(id);
        return prod.orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public Product create(ProductDTO prodDTO) {
        Category category = categoryService.findById(prodDTO.getCategoryId());
        Product prod = new Product(null, prodDTO.getName(), prodDTO.getPrice(), prodDTO.getImg(), category);
        productRepository.save(prod);
        return prod;
    }

    public void delete(Integer id) {

        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            throw new DataIntegrityViolationException("Error a o excluir!");
        }

    }

}
