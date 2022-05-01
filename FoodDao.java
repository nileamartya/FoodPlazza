package com.foodplazza.dao;

import java.util.List;

import com.foodplazza.pojo.Food;

public interface FoodDao {

	public boolean addFood(Food food);
	public boolean updateFood(Food food);
	public boolean deleteFood(int foodId);
	public List<Food>getAllFoods();
	public Food searchFoodById(int foodId);
	
	
	
}
