package sample.players.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Main;
import sample.players.model.Player;

/**
 * Created by Paulo on 12/10/2016.
 */
public class PlayerOverviewController {

    @FXML
    private TableView<Player> playerTable;
    @FXML
    private TableColumn<Player, String> nicknameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label nicknameLabel;
    @FXML
    private Label ageLabel;
    @FXML
    private Label rankLabel;
    @FXML
    private Label popularityLabel;
    @FXML
    private Label valueLabel;
    @FXML
    private Label salaryLabel;
    @FXML
    private Label farmLabel;
    @FXML
    private Label independecyLabel;
    @FXML
    private Label fightingLabel;
    @FXML
    private Label supportLabel;
    @FXML
    private Label rotationLabel;
    @FXML
    private Label positioningLabel;
    @FXML
    private Label mapAwarenessLabel;
    @FXML
    private Label aggressionLabel;
    @FXML
    private Label reflexLabel;
    @FXML
    private Label decisionMakingLabel;
    @FXML
    private Label potentialLabel;
    @FXML
    private Label happinessLabel;
    @FXML
    private Label intelligenceLabel;
    @FXML
    private Label concentrationLabel;
    @FXML
    private Label leadershipLabel;
    @FXML
    private Label rageLabel;
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




    // Reference to the main application.
    private Main main;

    public PlayerOverviewController() {
    }

    @FXML
    private void initialize() {
        nicknameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNickName()));
        showPlayerDetails(null);
        playerTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPlayerDetails(newValue));
        playerTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> getEstimatedStatus(newValue));
    }

    public void setMain(Main main) {
        this.main = main;

        playerTable.setItems(main.getPlayerData());
    }


    private void showPlayerDetails(Player player) {
        if (player != null) {

            firstNameLabel.setText(player.getFirstName());
            lastNameLabel.setText(player.getLastName());
            nicknameLabel.setText(player.getNickName());
            ageLabel.setText(Integer.toString(player.getAge()));
            rankLabel.setText(Integer.toString(player.getRank()));
            popularityLabel.setText(Integer.toString(player.getPopularity()));
            valueLabel.setText(Integer.toString(player.getValue()));
            salaryLabel.setText(Integer.toString(player.getSalary()));
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
            getEstimatedStatus(player);

        } else {
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            nicknameLabel.setText("");
            ageLabel.setText("");
            rankLabel.setText("");
            popularityLabel.setText("");
            valueLabel.setText("");
            salaryLabel.setText("");
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

        }
    }

    public void getEstimatedStatus(Player player) {
        double pos1;
        double pos2;
        double pos3;
        double pos4;
        double pos5;

        System.out.println(player.getNickName());
        pos1 = 0.65 * player.getFarm() + 0.05 * player.getIndependency() + 0 * player.getSupport() + 0.05 * player.getRotation() + 0.25 * player.getFighting();
        System.out.println("Carry Role: " + (int) pos1);

        pos2 = 0.30 * player.getFarm() + 0.1 * player.getIndependency() + 0 * player.getSupport() + 0.15 * player.getRotation() + 0.45 * player.getFighting();
        System.out.println("Mid Role: " + (int) pos2);

        pos3 = 0.15 * player.getFarm() + 0.55 * player.getIndependency() + 0 * player.getSupport() + 0.1 * player.getRotation() + 0.2 * player.getFighting();
        System.out.println("Off Role: " + (int) pos3);

        pos4 = 0.05 * player.getFarm() + 0.05 * player.getIndependency() + 0.25 * player.getSupport() + 0.5 * player.getRotation() + 0.15 * player.getFighting();
        System.out.println("Supp 4 Role: " + (int) pos4);

        pos5 = 0 * player.getFarm() + 0.1 * player.getIndependency() + 0.7 * player.getSupport() + 0.1 * player.getRotation() + 0.1 * player.getFighting();
        System.out.println("Supp 5 Role: " + (int) pos5);

        int roles[] = {(int)pos1, (int)pos2 ,(int)pos3, (int)pos4, (int)pos5};

        double value = Math.pow(1.082, bestRole(roles)+player.getPopularity());
        int salary = (int)value/80;
        System.out.println(salary);

        carryLabel.setText(Integer.toString((int)pos1));
        midLabel.setText(Integer.toString((int)pos2));
        offlaneLabel.setText(Integer.toString((int)pos3));
        support4Label.setText(Integer.toString((int)pos4));
        support5Label.setText(Integer.toString((int)pos5));
        estimatedValueLabel.setText(Integer.toString((int)value));
        estimatedSalaryLabel.setText(Integer.toString(salary));
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
}

