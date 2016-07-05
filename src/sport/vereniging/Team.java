package sport.vereniging;

import java.util.ArrayList;

public class Team {
private String teamcode, teamnaam;
private ArrayList ledenlijst;

public Team() {
    this.teamcode = "";
    this.teamnaam = "";
}

public Team(String teamcode, String teamnaam){
	this.teamcode = teamcode;
	this.teamnaam = teamnaam;
}
public String getTeamcode(){
	return teamcode;
}
public String getTeamnaam(){
	return teamnaam;
}
public void setTeamcode(String teamcode){
	this.teamcode = teamcode;
}
public void setTeamnaam(String teamnaam){
	this.teamnaam = teamnaam;


}
}