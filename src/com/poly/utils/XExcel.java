/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package com.poly.utils;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import javax.swing.JTable;
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
///**
// *
// * @author nguye
// */
//public class XExcel {
//    public void exportTable(JTable table, File file) throws IOException {
//        //TableModel model = tblNhanVien.getModel();
//        ///FileWriter out = new FileWriter(file);
//        //BufferedOutputStream dem = null; // đệm 1 output stream
//        XSSFWorkbook ghiFile = new XSSFWorkbook();// đọc file theo định dạng
//        FileOutputStream ghiDuLieu = null;//ghi lại dữ liệu
//        XSSFSheet Sheet = ghiFile.createSheet("JTable Sheet");
//        for (int i = 0; i < table.getRowCount(); i++) { // lấy các cột
//            XSSFRow excelRow = Sheet.createRow(i);
//            for (int j = 0; j < table.getColumnCount(); j++) { // lấy các dòng
//                XSSFCell excelCeli = excelRow.createCell(j);
//                excelCeli.setCellValue(table.getValueAt(i, j).toString());// lấy giá trị 
//            }
//            ghiDuLieu = new FileOutputStream(file);
//            //dem = new BufferedOutputStream(ghiDuLieu);
//            ghiFile.write(ghiDuLieu);
//        }
//    }
//}
