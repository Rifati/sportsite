package control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.Date;

import data.SportIO;
import sport.vereniging.Lid;
import sport.vereniging.Team;

@SuppressWarnings("serial")
public class SportServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SportIO io = new SportIO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		if (req.getParameter("verzend_nieuw_lid_knop") != null) {
			String roepnaam = req.getParameter("roepnaam");
			String tussenvoegsels = req.getParameter("tussenvoegsels");
			String achternaam = req.getParameter("achternaam");
			String email = req.getParameter("email");
			try {
				date = sdf.parse(req.getParameter("datum"));
			} catch (ParseException e) {
				date = new Date();
			}
			Lid lid = new Lid(roepnaam, tussenvoegsels, achternaam, email, date);
			io.voegLidToe(lid);
			resp.sendRedirect("/index.html");
		} else if (req.getParameter("wijzig_lid_knop") != null) {
			try {
				String roepnaam = req.getParameter("roepnaam");
				String tussenvoegsels = req.getParameter("tussenvoegsels");
				String achternaam = req.getParameter("achternaam");
				String email = req.getParameter("email");
				date = sdf.parse(req.getParameter("datum"));
				Lid lid = new Lid(roepnaam, tussenvoegsels, achternaam, email, date);
				io.verwijderLid(req.getParameter("spelerscode"));
				io.wijzigLid(lid);
				resp.sendRedirect("/overzicht_leden.jsp");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (req.getParameter("verwijder_lid_knop") != null) {
			String spelerscode = req.getParameter("spelerscode");
			io.verwijderLid(spelerscode);
			resp.sendRedirect("/overzicht_leden.jsp");
		} else if (req.getParameter("haal_lid") != null) {
			String spelerscode = req.getParameter("spelerscode");
			Lid lid = io.getLid(spelerscode);
			req.setAttribute("lid", lid);
			RequestDispatcher disp = req.getRequestDispatcher("/lid.jsp");
			disp.forward(req, resp);
		} else if (req.getParameter("leden") != null) {
			ArrayList<Lid> leden = io.getAlleLeden();
			req.setAttribute("leden", leden);
			RequestDispatcher disp = req.getRequestDispatcher("/overzicht_leden.jsp");
			disp.forward(req, resp);
		} else if (req.getParameter("teams") != null) {
			ArrayList<Team> teams = io.getAlleTeams();
			req.setAttribute("teams", teams);
			RequestDispatcher disp = req.getRequestDispatcher("/overzicht_teams.jsp");
			disp.forward(req, resp);
		}else if (req.getParameter("haal_team") != null) {
			String teamcode = req.getParameter("teamcode");
			Team team = io.getTeam(teamcode);
			req.setAttribute("team", team);
			RequestDispatcher disp = req.getRequestDispatcher("/team.jsp");
			disp.forward(req, resp);
		}else if (req.getParameter("verzend_nieuw_team_knop") != null) {
			String teamnaam = req.getParameter("teamnaam");
			String teamcode = req.getParameter("teamcode");
			Team team = new Team(teamcode, teamnaam);
			io.voegTeamToe(team);
			resp.sendRedirect("/toevoeg_team.html");
		}else if (req.getParameter("wijzig_team_knop") != null) {
				String teamnaam = req.getParameter("teamnaam");
				String teamcode = req.getParameter("teamcode");
				Team team = new Team(teamcode, teamnaam);
				io.verwijderTeam(req.getParameter("teamcode"));
				io.wijzigTeam(team);
				resp.sendRedirect("/overzicht_teams.jsp");
			
		} else if (req.getParameter("verwijder_team_knop") != null) {
			String teamcode = req.getParameter("teamcode");
			io.verwijderTeam(teamcode);
			resp.sendRedirect("/overzicht_teams.jsp");
	}
}
}
