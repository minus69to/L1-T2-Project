package com.example.javapart2final;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;


public class HelloController {

    public TextField PromComLogIn;
    static Stage stage;
    public Label LogInNoProCom;

    public void setStage(Stage stage) {

        this.stage = stage;
    }

    public static void end() throws Exception{
        Integer i = 1 ;
        Socket socket = new Socket("127.0.0.1", 22223);

        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        oos.writeObject(i);

    }

    static public void display(List<String> m){
        ListView<String> list=new ListView<>();
        for(String s:m){
            list.getItems().add(s);
        }
        StackPane layout = new StackPane();
        layout.getChildren().add(list);
        Scene scene = new Scene(layout,500,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {

        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void OnClickProCom(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ProComMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void OnClickExit(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("LogInWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        //System.exit(0);
    }
    public void mainMenu() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();

    }

    public void OnClickLogIn(ActionEvent event) throws Exception{

        if(PromComLogIn.getText() == null){
            LogInNoProCom.setText("No Such Production Company.");
        }
        else {
            Socket socket = new Socket("127.0.0.1", 22223);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            oos.writeObject(PromComLogIn.getText());
            HelloApplication.mvs = (List<Movies>) ois.readObject();
            if(HelloApplication.mvs.size() ==0) {
                LogInNoProCom.setText("No Such Production Company.");
            }
            else {
                mainMenu();
            }
        }

    }

    public void OnClickAddMovie(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("AddMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void OnClickTransferMovie(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("TransferMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }
}