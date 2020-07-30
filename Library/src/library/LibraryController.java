/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class LibraryController implements Initializable {
 private Label time;
    /**
     * Initializes the controller class.
     */public void entrypageaction(ActionEvent event) throws Exception {               
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/library/Entry_page.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
}
     public void newstudentaction(ActionEvent event) throws Exception {               
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/library/new_student.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
}
    public void newbookaction(ActionEvent event) throws Exception {               
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/library/new_book.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
}
    public void databaseaction(ActionEvent event) throws Exception {               
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/library/Database.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
}
    public void returnpageaction(ActionEvent event) throws Exception {               
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/library/Return_page.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
}
    @FXML
public void exitApplication(ActionEvent event) {
   Platform.exit();
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {        
        int second = LocalDateTime.now().getSecond();
        int minute = LocalDateTime.now().getMinute();
        int hour = LocalDateTime.now().getHour();
        time.setText(hour + ":" + (minute) + ":" + second);
    }),
         new KeyFrame(Duration.seconds(1))
    );
    clock.setCycleCount(Animation.INDEFINITE);
    clock.play();
    }    


    
}
