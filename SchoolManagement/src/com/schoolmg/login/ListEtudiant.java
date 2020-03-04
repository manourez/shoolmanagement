package com.schoolmg.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmg.bean.Etudiant;
import com.schoolmg.dao.DaoException;
import com.schoolmg.dao.DaoFactory;
import com.schoolmg.dao.StudentDao;

/**
 * Servlet implementation class ListEtudiant
 */
@WebServlet("/ListEtudiant")
public class ListEtudiant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.studentDao = daoFactory.getEtudiantDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEtudiant() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            request.setAttribute("etudiants", studentDao.lister());
        }
        catch (DaoException e) {
            request.setAttribute("erreur", e.getMessage());
        }
		this.getServletContext().getRequestDispatcher("/WEB-INF/etudiant.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String numero = request.getParameter("numero");
			Etudiant etudiant = new Etudiant();
			etudiant.setNumero(Integer.parseInt(numero));
		    studentDao.supprimer(etudiant);
		    request.setAttribute("etudiants", studentDao.lister());
		}
		catch (Exception e) {
			request.setAttribute("erreur", e.getMessage());
		}
		this.getServletContext().getRequestDispatcher("/WEB-INF/etudiant.jsp").forward(request, response);
	}

}
