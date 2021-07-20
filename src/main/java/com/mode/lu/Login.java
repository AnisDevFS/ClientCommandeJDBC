package com.mode.lu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		HttpSession session = request.getSession( true );
		String nom = ""; String password = "";
		
		if (request.getParameter( "nom" ) == null) 
			nom = (String) session.getAttribute("nom");
		else 
			nom = request.getParameter( "nom" );
		
		if (request.getParameter( "password" ) == null) 
			password = (String) session.getAttribute("password");
		else 
			password = request.getParameter( "password" );
		System.out.println(nom + password);
		int idClient = 0;
		ArrayList<Commande> cmds = new ArrayList<Commande>();
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

					int rsId = rs.getInt("id_client");
					String rsPassword = rs.getString("password");
					String rsNom = rs.getString("nom");
					String rsPrenom = rs.getString("prenom");
					String rsAdmin = rs.getString("admin");
					int rsAge = rs.getInt("age");

					if ( rsNom.equals(nom) && rsPassword.equals(password)) {
						session.setAttribute( "admin", rsAdmin );
						session.setAttribute( "password", rsPassword );
						session.setAttribute( "id", rsId );
						idClient = rsId;
						session.setAttribute( "nom", rsNom );
						session.setAttribute( "age", rsAge );
						session.setAttribute( "prenom", rsPrenom );
						session.setAttribute( "msgInfo", "Je viens juste de me connecter" );
						Goodcnx = true;
						break;
					}
					
				}
			}
			if (Goodcnx) {
				try( Statement statement1 = cnx.createStatement() ) {
					String sqlCmds = "SELECT * FROM cmd WHERE id_client = "+idClient ;
					ResultSet rs1 = statement1.executeQuery(sqlCmds);
					while (rs1.next()) {
						
						Commande c = new Commande(rs1.getInt("id_commande"), rs1.getInt("id_client"), rs1.getString("produit"), rs1.getInt("nombre"), rs1.getInt("prix"), rs1.getDate("date"));
						
						cmds.add(c);
						
					}
					session.setAttribute( "cmds", cmds );
				}
				request.getRequestDispatcher( "/WEB-INF/ConnectedAndCmds.jsp" ).forward( request, response );
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
