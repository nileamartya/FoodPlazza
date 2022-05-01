package com.foodplazza.controller;
import java.util.List;
import java.util.Scanner;
import com.foodplazza.dao.FoodDao;
import com.foodplazza.dao.FoodDaoImpl;
import com.foodplazza.pojo.Food;

public class FoodTest {

	public static void main(String[] args) {
		while (true) {
			String fName,description;
			int foodId,categoryId;
			double price;
			
			Scanner sc=new Scanner(System.in);
			System.out.println("1.Add Food");
			System.out.println("2.Update Food");
			System.out.println("3.Delete  Food");
			System.out.println("4.Get All Foods");
			System.out.println("5.Search Food By Id");
			System.out.println("Enter your choice:");
			int ch=sc.nextInt();
			Food food =new Food();
			FoodDao foodDao=new FoodDaoImpl();
			switch (ch) {
			case 1:
				System.out.println("Add Food Details....");
				System.out.println("Enter food name:");
				fName=sc.next();				
				System.out.println("Enter food description:");
				description=sc.next();
				System.out.println("Enter food category id:");
				categoryId=sc.nextInt();
				System.out.println("Enter food price:");
				price=sc.nextDouble();
				food.setFoodName(fName);				
				food.setDescription(description);
				food.setCategoryId(categoryId);
				food.setPrice(price);
				boolean b=foodDao.addFood(food);
				
				if(b)
				{
					System.out.println("inserted");
				}
				else
				{
					System.out.println("not inserted");
				}
				
				break;

				
			case 2:				
				
				System.out.println("Update Food Details....");
				System.out.println("Enter food name:");
				fName=sc.next();				
				System.out.println("Enter food description:");
				description=sc.next();
				System.out.println("Enter food category id:");
				categoryId=sc.nextInt();
				System.out.println("Enter food price:");
				
				price=sc.nextDouble();
				System.out.println("Enter food  id:");
				foodId=sc.nextInt();
				food.setFoodName(fName);				
				food.setDescription(description);
				food.setCategoryId(categoryId);
				food.setPrice(price);
				food.setFoodId(foodId);
				boolean b1=foodDao.updateFood(food);
				
				if(b1)
				{
					System.out.println("Updated...");
				}
				else
				{
					System.out.println("Not Updated");
				}
				
				break;
				
				
			case 3:				
				
				System.out.println("Delete Food Details....");
				
				System.out.println("Enter food  id:");
				foodId=sc.nextInt();
				
				food.setFoodId(foodId);
				boolean b2=foodDao.deleteFood(foodId);
				
				if(b2)
				{
					System.out.println("Delete...");
				}
				else
				{
					System.out.println("Not Delete..");
				}
				
				break;
			case 4:
				System.out.println("Get All Foods:");
				List<Food>foodList=foodDao.getAllFoods();
				
				for(int i=0;i<foodList.size();i++)
				{
					System.out.println(foodList.get(i));
					
				}
				
				break;
			case 5:
               System.out.println("Search  Food By Id....");
				
				System.out.println("Enter food  id:");
				foodId=sc.nextInt();
				food=foodDao.searchFoodById(foodId);
				System.out.println(food);
				break;

			default:
				break;
			}
			
			
			
		}

	}

}
