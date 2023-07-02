package TimeSheetApp.FrontEnd;

import TimeSheetApp.BackEnd.ScreenManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangeEntryScreen extends JFrame {
    private JPanel mainPanel;
    private ScreenManager screenManager;

    public ChangeEntryScreen(ScreenManager screenManager) {
        // Inicializando o screemanager
        this.screenManager = screenManager;

        // Criar armação principal
        setTitle("Alterar marcação de ponto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 800);
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setResizable(false);

        // Criar painel principal onde os botões vão ficar
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        getContentPane().add(mainPanel);

        // Criar e adicionar o botão returnToMenuScreen
        JButton returnToMenuScreenBtn = new JButton("Voltar para Menu");
        returnToMenuScreenBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenManager.showMenuScreen();
            }
        });

        mainPanel.add(returnToMenuScreenBtn);

        // Configurar a janela
        setPreferredSize(new Dimension(600, 400)); // Defina o tamanho preferido desejado
        pack();
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setResizable(false);
    }
}
