package com.edu.aphrodite.commentaire;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commentaires")
@CrossOrigin 
public class CommentaireController {

    
	
	private final CommentaireService commentaireService;

    public CommentaireController(CommentaireService commentaireService) {
		super();
		this.commentaireService = commentaireService;
	}
	   

    
    @PostMapping("/{productId}")
    public Commentaire addCommentaire(@PathVariable Long productId, @RequestBody CommentaireDTO commentaire) { 
        return commentaireService.saveCommentaire(commentaire , productId);
    }

    
    @GetMapping("/{productId}")
    public List<Commentaire> getCommentairesByProduit(@PathVariable Long productId) {
        return commentaireService.getCommentairesByProduitId(productId);
    }

  
    @DeleteMapping("/{id}")
    public void deleteCommentaire(@PathVariable Long id) {
        commentaireService.deleteCommentaire(id);
    }
}
