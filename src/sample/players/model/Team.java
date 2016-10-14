package sample.players.model;

/**
 * Created by Paulo on 10/10/2016.
 */
public class Team {
    /*  Basic information   */
    private String id;
    private String name;
    private String abbreviatedName;
    private int budget;
    private String[] playersId;
    private int tier;

    public Team() {
        playersId = new String[5];
    }
}
