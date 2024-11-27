package com.edu.aphrodite.commentaire;

import com.edu.aphrodite.produit.Produit;
import jakarta.persistence.*;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomUtilisateur;
    private String message;
    @ManyToOne
    @JoinColumn(name = "produit_id", nullable = false)
    private Produit produit;
    public Commentaire() {
    }

    public Commentaire(String nomUtilisateur, String message, Produit produit) {
        this.nomUtilisateur = nomUtilisateur;
        this.message = message;
        this.produit = produit;
    }

   
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }
    
    

    public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Produit getProduit() {
        return produit;
    }

    @Override
    public String toString() {
        return "Commentaire{" +
                "id=" + id +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", message='" + message + '\''+
                '}';
    }
}
