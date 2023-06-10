package com.example.javapart2final;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        HelloController helloController = new HelloController();
        helloController.setStage(stage);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LogInWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Log In");
        stage.setScene(scene);

        Image icon = new Image("Menu2.png");
        stage.getIcons().add(icon);

        stage.show();
    }

    public static List<Movies> mvs = new ArrayList();

    public static void main(String[] args) throws Exception{
        launch();
    }

    public void stop()throws Exception{
        super.stop();
        HelloController.end();
        System.exit(0);
    }
}