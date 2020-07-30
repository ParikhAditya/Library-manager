/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import com.google.zxing.BarcodeFormat;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class New_studentController implements Initializable {
@FXML
ImageView qrView;
String IDno;
 String name;
 String year;
 String branch;
 String address;
@FXML
TextField ID;
TextField Name;
TextField Branch;
TextField Year;
TextField Address;

Connection mycon = null;
Statement mystat = null;
ResultSet myres = null;

public Button closeButton;
    String save;
    /**
     * Initializes the controller class.*/
    @FXML
    public void generateBarcode(ActionEvent event) throws IOException{
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        String myID = ID.getText();
        int width = 300;
        int height = 300;
         
        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myID, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();
             
            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);
             
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }
             
            System.out.println("Success...");
             
        } catch (Exception ex) {
            Logger.getLogger(New_studentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        File dir = new File(save);
        if (!dir.exists()) {
            Stage dialog = new Stage();
            dialog.setTitle("Dialog Box");
            dialog.initModality(Modality.APPLICATION_MODAL);  
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("saveLocation.fxml")));
            dialog.setScene(scene);     
            dialog.showAndWait();
            
        }
        
        
        File outputfile = new File(save+myID+".png");
        if (!outputfile.exists()) {
            outputfile.createNewFile();
          
        }
        try{
            ImageIO.write(bufferedImage, "png", outputfile);
        } catch (IOException ex) {
            Logger.getLogger(New_studentController.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   }   
    @FXML
    public void add(ActionEvent event) throws SQLException  {
        mycon=DriverManager.getConnection("jdbc:derby://localhost:1527/TestDatabase","kane", "Kirtesh@1661");
        mystat=mycon.createStatement();
        IDno = ID.getText();
        year = Year.getText();
        name = Name.getText();
        address = Address.getText();
        branch = Branch.getText();
        
        //System.out.println(IDno+name+address+branch+year);
        mystat.executeUpdate("INSERT into TESTTABLE (name,year,branch,address,ID) Values("+name+","+year+","+branch+","+address+","+IDno+");");
    }
 @FXML
public void handleCloseButtonAction(ActionEvent event) {
    Stage stage = (Stage) closeButton.getScene().getWindow();
    stage.close();
}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
