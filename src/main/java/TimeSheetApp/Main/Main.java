package TimeSheetApp.Main;

import TimeSheetApp.BackEnd.ScreenManager;
import TimeSheetApp.FrontEnd.MenuScreen;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ScreenManager screenManager = new ScreenManager();
        screenManager.showMenuScreen();
    }
}