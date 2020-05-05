/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Professeur;

/**
 *
 * @author user
 */
public class DaoProfesseur extends MysqlDB implements IDao<Professeur> {
  private final String SQL_BY_MATRICULE="select * from professeur where matricule=?";
  private final String SQL_INSERT="insert into professeur (nom_complet,matricule) values(?,?)";
    public DaoProfesseur() {
       
    }
    
  
  @Override
    public int create(Professeur obj) {
       int id=0;
       this.initPS(SQL_INSERT);
      try {
          this.getPstm().setString(1,obj.getNomComplet());
          this.getPstm().setString(2,obj.getMatricule());
         this.executeMaj();
        ResultSet rs= this.getPstm().getGeneratedKeys();
        if(rs.first()){
            id=rs.getInt(1);
        }
       
      } catch (SQLException ex) {
          Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
      }finally{
           this.CloseConnexion();
      }
         return id;
    }
    
    public Professeur findByMatricule(String matricule) {
       
        Professeur prof=null;
        this.initPS(SQL_BY_MATRICULE);
      try {
          this.getPstm().setString(1, matricule);
          ResultSet rs=this.executeSelect();
          if(rs.first()){
              prof=new Professeur();
              prof.setId(rs.getInt(1));
              prof.setNomComplet(rs.getString(2));
              prof.setMatricule(rs.getString(3));
          }
          this.CloseConnexion();
      } catch (SQLException ex) {
          Logger.getLogger(DaoProfesseur.class.getName()).log(Level.SEVERE, null, ex);
      }
        
        
        return prof;
    }
    
    
    
    
    
    @Override
    public boolean update(Professeur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Professeur> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Professeur findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
