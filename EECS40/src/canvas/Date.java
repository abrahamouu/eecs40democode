package canvas;

//copy constructor demo
public class Date {
    private int month;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    private int day;
    private int year;

    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public Date(Date other){
        this.month = other.month;
        this.day = other.day;
        this.year = other.year;
    }

    public String toString(){
        return month + "/" + day + "/" + year;
    }
}
