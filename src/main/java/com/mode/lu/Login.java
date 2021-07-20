package com.mode.lu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Login() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher( "WEB-INF/Login.jsp" ).forward( request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nom = request.getParameter( "nom" );
		String password = request.getParameter( "password" );

		HttpSession session = request.getSession( true );
		boolean Goodcnx = false;
		String errorLogin = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/clientcommande";
		String loginDB = "root";
		String passwordDB = "";

		try (Connection cnx = DriverManager.getConnection(url, loginDB, passwordDB)) {

			String strSqlSelect = "SELECT * FROM client;";

			try( Statement statement = cnx.createStatement() ) {
				ResultSet rs = statement.executeQuery(strSqlSelect);
				while (rs.next()) {

					String rsId = rs.getString("id_client");
					String rsPassword = rs.getString("password");
					String rsNom = rs.getString("nom");
					String rsPrenom = rs.getString("prenom");
					String rsAdmin = rs.getString("admin");
					int rsAge = rs.getInt("age");

					if ( rsNom.equals(nom) && rsPassword.equals(password)) {
						session.setAttribute( "admin", rsAdmin );
						session.setAttribute( "password", rsPassword );
						session.setAttribute( "id", rsId );
						session.setAttribute( "nom", rsNom );
						session.setAttribute( "age", rsAge );
						session.setAttribute( "prenom", rsPrenom );
						session.setAttribute( "msgInfo", "Je viens juste de me connecter" );
						Goodcnx = true;
						request.getRequestDispatcher( "/WEB-INF/ConnectedAndCmds.jsp" ).forward( request, response );
					}
					
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (Goodcnx == false)	{
			errorLogin = "Login ou Password mauvais ou les 2 :D !";
			session.setAttribute( "errorLogin", errorLogin );
			doGet(request, response);
		}
					
		
	}

}
