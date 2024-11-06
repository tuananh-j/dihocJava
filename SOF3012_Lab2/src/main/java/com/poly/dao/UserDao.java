package com.poly.dao;

import java.util.List;

import com.poly.entity.User;

public interface UserDao {
	/*truy_van_tat*/
	List<User> find_all();
	/*truy_van_ma_nguoi_dung*/
	User find_id(String id);
	/*them_moi*/
	void create(User item);
	/*cap_nhat*/
	void update(User item);
	/*xoa_ma*/
	void delete_id(String id);
}
