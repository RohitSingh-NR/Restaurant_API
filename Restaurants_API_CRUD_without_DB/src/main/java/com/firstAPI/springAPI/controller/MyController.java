package com.firstAPI.springAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstAPI.springAPI.Entities.MenuList;
import com.firstAPI.springAPI.service.MenuListService;

@RestController
public class MyController {
	
	// calling object of MenuListService
	
	@Autowired
	public MenuListService mls;
	
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to @Pizza Developers";
	}

	//==========================================
	// Menu List
	
@GetMapping("/menu")
	public List<MenuList> getPizzaMenu(){
	
	return mls.getMenu();
		
	}
//===============================================

//Sorted Menu list - apply filter

@GetMapping("/menu/sortByName")
public List<MenuList> sortByName() {
	
	return mls.sortByName();
}

//====================================================

// Menu List Sorted by Price - apply filter

@GetMapping("/menu/sortByPrice")
public List<MenuList> sortByPrice() {
	
	return mls.sortByPrice();
}

//===================================================

@GetMapping("/menu/{pizzaName}")
public  MenuList getByName(@PathVariable String pizzaName) {
	return mls.searchByName(pizzaName);
}
//=================================================

@PostMapping("/addItem")
public String addItem(@RequestBody MenuList item) {
	return mls.addItem(item);
}

@PutMapping("/updateItem/{pizzaName}")
public String updateItem(@RequestBody MenuList item,@PathVariable String pizzaName) {
	return mls.updateItem(item,pizzaName);
}

@DeleteMapping("/delete/{pizzaName}")
public String deleteItem(@PathVariable String pizzaName) {
	
	return mls.deleteItem(pizzaName);
}
}
