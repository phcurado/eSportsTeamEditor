package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import soft.players.model.Player;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Aplicacao.fxml"));
        primaryStage.setTitle("Esports Manager Editor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        
        Player rtz = new Player("rtz", 10, 10, 90, 68, 30, 80, 85, 78, 83, 90, 92, 85);
        Player sumail = new Player("sumail", 10, 10, 80, 75, 30, 86, 90, 87, 90, 88, 92, 80);
        Player miracle = new Player("miracle", 10, 10, 86, 77, 40, 88, 92, 95, 88, 97, 92, 85);
        Player dendi = new Player("dendi", 10, 10, 78, 65, 30, 84, 80, 82, 83, 78, 70, 75);
        Player w33haa = new Player("w33haa", 10, 10, 78, 70, 30, 85, 87, 85, 86, 88, 86, 85);
        Player matumbaman = new Player("matumbaman", 10, 10, 95, 68, 30, 70, 80, 82, 83, 82, 92, 85);
        Player Universe = new Player("Universe", 10, 10, 70, 88, 30, 86, 87, 90, 83, 83, 82, 85);
        Player puppey = new Player("puppey", 10, 10, 45, 40, 84, 75, 75, 80, 85, 70, 75, 90);
        Player zai = new Player("zai", 10, 10, 75, 85, 86, 85, 75, 80, 80, 85, 85, 82);
        Player sonneiko = new Player("sonneiko", 10, 10, 65, 50, 90, 85, 75, 80, 80, 81, 85, 85);

        getPosition(rtz);
        getPosition(sumail);
        getPosition(miracle);
        getPosition(dendi);
        getPosition(w33haa);
        getPosition(matumbaman);
        getPosition(Universe);
        getPosition(puppey);
        getPosition(zai);
        getPosition(sonneiko);
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
        pos1 = 0.36*player.getFarm() + 0.1*player.getPush() + 0*player.getSupport() + 0.02*player.getRotation() + 0.16*player.getFighting()
                + 0.07*player.getPositioning() + 0.04*player.getMapAwareness() + 0.07*player.getAggression() + 0.07*player.getReflex() + 0.11*player.getDecisionMaking();
        System.out.println("Carry Role: " + (int)pos1);

        pos2 = 0.16*player.getFarm() + 0.06*player.getPush() + 0*player.getSupport() + 0.09*player.getRotation() + 0.27*player.getFighting()
                + 0.08*player.getPositioning() + 0.07*player.getMapAwareness() + 0.16*player.getAggression() + 0.03*player.getReflex() + 0.08*player.getDecisionMaking();
        System.out.println("Mid Role: " + (int)pos2);

        pos3 = 0.12*player.getFarm() + 0.25*player.getPush() + 0*player.getSupport() + 0.06*player.getRotation() + 0.25*player.getFighting()
                + 0.03*player.getPositioning() + 0.03*player.getMapAwareness() + 0.15*player.getAggression() + 0.02*player.getReflex() + 0.09*player.getDecisionMaking();
        System.out.println("Off Role: " + (int)pos3);

        pos4 = 0.05*player.getFarm() + 0*player.getPush() + 0.28*player.getSupport() + 0.17*player.getRotation() + 0.18*player.getFighting()
                + 0.03*player.getPositioning() + 0.03*player.getMapAwareness() + 0.15*player.getAggression() + 0.02*player.getReflex() + 0.09*player.getDecisionMaking();
        System.out.println("Supp 4 Role: " + (int)pos4);

        pos5 = 0*player.getFarm() + 0*player.getPush() + 0.4*player.getSupport() + 0.1*player.getRotation() + 0.15*player.getFighting()
                + 0.03*player.getPositioning() + 0.08*player.getMapAwareness() + 0.1*player.getAggression() + 0.02*player.getReflex() + 0.12*player.getDecisionMaking();
        System.out.println("Supp 5 Role: " + (int)pos5);

    }
}