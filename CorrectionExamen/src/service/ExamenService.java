/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DaoAffectation;
import dao.DaoClasse;
import dao.DaoProfesseur;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Affectation;
import models.Classe;
import models.Professeur;

/**
 *
 * @author user
 */
public class ExamenService {
    public DaoProfesseur daoProf ;
    public DaoClasse daoClasse ;
    public DaoAffectation daoAff ;
    public ExamenService() {
        daoProf=new DaoProfesseur();
        daoClasse=new DaoClasse();
        daoAff=new DaoAffectation();
    }
    
    
   public Professeur rechercherProfesseur(String matricule){
       return daoProf.findByMatricule(matricule);
    }
   
   public ArrayList<Classe> listerClasse(){
          return daoClasse.findAll();
    }
   
   public void affecterClasse(Professeur prof,List<Classe> classes){
       int idProf;
          
       if(prof.getId()==0){
           idProf=daoProf.create(prof);
           prof.setId(idProf);
       }
       System.out.println("\n"+classes.size());
       classes.stream().map((cl) -> {
           LocalDate db=LocalDate.now();
           Affectation aff=new Affectation(db, db.plusMonths(1), prof, cl);
            return aff;
        }).forEachOrdered((aff) -> {
            daoAff.create(aff);
        });
      
   }
   
   
}
