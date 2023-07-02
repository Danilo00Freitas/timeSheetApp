package TimeSheetApp.BackEnd;

import java.util.Date;

public class TimeSheetRecorder {
    private Date dateTime;
    private Date date;
    private String breakTime;
    private String returnTime;
    private String exitTime;
    private String entryTime;

    public TimeSheetRecorder() {
        this.date = getDate();
    }

    public void setDateTime(Date dateTimeToRegister) {
        this.dateTime = dateTimeToRegister;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public Date getDate() {
        return this.date;
    }

    public String getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(String breakTime) {
        this.breakTime = breakTime;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

}
