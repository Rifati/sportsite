package data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;

import sport.vereniging.Team;
import sport.vereniging.Lid;

 
public class SportIO {
    private DatastoreService datastore;
	
    //constructor
    public SportIO() {
        datastore = DatastoreServiceFactory.getDatastoreService();
    }
    
    //methode om lid toe te voegen
    public void voegLidToe(Lid lid) {
        //Maak entity mbv tabelnaam en unieke sleutel
        Entity ent = new Entity("Lid", lid.getSpelerscode());
        ent.setProperty("roepnaam", lid.getRoepnaam());
        ent.setProperty("tussenvoegsels", lid.getTussenvoegsels());
        ent.setProperty("achternaam", lid.getAchternaam());
        ent.setProperty("email", lid.getEmail());
        ent.setProperty("spelerscode", lid.getSpelerscode());
        ent.setProperty("datum", lid.getDatum());
        
        datastore.put(ent);
    }
    public void voegTeamToe(Team team) {
        //Maak entity mbv tabelnaam en unieke sleutel
        Entity ent = new Entity("Team", team.getTeamcode());
        ent.setProperty("teamnaam", team.getTeamnaam());
        ent.setProperty("teamcode", team.getTeamcode());
        datastore.put(ent);

    public ArrayList<Lid> getAlleLeden() {
        ArrayList<Lid> leden = new ArrayList<Lid>();
        Query q = new Query("Lid");
        PreparedQuery resultaten = datastore.prepare(q);
        for (Entity ent: resultaten.asIterable()) {
            Lid lid = new Lid();
            lid.setRoepnaam( (String) ent.getProperty("roepnaam") );
            lid.setTussenvoegsels( (String) ent.getProperty("tussenvoegsels") );
            lid.setAchternaam( (String) ent.getProperty("achternaam") );
            lid.setEmail( (String) ent.getProperty("email") );
            lid.setSpelerscode( (String) ent.getProperty("spelerscode") );
            try {
				lid.setDatum( new SimpleDateFormat("dd-MM-yyyy").parse((String) ent.getProperty("spelerscode")) );
			} catch (ParseException e) {
				lid.setDatum( new Date());
			}
            leden.add(lid);
        }
        return leden;
    }
    public Lid getLid(String spelerscode)  {
        Lid lid = null;
        Key k = KeyFactory.createKey("Lid", spelerscode);
        try {
            Entity ent = datastore.get(k);
            lid = new Lid();
            lid.setRoepnaam( (String) ent.getProperty("roepnaam") );
            lid.setTussenvoegsels( (String) ent.getProperty("tussenvoegsels") );
            lid.setAchternaam( (String) ent.getProperty("achternaam") );
            lid.setEmail( (String) ent.getProperty("email") );
            lid.setSpelerscode( (String) ent.getProperty("spelerscode") );
            lid.setDatum( (Date) ent.getProperty("datum"));
        } catch (EntityNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return lid;
    }
    public void verwijderLid(String spelerscode) {
        Key k = KeyFactory.createKey("Lid", spelerscode );
        datastore.delete(k);
    }
    public void wijzigLid(Lid lid) {
        this.voegLidToe(lid);
    }
    public void verwijderTeam(String teamcode) {
        Key k = KeyFactory.createKey("Team", teamcode );
        datastore.delete(k);
    }
    public void wijzigTeam(Team team) {
        this.voegTeamToe(team);
    }
	public ArrayList<Team> getAlleTeams() {
		ArrayList<Team> teams = new ArrayList<Team>();
		Query t = new Query("Team");
		PreparedQuery resultaten = datastore.prepare(t);
        for (Entity ent: resultaten.asIterable()) {
            Team team = new Team();
            team.setTeamnaam( (String) ent.getProperty("teamnaam") );
            team.setTeamcode( (String) ent.getProperty("teamcode") );
            teams.add(team);
        }
		return teams;
	}

	public Team getTeam(String teamcode) {
		Team team = null;
        Key k = KeyFactory.createKey("Team", teamcode);
        try {
            Entity ent = datastore.get(k);
            team = new Team();
            team.setTeamnaam( (String) ent.getProperty("teamnaam") );
            team.setTeamcode( (String) ent.getProperty("teamcode") );
	} catch (EntityNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
}
        return team;
	}
}
