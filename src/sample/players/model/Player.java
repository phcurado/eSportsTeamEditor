package sample.players.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Paulo on 10/10/2016.
 */
public class Player {
    /*  Personal information    */
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String birthDay;
    private int rank; //similar to ELO/MMR
    /*  Team information  */
    private int popularity;
    private String teamId;
    /*  Technique   */
    private int farm;
    private int independency;
    private int fighting;
    private int support;
    private int rotation;
    private int positioning;
    private int mapAwareness;
    private int aggression;
    private int reflex;
    private int decisionMaking;
    private int potential;
    /*  Personal Behavior   ps: some are hidden from the user*/
    private int happiness;
    private int intelligence;
    private int concentration;
    private int leadership;
    private int rage;
    /*  Appearance   */
    private int hairType;
    private int hairColor;
    private int faceType;
    private int faceColor;
    private int shirtType;
    private int shirtColor;
    private int pantsType;
    private int pantsColor;

    public Player() {
        this.firstName = "";
        this.lastName = "";
        this.nickName = "";
        this.birthDay = "0/0/0";
    }


    public Player(String firstName, String lastName, String nickName, String birthDay, int rank, int popularity, int farm, int independency, int fighting, int support, int rotation, int positioning, int mapAwareness, int aggression, int reflex, int decisionMaking, int potential, int happiness, int intelligence, int concentration, int leadership, int rage, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.birthDay = birthDay;
        this.rank = rank;
        this.popularity = popularity;
        this.farm = farm;
        this.independency = independency;
        this.fighting = fighting;
        this.support = support;
        this.rotation = rotation;
        this.positioning = positioning;
        this.mapAwareness = mapAwareness;
        this.aggression = aggression;
        this.reflex = reflex;
        this.decisionMaking = decisionMaking;
        this.potential = potential;
        this.happiness = happiness;
        this.intelligence = intelligence;
        this.concentration = concentration;
        this.leadership = leadership;
        this.rage = rage;
        this.id = ID;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public int getIndependency() {
        return independency;
    }

    public void setIndependency(int independency) {
        this.independency = independency;
    }

    public int getFighting() {
        return fighting;
    }

    public void setFighting(int fighting) {
        this.fighting = fighting;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int getPositioning() {
        return positioning;
    }

    public void setPositioning(int positioning) {
        this.positioning = positioning;
    }

    public int getMapAwareness() {
        return mapAwareness;
    }

    public void setMapAwareness(int mapAwareness) {
        this.mapAwareness = mapAwareness;
    }

    public int getAggression() {
        return aggression;
    }

    public void setAggression(int aggression) {
        this.aggression = aggression;
    }

    public int getReflex() {
        return reflex;
    }

    public void setReflex(int reflex) {
        this.reflex = reflex;
    }

    public int getDecisionMaking() {
        return decisionMaking;
    }

    public void setDecisionMaking(int decisionMaking) {
        this.decisionMaking = decisionMaking;
    }

    public int getPotential() {
        return potential;
    }

    public void setPotential(int potential) {
        this.potential = potential;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getLeadership() {
        return leadership;
    }

    public void setLeadership(int leadership) {
        this.leadership = leadership;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public int getHairType() {
        return hairType;
    }

    public void setHairType(int hairType) {
        this.hairType = hairType;
    }

    public int getHairColor() {
        return hairColor;
    }

    public void setHairColor(int hairColor) {
        this.hairColor = hairColor;
    }

    public int getFaceType() {
        return faceType;
    }

    public void setFaceType(int faceType) {
        this.faceType = faceType;
    }

    public int getFaceColor() {
        return faceColor;
    }

    public void setFaceColor(int faceColor) {
        this.faceColor = faceColor;
    }

    public int getShirtType() {
        return shirtType;
    }

    public void setShirtType(int shirtType) {
        this.shirtType = shirtType;
    }

    public int getShirtColor() {
        return shirtColor;
    }

    public void setShirtColor(int shirtColor) {
        this.shirtColor = shirtColor;
    }

    public int getPantsType() {
        return pantsType;
    }

    public void setPantsType(int pantsType) {
        this.pantsType = pantsType;
    }

    public int getPantsColor() {
        return pantsColor;
    }

    public void setPantsColor(int pantsColor) {
        this.pantsColor = pantsColor;
    }

    public int getAge() {
        int day;
        int month;
        int year;
        int age;
        String[] parts = birthDay.split("/");

        day = Integer.parseInt(parts[0]);
        month = Integer.parseInt(parts[1]);
        year = Integer.parseInt(parts[2]);

        Calendar cal = Calendar.getInstance();
        age = cal.get(Calendar.YEAR) - year;
        if( cal.get(Calendar.DAY_OF_MONTH) - day < 0)
            month++;
        if( cal.get(Calendar.MONTH)+1 - month < 0)
            age--;

        return age;
    }
}
