package com.edu.aphrodite.produit;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.edu.aphrodite.categories.Categorie;
import com.edu.aphrodite.commentaire.Commentaire;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ; 
	private String name ;
	private String photoUrl;
	private BigDecimal prix ;
	private boolean disponible ;
	private LocalDate dateAjout = LocalDate.now() ;
	private String description;
	
	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Commentaire> commentaireList ;  
	@ManyToOne
	private Categorie categorie ;
	
	
	
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrix() {
		return prix;
	}
	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public LocalDate getDateAjout() {
		return dateAjout;
	}
	public List<Commentaire> getCommentaireList() {
		return commentaireList;
	}
	public void setCommentaireList(List<Commentaire> commentaireList) {
		this.commentaireList = commentaireList;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
}
