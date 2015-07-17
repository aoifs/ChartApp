/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chartproject;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.beans.property.SimpleIntegerProperty;
/**
 *
 * @author eaoicon
 */
public class ChartController implements Initializable {

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
    private TableView table;
    @FXML 
    private TableColumn xColumn;
    @FXML 
    private TableColumn yColumn;
    
        
    @FXML
    private LineChart<Number,Number> graph;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        

       int xCoef = Integer.parseInt(enterX.getText());
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
           
    
            
             //table.setText(String.valueOf("( " + x + ", " + y + ")")); 
               
        }
        
        
         graph.getData().add(series);
         
        table.getItems().add(series);
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize");
    }
}

 
