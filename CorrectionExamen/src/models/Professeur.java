/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author user
 */
public class Professeur {
    private int id;
    private String nomComplet;
    private String matricule;

    public Professeur() {
    }

    public Professeur(int id, String nomComplet, String matricule) {
        this.id = id;
        this.nomComplet = nomComplet;
        this.matricule = matricule;
    }

    public Professeur(String nomComplet, String matricule) {
        this.nomComplet = nomComplet;
        this.matricule = matricule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    @Override
    public String toString() {
        return  nomComplet ;
    }

    public Professeur(int id) {
        this.id = id;
    }
    
    
}
