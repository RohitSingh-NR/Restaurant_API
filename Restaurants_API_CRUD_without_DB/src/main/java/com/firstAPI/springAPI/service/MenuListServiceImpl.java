package com.firstAPI.springAPI.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.firstAPI.springAPI.Entities.MenuList;

// Telling Spring Boot that this class is our Service Provider class or Service layer class

@Service
public class MenuListServiceImpl implements MenuListService {
	
	//=====================================================================
	//=====================================================================
	
	List<MenuList> myList;
	
	public MenuListServiceImpl() {
		myList = new ArrayList<>();
		myList.add(new MenuList("KFC Pizza", "Regular", 290));
		myList.add(new MenuList("MacDonalds", "Medium", 500));
		myList.add(new MenuList("Dominos", "Large", 700));
	}


	
	@Override
	public List<MenuList> getMenu() {
		// TODO Auto-generated method stub
		return myList;
	}
	
	
	@Override
	public List<MenuList> sortByName() {
		
		Comparator<MenuList> sortByName = Comparator.comparing(MenuList::getName);
		Collections.sort(myList,sortByName);
		return myList;
	}
	
	
	@Override
	public List<MenuList> sortByPrice() {
		// TODO Auto-generated method stub
		Comparator<MenuList> sortByPrice = Comparator.comparing(MenuList::getPrice);
		Collections.sort(myList,sortByPrice);
		return myList;
	}

	@Override
	public MenuList searchByName(String pizzaName) {
			// TODO Auto-generated method stub
			MenuList ml = null;
			for(MenuList pName : myList) {
				if(pName.getName().replace(" ","").toLowerCase().contains(pizzaName.replace(" ", "").toLowerCase())) {
					ml=pName;
					break;
				}
			}
			return ml;
		}



	@Override
	public String addItem(MenuList item) {
		// TODO Auto-generated method stub
		myList.add(item);
		return "New item added to the list";
	}



	@Override
	public String updateItem(MenuList item, String pizzaName) {
//		// TODO Auto-generated method stub
//		myList = myList.stream().map(x ->{
//			
//			if(x.getName().equals(pizzaName)) {
//				x.setSize(item.getSize());
//				x.setPrice(item.getPrice());
//			}
//			return x;
//		}).collect(Collectors.toList());
//		
//		return "Item updated in Menu";
		
		
		MenuList itemFound = null;
		for(MenuList searchForItem : myList) {
			if(searchForItem.getName().equals(pizzaName)) {
				itemFound = searchForItem;
				break;
			}
		}
			if(itemFound==null) {
				return "Item Not Found";
			}
			else {
				itemFound.setSize(item.getSize());
				itemFound.setPrice(item.getPrice());
				return "Item Updated in Menu";
			}
}



	@Override
	public String deleteItem(String pizzaName) {
		// TODO Auto-generated method stub
		
		myList.removeIf(x -> x.getName().equals(pizzaName));
		
		return "Requested Item Deleted";
	}

	

	
	}
	
	//===============================================================
	//===============================================================
