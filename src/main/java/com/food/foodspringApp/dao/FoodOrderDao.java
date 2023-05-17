package com.food.foodspringApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.food.foodspringApp.dto.FoodOrder;
import com.food.foodspringApp.dto.Item;
import com.food.foodspringApp.repository.FoodOrderRepo;
import com.food.foodspringApp.repository.ItemRepo;

@Repository
public class FoodOrderDao {
	
	@Autowired
	FoodOrderRepo foodOrderRepo;
	
	@Autowired
	ItemRepo itemRepo;
	
	public FoodOrder saveFoodOrder(FoodOrder foodOrder) {
		List<Item> listOfItems=foodOrder.getItems();
		List<Item> res=new ArrayList<Item>();
		if(listOfItems.isEmpty()) {
			foodOrder=foodOrderRepo.save(foodOrder);
		}
		else {
			foodOrder=foodOrderRepo.save(foodOrder);
			for(Item item:listOfItems) {
				item.setFoodorder(foodOrder);
				res.add(itemRepo.save(item));
			}
			foodOrder.setItems(res);
			
		}
		return foodOrder;
	}
	
	public Optional<FoodOrder> getFoodOrderById(int id) {
		return foodOrderRepo.findById(id);
	}
	
	public List<FoodOrder> getAllFoodOrder(){
		return foodOrderRepo.findAll();
	}
	
	public FoodOrder updateFoodOrder(FoodOrder foodOrder) {
		return foodOrderRepo.save(foodOrder);
	}
	
	public void deleteFoodOrder(int id) {
		foodOrderRepo.deleteById(id);
	}
	
	

}
