/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiontransport.Service;


import gestiontransport.Entite.Bus;
import gestiontransport.Entite.Trajet;
import gestiontransport.IService.IServiceTrajet;
import gestiontransport.Utils.DataBase;
import java.awt.AWTException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS-PC
 */
public class ServiceTrajet implements IServiceTrajet{
    
    private Connection con;
    private Statement ste;
    private DataBase mdb;

    public ServiceTrajet() {
        con = DataBase.getInstance().getConnection();

    }


            

    @Override
    public void delete(String nametrajet) throws SQLException{
     Statement stm= mdb.getConnection().createStatement();
       String requeteInsert = "DELETE FROM trajet WHERE Name='"+nametrajet+"';";
       stm.executeUpdate(requeteInsert);  
      
           }

    @Override
    public void update(String nametrajet,String busname) throws SQLException {
        
         Statement stm= mdb.getConnection().createStatement();
       String requeteInsert = "UPDATE `trajet` SET `bus_name`='"+busname+"' WHERE Name='"+ nametrajet +"';";
       stm.executeUpdate(requeteInsert);
 }
    
     @Override
     public void ajouter(String busname,String nametrajet) throws SQLException, AWTException {
        Statement stm= mdb.getConnection().createStatement();
       String requeteInsert = "INSERT INTO `pioneer`.`trajet` (`Name`,`bus_name`) VALUES ('" + nametrajet + "','"+busname+"');";
       stm.executeUpdate(requeteInsert);
       TrayIconDemo td = new TrayIconDemo();
            td.displayTray();
     }
 
    @Override
    public List<Trajet> afficher() throws SQLException {
    List<Trajet> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from trajet");
     while (rs.next()) {                
               String name=rs.getString("Name");
               String busname=rs.getString("bus_name");
               Trajet t =new Trajet(name,busname);
               arr.add(t);
     }
    return arr;
   }

    
}
