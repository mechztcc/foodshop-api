package com.food.shop.services;


import com.food.shop.domain.Product;
import com.food.shop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        List<Product> prods = productRepository.findAll();
        return prods;
    }
}
