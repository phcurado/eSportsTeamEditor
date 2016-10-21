package sample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.players.model.Player;
import sample.players.view.PlayerOverviewController;
import sample.view.RootLayoutController;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    public ObservableList<Player> playerData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Esports Manager Editor");
        this.primaryStage.getIcons().add(new Image("file:resources/images/icon.png"));

        getPlayersSaved();
        initRootLayout();
        showAplicacaoOverview();


/*
        playerData.add(new Player("Arthour", "Babaev", "Arteezy", "01/07/1996", 9018, 88, 88, 65, 82, 40, 87, 82, 80, 85, 90, 78, 88, 50, 82, 80, 78, 78, "PLAYER_000001"));
              playerData.add(new Player("Amer", "Al", "Miracle", "20/06/1997", 8965, 90, 86, 67, 84, 50, 90, 88, 87, 88, 84, 82, 94, 50, 85, 82, 75, 75, "PLAYER_000002"));
        playerData.add(new Player("Saahil", "Arora", "Universe", "11/10/1989", 8297, 87, 70, 90, 80, 55, 86, 86, 87, 88, 80, 85, 87, 50, 83, 88, 78, 60, "PLAYER_000003"));
            playerData.add(new Player("Paulo", "Curado", "Sabs", "05/10/1990", 3800, 60, 65, 67, 68, 72, 70, 60, 65, 62, 65, 62, 70, 50, 80, 70, 70, 80, "PLAYER_000004"));
            playerData.add(new Player("Paulo", "Dendi", "Dendi", "05/10/1990", 3800, 95, 77, 70, 80, 50, 77, 60, 65, 62, 65, 62, 70, 50, 80, 70, 70, 80, "PLAYER_000005"));*/
        ///System.out.println(getPlayerData().get(0).getNickName());
        //playerData.add(new Player("sumail", 80, 75, 30, 86, 87));

    }

    public ObservableList<Player> getPlayerData() {
        return playerData;
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            // Show the scene containing the root layout.
            primaryStage.setScene(scene);
            RootLayoutController controller = loader.getController();
            controller.setMain(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAplicacaoOverview() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("players/view/Aplicacao.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(personOverview);

            PlayerOverviewController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void getPlayersSaved() {
        try (Reader reader = new FileReader("Players.json");){
            Gson gson = new GsonBuilder().create();
            playerData.addAll(gson.fromJson(reader, Player[].class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}