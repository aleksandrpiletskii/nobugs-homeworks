package org.example.homeworks.clock;

public class Clock implements Readable {
    private int hours;
    private int minutes;
    private int seconds;

    public void setHours(int hours)
    {
        this.hours = hours;
    }

    public int getHours() {
        return this.hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getMinutes() {
        return this.minutes;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getSeconds() {
        return this.seconds;
    }

    public void tick(){
        int tick = getSeconds() + 1;
        System.out.println(getHours() + ":" + getMinutes() + ":" + tick);
    }

    @Override
    public void readTime(){
        System.out.println(getHours() + ":" + getMinutes() + ":" + getSeconds());
    }
}
