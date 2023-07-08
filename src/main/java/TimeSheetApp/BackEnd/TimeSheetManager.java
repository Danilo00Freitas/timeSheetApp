package TimeSheetApp.BackEnd;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeSheetManager {
    private List<String> timeSheetRecorderList; // Declaração da lista
    private Sheet sheet;
    private String excelDirPath;
    private String fileName = "PontoEletrônico.xlsx";
    private String filePath;
    private Workbook workbook;

    public TimeSheetManager() {
        timeSheetRecorderList = new ArrayList<>(); // Inicialização da lista
        excelDirPath = "/home/danilo/Desktop/estudos/JAVA/TImeSheet";
        filePath = excelDirPath + File.separator + fileName;

        File file = new File(filePath);
        if (file.exists()) {
            try (FileInputStream inputStream = new FileInputStream(file)) {
                this.workbook = new XSSFWorkbook(inputStream);
                this.sheet = workbook.getSheetAt(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            this.sheet = createWorkbookAndSheet();
        }
    }

    public Sheet createWorkbookAndSheet() {
        String[] titles = {"DATA", "ENTRADA", "INTERVALO", "RETORNO INTERVALO", "SAÍDA"};
        this.workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(fileName);
        Row row = sheet.createRow(0);
        int titleColum = 0;

        for (int i = 0; i < 5; i++) {
            Cell cell = row.createCell(titleColum);
            cell.setCellValue(titles[i]);
            sheet.autoSizeColumn(i);
            titleColum++;
        }
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sheet; // Retorna a planilha criada
    }

    public void exportToTable(ArrayList<String> timeSheetRecorderList) {
        SimpleDateFormat dateFormatted = new SimpleDateFormat("dd/MM/yyyy");
        String currentDate = timeSheetRecorderList.get(0);
        int cellIndex = 0;
        int rowIndex = this.sheet.getLastRowNum() + 1;

        Row row = sheet.createRow(rowIndex);
        for (String item : timeSheetRecorderList) {
            row.createCell(cellIndex).setCellValue(item);
            cellIndex++;
        }
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        }
        catch (IOException e) {
                e.printStackTrace();
        }
    }
}

