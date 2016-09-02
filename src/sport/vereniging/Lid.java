package sport.vereniging;

import java.util.Date;

public class Lid {
    private String spelerscode, roepnaam, 
        tussenvoegsels, achternaam, email, teamcode, adres, postcode, woonplaats;
    
    private Date datum;
    
    //lege constructor
    public Lid() {
        this.spelerscode = "";
        this.roepnaam = "";
        this.tussenvoegsels = "";
        this.achternaam = "";
        this.email = "";
        this.datum = new Date();
        this.teamcode = "";
        this.adres = "";
        this.postcode = "";
        this.woonplaats = "";
        		}

    /**
     * constructor maakt lid-object
     * @param roepnaam
     * @param tussenvoegsels
     * @param achternaam
     * @param email
     */
    public Lid (String roepnaam,
                String tussenvoegsels, 
                String achternaam,
                String email, Date datum, String adres,
                String postcode, String woonplaats) {
        
        this.roepnaam = roepnaam;
        this.tussenvoegsels = tussenvoegsels;
        this.achternaam = achternaam;
        this.email = email;
        this.spelerscode = email;  
        this.datum = datum;
        this.adres = adres;
        this.postcode = postcode;
        this.woonplaats = woonplaats;
        this.teamcode = "";
    }
    
    public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	/********* GETTERS EN SETTERS ************/
    
    public String getSpelerscode() {
        return spelerscode;
    }
    
    public void setSpelerscode(String spelerscode) {
        this.spelerscode = spelerscode;
    }
    
    public String getRoepnaam() {
        return roepnaam;
    }

    public void setRoepnaam(String roepnaam) {
        this.roepnaam = roepnaam;
    }

    public String getTussenvoegsels() {
        return tussenvoegsels;
    }

    public void setTussenvoegsels(String tussenvoegsels) {
        this.tussenvoegsels = tussenvoegsels;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }
    
    public String getEmail() {
    	return email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public String getTeamcode() {
		return teamcode;
	}

	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}
	public String getAdres() {
	    	return adres;
	}
	    
	public void setAdres(String adres) {
	    	this.adres = adres;
	}
	public String getPostcode() {
	    	return postcode;
	}
	    
    public void setPostcode(String postcode) {
	    	this.postcode = postcode;
	}
    public String getWoonplaats() {
    	return woonplaats;
    }
    
    public void setWoonplaats(String woonplaats) {
    	this.woonplaats = woonplaats;
    }    
    /**
     *@return samengevoegde naam
     *
     */
    public String getNaam() {
        String naam;
        if (tussenvoegsels.equals("")) {
            naam = roepnaam + " " + achternaam;
        } else {
            naam = roepnaam + " " + tussenvoegsels + " " + achternaam;
        }
        return naam;
    }
}