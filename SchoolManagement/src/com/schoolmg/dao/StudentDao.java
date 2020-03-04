package com.schoolmg.dao;

import java.util.List;

import com.schoolmg.bean.Etudiant;

public interface StudentDao {
    void ajouter(Etudiant etudiant) throws DaoException;
    void supprimer(Etudiant etudiant)throws DaoException;
    Etudiant selectionner(Etudiant etudiant) throws DaoException;
    void modifier(Etudiant etudiant) throws DaoException;
    List<Etudiant> lister() throws DaoException;
}
