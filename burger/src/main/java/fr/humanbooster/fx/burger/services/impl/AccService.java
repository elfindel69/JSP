package fr.humanbooster.fx.burger.services.impl;

import java.util.ArrayList;
import java.util.List;

import fr.humanbooster.fx.burger.business.Accompagnement;
import fr.humanbooster.fx.burger.services.IService;

public class AccService implements IService<Accompagnement> {

	private static List<Accompagnement> items = new ArrayList<>();
	public AccService(){
	}

	public static void init() {
		 items.add(new Accompagnement("Frites",0.5f));
		 items.add(new Accompagnement("Oignons frits",0.7f));
		 items.add(new Accompagnement("Potatoes",0.9f));
	}
	
	@Override
	public Accompagnement getItem(Long id) {
		 for (Accompagnement item : items) {
             if (item.getId().equals(id)) {
                    return item;
             }
		 }	
		 return null;
		
	}

	@Override
	public List<Accompagnement> getList() {
		// TODO Auto-generated method stub
		return items;
	}
}
