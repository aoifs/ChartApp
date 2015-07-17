/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chartproject;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author eaoicon
 */
public class DashboardController implements Initializable {

    
    
    @FXML
    private Label X;
    @FXML
    private Label Y;

    @FXML
    private TextField enterX;
    @FXML
    private TextField enterValue;

    @FXML
    private TextField C;
    @FXML
    private TextField result;

    @FXML
    private Label plus;

    @FXML 
    private TableColumn xColumn;
    @FXML 
    private TableColumn yColumn;
    
        
    @FXML
    private LineChart<String,Number> graph;
    @FXML
    private PieChart pieChart;
    private Object root;
    private Object data;
  
 
    
        

     /*   int xCoef = Integer.parseInt(enterX.getText());
        int c = Integer.parseInt(C.getText());

        System.out.println("X: " + enterX.getText());
        System.out.println("C: " + C.getText());
       
        XYChart.Series series = new XYChart.Series<>();
         series.setName("My Points");
        
 
        for (int x = 0; x <= 10; x++) {
            int y = xCoef * x + c;
         
            System.out.println("( " + x + ", " + y + ")");
            
            series.getData().add(new XYChart.Data(x, y));
         xColumn.setCellValueFactory(new PropertyValueFactory("xValues"));
 yColumn.setCellValueFactory(new PropertyValueFactory("yValues"));
           
    
            
             //table.setText(String.valueOf("( " + x + ", " + y + ")")); */
        @FXML
    private void handleButtonAction(ActionEvent event) {
        
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Month");       
        
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
  
    XYChart.Series series1 = new XYChart.Series();
        series1.setName ("Tests Failed"); 
        series1.getData().add(new XYChart.Data("Jan", 23));
        series1.getData().add(new XYChart.Data("Feb", 14));
        series1.getData().add(new XYChart.Data("Mar", 15));
        series1.getData().add(new XYChart.Data("Apr", 24));
        series1.getData().add(new XYChart.Data("May", 34));
        series1.getData().add(new XYChart.Data("Jun", 36));
        series1.getData().add(new XYChart.Data("Jul", 22));
        series1.getData().add(new XYChart.Data("Aug", 45));
        series1.getData().add(new XYChart.Data("Sep", 43));
        series1.getData().add(new XYChart.Data("Oct", 17));
        series1.getData().add(new XYChart.Data("Nov", 29));
        series1.getData().add(new XYChart.Data("Dec", 25));
        
      XYChart.Series series2 = new XYChart.Series();
        series2.setName ("Tests Unstable");
        series2.getData().add(new XYChart.Data("Jan", 11));
        series2.getData().add(new XYChart.Data("Feb", 10));
        series2.getData().add(new XYChart.Data("Mar", 5));
        series2.getData().add(new XYChart.Data("Apr", 2));
        series2.getData().add(new XYChart.Data("May", 8));
        series2.getData().add(new XYChart.Data("Jun", 3));
        series2.getData().add(new XYChart.Data("Jul", 2));
        series2.getData().add(new XYChart.Data("Aug", 4));
        series2.getData().add(new XYChart.Data("Sep", 4));
        series2.getData().add(new XYChart.Data("Oct", 1));
        series2.getData().add(new XYChart.Data("Nov", 9));
        series2.getData().add(new XYChart.Data("Dec", 5));
        
        
        
             
      XYChart.Series series3 = new XYChart.Series();
        series3.setName ("Tests Passed");
        series3.getData().add(new XYChart.Data("Jan", 30));
        series3.getData().add(new XYChart.Data("Feb", 23));
        series3.getData().add(new XYChart.Data("Mar", 16));
        series3.getData().add(new XYChart.Data("Apr", 29));
        series3.getData().add(new XYChart.Data("May", 39));
        series3.getData().add(new XYChart.Data("Jun", 40));
        series3.getData().add(new XYChart.Data("Jul", 27));
        series3.getData().add(new XYChart.Data("Aug", 54));
        series3.getData().add(new XYChart.Data("Sep", 50));
        series3.getData().add(new XYChart.Data("Oct", 39));
        series3.getData().add(new XYChart.Data("Nov", 38));
        series3.getData().add(new XYChart.Data("Dec", 29));
       
        graph.getData().addAll(series1,series2,series3);
      
      
    }

 


  

    
  
  
    
    
  /* @FXML
   private Label green;
   @FXML
   private Label orange;
   @FXML
   private Label red;
   */
       @Override
public void initialize(URL url, ResourceBundle rb) {

        
pieChart.setLabelLineLength(10);
pieChart.setLegendSide(Side.LEFT);

 ObservableList<PieChart.Data> pieChartData =
         
            FXCollections.observableArrayList (
            new PieChart.Data("Failed 40.62%", 0.4062),
            new PieChart.Data("Unstable 7.95%", 0.0795),
            new PieChart.Data("Passed 51.42%", 0.5142));
 
 
    
    pieChart.setData(pieChartData); 
}
}












 
