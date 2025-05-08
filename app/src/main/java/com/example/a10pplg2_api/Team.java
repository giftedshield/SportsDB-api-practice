package com.example.a10pplg2_api;

public class Team {
    private String strTeam;
    private String strStadium;

    public Team(String strTeam, String strStadium) {
        this.strTeam = strTeam;
        this.strStadium = strStadium;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }
}
