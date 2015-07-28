/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chartproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author eaoicon
 */
public class ExcelReader {

    public Map<String, Double> getPieChartData(String repo) {
        Map<String, Double> map = new HashMap<>();
        try {
            String fileName = "src/main/resources/Stabilityfinal.xlsx";
            String test = fileName;
            //String fileName2 = "src/main/resources/Series.xlsx";
            //String test2 = fileName2;
            FileInputStream file = new FileInputStream(new File(test));

            //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheet(repo);

            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
            int total = -1;
            int success = 0;
            int failure = 0;
            int unstable = 0;
            int aborted = 0;

            while (rowIterator.hasNext()) {
                ++total;
                Row row = rowIterator.next();

                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:

                            if (DateUtil.isCellDateFormatted(cell)) {

                                System.out.println(cell.getDateCellValue() + "\t\t");

                            } else {
                                System.out.print(cell.getNumericCellValue() + "\t\t");

                            }
                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;

                        case Cell.CELL_TYPE_STRING:
                            if (cell.getStringCellValue().equalsIgnoreCase("SUCCESS")) {
                                ++success;
                            } else if (cell.getStringCellValue().equalsIgnoreCase("FAILURE")) {
                                ++failure;
                            } else if (cell.getStringCellValue().equalsIgnoreCase("UNSTABLE")) {
                                ++unstable;
                            } else if (cell.getStringCellValue().equalsIgnoreCase("ABORTED")) {
                                ++aborted;
                            }
                            System.out.print(cell.getStringCellValue() + "\t\t");
                            break;

                    }
                }
                System.out.println("");

                file.close();
                FileOutputStream out
                        = new FileOutputStream(new File(fileName));
                workbook.write(out);
                out.close();
            }
            System.out.println("Total " + total);
            System.out.println("no. Successful " + success);
            System.out.println("no. Failures " + failure);
            System.out.println("no. Unstable " + unstable);

            int green = ((success * 100 / total));
            double passedPercentage = (double) green / 100;
            System.out.println("Passed: " + passedPercentage);

            int red = ((failure * 100 / total));
            double failedPercentage = (double) red / 100;
            System.out.println("Failed: " + failedPercentage);

            int orange = ((unstable * 100 / total));
            double unstablePercentage = (double) orange / 100;
            System.out.println("Unstable: " + unstablePercentage);

            int abort = ((aborted * 100 / total));
            double abortedPercentage = (double) abort / 100;
            System.out.println("Aborted: " + abortedPercentage);

            map.put("Failed", failedPercentage);

            map.put("Unstable", unstablePercentage);

            map.put("Passed", passedPercentage);

            map.put("Aborted", abortedPercentage);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;

    }

    public List<ChartSeries> getSeriesChartData(String repo) {
        List<ChartSeries> cs = new ArrayList<>();
        try {
            String fileName = "src/main/resources/Series.xlsx";
            String test = fileName;
            //String fileName2 = "src/main/resources/Series.xlsx";
            //String test2 = fileName2;
            FileInputStream file = new FileInputStream(new File(test));

            //Get the workbook instance for XLS file 
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheet(repo);

            //Iterate through each rows from first sheet
            Iterator<Row> rowIterator = sheet.iterator();
        
            ChartSeries chartSeries = null;
            while (rowIterator.hasNext()) {
                chartSeries = new ChartSeries();
                
                Row row = rowIterator.next();
                if (row.getRowNum()==0){
                   row = rowIterator.next();
                }

                //For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    switch (cell.getCellType()) {

                        case Cell.CELL_TYPE_NUMERIC:
                            //System.out.println("numeric");
                            switch (cell.getColumnIndex()) {
                                case 1:
                                    chartSeries.setTotal((int)cell.getNumericCellValue());
                                    break;
                                case 2:
                                    chartSeries.setPassed((int)cell.getNumericCellValue());
                                    break;
                                case 3:
                                    chartSeries.setFailed((int)cell.getNumericCellValue());
                                    break;
                                case 4:
                                    chartSeries.setSkipped((int)cell.getNumericCellValue());
                                    break;
                            }

                            System.out.println(cell.getDateCellValue() + "\t\t");
                            System.out.print(cell.getNumericCellValue() + "\t\t");

                            break;
                        case Cell.CELL_TYPE_BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t\t");
                            break;

                        case Cell.CELL_TYPE_STRING:
                            
                           chartSeries.setDate(cell.getStringCellValue());
                           System.out.print(cell.getStringCellValue() + "\t\t");
                            break;

                    }
                }
                System.out.println("");
                cs.add(chartSeries);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cs;

    }
}

class ChartSeries {

    private String date;
    private int total, passed, failed, skipped;

    public ChartSeries() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public int getSkipped() {
        return skipped;
    }

    public void setSkipped(int skipped) {
        this.skipped = skipped;
    }

    @Override
    public String toString() {
        return "ChartSeries{" + "date=" + date + ", total=" + total + ", passed=" + passed + ", failed=" + failed + ", skipped=" + skipped + '}';
    }

}

