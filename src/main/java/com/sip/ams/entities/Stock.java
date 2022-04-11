package com.sip.ams.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity

public class Stock {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	
	   @NotBlank(message = "Name is mandatory")
	    @Column(name = "name")
	    private String name;
	   
	   @NotBlank(message = "Date is mandatory")
	    @Column(name = "date")
	    private String date;
	   
	   
	 
	    @Column(name = "quantite")
	    private int quantite;
	   
	  /* @NotBlank(message = "Description is mandatory")*/
	    @Column(name = "description")
	    private String description;
	   
	   
   
		
	   
		   
			/**** Many To One ****/
			@ManyToOne(fetch = FetchType.LAZY, optional = false)
		    @JoinColumn(name = "article_id", nullable = false)
		    @OnDelete(action = OnDeleteAction.CASCADE)
		    private Article article;

		/**** methode avec parametre ****/
		public Stock( String name,String date,int quantite,String description) {
			
			this.name = name;
			this.date = date;
			this.quantite = quantite;
			this.description = description;
		}
		
		
		/**** methode sans parametre ****/
		 public Stock() {
			 
			 
		 }


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}


		public int getQuantite() {
			return quantite;
		}


		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}


		public String getDescription() {
			return description;
		}


		public void setDescription(String description) {
			this.description = description;
		}


	


		public Article getArticle() {
			return article;
		}


		public void setArticle(Article article) {
			this.article = article;
		}


	


		
		 
		 
	
	
	
	

}
