/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chartproject;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

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
    private LineChart<String, Number> graph;
    @FXML
    private PieChart pieChart;
    private Object root;
    private Object data;
    ExcelReader excelReader = new ExcelReader();

    @FXML
    private Button wfmac;
    @FXML
    private Button servcore;
    @FXML
    private Button wfmsr;
    @FXML
    private Button modelmsr;
    @FXML
    private Button failedBtn;
     @FXML
    private Button passedBtn;
      @FXML
    private Button skippedBtn;
       @FXML
    private Button totalBtn;
    

    private XYChart.Series failed;
     private XYChart.Series passed;
      private XYChart.Series skipped;
       private XYChart.Series total;

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
        setChartData("apworkflowmacro_acceptance");

    }

    @FXML
    public void handleRepoChange1() {

        setPieChartData("apworkflowmacro_acceptance");
        setChartData("apworkflowmacro_acceptance");

    }

    @FXML
    public void handleRepoChange2() {

        setPieChartData("apservicecore_acceptance");
        setChartData("apservicecore_acceptance");

    }

    @FXML
    public void handleFailed() {
        if(graph.getData().contains(failed)){
           graph.getData().remove(failed); 
        }else{
            graph.getData().add(failed);
     
        }
        
    }
    @FXML
    public void handleSkipped() {
        if(graph.getData().contains(skipped)){
           graph.getData().remove(skipped); 
        }else{
            graph.getData().add(skipped);
     
        }
        
    }
    @FXML
    public void handlePassed() {
        if(graph.getData().contains(passed)){
           graph.getData().remove(passed); 
        }else{
            graph.getData().add(passed);
     
        }
        
    }
    
    @FXML
    public void handleTotal() {
        if(graph.getData().contains(total)){
           graph.getData().remove(total); 
        }else{
            graph.getData().add(total);
     
        }
        
    }

    /* @FXML 
     public void handleRepoChange3 () {

     setPieChartData("ap-workflow-msrbsv1_acceptance");
    
     }
     @FXML 
     public void handleRepoChange4 () {

     setPieChartData("ap-model-msrbsv1_acceptance");
    
     }  */
    private void setPieChartData(String repo) {
        // TODO

        Pane root = new Pane();
        Scene scene = new Scene(root);
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

    private void setChartData(String repo) {
        graph.getData().clear();
        total = new XYChart.Series();
        total.setName("Total Tests");
//        ObservableList<XYChart.Series> totalData
//                = FXCollections.observableArrayList();
        passed = new XYChart.Series();
        passed.setName("Tests Passed");
        failed = new XYChart.Series();
        failed.setName("Tests Failed");
        skipped = new XYChart.Series();
        skipped.setName("Tests Skipped");
      

        List<ChartSeries> cs = excelReader.getSeriesChartData(repo);
        cs.stream().forEach(chartSeries -> {
            System.out.println("date: " + chartSeries.getDate() + ", " + chartSeries.getTotal());
            total.getData().add(new XYChart.Data(chartSeries.getDate(), chartSeries.getTotal()));
            passed.getData().add(new XYChart.Data(chartSeries.getDate(), chartSeries.getPassed()));
            failed.getData().add(new XYChart.Data(chartSeries.getDate(), chartSeries.getFailed()));
            skipped.getData().add(new XYChart.Data(chartSeries.getDate(), chartSeries.getSkipped()));
        });

        graph.getData().addAll(failed);
        graph.getData().addAll(skipped);
        graph.getData().addAll(passed);
        graph.getData().addAll(total);

    }

}
