<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sport.vereniging.*" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="data.SportIO" %>
    <%SportIO io = new SportIO(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>team</title>
</head>
<body>
<% 
if (request.getAttribute("team") == null) {
    response.sendRedirect("/sport?teams");
} else {  
     Team team = (Team) request.getAttribute("team");
%> 
<form action="/sport"  method="get">
    <input type="text" 
       name="teamnaam" 
       value="<%= team.getTeamnaam() %>">(teamnaam)<br>
    <input type="text" 
       name="teamcode" 
       value="<%= team.getTeamcode() %>">(teamcode)<br>
	<select name="spelerscode">
		<option></option>
		<%for (Lid lid : io.getAlleLeden()) { %>
			<option value = "<%= lid.getSpelerscode() %>" ><%=lid.getNaam() %></option>
		<%} %>
	</select>
       <input type="submit" 
       name="wijzig_team_knop" 
       value="wijzig">
    <input type="submit" 
       name="verwijder_team_knop" 
       value="verwijder">
</form>
<h1>Spelerlijst</h1>
	<%for (Lid lid : io.getAlleLeden()) {
		try {
		if (lid.getTeamcode().equalsIgnoreCase(team.getTeamcode())){%>
			<p> <%=lid.getNaam() %></p>
		<%}}catch (NullPointerException e){} }%>

<% } %>
</body>
</html>