package com.schoolmg.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.schoolmg.bean.Etudiant;
import com.schoolmg.dao.DaoFactory;
import com.schoolmg.dao.StudentDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.studentDao = daoFactory.getEtudiantDao();
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Etudiant etudiant = new Etudiant();
	        etudiant.setNom(request.getParameter("nom"));
	        etudiant.setPassword(request.getParameter("password"));
	        List<Etudiant> students = studentDao.lister();
	        
	        for(int i=0;i<students.size();i++) {
	        	if(students.contains(etudiant.getNom()) && students.contains(etudiant.getPassword())) {
	        		this.getServletContext().getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	        	}
	        }
	        
		} catch (Exception e) {
	        request.setAttribute("erreur", e.getMessage());
		}
		
	}

}
