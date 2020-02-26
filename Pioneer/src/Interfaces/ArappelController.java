/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import com.esprit.Entite.Rappel;
import com.esprit.Entite.Reclamation;
import com.esprit.Service.ServiceRappel;
import com.esprit.Service.ServiceReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ArappelController implements Initializable {
    private String cin="11121111";
    @FXML
    private TableView<Rappel> tabrappel;
    @FXML
    private TableColumn<Rappel, String> date;
    @FXML
    private TableColumn<Rappel, String> nom;
    @FXML
    private TableColumn<Rappel, String> prenom;
    @FXML
    private TableColumn<Rappel, String> Rappel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceRappel es = new ServiceRappel();
            ObservableList<Rappel> list = FXCollections.observableArrayList();
            
            list=Getlist();
            tabrappel.setItems(list);
            
            nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            prenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            Rappel.setCellValueFactory(new PropertyValueFactory<>("Text"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            tabrappel.setItems(list);
    }    

    private ObservableList<Rappel> Getlist() {
   ServiceRappel es = new ServiceRappel();
                 List<Rappel> arr=new ArrayList<>();
                 ObservableList<Rappel> list = FXCollections.observableArrayList();
        try {
            arr=es.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ArappelController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i< arr.size();i++)
                {
                   list.add(new Rappel(arr.get(i).getDate(),arr.get(i).getNom(),arr.get(i).getPrenom(), arr.get(i).getText()));
                }

      return list;  }    }
    

