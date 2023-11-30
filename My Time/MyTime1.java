public class MyTime1 {
    private int hour;
    private int minute;
    private int second;

    public MyTime1(int hour, int minute, int second) {
        setTime(hour, minute, second);
    }

    public void setTime(int hour, int minute, int second) {
        if (isValidTime(hour, minute, second)) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
        } else {
            System.out.println("Yaroqsiz soat, daqiqa yoki soniya!");
        }
    }

    private boolean isValidTime(int hour, int minute, int second) {
        return hour >= 0 && hour <= 23 &&
                minute >= 0 && minute <= 59 &&
                second >= 0 && second <= 59;
    }

    public void setHour(int hour) {
        if (isValidTime(hour, this.minute, this.second)) {
            this.hour = hour;
        } else {
            System.out.println("Yaroqsiz soat!");
        }
    }

    public void setMinute(int minute) {
        if (isValidTime(this.hour, minute, this.second)) {
            this.minute = minute;
        } else {
            System.out.println("Yaroqsiz daqiqa!");
        }
    }

    public void setSecond(int second) {
        if (isValidTime(this.hour, this.minute, second)) {
            this.second = second;
        } else {
            System.out.println("Yaroqsiz soniya!");
        }
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", this.hour, this.minute, this.second);
    }

    public void nextSecond() {
        int nextSecond = (this.second + 1) % 60;
        int nextMinute = (this.second + 1) / 60;
        this.second = nextSecond;
        nextMinute(nextMinute);
    }

    public void nextMinute() {
        nextMinute(1);
    }

    public void nextMinute(int minutesToAdd) {
        int totalMinutes = this.minute + minutesToAdd;
        this.minute = totalMinutes % 60;
        int nextHour = totalMinutes / 60;
        nextHour(nextHour);
    }

    public void nextHour() {
        nextHour(1);
    }

    public void nextHour(int hoursToAdd) {
        int totalHours = this.hour + hoursToAdd;
        this.hour = totalHours % 24;
    }

    public void previousSecond() {
        int prevSecond = (this.second - 1 + 60) % 60;
        int prevMinute = (this.second - 1) / 60;
        this.second = prevSecond;
        previousMinute(prevMinute);
    }

    public void previousMinute() {
        previousMinute(1);
    }

    public void previousMinute(int minutesToSubtract) {
        int totalMinutes = this.minute - minutesToSubtract + 60;
        this.minute = totalMinutes % 60;
        int prevHour = totalMinutes / 60;
        previousHour(prevHour);
    }

    public void previousHour() {
        previousHour(1);
    }

    public void previousHour(int hoursToSubtract) {
        int totalHours = this.hour - hoursToSubtract + 24;
        this.hour = totalHours % 24;
    }

    public static void main(String[] args) {
        MyTime1 myTime = new MyTime1(12, 30, 45);
        System.out.println("Initial Time: " + myTime.toString());

        myTime.nextSecond();
        System.out.println("Next Second: " + myTime.toString());

        myTime.nextMinute();
        System.out.println("Next Minute: " + myTime.toString());

        myTime.nextHour();
        System.out.println("Next Hour: " + myTime.toString());

        myTime.previousSecond();
        System.out.println("Previous Second: " + myTime.toString());

        myTime.previousMinute();
        System.out.println("Previous Minute: " + myTime.toString());

        myTime.previousHour();
        System.out.println("Previous Hour: " + myTime.toString());
    }
}
