package com.schoolmg.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.schoolmg.bean.Etudiant;

public class Student {
private Connection connexion;
    
    public List<Etudiant> recupererEtudiants() {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        Statement statement = null;
        ResultSet resultat = null;

        loadDatabase();
        
        try {
            statement = connexion.createStatement();

            // Exécution de la requête
            resultat = statement.executeQuery("SELECT Nom, Prenoms FROM etudiant;");

            // Récupération des données
            while (resultat.next()) {
                String nom = resultat.getString("Nom");
                String prenom = resultat.getString("Prenoms");
                
                Etudiant etudiant = new Etudiant();
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                
                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
        } finally {
            // Fermeture de la connexion
            try {
                if (resultat != null)
                    resultat.close();
                if (statement != null)
                    statement.close();
                if (connexion != null)
                    connexion.close();
            } catch (SQLException ignore) {
            }
        }
        
        return etudiants;
    }
    
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void ajouterEtudiant(Etudiant etudiant) {
        loadDatabase();
        
        try {
            PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO etudiant(Nom, Prenoms, Password) VALUES(?, ?, ?);");
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
