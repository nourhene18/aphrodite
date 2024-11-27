package com.edu.aphrodite.commentaire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.edu.aphrodite.produit.Produit;
import com.edu.aphrodite.produit.ProduitService;

import java.util.List;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;
    
    @Autowired
    private ProduitService produitService ; 

    public Commentaire saveCommentaire(CommentaireDTO commentaireDTO , Long productId) {
    	Produit produit = produitService.getProduit(productId) ; 
    	Commentaire commentaire = new Commentaire() ; 
    	commentaire.setProduit(produit);
    	commentaire.setNomUtilisateur(commentaireDTO.getNomUtilisateur());
    	commentaire.setMessage(commentaireDTO.getMessage());
        return commentaireRepository.save(commentaire);
    }

   
    public List<Commentaire> getCommentairesByProduitId(Long produitId) {
        return commentaireRepository.findByProduitId(produitId);
    }

   
    public void deleteCommentaire(Long id) {
        commentaireRepository.deleteById(id);
    }
}

