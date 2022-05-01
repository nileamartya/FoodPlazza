package com.foodplazza.controller;

import java.util.List;
import java.util.Scanner;

import com.foodplazza.dao.CartDao;
import com.foodplazza.dao.CartDaoImpl;
import com.foodplazza.pojo.Cart;

public class CartTest {

	public static void main(String[] args) {
		while (true) {
			String emailId;
			int foodId, quantity;
			double price;
			Scanner sc = new Scanner(System.in);
			System.out.println("1.Add To Cart");
			System.out.println("2.View Cart");
			System.out.println("Enter your choice:");
			int ch = sc.nextInt();
			Cart cart = new Cart();
			CartDao cartDao = new CartDaoImpl();
			switch (ch) {
			case 1:
				System.out.println("Add To Cart....");
				System.out.println("Enter emailId:");
				emailId = sc.next();
				System.out.println("Enter Food Id:");
				foodId = sc.nextInt();
				System.out.println("Enter food Quantity:");
				quantity = sc.nextInt();
				cart.setEmailId(emailId);
				cart.setFoodId(foodId);
				cart.setQuantity(quantity);

				boolean b = cartDao.addToCart(cart);

				if (b) {
					System.out.println("inserted into cart");
				} else {
					System.out.println("not inserted into cart");
				}

				break;
			case 2:
				
				System.out.println("Enter emailId:");
				emailId = sc.next();
				List<Cart>viewByEmail=cartDao.viewCartByEmail(emailId);
				for(int i=0;i<viewByEmail.size();i++)
				{
					System.out.println(viewByEmail.get(i));
				}
				
				break;
				

			default:
				break;
			}

		}
	}

}
