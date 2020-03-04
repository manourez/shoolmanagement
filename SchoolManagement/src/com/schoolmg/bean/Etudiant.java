package com.schoolmg.bean;

public class Etudiant {
	    private int numero;
		private String nom;
	    private String prenom;
	    private String fonction;
	    private String password;
	    
	    public int getNumero() {
			return numero;
		}
	    
	    public String getFonction() {
	    	return fonction;
	    }
	    
	    public void setFonction(String fonction) {
	    	this.fonction = fonction;
	    }
	    
	    public void setNumero(int numero) {
	    	this.numero = numero; 
	    }
		
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
		public String getPassword() {
			return password;
		}    
}
