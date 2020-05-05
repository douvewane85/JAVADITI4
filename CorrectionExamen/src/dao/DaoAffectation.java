/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Affectation;

/**
 *
 * @author user
 */
public class DaoAffectation extends MysqlDB implements IDao<Affectation>{
     private final String SQL_INSERT="insert into affectation (datedb,datefin,classe_id,prof_id) values(?,?,?,?)";
    public DaoAffectation() {
        
    }

    
    @Override
    public int create(Affectation obj) {
        System.out.println(obj);
        int id=0;
       this.initPS(SQL_INSERT);
      try {
          this.getPstm().setDate(1,Date.valueOf(obj.getDateDebut()));
          this.getPstm().setDate(2,Date.valueOf(obj.getDateFin()));
          this.getPstm().setInt(3, obj.getClasse().getId());
          this.getPstm().setInt(4, obj.getProf().getId());
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
    
    @Override
    public Affectation findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    @Override
    public boolean update(Affectation obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Affectation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
