package com.edu.aphrodite.categories;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.aphrodite.produit.Produit;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/categories")
public class CategorieController {

	
	private final CategoriesService categoriesService ; 
	
	
	public CategorieController(CategoriesService categoriesService) {
		super();
		this.categoriesService = categoriesService;
	}


	@GetMapping
	public List<Categorie> listCategorie() {
		return categoriesService.getListCategories();
		
	}
	
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public void ajouterCategorie (@RequestBody Categorie categorie) {
		categoriesService.ajouterCategorie(categorie);
	}
}
