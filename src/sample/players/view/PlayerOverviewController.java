package sample.players.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.players.model.Player;

import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by Paulo on 12/10/2016.
 */
public class PlayerOverviewController {

    @FXML
    private TableView<Player> playerTable;
    @FXML
    private TableColumn<Player, String> nicknameColumn;
    @FXML
    private TextField firstNameLabel;
    @FXML
    private TextField lastNameLabel;
    @FXML
    private TextField nicknameLabel;
    @FXML
    private TextField birthDayLabel;
    @FXML
    private TextField rankLabel;
    @FXML
    private TextField popularityLabel;
    @FXML
    private TextField farmLabel;
    @FXML
    private TextField independecyLabel;
    @FXML
    private TextField fightingLabel;
    @FXML
    private TextField supportLabel;
    @FXML
    private TextField rotationLabel;
    @FXML
    private TextField positioningLabel;
    @FXML
    private TextField mapAwarenessLabel;
    @FXML
    private TextField aggressionLabel;
    @FXML
    private TextField reflexLabel;
    @FXML
    private TextField decisionMakingLabel;
    @FXML
    private TextField potentialLabel;
    @FXML
    private TextField happinessLabel;
    @FXML
    private TextField intelligenceLabel;
    @FXML
    private TextField concentrationLabel;
    @FXML
    private TextField leadershipLabel;
    @FXML
    private TextField rageLabel;

    //Appearence settings
    @FXML
    private TextField hairTypeLabel;
    @FXML
    private TextField hairColorLabel;
    @FXML
    private TextField faceTypeLabel;
    @FXML
    private TextField faceColorLabel;
    @FXML
    private TextField shirtTypeLabel;
    @FXML
    private TextField shirtColorLabel;
    @FXML
    private TextField pantsTypeLabel;
    @FXML
    private TextField pantsColorLabel;
    @FXML
    private Label playerIdLabel;
    @FXML
    private Label teamIdLabel;

    //Estimated Values
    @FXML
    private Label carryLabel;
    @FXML
    private Label midLabel;
    @FXML
    private Label offlaneLabel;
    @FXML
    private Label support4Label;
    @FXML
    private Label support5Label;
    @FXML
    private Label estimatedValueLabel;
    @FXML
    private Label estimatedSalaryLabel;
    @FXML
    private Label estimatedAgeLabel;


    // Reference to the main application.
    private Main main;

    public PlayerOverviewController() {
    }

