package com.food.foodspringApp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodspringApp.dto.Product;
import com.food.foodspringApp.repository.ProductRepo;

@Repository
public class ProductDao {
	@Autowired
	ProductRepo productRepo;
	
	public Product saveProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product findProductByName(String name) {
		return productRepo.findProductByName(name);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
	
	public void deleteProducts(int id) {
		productRepo.deleteById(id);
	}
	
	public Optional<Product> findProductById(int id) {
		return productRepo.findById(id);
	}
	

}
