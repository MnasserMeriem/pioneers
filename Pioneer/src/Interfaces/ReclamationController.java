/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.esprit.Entite.Reclamation;
import com.esprit.Service.ServiceReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ReclamationController implements Initializable {

    private String cin="11121111";
    @FXML
    private TextField rec;
    @FXML
    private Button envoyer;
    @FXML
    private TextField nom;
    @FXML
    private TextField objet;
    @FXML
    private TextField prenom;
    @FXML
    private ImageView imgR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imgR.setImage(new Image("/images/reclamation.png"));
        // TODO
    }    
    
    public void SetCin(String cin)
    {
        this.cin=cin;
    }
    
    
     @FXML
  public void AjouterReclamation(ActionEvent event)  { 
        try {
            ServiceReclamation es = new ServiceReclamation();
            es.ajouter(new Reclamation(cin,rec.getText()));
            JOptionPane.showMessageDialog(null,"reclamation ajoutée");
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
}}
