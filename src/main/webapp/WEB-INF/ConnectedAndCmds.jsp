<%@page import="com.mode.entities.Commande"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Commandes</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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


<%-- 		<%
			ArrayList<Commande> cmds = (ArrayList<Commande>) session.getAttribute("cmds");
		
			for (Commande c : cmds) {
				out.print("<tr><td>" + c.getProduit() + "</td>") ;
				out.print("<td>" + c.getNombre() + "</td>") ;
				out.print("<td>" + c.getPrix() + "</td>") ;
				out.print("<td>" + c.getDate() + "</td>") ;
				out.print("<td><a class=\"btn btn-danger\" href=\"supprime?idCmd="+ c.getId_commande()+ "\">Supprimer</a></td></tr>") ;
			}
		%> --%>
		<!-- version JSTL -->
		<c:forEach var= "cmd" items = "${cmds}">
			
				<tr><td> <c:out value = "${cmd.produit }"/> </td>
				<td> <c:out value = "${cmd.nombre }"/> </td>
				<td> <c:out value = "${cmd.prix }"/> </td>
				<td> <c:out value = "${cmd.date }"/> </td>
				<td><a class="btn btn-danger" href="supprime?idCmd=${cmd.id_commande }"><i class="far fa-trash-alt"></i></a></td></tr>
			
		</c:forEach>
		
			</tbody>
		</table>
		<br>
		<a class="btn btn-info" href="modif">Modifier mes coordonnées</a><br><br>
 		  <c:set var = "cmdss" scope = "session" value = "${cmds}"/>
 			  <c:forEach var = "i" begin = "1" end = "5">
		         Item <c:out value = "${i}"/>
		      </c:forEach>
		      <c:forEach var= "cmd" items = "${cmds}">
		          <c:out value = "${cmd.produit }"/>
		          <c:out value = "${cmd.nombre }"/>
		          <br><small>pop</small>
		      </c:forEach>
		      <c:out value = "${cmdss.size() }"/>
		      <c:out value = "${nom }"/>
	</div>
	
	     <c:set var = "salary" scope = "session" value = "2000"/>
	     
      <c:if test = "${salary >= 10000}">
         <h2>My salary is:  <c:out value = "${salary}" default="inferieur à 2000€"/><h2>
      </c:if>
 
	<c:choose>
	  <c:when test="${'Mr' == 'Mrg'}">
	    <p>Bonjour Monsieur</p>
	  </c:when>
	  <c:when test="${'Mr' == 'Mre'}">
	    Bonjour Madame
	  </c:when>
	  <c:when test="${'Mr' == 'Mrx'}">
	    Bonjour Mademoiselle
	  </c:when>
	  <c:otherwise>
	    Bonjour
	  </c:otherwise>
	</c:choose>


</body>
</html>