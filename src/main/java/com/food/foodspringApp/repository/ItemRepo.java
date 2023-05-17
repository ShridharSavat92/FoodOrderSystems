package com.food.foodspringApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodspringApp.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer> {

}
