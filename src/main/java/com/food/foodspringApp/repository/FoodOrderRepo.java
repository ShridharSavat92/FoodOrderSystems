package com.food.foodspringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodspringApp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer> {
	
	

}
