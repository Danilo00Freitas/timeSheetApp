package TimeSheetApp.BackEnd;

import TimeSheetApp.FrontEnd.MenuScreen;
import TimeSheetApp.FrontEnd.EntryScreen;
import TimeSheetApp.FrontEnd.ChangeEntryScreen;

public class ScreenManager {
    private MenuScreen menuScreen;
    private EntryScreen entryScreen;
    private ChangeEntryScreen changeEntryScreen;
    private TimeSheetManager timeSheetManager;

    public ScreenManager() {
        // Inicializa os objetos das telas MenuScreen, EntryScreen e ChangeEntryScreen

        timeSheetManager = new TimeSheetManager();
        menuScreen = new MenuScreen(this);
        entryScreen = new EntryScreen(this, timeSheetManager);
        changeEntryScreen = new ChangeEntryScreen(this,timeSheetManager);
    }

    public void showMenuScreen() {
        // Mostra a tela do Menu e esconde as outras telas
        menuScreen.setVisible(true);
        entryScreen.setVisible(false);
        changeEntryScreen.setVisible(false);
    }

    public void showEntryScreen() {
        // Mostra a tela de Entrada e esconde as outras telas
        menuScreen.setVisible(false);
        entryScreen.setVisible(true);
        changeEntryScreen.setVisible(false);
    }

    public void showChangeEntryScreen() {
        // Mostra a tela de Alterar Marcação de Ponto e esconde as outras telas
        menuScreen.setVisible(false);
        entryScreen.setVisible(false);
        changeEntryScreen.setVisible(true);
    }
}
