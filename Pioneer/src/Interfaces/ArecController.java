/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

//import com.employe.gui.AfficheEmployeController;
import com.esprit.Entite.Reclamation;
import com.esprit.Service.ServiceReclamation;
import java.lang.reflect.Array;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
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
public class ArecController implements Initializable {

    @FXML
    private TableView<Reclamation> TableRec;
    @FXML
    private TableColumn<Reclamation,Timestamp> tfDate;
    @FXML
    private TableColumn<Reclamation, String> tfNom;
    @FXML
    private TableColumn<Reclamation, String> tfPrenom;
    @FXML
    private TableColumn<Reclamation, String> tfReclamation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       // System.out.println("fhfh");
         ServiceReclamation es = new ServiceReclamation();
            ObservableList<Reclamation> list = FXCollections.observableArrayList();
            
            list=Getlist();
            TableRec.setItems(list);
            
            tfNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
            tfPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
            tfReclamation.setCellValueFactory(new PropertyValueFactory<>("Text"));
            tfDate.setCellValueFactory(new PropertyValueFactory<>("date"));
            TableRec.setItems(list);
    }
    
    public ObservableList<Reclamation> Getlist()
    {
                 ServiceReclamation es = new ServiceReclamation();
                 List<Reclamation> arr=new ArrayList<>();
                 ObservableList<Reclamation> list = FXCollections.observableArrayList();
        try {
            arr=es.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ArecController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i< arr.size();i++)
                {
                   list.add(new Reclamation(arr.get(i).getDate(),arr.get(i).getNom(),arr.get(i).getPrenom(), arr.get(i).getText()));
                }

      return list;  
    }
    }    
    

