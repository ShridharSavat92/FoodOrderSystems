package com.food.foodspringApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodspringApp.dto.Customer;
import com.food.foodspringApp.repository.CustomerRepo;

@Repository
public class CustomerDao {
	@Autowired
	CustomerRepo customerRepo;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
		
	}
	
	public Optional<Customer> findBasedOnId(int id) {
		return customerRepo.findById(id);
	}
	
	public List<Customer> getAllCustomer() {
		return customerRepo.findAll();
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public void deleteCustomer(int id) {
		customerRepo.deleteById(id);
	}
	
	public Customer getByEmail(String email) {
		return customerRepo.findByEmail(email);
	}

}
