package TimeSheetApp.FrontEnd;

import TimeSheetApp.BackEnd.PersonalizedTimer;
import TimeSheetApp.BackEnd.ScreenManager;
import TimeSheetApp.BackEnd.TimeSheetManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.text.SimpleDateFormat;

public class EntryScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel timerPane;
    private JTextField dateTextF;
    private JTextField timetextF;
    private TimeSheetManager timeSheetManager;
    private ScreenManager screenManager;

    public EntryScreen(ScreenManager screenManager) {
        // Inicializando o screemanager
        this.screenManager = screenManager;

        // Configurar o layout do timerPane como GridLayout com 2 linhas e 1 coluna
        timerPane = new JPanel();
        timerPane.setLayout(new GridLayout(2, 1));
        dateTextF = new JTextField();
        timetextF = new JTextField();

        // Adicionar os componentes ao timerPane/container
        timerPane.add(dateTextF);
        timerPane.add(timetextF);
        Font font = new Font("Verdana", Font.PLAIN, 50);
        dateTextF.setFont(font);
        dateTextF.setHorizontalAlignment(SwingConstants.CENTER);
        timetextF.setFont(font);
        timetextF.setHorizontalAlignment(SwingConstants.CENTER);

        // Criar e configurar o JFrame
        setTitle("TimeSheetApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1)); // GridLayout com 2 linhas e 1 coluna
        getContentPane().add(mainPanel);

        mainPanel.add(timerPane);

        // Adicionar botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(6, 1)); // GridLayout com 1 linha e 4 colunas

        JButton entryBtn = new JButton("Entrada");
        JButton breakBtn = new JButton("Saída Intervalo");
        JButton breakReturnBtn = new JButton("Retorno intervalo");
        JButton exitBtn = new JButton("Saída");

        Date currentDate = new Date();
        SimpleDateFormat dateFormatted = new SimpleDateFormat("dd/MM/yyyy");
        String stringF = dateFormatted.format(currentDate);
        JButton saveBtn = new JButton("Salvar ponto do dia " + stringF);
        JButton returnToMenuBtn = new JButton("Voltar para Menu");

        buttonPanel.add(entryBtn);
        buttonPanel.add(breakBtn);
        buttonPanel.add(breakReturnBtn);
        buttonPanel.add(exitBtn);
        buttonPanel.add(saveBtn);
        buttonPanel.add(returnToMenuBtn);

        mainPanel.add(buttonPanel);

        // Adicionando ação aos botões
        timeSheetManager = new TimeSheetManager();

        entryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O botão de entrar foi acionado ");
            }
        });

        breakBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O botão de sair para almoço foi acionado ");
            }
        });

        breakReturnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O botão de voltar do almoço foi acionado");
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O botão de saída foi acionado");
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "O botão de salvar foi acionado");
                /*Eu quero fazer uma lógica que possibilite que o programa analise se todos os dados do dia foram preenchidos,
                 * Caso sim, o programa estará importando os dados para o excel e atualizando a planilha, se não quero que ele
                 * retorne qual informação falta ser adicionada*/
            }
        });

        returnToMenuBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                screenManager.showMenuScreen();
            }
        });

        // Configurar a janela e torná-la visível
        setPreferredSize(new Dimension(600, 400)); // Defina o tamanho preferido desejado
        pack();
        setLocationRelativeTo(null); // Centralizar a janela na tela
        setResizable(false);

        // Inicializar a interface
        initializeUI();
    }

    // Iniciar o timer para atualizar o campo de texto do horário
    public void initializeUI() {
        PersonalizedTimer localTimer = new PersonalizedTimer(timetextF);
        localTimer.startTimer();
        dateTextF.setText(localTimer.getDate());
    }
}
