<%@page import="com.mode.entities.Commande"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commandes</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<br>
		<h1>c'est moi ${ nom} - Mes commandes</h1>
		<br>
		<h3 class="text-danger">${ msgInfo }</h3>
		<br>
		
		<table>
		    <thead>
		        <tr>
		            <th>Produit</th>
		            <th>Nombre</th>
		            <th>Prix en €</th>
		            <th>Date de commande</th>
		            <th>Action</th>
		        </tr>
		    </thead>
		    <tbody>


		<%
			ArrayList<Commande> cmds = (ArrayList<Commande>) session.getAttribute("cmds");
		
			for (Commande c : cmds) {
				out.print("<tr><td>" + c.getProduit() + "</td>") ;
				out.print("<td>" + c.getNombre() + "</td>") ;
				out.print("<td>" + c.getPrix() + "</td>") ;
				out.print("<td>" + c.getDate() + "</td>") ;
				out.print("<td><a class=\"btn btn-danger\" href=\"supprime?idCmd="+ c.getId_commande()+ "\">Supprimer</a></td></tr>") ;
			}
		%>
		
				    </tbody>
		</table>
		<br>
		<a class="btn btn-info" href="modif">Modifier mes coordonnées</a>
		
	</div>
	


</body>
</html>