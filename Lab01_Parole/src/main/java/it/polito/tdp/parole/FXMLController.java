package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnCancella;
    
    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;
    
    @FXML
    private TextArea txtTempi;

    @FXML
    void doInsert(ActionEvent event) {
  
    	String pippo = "";
    	double start = 0.0;
    	double stop = 0.0;
    	
    	String parolaInserita = txtParola.getText();
    	
    	if(!parolaInserita.contains(" ")) {
    		
    		start = System.nanoTime();
    		elenco.addParola(parolaInserita);
    		stop = System.nanoTime();
    		
    		for(String s : elenco.getElenco()) {
    			if(pippo == "") {
    				pippo = s;
    			}else {
    				pippo = pippo + "\n" + s;
    			}
    		}
        	txtResult.setText(pippo);	
    	}
        txtTempi.appendText("\n" + (stop-start)/1e9);
    }

    @FXML
    void doReset(ActionEvent event) {
    	double  start = System.nanoTime();
    	elenco.reset();
    	double  stop = System.nanoTime();
    	txtResult.clear();
        txtTempi.appendText("\n" + (stop-start)/1e9);
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	
    	String pippo = "";
    	String parolaCancellata = txtResult.getSelectedText();
    	double  start = System.nanoTime();
    	elenco.getElenco().remove(parolaCancellata);
    	double  stop = System.nanoTime();
    	for(String s : elenco.getElenco()) {
			if(pippo == "") {
				pippo = s;
			}else {
				pippo = pippo + "\n" + s;
			}
		}
    	txtResult.setText(pippo);
        txtTempi.appendText("\n" + (stop-start)/1e9);
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

        elenco = new Parole() ;
    }
}
