package sample.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;

import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by Paulo on 20/10/2016.
 */
public class RootLayoutController {

    private Main main;

    public RootLayoutController() {
    }

    @FXML
    void handleSavePlayers() {
        try (Writer writer = new FileWriter("Players.json");){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(main.getPlayerData(), writer);

            try (Writer writerTeam = new FileWriter("Teams.json");){
                Gson gsonTeam = new GsonBuilder().setPrettyPrinting().create();
                gsonTeam.toJson(main.getTeamData(), writerTeam);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try (Writer writerContract = new FileWriter("Contracts.json");){
                Gson gsonContract = new GsonBuilder().setPrettyPrinting().create();
                gsonContract.toJson(main.getContractData(), writerContract);
            } catch (Exception e) {
                e.printStackTrace();
            }

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("Salvo");
            alert.setHeaderText("Players and Teams saved");
            alert.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @FXML
    void handleExit() {
        System.exit(0);

    }

    public void setMain(Main main) {
        this.main = main;
    }


}
