/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class Entry_pageController implements Initializable {
@FXML
public Button closeButton;
    private int ScannedID;
    
    Connection mycon=null;
    Statement mystat=null;
    ResultSet myres=null;
    ResultSet myres2=null;
    server s = new server();

        @FXML
    private Button fetch;
    @FXML 
    private TextField IDno;
    @FXML 
    private TextField branch;
    @FXML 
    private TextField year;
    @FXML 
    private TextField address;
    @FXML 
    private TextField name;
    @FXML 
    private TextField ID;
    @FXML 
    private TextField bookname;
    @FXML 
    private TextField author;
    @FXML
    private Label time;
    @FXML
    private Label date;
    @FXML
    private Label day;
    @FXML
    public Pane base;


    /**
     * Initializes the controller class.*/
 @FXML
public void handleCloseButtonAction(ActionEvent event) {
    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
}
    /**
     * Initializes the controller class.
     */
@FXML
    public void fetch_student_records(ActionEvent event) throws IOException{
         
        String query1;
        
        
        try {
           mycon=DriverManager.getConnection("jdbc:derby://localhost:1527/TestDatabase","kane", "Kirtesh@1661");
           mystat=mycon.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Empty_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(s.message.substring(0, 3).equals("SID"))
        {
            
            ScannedID=Integer.parseInt(s.message.substring(3));
            
            try {
                query1 = "Select * from TESTTABLE where ID="+ScannedID+" ";
                myres=mystat.executeQuery(query1);
                while(myres.next()){
                    try{
                        IDno.setText(myres.getString("ID"));
                        name.setText(myres.getString("NAME"));
                        branch.setText(myres.getString("BRANCH"));
                        address.setText(myres.getString("ADDRESS"));
                        year.setText(myres.getString("YEAR"));
                        
                    }catch(Exception e){e.printStackTrace();
                    System.out.println("error here");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empty_pageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            try {
                try{
                    ScannedID=Integer.parseInt(s.message);
                }catch(NumberFormatException e){
                System.out.println("Number error.");
                }
                query1 = "Select * from BOOK where ID="+ScannedID+" ";
                myres=mystat.executeQuery(query1);
                while(myres.next()){
                    try{
                        
                        bookname.setText(myres.getString("NAME"));
                        author.setText(myres.getString("AUTHOR"));
                        ID.setText(myres.getString("ID"));
                        
                    }catch(Exception e){e.printStackTrace();
                    System.out.println("error here2");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(Empty_pageController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
        

    
    }
        @FXML
     void Process(ActionEvent event) throws IOException{
        boolean check = false;
        try {
            mycon=DriverManager.getConnection("jdbc:derby://localhost:1527/TestDatabase","kane", "Kirtesh@1661");
            mystat=mycon.createStatement();         
            myres2=mystat.executeQuery("Select * from DATABASE");
            while(myres2.next()){
                if(myres2.getString("STUDENTID").equals(IDno.getText())){
                    if(myres2.getString("SECONDARYBOOK")!=null){
                        Stage dialog = new Stage();
                        dialog.setTitle("Dialog Box");
                        Scene scene = new Scene(FXMLLoader.load(getClass().getResource("maxissue.fxml")));
                        dialog.setScene(scene);                        
                        dialog.show();
                        check=true;
                        break;
                    }else{
                        mystat.executeUpdate("update DATABASE set SECONDARYBOOK="+ID.getText()+" where STUDENTID="+IDno.getText());
                        break;
                    }
                
                }              
                
            }
            if(check==false){
                Stage dialog = new Stage();
                dialog.setTitle("Dialog Box");
                dialog.initModality(Modality.APPLICATION_MODAL);  
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("norecord.fxml")));
                dialog.setScene(scene);     
                dialog.showAndWait();
                        
            }
        } catch (SQLException ex) {
            Logger.getLogger(Empty_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
