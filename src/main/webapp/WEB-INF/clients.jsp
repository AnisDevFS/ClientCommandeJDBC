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
</head>
<body>
	<div class="container">
		<h2> Afficher les autres et pas le client connecté</h2>
	
	
	
			<table>
		    <thead>
		        <tr>
		            <th>Id</th>
		            <th>Nom</th>
		            <th>Prenom</th>
		            <th>Age</th>
		        </tr>
		    </thead>
		    <tbody>

		    	<c:forEach var= "cl" items = "${clients}">
				
					<c:if test="${id != cl.id_client}">
					
						<tr><td> ${ ( admin == "admin" ) ? cl.id_client : (cl.admin == "user") ? cl.id_client : "" } </td>
						<td> ${ ( admin == "admin" ) ? cl.nom : (cl.admin == "user") ? cl.nom : ""  } </td>
						<td> ${ ( admin == "admin" ) ? cl.prenom : (cl.admin == "user") ? cl.prenom : ""  } </td>
						<td> ${ ( admin == "admin" ) ? cl.age : (cl.admin == "user") ? cl.age : ""  } </td>
						</tr>
					</c:if>

				</c:forEach>

<%-- 		    <c:if test="${admin == 'admin'}">
		    	<c:forEach var= "cl" items = "${clients}">
				
					<c:if test="${id != cl.id_client}">
					
						<tr><td> <c:out value = "${cl.id_client }"/> </td>
						<td> <c:out value = "${cl.nom }"/> </td>
						<td> <c:out value = "${cl.prenom }"/> </td>
						<td> <c:out value = "${cl.age }"/> </td>
						</tr>
					</c:if>

				</c:forEach>
		    </c:if> --%>

			
	</tbody></table>
</div>
</body>
</html>