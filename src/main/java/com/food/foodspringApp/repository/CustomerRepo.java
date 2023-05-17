package com.food.foodspringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodspringApp.dto.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
	Customer findByEmail(String email);
	

}
