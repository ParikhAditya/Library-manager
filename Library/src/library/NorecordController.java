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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class NorecordController implements Initializable {
    @FXML
    private Button yes;
    @FXML
    private Button no;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void yes(ActionEvent event)
    {
        Stage stage=(Stage)yes.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void no(ActionEvent event)
    {
        Stage stage=(Stage)no.getScene().getWindow();
        stage.close();
    }
}
