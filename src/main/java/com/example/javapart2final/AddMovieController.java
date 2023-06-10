package com.example.javapart2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class AddMovieController {
    public TextField AddMovieTitle;
    public TextField AddMovieReleaseYear;
    public TextField AddMovieRunTime;
    public TextField AddMovieBudget;
    public TextField AddMovieRevenue;
    public TextField AddMovieGenre1;
    public TextField AddMovieGenre2;
    public TextField AddMovieGenre3;

    public void BackToHelloView(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void AddMovieSubmit(ActionEvent event) throws Exception {
        Movies m = new Movies(AddMovieTitle.getText(), AddMovieReleaseYear.getText(), AddMovieGenre1.getText(), AddMovieGenre2.getText(), AddMovieGenre3.getText(), AddMovieRunTime.getText(), HelloApplication.mvs.get(0).getProductionCom(), AddMovieBudget.getText(), AddMovieRevenue.getText());
        HelloApplication.mvs.add(m);

        Socket socket = new Socket("127.0.0.1",22223);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        oos.writeObject(m);
    }
}
