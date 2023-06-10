package com.example.javapart2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class takingInput {

    @FXML
    private TextField productionCompany;

    public Button submit;

    public void Submission(ActionEvent event)throws Exception {
        ProductionCompany p = new ProductionCompany();
       // ProComRecentMoviesShowController.list2 = p.MostRecentMovies(productionCompany.getText());

        if(event.getSource()== submit) {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tableview.fxml")));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initOwner(top10.getScene().getWindow());
            stage.showAndWait();
        }
    }

    public void OnClickBackToProComMenu(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProComMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
   /* public void Submission(ActionEvent event) throws Exception
    {
        if(event.getSource()== submit) {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("tableview.fxml")));
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initOwner(top10.getScene().getWindow());
            stage.showAndWait();
        }
    }

    */
}
