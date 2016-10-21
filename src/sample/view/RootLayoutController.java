package sample.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.Main;
import sample.players.model.Player;

import java.io.FileWriter;
import java.io.Writer;

/**
 * Created by Paulo on 20/10/2016.
 */
public class RootLayoutController {

    private ObservableList<Player> playerData = FXCollections.observableArrayList();

    // Reference to the main application.
    private Main main;

    public RootLayoutController() {
    }

    @FXML
    void handleSavePlayers() {
        try (Writer writer = new FileWriter("Players.json");){
            Gson gson = new GsonBuilder().create();
            gson.toJson(main.getPlayerData(), writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setMain(Main main) {
        this.main = main;
    }


}
