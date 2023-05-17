package com.food.foodspringApp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodspringApp.dao.FoodOrderDao;
import com.food.foodspringApp.dto.FoodOrder;

@RestController
@RequestMapping("/foods")
public class FoodOrderController {
	@Autowired
	FoodOrderDao foodOrderDao;
	
	@PostMapping //("/foods")
	public FoodOrder saveFoodOrders(@RequestBody FoodOrder foodOrder) {
		return foodOrderDao.saveFoodOrder(foodOrder);
	}
	
	@GetMapping("/{id}")
	public FoodOrder getFoodOrdersById(@PathVariable int id) {
	Optional<FoodOrder> op=foodOrderDao.getFoodOrderById(id);
	if(op.isEmpty()) {
		return null;
	}
	else {
		return op.get();
	}
 }
	
	@GetMapping
	public List<FoodOrder> getFoodOrders(){
		return foodOrderDao.getAllFoodOrder();
	}
	
	@PutMapping
	public FoodOrder updateFoodOrders(@RequestBody FoodOrder foodOrder) {
		return foodOrderDao.updateFoodOrder(foodOrder);
		
	}
	
	@DeleteMapping
	public String deleteFoodOrders(int id) {
		Optional<FoodOrder> op=foodOrderDao.getFoodOrderById(id);
		if(op.isPresent()) {
			foodOrderDao.deleteFoodOrder(id);
			return "Record has been deleted";
		}
		else {
			return "Record not found";
		}
	}

}
