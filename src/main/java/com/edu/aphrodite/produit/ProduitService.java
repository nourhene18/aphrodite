package com.edu.aphrodite.produit;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProduitService {
	
	private final ProduitRepository produitRepository ;

	public ProduitService(ProduitRepository produitRepository) {
		super();
		this.produitRepository = produitRepository;
	}
	
	
	public void ajouterOuModifierProduit(Produit produit) {
		produitRepository.save(produit);
	}
	
	public List<Produit> tousLesProduits() {
		return produitRepository.findAll();
	}
	
	public void deleteProduit(Long id) {
		produitRepository.deleteById(id);
	}
	public Produit getProduit(Long id) {
		return produitRepository.findById(id).orElse(null);
		
	}
	
	


}
