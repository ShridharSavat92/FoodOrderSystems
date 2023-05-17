package com.food.foodspringApp.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodspringApp.dao.ProductDao;
import com.food.foodspringApp.dto.Product;
import com.food.foodspringApp.repository.ProductRepo;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductDao productDao;
	
	@PostMapping
	public Product saveProductRecords(@RequestBody Product product) {
		return productDao.saveProduct(product);
	}
	
	@GetMapping
	public Product findProductRecords(String name) {
		return productDao.findProductByName(name);
	}
	
	@PutMapping
	public Product updateProducts(@RequestBody Product product) {
		return productDao.updateProduct(product);
	}
	
	@DeleteMapping
	public String deleteProducts(@RequestParam int id) {
		Optional<Product> product=productDao.findProductById(id);
		if(product.isPresent()) {
			productDao.deleteProducts(id);
			return "Product has been deleted";
		}
		else {
			return "Products records not found";
		}
	}

}
