package com.food.shop.resources;

import com.food.shop.domain.Product;
import com.food.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProductResource {

    @Autowired
    ProductService productService;


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getAll() {
        List<Product> prods = productService.findAll();
        return ResponseEntity.ok(prods);
    }
}
