package com.food.foodspringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodspringApp.dto.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {
	Product findProductByName(String name);

}
