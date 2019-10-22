import java.util.Calendar;
import java.util.Date;

public class Time {
    private Calendar calendar;
    private Date date;
    private long starttime,midtime,endtime;
    private int year,month,day,hour,min,second;
    public Time (){
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(year,month,day,hour-1,min,second);
        endtime = calendar.getTimeInMillis();
    }
    public long countdown(int hour,int min,int second){
        date = new Date();
        starttime = date.getTime();
        midtime = (endtime - starttime)/1000;
        return midtime;
    }
    public long countdown2(int hour,int min,int second){
        midtime = endtime / 1000;
        return midtime;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
