package com.mode.lu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Supprime
 */
@WebServlet("/supprime")
public class Supprime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Supprime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession session = request.getSession( true );
		String email = (String) session.getAttribute("email");
		String nom = (String) session.getAttribute("nom");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/login";
		String loginDB = "root";
		String passwordDB = "";
		
		try (Connection cnx = DriverManager.getConnection(url, loginDB, passwordDB)) {

//			String strSqlUpdate = "INSERT INTO users ( Nom,  email, password) VALUES ('"+nom+"', '"+email+"', '"+password+"');";
			String strSqldelete = "DELETE FROM users WHERE email='"+email+"' ;";
			try(	Statement statement = cnx.createStatement() ) {
				statement.executeUpdate(strSqldelete);
				session.setAttribute( "errorLogin", "" );
				System.out.println(nom +" est bien supprimé");
				request.getRequestDispatcher( "/Login.jsp" ).forward( request, response );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	
	
	}

}
