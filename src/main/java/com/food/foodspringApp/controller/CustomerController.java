package com.food.foodspringApp.controller;

import java.io.PrintWriter;
import java.util.List;
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

import com.food.foodspringApp.dao.CustomerDao;
import com.food.foodspringApp.dto.Customer;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	
	@PostMapping
	public Customer saveCustomers(@RequestBody Customer customer) {
		return customerDao.saveCustomer(customer);
	}
	
	/*@GetMapping
	public Customer findyById(@RequestParam int id) {
		Optional<Customer> op=customerDao.findBasedOnId(id);
		if(op.isEmpty()) {
			return null;
		}
		else {
			return op.get();
		}
	}*/
	
	/*@GetMapping
	public List<Customer> getAllRecords() {
		return customerDao.getAllCustomer();
	}*/
	
	@PutMapping
	public Customer updateRecords(@RequestBody Customer customer) {
		return customerDao.updateCustomer(customer);
	}
	
	@DeleteMapping
	public String deleteRecords(int id) {
		Optional<Customer> customer=customerDao.findBasedOnId(id);
		if(customer.isPresent()) {
			customerDao.deleteCustomer(id);
			return "Records has been deleted";
		}
		else {
			return "Records not found";
		}
	}
	
	@GetMapping
	public Customer getRecordsByEmail(String email) {
		Customer customer=customerDao.getByEmail(email);
		if(customer==null) {
			return null;
		}
		else {
			return customer;
		}
		
	}

}
