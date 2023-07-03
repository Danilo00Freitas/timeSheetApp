package TimeSheetApp.BackEnd;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeSheetManager {
    private List<TimeSheetRecorder> timeSheetRecorderList; // Declaração da lista
    private Workbook workbook;
    private Sheet sheet;
    private String excelDirPath;
    private String fileName;
    private String filePath;

    public TimeSheetManager() {
        timeSheetRecorderList = new ArrayList<>(); // Inicialização da lista
    }

    public void createWorkbookAndSheet() {
        this.workbook = new XSSFWorkbook();
        this.sheet = workbook.createSheet("PontoEletrônico.xlsx");
    }

    public void exportToTable(String archiveName) {
        int rowIndex = 0;
        for (TimeSheetRecorder register : timeSheetRecorderList) {
            Row row = sheet.createRow(rowIndex++);
            addDateRegister(row, register);
            addEntryRegister(row, register);
            addBreakRegister(row, register);
            addReturnRegister(row, register);
            addExitRegister(row, register);
        }
        try (FileOutputStream fileOut = new FileOutputStream(archiveName)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void addDateRegister(Row row, TimeSheetRecorder register){
        Cell dateCell = row.createCell(0);
    }

    public void addEntryRegister(Row row, TimeSheetRecorder register) {
        Cell entryCell = row.createCell(1);
        entryCell.setCellValue(register.getEntryTime());
    }

    private void addBreakRegister(Row row, TimeSheetRecorder register) {
        Cell breakCell = row.createCell(2);
        breakCell.setCellValue(register.getBreakTime());
    }

    private void addReturnRegister(Row row, TimeSheetRecorder register) {
        Cell returnCell = row.createCell(3);
        returnCell.setCellValue(register.getReturnTime());
    }

    private void addExitRegister(Row row, TimeSheetRecorder register) {
        Cell exitCell = row.createCell(4);
        exitCell.setCellValue(register.getExitTime());
    }

    public TimeSheetRecorder getLastRegister() {
        if (timeSheetRecorderList.isEmpty()) {
            TimeSheetRecorder newRegister = new TimeSheetRecorder();
            timeSheetRecorderList.add(newRegister);
            return newRegister;
        } else {
            return timeSheetRecorderList.get(timeSheetRecorderList.size() - 1);
        }
    }

    public boolean verifyFileExistance() {
        excelDirPath = "/home/danilo/Desktop/estudos/JAVA/TImeSheet";
        fileName = "PontoEletrônico.xlsx";
        filePath = excelDirPath + File.separator + fileName;
        File file = new File(filePath);
        if (!file.exists()) {
            createWorkbookAndSheet();
            return true;
        }else{
            return false;
        }
    }

}
