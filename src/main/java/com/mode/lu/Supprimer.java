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
 * Servlet implementation class Supprimer
 */
@WebServlet("/supprime")
public class Supprimer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Supprimer() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idCmdString = request.getParameter("idCmd");
		int idCmd = Integer.parseInt(idCmdString);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/clientcommande";
		String loginDB = "root";
		String passwordDB = "";
		
		try (Connection cnx = DriverManager.getConnection(url, loginDB, passwordDB)) {

			String strSqldelete = "DELETE FROM cmd WHERE id_commande="+idCmd+" ;";
			try(	Statement statement = cnx.createStatement() ) {
				statement.executeUpdate(strSqldelete);
//				request.getRequestDispatcher( "/WEB-INF/ConnectedAndCmds.jsp" ).forward( request, response );
//				response.sendRedirect("supprime");
				Login log = new Login();
				
				log.doPost(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
