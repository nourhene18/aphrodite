package com.edu.aphrodite.categories;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CategoriesService {
	
	private final CategorieRepository categorieRepository ; 
	
	public CategoriesService(CategorieRepository categorieRepository) {
	this.categorieRepository = categorieRepository ;
	}
	
	public void ajouterCategorie(Categorie categorie) {
		categorieRepository.save(categorie) ;
	}

	public List<Categorie> getListCategories() {
		return categorieRepository.findAll() ;
	}
}
