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
  <li><a href="index.html">Lid Toevoegen</a></li>
  <li><a href="toevoeg_team.html">Team Toevoegen</a></li>
  <li><a href="overzicht_leden.jsp">Overzicht leden</a></li>
</ul>
</head>
<body>
<%@ page import="sport.vereniging.*" %>
<%@ page import="java.util.ArrayList" %>

<%
if (request.getAttribute("teams") == null) {
    response.sendRedirect("/sport?teams");
} else { 
    ArrayList<Team> teams = (ArrayList<Team>) request.getAttribute("teams");

%>
<h1>Teamsoverzicht</h1>
<%  for (Team team: teams) { %>
        <%= team.getTeamnaam() %>
        <a href="/sport?haal_team=ok&team=ok&teamcode=<%= team.getTeamcode() %>">naar Team</a><br>
        
<%  }
}   %>

</body>
</html>