    @FXML
    private void initialize() {
        nicknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNickName()));
        showPlayerDetails(null);
        playerTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPlayerDetails(newValue));
    }

    @FXML
    private void handleConfirmPlayer() {
        int selectedIndex = playerTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0) {
            if(isInputValid(selectedIndex)) {
                playerTable.getItems().get(selectedIndex).setFirstName(firstNameLabel.getText());
                playerTable.getItems().get(selectedIndex).setLastName(lastNameLabel.getText());
                playerTable.getItems().get(selectedIndex).setNickName(nicknameLabel.getText());
                playerTable.getItems().get(selectedIndex).setBirthDay(birthDayLabel.getText());
                playerTable.getItems().get(selectedIndex).setRank(Integer.parseInt(rankLabel.getText()));
                playerTable.getItems().get(selectedIndex).setPopularity(Integer.parseInt(popularityLabel.getText()));
                playerTable.getItems().get(selectedIndex).setFarm(Integer.parseInt(farmLabel.getText()));
                playerTable.getItems().get(selectedIndex).setIndependency(Integer.parseInt(independecyLabel.getText()));
                playerTable.getItems().get(selectedIndex).setFighting(Integer.parseInt(fightingLabel.getText()));
                playerTable.getItems().get(selectedIndex).setSupport(Integer.parseInt(supportLabel.getText()));
                playerTable.getItems().get(selectedIndex).setRotation(Integer.parseInt(rotationLabel.getText()));
                playerTable.getItems().get(selectedIndex).setPositioning(Integer.parseInt(positioningLabel.getText()));
                playerTable.getItems().get(selectedIndex).setMapAwareness(Integer.parseInt(mapAwarenessLabel.getText()));
                playerTable.getItems().get(selectedIndex).setAggression(Integer.parseInt(aggressionLabel.getText()));
                playerTable.getItems().get(selectedIndex).setReflex(Integer.parseInt(reflexLabel.getText()));
                playerTable.getItems().get(selectedIndex).setDecisionMaking(Integer.parseInt(decisionMakingLabel.getText()));
                playerTable.getItems().get(selectedIndex).setPotential(Integer.parseInt(potentialLabel.getText()));
                playerTable.getItems().get(selectedIndex).setHappiness(Integer.parseInt(happinessLabel.getText()));
                playerTable.getItems().get(selectedIndex).setIntelligence(Integer.parseInt(intelligenceLabel.getText()));
                playerTable.getItems().get(selectedIndex).setConcentration(Integer.parseInt(concentrationLabel.getText()));
                playerTable.getItems().get(selectedIndex).setLeadership(Integer.parseInt(leadershipLabel.getText()));
                playerTable.getItems().get(selectedIndex).setRage(Integer.parseInt(rageLabel.getText()));
                playerTable.getItems().get(selectedIndex).setHairType(Integer.parseInt(hairTypeLabel.getText()));
                playerTable.getItems().get(selectedIndex).setHairColor(Integer.parseInt(hairColorLabel.getText()));
                playerTable.getItems().get(selectedIndex).setFaceType(Integer.parseInt(faceTypeLabel.getText()));
                playerTable.getItems().get(selectedIndex).setFaceColor(Integer.parseInt(faceColorLabel.getText()));
                playerTable.getItems().get(selectedIndex).setShirtType(Integer.parseInt(shirtTypeLabel.getText()));
                playerTable.getItems().get(selectedIndex).setShirtColor(Integer.parseInt(shirtColorLabel.getText()));
                playerTable.getItems().get(selectedIndex).setPantsType(Integer.parseInt(pantsTypeLabel.getText()));
                playerTable.getItems().get(selectedIndex).setPantsColor(Integer.parseInt(pantsColorLabel.getText()));
                getEstimatedStatus(playerTable.getItems().get(selectedIndex));
                playerTable.refresh();

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Player Selected");
            alert.setContentText("Please select a player in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleDeletePlayer() {
        int selectedIndex = playerTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0) {
            playerTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Player Selected");
            alert.setContentText("Please select a player in the table.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewPlayer() {
        if(uniqueName("NEW PLAYER")) {
            Player newPlayer = new Player();
            newPlayer.setNickName("NEW PLAYER");
            newPlayer.setId(setNewplayerID());
            newPlayer.setTeamId("TEAM_0000");
            playerTable.getItems().add(newPlayer);
            playerTable.getSelectionModel().select(newPlayer);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("New Player");
            alert.setHeaderText("Already Created a new Player");
            alert.setContentText("Please edit and confirm the NickName of your new Player before creating another, must be unique and different of the default NEW PLAYER nickname");
            alert.showAndWait();
        }



    }
/*
    @FXML
    void handleSavePlayers() {
        try (Writer writer = new FileWriter("Players.json");){
            Gson gson = new GsonBuilder().create();
            gson.toJson(playerTable.getItems(), writer);
            String outpt = gson.toJson(playerTable.getItems());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    */

    public void setMain(Main main) {
        this.main = main;

        playerTable.setItems(main.getPlayerData());
    }

    private void showPlayerDetails(Player player) {
        if (player != null) {

            firstNameLabel.setText(player.getFirstName());
            lastNameLabel.setText(player.getLastName());
            nicknameLabel.setText(player.getNickName());
            birthDayLabel.setText(player.getBirthDay());
            rankLabel.setText(Integer.toString(player.getRank()));
            popularityLabel.setText(Integer.toString(player.getPopularity()));
            farmLabel.setText(Integer.toString(player.getFarm()));
            independecyLabel.setText(Integer.toString(player.getIndependency()));
            fightingLabel.setText(Integer.toString(player.getFighting()));
            supportLabel.setText(Integer.toString(player.getSupport()));
            rotationLabel.setText(Integer.toString(player.getRotation()));
            positioningLabel.setText(Integer.toString(player.getPositioning()));
            mapAwarenessLabel.setText(Integer.toString(player.getMapAwareness()));
            aggressionLabel.setText(Integer.toString(player.getAggression()));
            reflexLabel.setText(Integer.toString(player.getReflex()));
            decisionMakingLabel.setText(Integer.toString(player.getDecisionMaking()));
            potentialLabel.setText(Integer.toString(player.getPotential()));
            happinessLabel.setText(Integer.toString(player.getHappiness()));
            intelligenceLabel.setText(Integer.toString(player.getIntelligence()));
            concentrationLabel.setText(Integer.toString(player.getConcentration()));
            leadershipLabel.setText(Integer.toString(player.getLeadership()));
            rageLabel.setText(Integer.toString(player.getRage()));
            hairTypeLabel.setText(Integer.toString(player.getHairType()));
            hairColorLabel.setText(Integer.toString(player.getHairColor()));
            faceTypeLabel.setText(Integer.toString(player.getFaceType()));
            faceColorLabel.setText(Integer.toString(player.getFaceColor()));
            shirtTypeLabel.setText(Integer.toString(player.getShirtType()));
            shirtColorLabel.setText(Integer.toString(player.getShirtColor()));
            pantsTypeLabel.setText(Integer.toString(player.getPantsType()));
            pantsColorLabel.setText(Integer.toString(player.getPantsColor()));
            playerIdLabel.setText(player.getId());
            teamIdLabel.setText(player.getTeamId());
            getEstimatedStatus(player);

        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            nicknameLabel.setText("");
            birthDayLabel.setText("");
            rankLabel.setText("");
            popularityLabel.setText("");
            farmLabel.setText("");
            independecyLabel.setText("");
            fightingLabel.setText("");
            supportLabel.setText("");
            rotationLabel.setText("");
            positioningLabel.setText("");
            mapAwarenessLabel.setText("");
            aggressionLabel.setText("");
            reflexLabel.setText("");
            decisionMakingLabel.setText("");
            potentialLabel.setText("");
            happinessLabel.setText("");
            intelligenceLabel.setText("");
            concentrationLabel.setText("");
            leadershipLabel.setText("");
            rageLabel.setText("");
            hairTypeLabel.setText("");
            hairColorLabel.setText("");
            faceTypeLabel.setText("");
            faceColorLabel.setText("");
            shirtTypeLabel.setText("");
            shirtColorLabel.setText("");
            pantsTypeLabel.setText("");
            pantsColorLabel.setText("");

            carryLabel.setText("");
            midLabel.setText("");
            offlaneLabel.setText("");
            support4Label.setText("");
            support5Label.setText("");
            estimatedValueLabel.setText("");
            estimatedSalaryLabel.setText("");
            estimatedAgeLabel.setText("");

        }
    }

    public void getEstimatedStatus(Player player) {
        double pos1;
        double pos2;
        double pos3;
        double pos4;
        double pos5;

        pos1 = 0.65 * player.getFarm() + 0.05 * player.getIndependency() + 0 * player.getSupport() + 0.05 * player.getRotation() + 0.25 * player.getFighting();
        pos2 = 0.25 * player.getFarm() + 0.1 * player.getIndependency() + 0 * player.getSupport() + 0.10 * player.getRotation() + 0.55 * player.getFighting();
        pos3 = 0.15 * player.getFarm() + 0.55 * player.getIndependency() + 0 * player.getSupport() + 0.1 * player.getRotation() + 0.2 * player.getFighting();
        pos4 = 0.05 * player.getFarm() + 0.05 * player.getIndependency() + 0.25 * player.getSupport() + 0.5 * player.getRotation() + 0.15 * player.getFighting();
        pos5 = 0 * player.getFarm() + 0.1 * player.getIndependency() + 0.7 * player.getSupport() + 0.1 * player.getRotation() + 0.1 * player.getFighting();
        int roles[] = {(int)pos1, (int)pos2 ,(int)pos3, (int)pos4, (int)pos5};
        double value = Math.pow(Math.pow(1.12, bestRole(roles)) + Math.pow(1.09, player.getPopularity()), 1.25)*14/(Math.pow(1.035,200-bestRole(roles)-player.getPopularity()));
       // double value = Math.pow(Math.pow(1.145, bestRole(roles)) + Math.pow(1.03, player.getPopularity()), 1.25)*14/(Math.pow(1.035,200-bestRole(roles)-player.getPopularity()));
        double salary = Math.pow(Math.pow(1.09, bestRole(roles)) + Math.pow(1.075, player.getPopularity()), 1.22)*3/(Math.pow(1.035,200-1.1*bestRole(roles)-0.9*player.getPopularity()));

        carryLabel.setText(Integer.toString((int)pos1));
        midLabel.setText(Integer.toString((int)pos2));
        offlaneLabel.setText(Integer.toString((int)pos3));
        support4Label.setText(Integer.toString((int)pos4));
        support5Label.setText(Integer.toString((int)pos5));
        estimatedValueLabel.setText(Integer.toString((int)value));
        estimatedSalaryLabel.setText(Integer.toString((int)salary));
        estimatedAgeLabel.setText(Integer.toString(player.getAge()));

    }

    public int bestRole(int roles[]) {
        for(int i = 4; i >= 1; i--) {
            for(int j = 0; j < i; j++) {
                if (roles[j] > roles[j+1]) {
                    int buffer = roles[j];
                    roles[j] = roles[j+1];
                    roles[j+1] = buffer;
                }
            }
        }
        return roles[4];
    }

    public long calculateplayerID() {
        long playerId;
        long newId = 0;
        for (int i = 0; i < playerTable.getItems().size(); i++) {
            for (int j = 0; j < playerTable.getItems().size(); j++) {
                playerId = Integer.parseInt(playerTable.getItems().get(j).getId().split("_")[1]);
                if (newId == playerId)
                    newId++;

            }
        }
        return newId;
    }

    public String setNewplayerID() {
        String newPlayerId;
        String calculateID = Long.toString(calculateplayerID());
        String zeros = "";
        for( int i = 0; i < 6 - calculateID.length(); i++) {
            zeros = zeros + "0";
        }
        newPlayerId = "PLAYER_" + zeros + calculateID;

        return newPlayerId;
    }

    public boolean uniqueNameInTable(String name, int selectedIndex) {
        String playerName;
        for (int i = 0; i < playerTable.getItems().size(); i++) {
            playerName = playerTable.getItems().get(i).getNickName();
            if (name.equals(playerName))
                if(playerTable.getItems().get(selectedIndex).getNickName().equals(name))
                    return true;
            else
                return false;
        }
        return true;
    }

    public boolean uniqueName(String name) {
        String playerName;
        for (int i = 0; i < playerTable.getItems().size(); i++) {
            playerName = playerTable.getItems().get(i).getNickName();
            if (name.equals(playerName))
                    return false;
        }
        return true;
    }

    public boolean isInputValid(int selectedIndex) {
        String errorMessage = "";
        if (firstNameLabel.getText() == null || firstNameLabel.getLength() == 0)
            errorMessage += "No valid first name\n";
        if (!uniqueNameInTable(nicknameLabel.getText(), selectedIndex))
            errorMessage += "Nickname already exist\n";
        if (nicknameLabel.getText().equals("NEW PLAYER"))
            errorMessage += "Don't use the default nickname\n";

        if (errorMessage.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Success");
            alert.setHeaderText("Player Confirmed");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);
            alert.showAndWait();
            return false;
        }

    }
}

