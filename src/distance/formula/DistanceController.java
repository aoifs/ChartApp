/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distance.formula;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author eaoicon
 */
public class DistanceController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private TextField uValue;
    @FXML
    private TextField tValue;
   
    @FXML 
    private TextField aValue;
    @FXML 
    private TextField result;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        int u=Integer.parseInt(uValue.getText());
        int t=Integer.parseInt(tValue.getText());
        int a=Integer.parseInt(aValue.getText());

     System.out.println("uValue: " + uValue.getText());
     System.out.println("tValue: " + tValue.getText());
     System.out.println("aValue: " + aValue.getText());
     
     int s = (u*t)+(a/2*t*t);
     System.out.println("s: " + s);
     result.setText(String.valueOf(s));
     
    

        //label.setText("Hello World!")
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize");
    }

}
