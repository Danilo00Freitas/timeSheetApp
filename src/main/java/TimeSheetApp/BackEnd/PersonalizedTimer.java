package TimeSheetApp.BackEnd;

import javax.swing.JTextField;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class PersonalizedTimer {

    private JTextField timeTxt;
    private JTextField dateTxt;

    public PersonalizedTimer(JTextField timeTxt) {
        this.timeTxt = timeTxt;
        this.dateTxt = new JTextField();
        SimpleDateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateTxt.setText(dateFormat.format(new Date()));
    }

    // Atualizar o campo de texto da data
    public String getDate(){
        return dateTxt.getText();
    }


    public void startTimer() {
        // Cria um TimerTask para atualizar o campo de texto do horário
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                updateTime();
            }
        };

        // Cria um Timer para agendar a tarefa de atualização a cada segundo
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1000);
    }

    private void updateTime() {
        // Configurar formato do horário
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

        // Obter o horário atual
        Date currentTime = new Date();

        // Atualizar o campo de texto do horário
        timeTxt.setText(timeFormat.format(currentTime));
    }
    public Date getActualDate(){
        return new Date();
    }

}