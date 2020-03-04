<%@ include file="header.jsp" %>
	<ul>
        <c:forEach var="etudiant" items="${ etudiants }">
        	<c:if test="${ etudiant.fonction == 'Professeur' }">
            <li>
            	<c:out value="${ etudiant.prenom }" /> <c:out value="${ etudiant.nom }" />   
				<form method="post" action="modifierEtudiant">
					<input type="hidden" name="id" value="${ etudiant.numero }">
					<button class="btn btn-primary" type="submit">Modifier</button>
				</form>
				<form method="post" action="etudiant">
					<input type="hidden" name="id" value="${ etudiant.numero }">
					<button class="btn btn-danger" type="submit">Supprimer</button>
				</form>				
			</li>
        	</c:if>
        
        </c:forEach>
    </ul> 
<%@ include file="footer.jsp" %>