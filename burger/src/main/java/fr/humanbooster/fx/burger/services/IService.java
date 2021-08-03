package fr.humanbooster.fx.burger.services;

import java.util.List;

public interface IService <T>{
	public T getItem(Long id);
	public List<T> getList();
}
