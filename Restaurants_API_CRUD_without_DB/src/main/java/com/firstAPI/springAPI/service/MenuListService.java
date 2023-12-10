package com.firstAPI.springAPI.service;

import java.util.List;

import com.firstAPI.springAPI.Entities.MenuList;

public interface MenuListService {
	
	public List<MenuList> getMenu();
	public List<MenuList> sortByName();
	public List<MenuList> sortByPrice();
	public MenuList searchByName(String pizzaName);
	public String addItem(MenuList item);
	public String updateItem(MenuList item, String pizzaName);
	public String deleteItem(String pizzaName);

}
