
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover:not(.active) {
    background-color: #111;
}

.active {
    background-color: #4CAF50;
}
</style>
<ul>
  <li><a href="home.html">Home</a></li>
  <li><a href="index.jsp">Lid Toevoegen</a></li>
  <li><a href="toevoeg_team.html">Team Toevoegen</a></li>
  <li><a href="overzicht_teams.jsp">Overzicht Teams</a></li>
</ul>
</head>
<body>
<%@ page import="sport.vereniging.*" %>
<%@ page import="java.util.ArrayList" %>

<%
if (request.getAttribute("leden") == null) {
    response.sendRedirect("/sport?leden");
} else { 
     ArrayList<Lid> leden = (ArrayList<Lid>) request.getAttribute("leden");
%>

<h1>Ledenoverzicht</h1>
<%  for (Lid lid: leden) { %>
        <%= lid.getNaam() %>
        <a href="/sport?haal_lid=ok&lid=ok&spelerscode=<%= lid.getSpelerscode() %>">naar lid</a><br>
        
<%  }
}   %>

</body>
</html>