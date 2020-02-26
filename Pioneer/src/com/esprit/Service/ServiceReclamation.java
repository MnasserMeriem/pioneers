/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.Service;



import com.esprit.Entite.Reclamation;
import com.esprit.IService.IService;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import com.esprit.Utils.DataBase;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class ServiceReclamation implements IService<Reclamation> {

    private Connection con;
    private Statement ste;

    public ServiceReclamation() {
        con = DataBase.getInstance().getConnection();

    }
// ************************************méthode ajouter********************************************
    @Override
    public void ajouter(Reclamation t) throws SQLException {
       
        ste = con.createStatement();
        String requeteInsert ="INSERT INTO `reclamations` (`cin`, `date`, `text`) VALUES ( '"+t.getCin()+"', current_timestamp(), '"+t.getText()+"')";
        ste.executeUpdate(requeteInsert);
        
    }
    
 
            
// ************************************méthode supprimer********************************************
     public void supprimerReclamation(String Nom){
        String requete="delete from Reclamation where nom="+Nom+"";
        try { 
            Statement st = con.createStatement();
            st.executeUpdate(requete);
            System.out.println("Reclamtion supprimée");
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    // ************************************méthode trie********************************************
    
   public List<Reclamation> trieReclamation(String o ) 
    {
        String requete = "SELECT * FROM reclamations order by "+o;
        PreparedStatement pst;
            List<Reclamation> list = new ArrayList<>();

        try {
            pst = con.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
            
            
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String date=rs.getString("Date");
               String Text=rs.getString("text");
               Reclamation r =new Reclamation(nom,prenom,date,Text);
            list.add(r);
            }
            
        
        } catch (SQLException ex) {
            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
       return list;
          
        
    }
    
   // ************************************méthode rechercher********************************************
    
//    public List<Reclmation> rechercheReclamation(String colonne, String reclamation) {
//        List<Reclamation> list = new ArrayList<>();
//        String requete;
//      
//            requete = "select * from reclamation where "+colonne+" like '%"+reclamation+"%'";
//     
//        try {
//            ste = con.createStatement();
//        ResultSet rs = ste.executeQuery(requete);
//        while (rs.next()) {
//

//               String Text=rs.getString nom=rs.getString("nom");
//               String prenom=rs.getString("prenom");
//               Date date=rs.getDate("Date");
//               String Text=rs.getString(nom);
//               Reclamation r=new Reclamation(date, nom, prenom,Text);
//            list.add(p);
//        }
//    }
//    catch (SQLException ex) {
//            Logger.getLogger(ServiceReclamation.class.getName()).log(Level.SEVERE, null, ex);
//    }
//
//    return list ;
//}

    // ************************************méthode read********************************************

    @Override
    public List<Reclamation> readAll() throws SQLException {
    List<Reclamation> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("SELECT    nom , prenom, text , date\n" +
"from reclamations r inner JOIN user u\n" +
"on r.cin= u.cin");
     while (rs.next()) {                
               
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String date=rs.getString("date");
               String Text=rs.getString("text");
               Reclamation r=new Reclamation(date,nom,prenom,Text);
     arr.add(r);
     }
    return arr;
    }

    @Override
    public void update(Reclamation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Reclamation t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

