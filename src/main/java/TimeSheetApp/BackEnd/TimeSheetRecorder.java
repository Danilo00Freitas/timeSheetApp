package TimeSheetApp.BackEnd;

import java.util.Date;

public class TimeSheetRecorder {
    private Date dateTime;
    private Date date;

    public TimeSheetRecorder() {
        this.date = getDate();
    }

    public void setDateTime(Date dateTimeToRegister) {
        this.dateTime = dateTimeToRegister;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Date getDate(){
        return this.date;
    }
}

