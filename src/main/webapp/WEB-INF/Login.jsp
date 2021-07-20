<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous"></head>
<body>
<div class="container">

<br><br>
<h1>Veuillez vous authentifier ou S'inscrire</h1><br>
		<form action="login" method="post">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Nom</label>
		    <input type="text" name="nom" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="text" name="password" class="form-control" id="exampleInputPassword1">
		  </div>

		  <button type="submit" class="btn btn-primary">Se connecter</button>
		  <a class="btn btn-warning" href="inscription">S'inscrire</a>
		  
		</form>
		<br>
		<small class="text-danger">${ errorLogin }</small>
		</div>
		
        <br>
        

</body>
</html>