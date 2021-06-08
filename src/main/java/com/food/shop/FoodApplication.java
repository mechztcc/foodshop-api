package com.food.shop;

import com.food.shop.domain.Category;
import com.food.shop.domain.Product;
import com.food.shop.domain.User;
import com.food.shop.repositories.CategoryRepository;
import com.food.shop.repositories.ProductRepository;
import com.food.shop.repositories.UserRepository;
import com.food.shop.services.CategoryService;
import com.food.shop.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class FoodApplication implements CommandLineRunner {


	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryService categoryService;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(FoodApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Pizzas");
		Category cat2 = new Category(null, "Burgers");

		Product prod1 = new Product(null, "Calabresa", 22.99, "urldaImagem1", cat1);
		Product prod2 = new Product(null, "Catupiry", 22.99, "urldaImagem2", cat1);

		Product prod3 = new Product(null, "X-Burger", 13.99, "urldaImagem3",cat2);

		User user1 = new User(null, "email@email.com", bCryptPasswordEncoder.encode("123456"));

		cat1.setProducts(Arrays.asList(prod1, prod2));
		cat2.setProducts(Arrays.asList(prod3));




		categoryRepository.save(cat1);
		categoryRepository.save(cat2);


		productRepository.save(prod1);
		productRepository.save(prod2);
		productRepository.save(prod3);


		userRepository.save(user1);






	}
}
