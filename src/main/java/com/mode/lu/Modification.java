package com.mode.lu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mode.entities.Commande;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/modif")
public class Modification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Modification() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "/WEB-INF/modif.jsp" ).forward( request, response );
	}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter( "nom" );
		String prenom = request.getParameter( "prenom" );
		String password = request.getParameter( "password" );
		String age = request.getParameter( "age" );
		int ageInt = Integer.parseInt(age);
		
		
		HttpSession session = request.getSession( true );
		int idClient = (int) session.getAttribute("id");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/clientcommande";
		String loginDB = "root";
		String passwordDB = "";
		
		try (Connection cnx = DriverManager.getConnection(url, loginDB, passwordDB)) {

			String strSqlUpdate = "UPDATE client SET nom='"+nom+"', prenom = '"+prenom+"', age = "+ ageInt +" , password = '"+password+"' WHERE client.id_client =" +idClient;
			try(	Statement statement = cnx.createStatement() ) {
				statement.executeUpdate(strSqlUpdate);
				session.setAttribute( "nom", nom );
				session.setAttribute( "prenom", prenom );
				session.setAttribute( "password", password );
				session.setAttribute( "age", ageInt );

				session.setAttribute( "msgInfo", "Je viens juste de modifier mes coordonnées" );

				request.getRequestDispatcher( "/WEB-INF/ConnectedAndCmds.jsp" ).forward( request, response );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	
	
	}

}
