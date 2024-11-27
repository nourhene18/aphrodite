package com.edu.aphrodite.produit;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/products")
public class ProduitController {
	private final ProduitService produitService ;
	
	
	public ProduitController(ProduitService produitService) {
		this.produitService = produitService;
	}

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public void ajouterOuModifierProduit(@RequestBody Produit produit) {
		produitService.ajouterOuModifierProduit(produit);
	}
	
	@GetMapping 
	public List<Produit> listProduit() {
		return produitService.tousLesProduits();
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteProduit(@PathVariable Long id) {
		produitService.deleteProduit(id);
	}
	@GetMapping("/{id}")
	public Produit getProduit(@PathVariable Long id) {
		return produitService.getProduit(id);
	}
 
}
