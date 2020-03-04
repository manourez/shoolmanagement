package com.schoolmg.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.schoolmg.bean.Etudiant;
//import com.schoolmg.dao.AdministrateurDao;
import com.schoolmg.dao.DaoFactory;
import com.schoolmg.dao.StudentDao;


/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.studentDao = daoFactory.getEtudiantDao();
    }
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Etudiant etudiant = new Etudiant();
	        etudiant.setNom(request.getParameter("nom"));
	        etudiant.setPrenom(request.getParameter("prenom"));
	        etudiant.setFonction(request.getParameter("fonction"));
	        etudiant.setPassword(request.getParameter("password"));
	        studentDao.ajouter(etudiant);
		} catch (Exception e) {
	        request.setAttribute("erreur", e.getMessage());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

}
