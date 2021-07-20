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



@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Inscription() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "/WEB-INF/Inscription.jsp" ).forward( request, response );
	}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter( "nom" );
		String prenom = request.getParameter( "prenom" );
		String password = request.getParameter( "password" );
		String age = request.getParameter( "age" );
		int ageInt = Integer.parseInt(age);
		String type = request.getParameter( "type" );
		
		HttpSession session = request.getSession( true );

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/clientcommande";
		String loginDB = "root";
		String passwordDB = "";
		
		try (Connection cnx = DriverManager.getConnection(url, loginDB, passwordDB)) {

			String strSqlUpdate = "INSERT INTO client ( admin, nom,  prenom, age, password) VALUES ('"+type+"', '"+nom+"', '"+prenom+"' ,"+age+" , '"+password+"');";

			try(	Statement statement = cnx.createStatement() ) {
				statement.executeUpdate(strSqlUpdate);
				session.setAttribute( "nom", nom );
				session.setAttribute( "prenom", prenom );
				session.setAttribute( "password", password );
				session.setAttribute( "age", ageInt );
				session.setAttribute( "type", type );
				session.setAttribute( "msgInfo", "Je viens juste de m inscrire" );
//				int id = statement.executeUpdate(strSqlUpdate, Statement.RETURN_GENERATED_KEYS);
				System.out.println(nom +" est bien ajouté avec l'id ");
				request.getRequestDispatcher( "/WEB-INF/ConnectedAndCmds.jsp" ).forward( request, response );
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
	
	
	}

}
