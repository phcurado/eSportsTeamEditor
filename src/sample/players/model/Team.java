package sample.players.model;

/**
 * Created by Paulo on 10/10/2016.
 */
public class Team {
    /*  Basic information   */
    private String id;
    private String name;
    private String abbreviatedName;
    private long budget;
    private String[] playersId;
    private int tier;

    public Team() {
        playersId = new String[6];
    }

    public Team(String name, String abbreviatedName, long budget, int tier) {
        this.name = name;
        this.abbreviatedName = abbreviatedName;
        this.budget = budget;
        this.tier = tier;
        playersId = new String[6];
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviatedName() {
        return abbreviatedName;
    }

    public void setAbbreviatedName(String abbreviatedName) {
        this.abbreviatedName = abbreviatedName;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public String[] getPlayersId() {
        return playersId;
    }

    public void setPlayersId(String[] playersId) {
        this.playersId = playersId;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
