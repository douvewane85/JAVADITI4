/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.LocalDate;


/**
 *
 * @author user
 */
public class Affectation {
    private int id;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
        
    }

   

    public Professeur getProf() {
        return prof;
    }

    public void setProf(Professeur prof) {
        this.prof = prof;
    }

    public Classe getClasse() {
        return classe;
    }

    //Propriete de Navigation
    //ManyToOne
    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    private Professeur prof;
    private Classe classe;

    public Affectation() {
    }

    public Affectation(int id, LocalDate dateDebut, LocalDate dateFin, Professeur prof, Classe classe) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prof = prof;
        this.classe = classe;
    }

    public Affectation(LocalDate dateDebut, LocalDate dateFin, Professeur prof, Classe classe) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.prof = prof;
        this.classe = classe;
    }

    @Override
    public String toString() {
        return  prof.getNomComplet() +" "+classe.getLibelle();
                
    }
    
    
    
}
