package TimeSheetApp.BackEnd;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimeSheetManager {
    private List<TimeSheetRecorder> registerList;

    public TimeSheetManager(){
        registerList = new ArrayList<>();
    }

    public void addRegister(TimeSheetRecorder newRegister){
        registerList.add(newRegister);
    }

    /*public boolean exportingRegisterList(String archiveName){
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Time sheet register");

        int rowIndex = 0;
        for (TimeSheetRecorder register : registerList) {
            Row row = sheet.createRow(rowIndex++);
            Cell dateCell = row.createCell(0);
            dateCell.setCellValue(register.getDate());
            Cell entryCell = row.createCell(1);
            entryCell.setCellValue(register.getEntryTime());
            Cell breakCell = row.createCell(2);
            breakCell.setCellValue(register.getBreakTime());
            Cell returnCell = row.createCell(3);
            returnCell.setCellValue(register.getReturnTime());
            Cell exitCell = row.createCell(4);
            exitCell.setCellValue(register.getExitTime());
        }

        try (FileOutputStream fileOut = new FileOutputStream(archiveName)){
            workbook.write(fileOut);
            return true;
        } catch (IOException e){
            return false;
        }
    }*/
}
