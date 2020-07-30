/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */

public class LoginController implements Initializable {
@FXML
Button button;
@FXML
TextField user;
@FXML
PasswordField pwd;
@FXML
Label er;
@FXML
Label dt;
@FXML
ImageView logo;
DateFormat d = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date now = new Date();
public void buttonaction(ActionEvent e){
        try {
             
            // dt = dt.setText();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/library/library.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                Scene scene = new Scene(root1);
                stage.setScene(scene);  
                String s2 = user.getText();
                String p2 = pwd.getText();
                if("admin".equals(s2) && "password".equals(p2))
                    stage.show();
                else
                    er.setText("Invalid Username/Password");
        } catch(IOException e1) {
           e1.printStackTrace();
          }
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
