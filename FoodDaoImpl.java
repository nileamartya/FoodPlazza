package com.foodplazza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.foodplazza.pojo.Food;
import com.foodplazza.utility.DBUtility;

public class FoodDaoImpl implements FoodDao {
	Connection conn = null;
	PreparedStatement ps = null;

	public boolean addFood(Food food) {

		try {
			conn = DBUtility.getConnectionObj();
			String sql = "insert into food(foodname,foodprice,categoryid,description)values(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, food.getFoodName());
			ps.setDouble(2, food.getPrice());
			ps.setInt(3, food.getCategoryId());
			ps.setString(4, food.getDescription());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateFood(Food food) {
		try {
			conn = DBUtility.getConnectionObj();
			String sql = "update food set foodname=?,foodprice=?,categoryid=?,description=? where foodid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, food.getFoodName());
			ps.setDouble(2, food.getPrice());
			ps.setInt(3, food.getCategoryId());
			ps.setString(4, food.getDescription());
			ps.setInt(5, food.getFoodId());
			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteFood(int foodId) {
		try {
			conn = DBUtility.getConnectionObj();
			String sql = "delete from  food where foodid=?";
			ps = conn.prepareStatement(sql);

			ps.setInt(1, foodId);

			int i = ps.executeUpdate();
			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Food> getAllFoods() {
        List<Food>al=new ArrayList<Food>();
		try {
			conn = DBUtility.getConnectionObj();
			String sql = "select * from food ";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				// ps.setDouble(2, food.getPrice());
				Food food = new Food();
				food.setFoodId(rs.getInt("foodid"));
				food.setFoodName(rs.getString("foodname"));
				food.setPrice(rs.getDouble("foodprice"));
				food.setDescription(rs.getString("description"));
				food.setCategoryId(rs.getInt("categoryid"));
				al.add(food);
			}
			return al;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public Food searchFoodById(int foodId) {
		  			try {
				conn = DBUtility.getConnectionObj();
				String sql = "select * from food where foodid=?";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, foodId);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {

					// ps.setDouble(2, food.getPrice());
					Food food = new Food();
					food.setFoodId(rs.getInt("foodid"));
					food.setFoodName(rs.getString("foodname"));
					food.setPrice(rs.getDouble("foodprice"));
					food.setDescription(rs.getString("description"));
					food.setCategoryId(rs.getInt("categoryid"));
					return food;
				}
				

			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

}
