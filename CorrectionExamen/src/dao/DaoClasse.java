/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Classe;

/**
 *
 * @author user
 */
public class DaoClasse extends MysqlDB implements IDao<Classe> {
     private final String SQL_ALL="select * from classe";
    @Override
    public ArrayList<Classe> findAll() {
       ArrayList<Classe> classes=null;
       this.initPS(SQL_ALL);
        
        classes=new ArrayList<>();
         try {
             ResultSet rs=  this.executeSelect();
             while(rs.next()){
                 Classe cl=new Classe();
                 cl.setId(rs.getInt(1));
                 cl.setLibelle(rs.getString(2));
                 classes.add(cl);
             }
         } catch (SQLException ex) {
             Logger.getLogger(DaoClasse.class.getName()).log(Level.SEVERE, null, ex);
         }
       
       
       return classes;
    }
    
    
    @Override
    public int create(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Classe obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public Classe findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
