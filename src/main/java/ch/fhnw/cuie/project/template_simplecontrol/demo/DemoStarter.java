package ch.fhnw.cuie.project.template_simplecontrol.demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class DemoStarter extends Application {

    @Override
    public void start(Stage primaryStage) {
        SnowPM pm        = new SnowPM();
        Region            rootPanel = new DemoPane(pm);

        Scene scene = new Scene(rootPanel);

        primaryStage.setTitle("Snow Height Control");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
