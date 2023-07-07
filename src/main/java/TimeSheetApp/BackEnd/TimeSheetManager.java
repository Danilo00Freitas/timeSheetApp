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
}
