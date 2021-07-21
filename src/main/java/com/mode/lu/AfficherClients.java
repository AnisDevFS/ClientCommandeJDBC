package com.mode.lu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mode.entities.Client;
import com.mode.entities.Commande;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AfficherClients
 */
@WebServlet("/clients")
public class AfficherClients extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AfficherClients() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Afficher les autres et pas le client connecté
		HttpSession session = request.getSession( true );
		
//		Client connectedClient = new Client((int) session.getAttribute("id") , 
//				(String) session.getAttribute("nom"),
//				(String) session.getAttribute("prenom"), (String) session.getAttribute("password"),
//				(int) session.getAttribute("age") , (String) session.getAttribute("admin"));
//		
//		session.setAttribute( "connectedClient", connectedClient );
		ArrayList<Client> clients = new ArrayList<Client>();
		
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

					Client cl = new Client(rsId, rsNom, rsPrenom, rsPassword, rsAge, rsAdmin);
					clients.add(cl);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("clients", clients);
		request.getRequestDispatcher("/WEB-INF/clients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
