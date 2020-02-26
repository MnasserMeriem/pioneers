/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.esprit.Entite.Reclamation;
import com.esprit.Service.ServiceReclamation; 
import java.io.IOException;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.esprit.Utils.DataBase;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class addReclamation implements Initializable{

    @FXML
    private TextField objet;
    @FXML
    private TextField rec;
    @FXML
    private Button envoyer;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
  //  private Date date;
    private Connection con;
    private DataBase db;
    private PreparedStatement pst;
    
            
  
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    
 //   public void envoyerAction(ActionEvent e) throws IOException
   // {
 //   envoyer.getScene().getWindow().hide();
    
    
    //}

   
    @FXML
  public void AjouterReclamation(ActionEvent event) throws SQLException   { 
      ServiceReclamation es = new ServiceReclamation();
      es.ajouter(new Reclamation(nom.getText(),prenom.getText(),rec.getText()));
      JOptionPane.showMessageDialog(null,"reclamation ajoutée");
        
        
        
        
        
      /*  PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev ->{
        
        });
        pt.play();*/         
          /*     try {
             pst.setString(2, nom.getText());
                pst.setString(3, prenom.getText() );
                pst.setString(4, rec.getText());
                
                pst.executeUpdate(insert);
        } catch (SQLException e1) {
        }*/
 
               
    
        /*
            //long date = System.currentTimeMillis();
            String nomR = nom.getText();
            String prenomR = prenom.getText();
            String recR = rec.getText();
           // String objetR = objet.getText();
            ServiceReclamation sr = new ServiceReclamation();
            Reclamation r = new Reclamation(nomR, prenomR, recR);
            sr.ajouter(r);
            
            FXMLLoader loader = new FXMLLoader
                        (getClass()
                         .getResource("Reclamation.fxml"));
            try {
                Parent root = loader.load();
                AfficherReclamation ar = loader.getController();
                ar.setResnom(nom);
                ar.setResprenom(prenom);
                ar.setResrec(rec);
                
                nom.getScene().setRoot(root);
                
                
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                }*/
    
        }
        
        
    }
    


