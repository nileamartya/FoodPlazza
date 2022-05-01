package com.foodplazza.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodplazza.pojo.Cart;
import com.foodplazza.utility.DBUtility;

public class CartDaoImpl implements CartDao{
Connection conn=null;
PreparedStatement ps=null;
	@Override
	public boolean addToCart(Cart cart) {
		try {
			conn=DBUtility.getConnectionObj();
			String sql="insert into cart(emailId,foodId,quantity)values(?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, cart.getEmailId());
			ps.setInt(2, cart.getFoodId());
			ps.setInt(3, cart.getQuantity());
			int i=ps.executeUpdate();
			if(i>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
		
		
		return false;
	}
	@Override
	public List<Cart> viewCartByEmail(String emailId) {
		List<Cart> al=new ArrayList<Cart>();
		try {
			conn=DBUtility.getConnectionObj();
			String sql="select f.foodname ,f.foodprice ,c.cartId,c.emailId,f.foodid ,c.quantity from food as f inner join cart as c where f.foodid=c.foodId and c.emailId=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1,emailId);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Cart cart=new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setEmailId(rs.getString("emailId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setFoodId(rs.getInt("foodId"));
				cart.setFoodname(rs.getString("foodname"));
				cart.setPrice(rs.getDouble("foodprice"));
				al.add(cart);
			}
			return  al;
			
			
			
		} catch (Exception e) {
			e.printStackTrace();;
		}
		
		
		
		
		
		return null;
	}

}
