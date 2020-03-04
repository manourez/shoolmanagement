package com.schoolmg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.schoolmg.bean.Etudiant;

public class StudentDaoImplement implements StudentDao {
	private DaoFactory daoFactory;

    StudentDaoImplement(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(Etudiant etudiant) throws DaoException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO etudiant(Nom, Prenoms, Fonction, Password) VALUES(?, ?, ?, ?);");
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getFonction());
            preparedStatement.setString(4, etudiant.getPassword());
            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
                    
    }
    
    public void supprimer(Etudiant etudiant) throws DaoException {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("DELETE FROM etudiant WHERE NUMERO = ?;");
            preparedStatement.setInt(1, etudiant.getNumero());
            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
    }
    
    public void modifier(Etudiant etudiant) throws DaoException {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("UPDATE etudiant SET Nom = ?, Prenoms = ?, Fonction = ? WHERE Numero = ?");
            preparedStatement.setString(1, etudiant.getNom());
            preparedStatement.setString(2, etudiant.getPrenom());
            preparedStatement.setString(3, etudiant.getFonction());
            preparedStatement.setString(4, etudiant.getPassword());
            preparedStatement.setInt(5, etudiant.getNumero());
            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
    }
    
    public Etudiant selectionner(Etudiant etudiant) throws DaoException {
    	Connection connexion = null;
        PreparedStatement preparedStatement = null;
        
        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("SELECT * FROM etudiant WHERE NUMERO = ?;");
            preparedStatement.setInt(1, etudiant.getNumero());
            preparedStatement.executeUpdate();
            connexion.commit();
        } catch (SQLException e) {
            try {
                if (connexion != null) {
                    connexion.rollback();
                }
            } catch (SQLException e2) {
            }
            throw new DaoException("Impossible de communiquer avec la base de données");
        }
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return etudiant;
    }

    @Override
    public List<Etudiant> lister() throws DaoException {
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT Numero, Nom, Prenoms, Fonction FROM etudiant;");

            while (resultat.next()) {
            	int numero = resultat.getInt("Numero");
                String nom = resultat.getString("Nom");
                String prenom = resultat.getString("Prenoms");
                String fonction = resultat.getString("Fonction");

                Etudiant etudiant = new Etudiant();
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setNumero(numero);
                etudiant.setFonction(fonction);

                etudiants.add(etudiant);
            }
        } catch (SQLException e) {
            throw new DaoException("Impossible de communiquer avec la base de données");
        } 
        finally {
            try {
                if (connexion != null) {
                    connexion.close();  
                }
            } catch (SQLException e) {
                throw new DaoException("Impossible de communiquer avec la base de données");
            }
        }
        return etudiants;
    }
}
