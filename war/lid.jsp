<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="sport.vereniging.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="data.SportIO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lid overzicht</title>
</head>
<body>
<% 
if (request.getAttribute("lid") == null) {
    response.sendRedirect("/sport?leden");
} else {
	 SportIO io = new SportIO();
     Lid lid = (Lid) request.getAttribute("lid");
     SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
%> 
<form action="/sport"  method="get">
    <input type="text" 
       name="roepnaam" 
       value="<%= lid.getRoepnaam() %>">(roepnaam)<br>
    <input type="text" 
       name="tussenvoegsels" 
       value="<%= lid.getTussenvoegsels() %>">(tussenvoegsels)<br>
    <input type="text" 
       name="achternaam" 
       value="<%= lid.getAchternaam() %>">(achternaam)<br>
    <input type="text" 
       name="email" 
       value="<%= lid.getEmail() %>">(email)<br>
    <input type="text" 
       name="adres" 
       value="<%= lid.getAdres() %>">(adres)<br>
    <input type="text" 
       name="postcode" 
       value="<%= lid.getPostcode() %>">(postcode)<br>
    <input type="text" 
       name="adres" 
       value="<%= lid.getWoonplaats() %>">(woonplaats)<br>
    <input type="hidden" 
       name="spelerscode" 
       value="<%= lid.getSpelerscode() %>">
    <input type="submit" 
       name="wijzig_lid_knop" 
       value="wijzig">
    <input type="submit" 
       name="verwijder_lid_knop" 
       value="verwijder">
    <input type="text" name="datum" value="<%=sdf.format(lid.getDatum()) %>">
    <%try { %>
    <p>Team: <%= io.getTeam(lid.getTeamcode()).getTeamnaam() %></p>
    <%} catch (Exception e){}%>
       
</form>
<% } %>

</body>
</html>