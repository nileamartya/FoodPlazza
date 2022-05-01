package com.foodplazza.dao;

import java.util.List;

import com.foodplazza.pojo.Cart;

public interface CartDao {
	
	public boolean addToCart(Cart cart);
	//select f.foodName ,f.foodPrice ,c.cartId,c.emailId,f.foodid ,c.quantity from food as f inner join cart as c where f.foodid=c.foodId;
    public List<Cart> viewCartByEmail(String emailId);
   
}
