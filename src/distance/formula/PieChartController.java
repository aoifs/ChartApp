/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distance.formula;





import java.awt.Color;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.chart.PieChart;

/**
 *
 * @author eaoicon
 */
public class PieChartController implements Initializable {
    
    @FXML
    private PieChart pieChart;
    
    
    
  /* @FXML
   private Label green;
   @FXML
   private Label orange;
   @FXML
   private Label red;
   */
   
   
   
 
    @Override
public void initialize(URL url, ResourceBundle rb) {
    // TODO

pieChart.setLabelLineLength(10);
pieChart.setLegendSide(Side.LEFT);

 ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
            new PieChart.Data("Failed 15%", 0.15),
            new PieChart.Data("Unstable 25%", 0.25),
            new PieChart.Data("Passed 60%", 0.60));

    
    pieChart.setData(pieChartData);
    
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

}
