package com.mycompany.chartproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Dashboard.fxml"));

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");

        stage.setTitle("JavaFX and Maven");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        launch(args);

        /*XSSFWorkbook workbook = new XSSFWorkbook();
         XSSFSheet sheet = workbook.createSheet("Sample sheet");
 
         Map<String, Object[]> data = new HashMap<String, Object[]>();
         data.put("1", new Object[] {"Emp No.", "Name", "Salary"});
         data.put("2", new Object[] {1d, "John", 1500000d});
         data.put("3", new Object[] {2d, "Sam", 800000d});
         data.put("4", new Object[] {3d, "Dean", 700000d});
 
         Set<String> keyset = data.keySet();
         int rownum = 0;
         for (String key : keyset) {
         Row row = sheet.createRow(rownum++);
         Object [] objArr = data.get(key);
         int cellnum = 0;
         for (Object obj : objArr) {
         Cell cell = row.createCell(cellnum++);
         if(obj instanceof Date) 
         cell.setCellValue((Date)obj);
         else if(obj instanceof Boolean)
         cell.setCellValue((Boolean)obj);
         else if(obj instanceof String)
         cell.setCellValue((String)obj);
         else if(obj instanceof Double)
         cell.setCellValue((Double)obj);
         }
         }
 
         try {
         FileOutputStream out = 
         new FileOutputStream(new File("src/main/resources/blank.xlsx"));
         workbook.write(out);
         out.close();
         System.out.println("Excel written successfully..");
     
         } catch (FileNotFoundException e) {
         e.printStackTrace();
         } catch (IOException e) {
         e.printStackTrace();
         }
         }
         }  */
        /*   try {
     
         String test = "src/main/resources/Test.xlsx";
         FileInputStream file = new FileInputStream(new File(test));
     
         //Get the workbook instance for XLS file 
         XSSFWorkbook workbook = new XSSFWorkbook(file);
 
         //Get first sheet from the workbook
         XSSFSheet sheet = workbook.getSheetAt(0);
     
         //Iterate through each rows from first sheet
         Iterator<Row> rowIterator = sheet.iterator();
         while(rowIterator.hasNext()) {
         Row row = rowIterator.next();
    
         //For each row, iterate through each columns
         Iterator<Cell> cellIterator = row.cellIterator();
      
       
         while(cellIterator.hasNext()) {
             
         Cell cell = cellIterator.next();
        
         switch(cell.getCellType()) {
                
         case Cell.CELL_TYPE_NUMERIC:
                   
         if  (DateUtil.isCellDateFormatted(cell)) {
          
         System.out.println(cell.getDateCellValue()+ "\t\t" ) ;
           
            
         }
                  
                   
    
         else{
         System.out.print(cell.getNumericCellValue() + "\t\t");
         
                       
        
          
          
         }
         break;
         case Cell.CELL_TYPE_BOOLEAN:
         System.out.print(cell.getBooleanCellValue() + "\t\t");
         break;
               
         case Cell.CELL_TYPE_STRING:
         System.out.print(cell.getStringCellValue() + "\t\t");
         break;
                    
                    
         }
            
         }
         System.out.println("");
         }
         file.close();
         FileOutputStream out = 
         new FileOutputStream(new File(test));
         workbook.write(out);
         out.close();
     
         } catch (FileNotFoundException e) {
         e.printStackTrace();
         } catch (IOException e) {
         e.printStackTrace();
         }
   
         }
    
         } 
         */
    }
}
