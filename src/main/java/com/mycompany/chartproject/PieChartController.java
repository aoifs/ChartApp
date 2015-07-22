/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chartproject;


import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;

/**
 *
 * @author eaoicon
 */
public class PieChartController implements Initializable {

    @FXML
    private PieChart pieChart;
    @FXML 
    private Button wfmac;
    @FXML 
    private Button servcore;
    @FXML 
    private Button wfmsr;
    @FXML 
    private Button modelmsr;    
    
            
            ExcelReader excelReader = new ExcelReader();

    /* @FXML
     private Label green;
     @FXML
     private Label orange;
     @FXML
     private Label red;
     */
    //method linked to the view
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setPieChartData("apworkflowmacro_acceptance");

    }

    @FXML 
    public void handleRepoChange1 () {

        setPieChartData("apworkflowmacro_acceptance");
    
    }
     @FXML 
    public void handleRepoChange2 () {

        setPieChartData("apservicecore_acceptance");
    
    }
     @FXML 
    public void handleRepoChange3 () {

        setPieChartData("ap-workflow-msrbsv1_acceptance");
    
    }
     @FXML 
    public void handleRepoChange4 () {

        setPieChartData("ap-model-msrbsv1_acceptance");
    
    }
            
    private void setPieChartData(String repo) {
        // TODO

        Map<String, Double> map = excelReader.getPieChartData(repo);
        pieChart.setLabelLineLength(10);
        pieChart.setLegendSide(Side.LEFT);

        ObservableList<PieChart.Data> pieChartData
                = FXCollections.observableArrayList(
                        new PieChart.Data("Failed ", +map.get("Failed")),
                        new PieChart.Data("Unstable ", +map.get("Unstable")),
                        new PieChart.Data("Passed ", +map.get("Passed")),
                        new PieChart.Data("Aborted ", +map.get("Aborted")));
 
        pieChart.setData(pieChartData);
    }
}

/*
 final Label caption = new Label("");
 caption.setTextFill(Color.BLACK);
 caption.setStyle("-fx-font: 24 arial;");

  
          
 for (final PieChart.Data data : pieChart.getData()); {
 data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
 new EventHandler<MouseEvent>() {
 @Override public void handle(MouseEvent e) {
 caption.setTranslateX(e.getSceneX());
 caption.setTranslateY(e.getSceneY());
 caption.setText(String.valueOf(data.getPieValue()) + "%");
             
 });
 }
 }          
 */
