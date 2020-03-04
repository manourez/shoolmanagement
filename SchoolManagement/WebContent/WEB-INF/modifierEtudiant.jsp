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
	<form method="post" action="modifierEtudiant">
		<input type="hidden" name="id" value="${ etudiant.numero }">
    	<p>
	    	<label for="nom">Nom : </label>
	    	<input type="text" name="nom" id="nom" value="${ etudiant.nom }" />
    	</p>
    	<p>
	    	<label for="prenom">Prenoms : </label>
	    	<input type="text" name="prenom" id="prenom" value="${ etudiant.prenom }" />
    	</p>
    	<p>
	    	<label for="password">Password : </label>
	    	<input type="password" name="password" id="password" value="${ etudiant.password }" />
    	</p>
    	<p>
    		Veuillez indiquer votre fonction :<br />
	       <input type="radio" name="fonction" value="Administrateur" id="Administrateur" /> <label for="Administrateur">Administrateur</label>
	       <input type="radio" name="fonction" value="Etudiant" id="Etudiant" /> <label for="Etudiant">Etudiant</label><br />
	       <input type="radio" name="fonction" value="Professeur" id="Professeur" /> <label for="Professeur">Professeur</label><br />
    	</p>
    	<input type="submit" />
    </form>
    
    <a href="/SchoolManagement/etudiant"> &lt;back</a>
</body>
</html>