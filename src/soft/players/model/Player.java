package soft.players.model;

/**
 * Created by Paulo on 10/10/2016.
 */
public class Player {
    /*  Personal information    */
    private String id;
    private String firstName;
    private String lastName;
    private String nickName;
    private int age;
    private int rank; //similar to ELO/MMR
    /*  Team information  */
    private int value;
    private int salary;
    private int popularity;
    private String teamId;
    /*  Technique   */
    private int farm;
    private int push;
    private int support;
    private int rotation;
    private int fighting;
    private int positioning;
    private int mapAwareness;
    private int aggression;
    private int potential;
    /*  Personal Behavior   ps: some are hidden from the user*/
    private int happiness;
    private int reflex;
    private int decisionMaking;
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
    }

    public Player(String nickName, int value, int salary, int farm, int push, int support, int rotation, int fighting, int positioning, int mapAwareness, int aggression, int reflex, int decisionMaking) {
        this.nickName = nickName;
        this.value = value;
        this.salary = salary;
        this.farm = farm;
        this.push = push;
        this.support = support;
        this.rotation = rotation;
        this.fighting = fighting;
        this.positioning = positioning;
        this.mapAwareness = mapAwareness;
        this.aggression = aggression;
        this.reflex = reflex;
        this.decisionMaking = decisionMaking;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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

    public int getPush() {
        return push;
    }

    public void setPush(int push) {
        this.push = push;
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

    public int getFighting() {
        return fighting;
    }

    public void setFighting(int fighting) {
        this.fighting = fighting;
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
}
