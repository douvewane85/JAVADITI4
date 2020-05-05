/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import models.Classe;
import models.Professeur;
import service.ExamenService;

/**
 *
 * @author user
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private Button btnSearch;
    @FXML
    private TextField txtMatricule;
    @FXML
    private TextField txtNom;
    
   
    //Service
    private ExamenService es;
    Professeur prof;
    @FXML
    private ComboBox<Classe> cboClasse;
    
    private ObservableList<Classe> obClasse;
     private ObservableList<Classe> obClasseAff;
    @FXML
    private Button btnAddClasse;
    @FXML
    private TableView<Classe> tblvClasses;
    @FXML
    private TableColumn<Classe, String> tblcID;
    @FXML
    private TableColumn<Classe, String> tbcLibelle;
    @FXML
    private Text lblSms;
    @FXML
    private Button btnValider;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           es=new ExamenService();
           obClasse=FXCollections.observableArrayList(es.listerClasse());
           cboClasse.setItems(obClasse);
           obClasseAff=FXCollections.observableList(new ArrayList<Classe>());
           tblcID.setCellValueFactory(new PropertyValueFactory<>("id"));
           tbcLibelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
           tblvClasses.setItems(obClasseAff);
           lblSms.setText("");
         
    }    

    @FXML
    private void handleSearchProf(ActionEvent event) {
        prof=es.rechercherProfesseur(txtMatricule.getText());
        txtNom.setDisable(false);
        txtNom.setText("");
        if(prof!=null){
            txtNom.setText(prof.getNomComplet());
            txtNom.setDisable(true);
        }
        System.out.print("Search"+prof);
    }

    @FXML
    private void handleAddClasse(ActionEvent event) {
      Classe classe=  cboClasse.getSelectionModel().getSelectedItem();
       boolean trouve =false;  
      for(Classe c:obClasseAff ){
            if(c.getId()==classe.getId()) {
                trouve =true;
                break;
            } 
        }
         if(!trouve) {
             obClasseAff.add(classe);
             lblSms.setText("");
             btnValider.setDisable(false);
         }else{
             lblSms.setText("Cette a Déja eté affecté à ce Professeur");
         }
         
         
    }

    @FXML
    private void handleAddAffectation(ActionEvent event) {
       
        if(prof==null){
            prof=new Professeur(txtNom.getText(),
                   txtMatricule.getText());
           
        }
        
       
        es.affecterClasse(prof,obClasseAff.subList(0, obClasseAff.size()));
        obClasseAff.clear();
        btnValider.setDisable(true);
    }
    
}
