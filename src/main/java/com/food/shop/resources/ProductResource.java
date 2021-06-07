package com.food.shop.resources;

import com.food.shop.domain.Product;
import com.food.shop.dto.ProductDTO;
import com.food.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> findById(@PathVariable Integer id) {
        Product prod = productService.findById(id);
        return ResponseEntity.ok(prod);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody ProductDTO prodDTO) {
        Product prod = productService.create(prodDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(prod.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
       productService.delete(id);
       return ResponseEntity.noContent().build();
    }
    

}
