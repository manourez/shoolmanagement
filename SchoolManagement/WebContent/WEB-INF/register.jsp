<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ !empty erreur }"><p style="color:red;"><c:out value="${ erreur }" /></p></c:if>
	<form method="post" action="index">
    	<p>
	    	<label for="nom">Nom : </label>
	    	<input type="text" name="nom" id="nom" />
    	</p>
    	<p>
	    	<label for="prenom">Prenoms : </label>
	    	<input type="text" name="prenom" id="prenom" />
    	</p>
    	<p>
	    	<label for="password">Password : </label>
	    	<input type="password" name="password" id="password" />
    	</p>
    	<p>
    		Veuillez indiquer votre fonction :<br />
	       <input type="radio" name="fonction" value="Administrateur" id="Administrateur" /> <label for="Administrateur">Administrateur</label>
	       <input type="radio" name="fonction" value="Etudiant" id="Etudiant" /> <label for="Etudiant">Etudiant</label><br />
	       <input type="radio" name="fonction" value="Professeur" id="Professeur" /> <label for="Professeur">Professeur</label><br />
    	</p>
    	<input type="submit" />
    </form>
</body>
</html>