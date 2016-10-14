package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.players.model.Player;
import sample.players.view.PlayerOverviewController;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    private ObservableList<Player> playerData = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Esports Manager Editor");

        initRootLayout();

        showAplicacaoOverview();



        playerData.add(new Player("Arthour", "Babaev", "Arteezy", 20, 9018, 500000, 8000, 88, 88, 65, 82, 40, 87, 82, 80, 85, 90, 78, 88, 50, 82, 80, 78, 78));
              playerData.add(new Player("Amer", "Al", "Miracle", 19, 8965, 500000, 8000, 90, 86, 67, 84, 50, 90, 88, 87, 88, 84, 82, 94, 50, 85, 82, 75, 75));
        playerData.add(new Player("Saahil", "Arora", "Universe", 27, 8297, 500000, 8000, 87, 70, 90, 80, 55, 86, 86, 87, 88, 80, 85, 87, 50, 83, 88, 78, 60));
            playerData.add(new Player("Paulo", "Curado", "Sabs", 26, 3800, 500000, 8000, 60, 65, 50, 68, 72, 70, 60, 65, 62, 65, 62, 70, 50, 80, 70, 70, 80));
        //playerData.add(new Player("sumail", 80, 75, 30, 86, 87));

    }

    public ObservableList<Player> getPlayerData() {
        return playerData;
    }

    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            // Show the scene containing the root layout.
            primaryStage.setScene(scene);
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

    public void getPosition(Player player) {
        double pos1;
        double pos2;
        double pos3;
        double pos4;
        double pos5;

        System.out.println(player.getNickName());
        pos1 = 0.65 * player.getFarm() + 0.05 * player.getIndependency() + 0 * player.getSupport() + 0.05 * player.getRotation() + 0.25 * player.getFighting();
        System.out.println("Carry Role: " + (int) pos1);

        pos2 = 0.30 * player.getFarm() + 0.10 * player.getIndependency() + 0 * player.getSupport() + 0.15 * player.getRotation() + 0.45 * player.getFighting();
        System.out.println("Mid Role: " + (int) pos2);

        pos3 = 0.15 * player.getFarm() + 0.55 * player.getIndependency() + 0 * player.getSupport() + 0.1 * player.getRotation() + 0.20 * player.getFighting();
        System.out.println("Off Role: " + (int) pos3);

        pos4 = 0.05 * player.getFarm() + 0.05 * player.getIndependency() + 0.25 * player.getSupport() + 0.5 * player.getRotation() + 0.15 * player.getFighting();
        System.out.println("Supp 4 Role: " + (int) pos4);

        pos5 = 0 * player.getFarm() + 0.1 * player.getIndependency() + 0.7 * player.getSupport() + 0.1 * player.getRotation() + 0.1 * player.getFighting();
        System.out.println("Supp 5 Role: " + (int) pos5);

    }
}