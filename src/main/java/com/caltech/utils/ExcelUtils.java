package com.caltech.utils;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelUtils {

    public Object[][] excelReader() throws Exception{
        FileInputStream fis=null;
        XSSFWorkbook wb=null;
        Object[][] data=null;

        try {
           fis = new FileInputStream(System.getProperty("user.dir") + "/logindata.xlsx");
            wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheet("data");
            int row = sheet.getPhysicalNumberOfRows();
            System.out.println(row);
            int cell = sheet.getRow(0).getPhysicalNumberOfCells();
            System.out.println(cell);


             data = new Object[row - 1][cell];

            for (int i = 1; i < row; i++) {

                for (int j = 0; j < cell; j++) {
                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
        } catch(Exception e) {
            e.printStackTrace();

        } finally {
            if (wb != null) wb.close();
            if (fis != null) fis.close();
        }
            return data;
        }
    }


