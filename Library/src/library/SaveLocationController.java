/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SaveLocationController implements Initializable {

    @FXML
    private Button yes;
    @FXML
    public TextField saveLoc;
    New_studentController s;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    @FXML
    private void proceed(ActionEvent event) {
        if(saveLoc.getText() != null){
            s.save=saveLoc.getText();
            
        }
        Stage stage=(Stage)yes.getScene().getWindow();
        stage.close();
    }
    
}
