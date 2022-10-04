package Peeyade;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

public class Schedule{
    private int id;
    private String date;
    private String time;
    boolean isAvailabe = true;

    public void setId(int n){
        id = n;
    }

    public void setDate(String s){
        SimpleDateFormat dformat = new SimpleDateFormat("yyyy-MM-dd");
        try{
        Date dnow = new Date();
        Date d = dformat.parse(s);
        if(d.compareTo(dnow)<=0){
            isAvailabe = false;
        }
        date = s;
        } catch(ParseException e){
            throw new InputMismatchException("Date format is not valid");
        }
    }

    public void setTime(String s){
        if(!s.contains(":")){
            throw new InputMismatchException("Hour format is not valid");
        }
        int hour = Integer.parseInt(s.split(":")[0]);
        int minute = Integer.parseInt(s.split(":")[1]);
        if((hour>=0&&hour<=23)&&(minute>=0&&minute<=59)){
            time = s;
        }else{
            throw new InputMismatchException("Schedule Time is not valid");
        }
    }

    public int getId(){
        return id;
    }

    public String getDate(){
        return date;
    }

    public String getTime(){
        return time;
    }
    public String getisValid(){
        if(isAvailabe){
            return "valid";
        }else{
            return "invalid";
        }
    }

    public Schedule(int n, String s, String d, String t){
        if(s.equalsIgnoreCase("valid")){
            isAvailabe = true;
        }else{
            isAvailabe= false;
        }
        setId(n);
        setDate(d);
        setTime(t);
    }

    public void printSchedule(){
        System.out.println("Tarikh: "+date+" | saat: "+time);
    }
}
