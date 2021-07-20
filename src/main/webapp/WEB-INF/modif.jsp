<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modification</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous"></head>
<body>
<div class="container">

<br><br>
<h1>Modifier c'est par ici !</h1><br>
		<form action="modif" method="post">
		  <div class="form-group">
		    <label for="nom">Nom :</label>
		    <input type="text" name="nom" value="${nom }" class="form-control" id="nom" >
		  </div>
		  <div class="form-group">
		    <label for="prenom">Prenom :</label>
		    <input type="text" name="prenom" value="${prenom }" class="form-control" id="prenom">
		  </div>
		  <div class="form-group">
		    <label for="age">Age :</label>
		    <input type="number" name="age" value="${age }" class="form-control" id="age">
		  </div>
		  <div class="form-group">
		    <label for="password">Password :</label>
		    <input type="text" name="password" value="${password }" class="form-control" id="password">
		  </div>

		  <button type="submit" class="btn btn-info">Valider la modification</button>
<!-- 		  <a class="btn btn-info" href="login">Retour</a> -->
		  
		</form>
		<br>
<%-- 		<small class="text-danger">${ errorLogin }</small>
 --%>		</div>
		
        <br>
        

</body>
</html>