package com.edu.aphrodite.produit;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produit")
public class ProduitController {
	private final ProduitService produitService ;
	
	
	public ProduitController(ProduitService produitService) {
		this.produitService = produitService;
	}

	@PostMapping
	public void ajouterOuModifierProduit(@RequestBody Produit produit) {
		produitService.ajouterOuModifierProduit(produit);
	}
	
	@GetMapping 
	public List<Produit> listProduit() {
		return produitService.tousLesProduits();
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduit(@PathVariable Long id) {
		produitService.deleteProduit(id);
	}
 
}
