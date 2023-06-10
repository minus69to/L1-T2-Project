package com.example.javapart2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ProComMenuController {
   @FXML
    public Label totalProfit;
    ProductionCompany productionCompany = new ProductionCompany();
    public void OnClickBackMenu(ActionEvent actionEvent) throws IOException {
        totalProfit.setText(null);
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void OnClickRecenetMoviesShow(ActionEvent actionEvent) throws IOException {
        totalProfit.setText(null);
        try {
            Socket socket = new Socket("127.0.0.1", 22223);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject(HelloApplication.mvs.get(0).getProductionCom());
            HelloApplication.mvs = (List<Movies>) ois.readObject();
        }catch (Exception ignored){}

        HelloController.display(productionCompany.MostRecentMovies(HelloApplication.mvs.get(0).getProductionCom()));

    }

    public void OnClickMaxRevMoviesShow(ActionEvent actionEvent) throws IOException {
        totalProfit.setText(null);
        try {
            Socket socket = new Socket("127.0.0.1", 22223);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject(HelloApplication.mvs.get(0).getProductionCom());
            HelloApplication.mvs = (List<Movies>) ois.readObject();
        }catch (Exception ignored){}
        HelloController.display(productionCompany. MaxRevenue(HelloApplication.mvs.get(0).getProductionCom()));
    }

    public void OnClickProfit(ActionEvent event) throws IOException {
        try {
            Socket socket = new Socket("127.0.0.1", 22223);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject(HelloApplication.mvs.get(0).getProductionCom());
            HelloApplication.mvs = (List<Movies>) ois.readObject();
        }catch (Exception ignored){}
        long Profit = ProductionCompany.TotalProfit();
        totalProfit.setText("Total Profit : "+Profit+"$");
    }

    //**************************
    public void OnClickAllMoviesShow(ActionEvent event) {
        totalProfit.setText(null);
        try {
            Socket socket = new Socket("127.0.0.1", 22223);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject(HelloApplication.mvs.get(0).getProductionCom());
            HelloApplication.mvs = (List<Movies>) ois.readObject();
        }catch (Exception ignored){}

        HelloController.display(productionCompany.AllMovies(HelloApplication.mvs.get(0).getProductionCom()));
    }


}
