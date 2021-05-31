package com.food.shop.resources;

import com.food.shop.domain.Category;
import com.food.shop.dto.CategoryDTO;
import com.food.shop.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoryResource {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Category>> findAll() {
        List<Category> categories = categoryService.findAll();
        return ResponseEntity.ok(categories);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody CategoryDTO catDTO) {
        Category cat = categoryService.create(catDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category cat = categoryService.findById(id);
        return ResponseEntity.ok(cat);
    }
}
