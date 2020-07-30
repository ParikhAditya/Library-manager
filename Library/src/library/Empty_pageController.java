/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class Empty_pageController implements Initializable,Runnable{
    private TextField IDno;
    private TextField branch;
    private TextField year;
    private TextField address;
    private TextField name;
    private TextField ID;
    private TextField bookname;
    private TextField author;
    private Label time;
    
    server s = new server();
    private int ScannedID;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button button;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
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
        Thread t=new Thread(new Empty_pageController());
        t.setDaemon(true);
        t.start();
    }   
    
    @Override
    public void run() {
        boolean b=true;
        s.status=b;
        try {
            s.doInBackground();
        } catch (InterruptedException ex) {
            Logger.getLogger(Empty_pageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   /*  @FXML
     public void handleButtonAction(ActionEvent event) throws IOException{
     Parent root;
     if(event.getSource()==bt1){
        //load up OTHER FXML document
       root = FXMLLoader.load(getClass().getResource("library.fxml"));
      }}*/
    
    public void fetch_student_records(ActionEvent event){
        Connection mycon=null;
        Statement mystat=null;
        ResultSet myres=null;
        try{
            ScannedID=Integer.parseInt(s.message);
        }catch(NumberFormatException e){
            System.out.println("Number error.");
        }
        String query1;
        query1 = "Select * from TESTTABLE where ID="+ScannedID+" ";
       // String query2="Select * from BOOK";
        try{
            mycon=DriverManager.getConnection("jdbc:derby://localhost:1527/TestDatabase","kane", "Kirtesh@1661");
            mystat=mycon.createStatement();
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
          /*  myres=mystat.executeQuery(query2);
            while(myres.next()){
            try{
                ID.setText(myres.getString("ID"));
                bookname.setText(myres.getString("NAME"));
                
                author.setText(myres.getString("AUTHOR"));
                
                
            }catch(Exception e){e.printStackTrace();
                System.out.println("error here 2");
            }
            }
                */
         
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
    public void clear(ActionEvent Event){
        IDno.clear();
        branch.clear();
        bookname.clear();
        ID.clear();
        author.clear();
        address.clear();
        name.clear();
        year.clear();
    }

    public void Process(){
        
        
    
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
    }
    
    
    
}