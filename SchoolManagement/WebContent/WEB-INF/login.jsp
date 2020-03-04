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
	    	<label for="password">Password : </label>
	    	<input type="password" name="password" id="password" />
    	</p>  	
    	<input type="submit" />
    </form>
</body>
</html>