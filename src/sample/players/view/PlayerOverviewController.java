package sample.players.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.players.model.Contract;
import sample.players.model.Player;
import sample.players.model.Team;

import java.util.Calendar;

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

    @FXML
    private TableView<Team> teamTable;
    @FXML
    private TableColumn<Team, String> teamNameColumn;
    @FXML
    private TextField teamNameField;
    @FXML
    private TextField teamAbbreviatedNameField;
    @FXML
    private TextField budgetField;
    @FXML
    private TextField tierField;
    @FXML
    private Label teamIdLabel1;
    @FXML
    private TableView<Player> noTeamPlayerTable;
    @FXML
    private TableColumn<Player, String> noTeamNicknameColumn;
    @FXML
    private TableView<Player> playerInTeamTable;
    @FXML
    private TableColumn<Player, String> playerInTeamColumn;
    @FXML
    private TableView<Contract> contractTable;
    @FXML
    private TableColumn<Contract, String> contractIdColumn;
    @FXML
    private TableColumn<Contract, String> contractTeamIdColumn;
    @FXML
    private TableColumn<Contract, String> contractPlayerIdColumn;
    @FXML
    private Label contractIdLabel;
    @FXML
    private TextField transferFeeField;
    @FXML
    private TextField salaryField;
    @FXML
    private Label estimatedBudgetLabel;
    @FXML
    private Label estimatedTeamSTRLabel;

    ObservableList<String> playerHairTypeOptions = FXCollections.observableArrayList("careca", "muito curto", "curto penteado liso", "curto penteado enrolado",  "médio penteado liso",
            "médio penteado enrolado", "grande penteado liso", "grande penteado enrolado", "curto com franjas liso", "curto com franjas enrolado", "médio com franjas liso", "médio com franjas enrolado",
            "grande com franjas liso", "grande com franjas enrolado", "feminino grande");
    ObservableList<String> playerHairColorOptions = FXCollections.observableArrayList("branco", "castanho", "preto", "loiro", "vermelho", "verde");
    ObservableList<String> playerFaceTypeOptions = FXCollections.observableArrayList("magro", "normal", "arredondado", "gordo");
    ObservableList<String> playerFaceColorOptions = FXCollections.observableArrayList("branco", "moreno", "amarelo", "negro");
    ObservableList<String> playerExpressionTypeOptions = FXCollections.observableArrayList("sério europeu", "sorridente europeu", "normal europeu",
            "sério asiático", "sorridente asiático", "normal asiático");
    ObservableList<String> playerAcessoryOptions = FXCollections.observableArrayList("sem óculos", "com óculos retangulo", "com óculos redondo");



    @FXML
    private ChoiceBox playerHairType;
    @FXML
    private ChoiceBox playerHairColor;
    @FXML
    private ChoiceBox playerFaceType;
    @FXML
    private ChoiceBox playerFaceColor;
    @FXML
    private ChoiceBox playerExpressionType;
    @FXML
    private ChoiceBox playerAcessory;



    // Reference to the main application.
    private Main main;

    public PlayerOverviewController() {
    }

    @FXML
    private void initialize() {
        playerHairType.setValue(playerHairTypeOptions.get(0));
        playerHairType.setItems(playerHairTypeOptions);

        playerHairColor.setValue(playerHairColorOptions.get(0));
        playerHairColor.setItems(playerHairColorOptions);

        playerFaceType.setValue(playerFaceTypeOptions.get(0));
        playerFaceType.setItems(playerFaceTypeOptions);

        playerFaceColor.setValue(playerFaceColorOptions.get(0));
        playerFaceColor.setItems(playerFaceColorOptions);

        playerExpressionType.setValue(playerExpressionTypeOptions.get(0));
        playerExpressionType.setItems(playerExpressionTypeOptions);

        playerAcessory.setValue(playerAcessoryOptions.get(0));
        playerAcessory.setItems(playerAcessoryOptions);


        nicknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNickName()));
        showPlayerDetails(null);
        playerTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPlayerDetails(newValue));

        teamNameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        showTeamDetails(null);
        teamTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showTeamDetails(newValue));

        noTeamNicknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNickName()));

        contractIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        contractTeamIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTeamId()));
        contractPlayerIdColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPlayerId()));

        playerInTeamColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNickName()));
        playerInTeamTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPlayerInTeamDetails(newValue));
        showPlayerInTeamDetails(null);
    }
    public void show(Contract contrat){}

    @FXML
    private void handleConfirmPlayer() {
        int selectedIndex = playerTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0) {
            if(isInputValidPlayer(selectedIndex)) {
                playerTable.getItems().get(selectedIndex).setFirstName(firstNameLabel.getText());
                playerTable.getItems().get(selectedIndex).setLastName(lastNameLabel.getText());
                playerTable.getItems().get(selectedIndex).setNickName(nicknameLabel.getText());
                String data = birthDayLabel.getText();
                String dataSplited[] = data.split("/");
                Calendar calendar = Calendar.getInstance();
                calendar.set(Integer.parseInt(dataSplited[2]), Integer.parseInt(dataSplited[1]) - 1, Integer.parseInt(dataSplited[0]));
                playerTable.getItems().get(selectedIndex).setBirthDay(calendar);
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

                playerTable.getItems().get(selectedIndex).setHairType(playerHairType.getSelectionModel().getSelectedIndex());
                playerTable.getItems().get(selectedIndex).setHairColor(playerHairColor.getSelectionModel().getSelectedIndex());
                playerTable.getItems().get(selectedIndex).setFaceType(playerFaceType.getSelectionModel().getSelectedIndex());
                playerTable.getItems().get(selectedIndex).setFaceColor(playerFaceColor.getSelectionModel().getSelectedIndex());
                playerTable.getItems().get(selectedIndex).setExpressionType(playerExpressionType.getSelectionModel().getSelectedIndex());
                playerTable.getItems().get(selectedIndex).setAccessory(playerAcessory.getSelectionModel().getSelectedIndex());

                getEstimatedStatus(playerTable.getItems().get(selectedIndex));
                playerTable.refresh();
                updateNoTeamPlayerTable();

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
    private void handleConfirmTeam() {
        int selectedIndex = teamTable.getSelectionModel().getSelectedIndex();
        int selectedPlayerIndex = playerInTeamTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0) {
            if(isInputValidTeam(selectedIndex)) {
                teamTable.getItems().get(selectedIndex).setName(teamNameField.getText());
                teamTable.getItems().get(selectedIndex).setAbbreviatedName(teamAbbreviatedNameField.getText());
                teamTable.getItems().get(selectedIndex).setBudget(Integer.parseInt(budgetField.getText()));
                teamTable.getItems().get(selectedIndex).setTier(Integer.parseInt(tierField.getText()));
                teamTable.refresh();
            }
            if(selectedPlayerIndex >= 0) {
                changeContract(playerInTeamTable.getItems().get(selectedPlayerIndex), "fee", Integer.parseInt(transferFeeField.getText()));
                changeContract(playerInTeamTable.getItems().get(selectedPlayerIndex), "salary", Integer.parseInt(salaryField.getText()));
                estimatedBudgetLabel.setText(Long.toString(estimateTeamBudget(teamTable.getItems().get(selectedIndex))));
                estimatedTeamSTRLabel.setText(Integer.toString(estimateTeamStr(teamTable.getItems().get(selectedIndex))));
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Team Selected");
            alert.setContentText("Please select a team in the table.");
            alert.showAndWait();
        }


    }

    @FXML
    private void handleDeletePlayer() {
        int selectedIndex = playerTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0) {
            if(isPlayerHaveTeam(playerTable.getItems().get(selectedIndex))) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("Player on Team");
                alert.setHeaderText("This player is on a Team");
                alert.setContentText("Please remove the player on it's team first. Team: ");
                alert.showAndWait();

            }
            else
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
    private void handleDeleteTeam() {
        int selectedIndex = teamTable.getSelectionModel().getSelectedIndex();
        if(selectedIndex >= 0) {
            if(isTeamHavePlayer(teamTable.getItems().get(selectedIndex))) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("Player on Team");
                alert.setHeaderText("This team has player(s)");
                alert.setContentText("Please remove the player(s) of this team first");
                alert.showAndWait();
            }
            else
                teamTable.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Team Selected");
            alert.setContentText("Please select a team in the table.");
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
    @FXML
    private void handleNewTeam() {
        if(uniqueTeamName("NEW TEAM")) {
            Team newTeam = new Team();
            newTeam.setName("NEW TEAM");
            newTeam.setId(setNewTeamID());
            teamTable.getItems().add(newTeam);
            teamTable.getSelectionModel().select(newTeam);
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("New Team");
            alert.setHeaderText("Already Created a new Team");
            alert.setContentText("Please edit and confirm the Name of your new Team before creating another, must be unique and different of the default NEW TEAM name");
            alert.showAndWait();
        }
    }
    @FXML
    private void handleAddPlayerOnTeam() {
        int selectedIndexPlayer = noTeamPlayerTable.getSelectionModel().getSelectedIndex();
        int selectedIndexTeam = teamTable.getSelectionModel().getSelectedIndex();
        if(selectedIndexPlayer >= 0 && selectedIndexTeam >= 0) {
            if(playerInTeamTable.getItems().size() < 6) {

                Contract newContract = new Contract();
                newContract.setTeamId(teamTable.getItems().get(selectedIndexTeam).getId());
                newContract.setPlayerId(noTeamPlayerTable.getItems().get(selectedIndexPlayer).getId());
                newContract.setId(setNewContractID());
                contractTable.getItems().add(newContract);
                setPlayerIdInTeam(teamTable.getItems().get(selectedIndexTeam), newContract.getPlayerId());
                playerInTeamTable.getItems().add(noTeamPlayerTable.getItems().get(selectedIndexPlayer));
                noTeamPlayerTable.getItems().get(selectedIndexPlayer).setTeamId(teamTable.getItems().get(selectedIndexTeam).getId());
                noTeamPlayerTable.getItems().remove(selectedIndexPlayer);
                //updatePlayerInTeam(); //TODO
                playerInTeamTable.refresh();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(main.getPrimaryStage());
                alert.setTitle("Error:");
                alert.setHeaderText("Team has too much players");
                alert.setContentText("Please remove one player of this team or choose a different team for this player");
                alert.showAndWait();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("Select a Team and a Player");
            alert.setContentText("Please select a Team from the table Team Name and a Player from the table Players whithout team");
            alert.showAndWait();

        }

    }
    @FXML
    private void handleRemovePlayerOnTeam() {
        int selectedIndexPlayer = playerInTeamTable.getSelectionModel().getSelectedIndex();
        int selectedIndexTeam = teamTable.getSelectionModel().getSelectedIndex();
        if(selectedIndexPlayer >= 0 && selectedIndexTeam >= 0) {
            for (int i = 0; i < contractTable.getItems().size(); i++) {
                if (contractTable.getItems().get(i).getPlayerId().equals(playerInTeamTable.getItems().get(selectedIndexPlayer).getId()))
                    contractTable.getItems().remove(i);
            }
            for (int i = 0; i < teamTable.getItems().get(selectedIndexTeam).getPlayersId().length; i++) {
                if (teamTable.getItems().get(selectedIndexTeam).getPlayersId()[i] != null) {
                    if (teamTable.getItems().get(selectedIndexTeam).getPlayersId()[i].equals(playerInTeamTable.getItems().get(selectedIndexPlayer).getId()))
                        teamTable.getItems().get(selectedIndexTeam).getPlayersId()[i] = null;
                }
            }
            playerInTeamTable.getItems().get(selectedIndexPlayer).setTeamId("TEAM_0000");
            updateNoTeamPlayerTable();
            playerInTeamTable.getItems().remove(selectedIndexPlayer);
            estimatedBudgetLabel.setText(Long.toString(estimateTeamBudget(teamTable.getItems().get(selectedIndexTeam))));
            updatePlayerInTeam();
        }

    }

    @FXML
    private void handleUpPlayerOnTeam(){
        int selectedIndexPlayer = playerInTeamTable.getSelectionModel().getSelectedIndex();
        int selectedIndexTeam = teamTable.getSelectionModel().getSelectedIndex();
        if(selectedIndexTeam >= 0 && selectedIndexTeam >= 0 && selectedIndexPlayer > 0) {

            String playerId = playerInTeamTable.getItems().get(selectedIndexPlayer).getId();
            System.out.println(playerId);
            String[] playersInTeam = teamTable.getItems().get(selectedIndexTeam).getPlayersId();
            playersInTeam[selectedIndexPlayer] = playersInTeam[selectedIndexPlayer-1];
            playersInTeam[selectedIndexPlayer-1] = playerId;
            teamTable.getItems().get(selectedIndexTeam).setPlayersId(playersInTeam);
            updatePlayerInTeam();


        }
    }

    private void updatePlayerInTeam() {
        int selectedIndex = teamTable.getSelectionModel().getSelectedIndex();
        playerInTeamTable.getItems().clear();
            for (int k = 0; k < teamTable.getItems().get(selectedIndex).getPlayersId().length; k++) {
                if (teamTable.getItems().get(selectedIndex).getPlayersId()[k] != null) {
                    for (int j = 0; j < playerTable.getItems().size(); j++) {
                        if(teamTable.getItems().get(selectedIndex).getPlayersId()[k].equals(playerTable.getItems().get(j).getId())) {
                            playerInTeamTable.getItems().add(playerTable.getItems().get(j));
                        }
                    }
                    }


        }
        estimatedTeamSTRLabel.setText(Integer.toString(estimateTeamStr(teamTable.getItems().get(selectedIndex))));

    }

    public int setPlayerIdInTeam(Team team, String id) {
        for (int i = 0; i < team.getPlayersId().length; i++) {
            if(team.getPlayersId()[i] == null) {
                team.getPlayersId()[i] = id;
                return 1;
            }
        }
        return 0;
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
        teamTable.setItems(main.getTeamData());
        contractTable.setItems(main.getContractData());
        updateNoTeamPlayerTable();
    }

    public void updateNoTeamPlayerTable() {
        noTeamPlayerTable.getItems().clear();
        for(int i = 0; i < main.getPlayerData().size(); i++) {
            if(main.getPlayerData().get(i).getTeamId().equals("TEAM_0000"))
                noTeamPlayerTable.getItems().add(main.getPlayerData().get(i));
        }
    }

    private void showPlayerDetails(Player player) {
        if (player != null) {

            firstNameLabel.setText(player.getFirstName());
            lastNameLabel.setText(player.getLastName());
            nicknameLabel.setText(player.getNickName());
            String texto = player.getBirthDay().get(Calendar.DAY_OF_MONTH) + "/" + (player.getBirthDay().get(Calendar.MONTH)+1) + "/" + player.getBirthDay().get(Calendar.YEAR);
            birthDayLabel.setText(texto);
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

            playerHairType.setValue(playerHairTypeOptions.get(player.getHairType()));
            playerHairColor.setValue(playerHairColorOptions.get(player.getHairColor()));
            playerFaceType.setValue(playerFaceTypeOptions.get(player.getFaceType()));
            playerFaceColor.setValue(playerFaceColorOptions.get(player.getFaceColor()));
            playerExpressionType.setValue(playerExpressionTypeOptions.get(player.getExpressionType()));
            playerAcessory.setValue(playerAcessoryOptions.get(player.getAccessory()));

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

    private void showTeamDetails(Team team) {
        playerInTeamTable.getItems().clear();
        if (team != null) {
            teamNameField.setText(team.getName());
            teamAbbreviatedNameField.setText(team.getAbbreviatedName());
            budgetField.setText(Long.toString(team.getBudget()));
            tierField.setText(Integer.toString(team.getTier()));
            teamIdLabel1.setText(team.getId());

            for(int i = 0; i < team.getPlayersId().length; i++) {
                if (team.getPlayersId()[i] != null) {
                    for (int j = 0; j < playerTable.getItems().size(); j++) {
                        if(team.getPlayersId()[i].equals(playerTable.getItems().get(j).getId())) {
                            playerInTeamTable.getItems().add(playerTable.getItems().get(j));
                        }
                    }
                }
            }

            estimatedBudgetLabel.setText(Long.toString(estimateTeamBudget(team)));
            estimatedTeamSTRLabel.setText(Integer.toString(estimateTeamStr(team)));

        } else {
            teamNameField.setText("");
            teamAbbreviatedNameField.setText("");
            budgetField.setText("");
            tierField.setText("");
            teamIdLabel1.setText("");
            estimatedBudgetLabel.setText("");
        }
    }

    private void showPlayerInTeamDetails(Player player) {
        if(player != null) {
            contractIdLabel.setText(searchContractId(player, "id"));
            transferFeeField.setText(searchContractId(player, "fee"));
            salaryField.setText(searchContractId(player, "salary"));
            getEstimatedStatus(player);
        }
    }

    private String searchContractId(Player player, String info) {
        for(int i = 0; i < contractTable.getItems().size(); i++) {
            String playerId = contractTable.getItems().get(i).getPlayerId();
            if(playerId.equals(player.getId())) {
                if (info.equals("id"))
                    return contractTable.getItems().get(i).getId();
                if (info.equals("fee"))
                    return Integer.toString(contractTable.getItems().get(i).getTransferFee());
                if (info.equals("salary"))
                    return Integer.toString(contractTable.getItems().get(i).getSalary());
                else
                    return "";
            }
        }
        return "NO CONTRACT";
    }

    private boolean isPlayerHaveTeam(Player player) {
        for(int i = 0; i < contractTable.getItems().size(); i++) {
            String playerId = contractTable.getItems().get(i).getPlayerId();
            if(playerId.equals(player.getId())) {
                return true;
            }
        }
        return false;
    }

    private boolean isTeamHavePlayer(Team team) {
        for(int i = 0; i < contractTable.getItems().size(); i++) {
            String teamId = contractTable.getItems().get(i).getTeamId();
            if(teamId.equals(team.getId())) {
                return true;
            }
        }
        return false;
    }

    private void changeContract(Player player, String info, int change) {
        for(int i = 0; i < contractTable.getItems().size(); i++) {
            String playerId = contractTable.getItems().get(i).getPlayerId();
            if(playerId.equals(player.getId())) {
                if (info.equals("fee"))
                    contractTable.getItems().get(i).setTransferFee(change);
                if (info.equals("salary"))
                    contractTable.getItems().get(i).setSalary(change);
            }
        }
    }

    public void getEstimatedStatus(Player player) {
        double pos1;
        double pos2;
        double pos3;
        double pos4;
        double pos5;

        pos1 = 0.65 * player.getFarm() + 0.05 * player.getIndependency() + 0 * player.getSupport() + 0.05 * player.getRotation() + 0.25 * player.getFighting();
        pos2 = 0.15 * player.getFarm() + 0.1 * player.getIndependency() + 0 * player.getSupport() + 0.10 * player.getRotation() + 0.65 * player.getFighting();
        pos3 = 0.1 * player.getFarm() + 0.60 * player.getIndependency() + 0 * player.getSupport() + 0.15 * player.getRotation() + 0.15 * player.getFighting();
        pos4 = 0 * player.getFarm() + 0.05 * player.getIndependency() + 0.4 * player.getSupport() + 0.5 * player.getRotation() + 0.05 * player.getFighting();
        pos5 = 0 * player.getFarm() + 0.05 * player.getIndependency() + 0.75 * player.getSupport() + 0.1 * player.getRotation() + 0.1 * player.getFighting();
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

    public long estimateTeamBudget(Team team) {
        long estimatedBudget = 0;
        for (int i = 0; i < team.getPlayersId().length; i++) {
            if(team.getPlayersId()[i] != null) {
                for (int j = 0; j < contractTable.getItems().size(); j++) {
                    if (team.getPlayersId()[i].equals(contractTable.getItems().get(j).getPlayerId())) {
                        estimatedBudget = estimatedBudget + contractTable.getItems().get(j).getSalary();
                    }
                }
            }
        }
        return 12*estimatedBudget;
    }

    public int estimateTeamStr(Team team) {
        int estimatedSTR = 0;
        for (int i = 0; i < team.getPlayersId().length; i++) {
            if(team.getPlayersId()[i] != null) {
                for (int j = 0; j < contractTable.getItems().size(); j++) {
                    if (team.getPlayersId()[i].equals(contractTable.getItems().get(j).getPlayerId())) {
                        for (int k = 0; k < playerTable.getItems().size(); k ++) {
                            if(playerTable.getItems().get(k).getId().equals(contractTable.getItems().get(j).getPlayerId())) {
                               estimatedSTR = estimatedSTR +estimatedPlayerOverall(playerTable.getItems().get(k));
                            }
                        }
                    }
                }
            }
        }
        if(playerInTeamTable.getItems().size() > 0)
            return estimatedSTR/playerInTeamTable.getItems().size();
        else
            return 0;
    }
    public int estimatedPlayerOverall(Player player) {
        double pos1;
        double pos2;
        double pos3;
        double pos4;
        double pos5;

        pos1 = 0.65 * player.getFarm() + 0.05 * player.getIndependency() + 0 * player.getSupport() + 0.05 * player.getRotation() + 0.25 * player.getFighting();
        pos2 = 0.15 * player.getFarm() + 0.1 * player.getIndependency() + 0 * player.getSupport() + 0.10 * player.getRotation() + 0.65 * player.getFighting();
        pos3 = 0.1 * player.getFarm() + 0.6 * player.getIndependency() + 0 * player.getSupport() + 0.15 * player.getRotation() + 0.15 * player.getFighting();
        pos4 = 0 * player.getFarm() + 0.05 * player.getIndependency() + 0.4 * player.getSupport() + 0.50 * player.getRotation() + 0.05 * player.getFighting();
        pos5 = 0 * player.getFarm() + 0.05 * player.getIndependency() + 0.75 * player.getSupport() + 0.1 * player.getRotation() + 0.1 * player.getFighting();
        int roles[] = {(int)pos1, (int)pos2 ,(int)pos3, (int)pos4, (int)pos5};

        return bestRole(roles);

    }

    public long calculateplayerID() {
        long playerId;
        long newId = 1;
        for (int i = 0; i < playerTable.getItems().size(); i++) {
            for (int j = 0; j < playerTable.getItems().size(); j++) {
                playerId = Integer.parseInt(playerTable.getItems().get(j).getId().split("_")[1]);
                if (newId == playerId)
                    newId++;

            }
        }
        return newId;
    }

    public long calculateTeamID() {
        long teamId;
        long newId = 1;
        for (int i = 0; i < teamTable.getItems().size(); i++) {
            for (int j = 0; j < teamTable.getItems().size(); j++) {
                teamId = Integer.parseInt(teamTable.getItems().get(j).getId().split("_")[1]);
                if (newId == teamId)
                    newId++;

            }
        }
        return newId;
    }

    public long calculateContractID() {
        long contractId;
        long newId = 1;
        for (int i = 0; i < contractTable.getItems().size(); i++) {
            for (int j = 0; j < contractTable.getItems().size(); j++) {
                contractId = Integer.parseInt(contractTable.getItems().get(j).getId().split("_")[1]);
                if (newId == contractId)
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

    public String setNewTeamID() {
        String newTeamId;
        String calculateID = Long.toString(calculateTeamID());
        String zeros = "";
        for( int i = 0; i < 4 - calculateID.length(); i++) {
            zeros = zeros + "0";
        }
        newTeamId = "TEAM_" + zeros + calculateID;

        return newTeamId;
    }

    public String setNewContractID() {
        String newContractId;
        String calculateID = Long.toString(calculateContractID());
        String zeros = "";
        for( int i = 0; i < 6 - calculateID.length(); i++) {
            zeros = zeros + "0";
        }
        newContractId = "CONTRACT_" + zeros + calculateID;

        return newContractId;
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

    public boolean uniqueNameInTableTeam(String name, int selectedIndex) {
        String teamName;
        for (int i = 0; i < teamTable.getItems().size(); i++) {
            teamName = teamTable.getItems().get(i).getName();
            if (name.equals(teamName))
                if(teamTable.getItems().get(selectedIndex).getName().equals(name))
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

    public boolean uniqueTeamName(String name) {
        String teamName;
        for (int i = 0; i < teamTable.getItems().size(); i++) {
            teamName = teamTable.getItems().get(i).getName();
            if (name.equals(teamName))
                return false;
        }
        return true;
    }

    public boolean isInputValidPlayer(int selectedIndex) {
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

    public boolean isInputValidTeam(int selectedIndex) {
        String errorMessage = "";
        if (teamNameField.getText() == null || teamNameField.getLength() == 0)
            errorMessage += "No valid team name\n";
        if (!uniqueNameInTableTeam(teamNameField.getText(), selectedIndex))
            errorMessage += "Team name already exist\n";
        if (teamNameField.getText().equals("NEW TEAM"))
            errorMessage += "Don't use the default name\n";

        if (errorMessage.length() == 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Success");
            alert.setHeaderText("Team Confirmed");
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

