package TimeSheetApp.BackEnd;

import TimeSheetApp.FrontEnd.MenuScreen;
import TimeSheetApp.FrontEnd.EntryScreen;

public class ScreenManager {

    private MenuScreen menuScreen;
    private EntryScreen entryScreen;

    public ScreenManager(){
        menuScreen = new MenuScreen(this);
        entryScreen = new EntryScreen(this);
    }

    public void showMenuScreen() {
        menuScreen.setVisible(true);
        entryScreen.setVisible(false);
    }

    public void showEntryScreen() {
        menuScreen.setVisible(false);
        entryScreen.initializeUI();
        entryScreen.setVisible(true);
    }
}
