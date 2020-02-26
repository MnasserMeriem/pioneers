/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.esprit.Entite.Reclamation;
import com.esprit.Service.ServiceReclamation;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder.Body;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class EmailController implements Initializable {

    @FXML
    private TextField a;
    @FXML
    private TextField objet;
    @FXML
    private TextArea message;
    @FXML
    private Button envoyer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyerAction(ActionEvent event) {
        mail m = new mail();
        try {
            mail.sendMail("myriammnasser@gmail.com", "hhhhhhh");
        } catch (Exception ex) {
            Logger.getLogger(EmailController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }

