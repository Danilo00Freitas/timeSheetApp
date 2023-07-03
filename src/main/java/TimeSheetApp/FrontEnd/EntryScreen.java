package TimeSheetApp.FrontEnd;

import TimeSheetApp.BackEnd.PersonalizedTimer;
import TimeSheetApp.BackEnd.ScreenManager;
import TimeSheetApp.BackEnd.TimeSheetManager;
import TimeSheetApp.BackEnd.TimeSheetRecorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class EntryScreen extends JFrame {
    private JPanel mainPanel;
    private JPanel timerPane;
    private JTextField dateTextF;
    private JTextField timetextF;
    private TimeSheetManager timeSheetManager = new TimeSheetManager();
    private List<String> timeSheetRecorderlist = new ArrayList<>();
    private ScreenManager screenManager;
    private int rowIndex = 0;


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
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();

        entryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String entryTime = timeFormat.format(new Date());
                TimeSheetRecorder record = new TimeSheetRecorder();
                timeSheetRecorderlist.add(entryTime);
                /*record.setEntryTime(entryTime);
                timeSheetRecorderlist.add(record);*/
                JOptionPane.showMessageDialog(null, "Batida de entrada às " + entryTime + " adicionada");
            }
        });

        breakBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String breakTime = timeFormat.format(new Date());
                TimeSheetRecorder record = new TimeSheetRecorder();
                timeSheetRecorderlist.add(breakTime);
                /*record.setBreakTime(breakTime);
                timeSheetRecorderlist.add(record);*/
                JOptionPane.showMessageDialog(null, "Batida de saída para almoço às " + breakTime + " adicionada");
            }
        });

        breakReturnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String returnTime = timeFormat.format(new Date());
                TimeSheetRecorder record = new TimeSheetRecorder();
                timeSheetRecorderlist.add(returnTime);
                /*record.setReturnTime(returnTime);
                timeSheetRecorderlist.add(record);*/
                JOptionPane.showMessageDialog(null, "Volta do almoço às " + returnTime + " registrada");
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String exitTime = timeFormat.format(new Date());
                TimeSheetRecorder record = new TimeSheetRecorder();
                timeSheetRecorderlist.add(exitTime);
                /*record.setExitTime(exitTime);
                timeSheetRecorderlist.add(record);*/
                JOptionPane.showMessageDialog(null, " Saída registrada às " + exitTime + " registrada");
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timeSheetRecorderlist.size() == 4) {
                    if (timeSheetManager.verifyFileExistance()) {
                        timeSheetManager.createWorkbookAndSheet();
                        JOptionPane.showMessageDialog(null, "Uma nova planilha foi criada");
                    }
                } else {
                    timeSheetRecorderlist.clear();
                    JOptionPane.showMessageDialog(null, "ERRO! Você não inseriu as 4 batidas de ponto. Tente novamente!");
                }
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
        timetextF.setEditable(false);
        localTimer.startTimer();
        dateTextF.setText(localTimer.getDate());
        dateTextF.setEditable(false);

    }
}
