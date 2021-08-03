package fr.humanbooster.fx.burger.services.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.burger.business.Boisson;
import fr.humanbooster.fx.burger.services.IService;

public class BoissonService implements IService<Boisson> {
	
	private static List<Boisson> items = new ArrayList<>();
	public BoissonService(){
	}

	public static void init() {
		items.add(new Boisson("Coca",1.5f));
		items.add(new Boisson("Pepsi",1.5f));
		items.add(new Boisson("Fanta",1.5f));
		
	}
	
	@Override
	public Boisson getItem(Long id) {
		 for (Boisson item : items) {
             if (item.getId().equals(id)) {
                    return item;
             }
		 }	
		 return null;
		
	}

	@Override
	public List<Boisson> getList() {
		// TODO Auto-generated method stub
		return items;
	}

}
