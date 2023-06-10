package com.example.javapart2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TransferMovieController {
    public Label NoTransferMovieFound;
    public TextField TransferMovieTitle;
    public TextField TransferMovieProCom;

    public void OnClickBackToHelloView(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void TransferMovieSubmit(ActionEvent event) {
        List<Movies> M = new ArrayList<>();

        for (Movies m : HelloApplication.mvs)
        {
            if (TransferMovieTitle.getText().equalsIgnoreCase(m.getTitle())) M.add(m);
        }

        if (M.size() == 0) NoTransferMovieFound.setText("No such Movie Found");
        else {
            try {

                Socket socket = new Socket("127.0.0.1", 22223);

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                String [] strings ={TransferMovieTitle.getText(),HelloApplication.mvs.get(0).getProductionCom(),TransferMovieProCom.getText()};

                oos.writeObject(strings);
            }catch (Exception ignored){}
        }
    }
}
