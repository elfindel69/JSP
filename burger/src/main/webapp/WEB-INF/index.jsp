<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Burger World</title>
	</head>
	<body>
		<form action="commande" method="post">
			<div>
				<input type="radio" name="lieu" id="place" value="true">
	        	<label for="place">Sur place</label>
	        	<input type="radio" name="lieu" id="emporter" value="false">
	        	<label for="emporter">A emporter</label>
			</div>
			 <div>
	            <label for="burger">Votre Burger </label>
	            <select name="burger">
	                <c:forEach var="burger" items="${burgers}">
	                        <option value="${burger.id}">${burger.nom} (${burger.prix} Euros)</option>
	                </c:forEach>
	            </select>
	        </div>
	       <div>
	            <label for="accompagnement">Vos Accompagnements </label>
	            <select name="accompagnement">
	                <c:forEach var="accompagnement" items="${accompagnements}">
	                        <option value="${accompagnement.id}">${accompagnement.nom} (${accompagnement.prix} Euros)</option>
	                </c:forEach>
	            </select>
	        </div>
	        <div>
	            <label for="boisson">Vos Boissons </label>
	            <select name="boisson">
	                <c:forEach var="boisson" items="${boissons}">
	                        <option value="${boisson.id}">${boisson.nom} (${boisson.prix} Euros)</option> 
	                </c:forEach>
	            </select>
	        </div>
	        <div>
	            <p>Vos sauces: </p>
	           
	            <c:forEach var="sauce" items="${sauces}">
	            		<label for="${sauce.nom}">${sauce.nom} </label>
	                    <input value="${sauce.id}" name="sauce_id" type="checkbox">
	            </c:forEach>
	        </div>
	        <div>
	        	<label for="remarques">Vos remarques</label>
	        	<textarea name="remarques" id="remarques" rows="10" cols="20"></textarea>
	        </div>
	        <div>
	        	<label for="card">Numéro de carte</label>
	       		<input type="text" name="card">
	       		<br>
	       		<p>date d'expiration</p>
	       		<label for="mois">mois</label>
				<select name="mois">
	                <c:forEach var="item" items="${mois}">
	                        <option value="${item}">${item}</option> 
	                </c:forEach>
	            </select>
	            <br>	
	            <label for="annee">année</label>
				<select name="annee">
	                <c:forEach var="annee" items="${annees}">
	                        <option value="${annee}">${annee}</option> 
	                </c:forEach>
	            </select>  
				<br>
			    <label for="code">code CVV</label>
	       		<input type="text" name="code">
	        </div>
	        <input type="submit" value="envoyer">
		</form>
	       
	</body>
</html>