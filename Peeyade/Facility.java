package Peeyade;

import java.util.InputMismatchException;

public class Facility {
    private int itemId;
    boolean facilities;
    boolean brunch;
    boolean ticket;
    boolean transportation;
    boolean food;
    private String[] others = new String[20];
    
    public void setOthers(String[] s){
        if(s.length>20){
            throw new InputMismatchException("Others out of range");
        }else{
            others = s;
        }
    }

    public String[] getOthers(){
        return others;
    }
    public int getId(){
        return itemId;
    }

    private boolean booleanCheck(String s){
        if(s.equalsIgnoreCase("true"))
            return true;
        else
            return false;
    }

    public Facility(int id, String facilitiy, String b,String t, String transport, String f, String other){
        itemId = id;
        facilities = booleanCheck(facilitiy);
        brunch = booleanCheck(b);
        ticket = booleanCheck(t);
        transportation = booleanCheck(transport);
        food = booleanCheck(f);
        if(!other.equalsIgnoreCase("false"))
            setOthers(other.split("-"));
    }

    public void printFacilities(){
        if(facilities)
            System.out.println("Facilities");
        if(brunch)
            System.out.println("brunch");
        if(ticket)
            System.out.println("ticket");
        if(transportation)
            System.out.println("transportation");
        if(food)
            System.out.println("food");
        if(others[0]!=""){
            for(int i=0; i<25; i++){
                if(others[i]!=null){
                    System.out.println(others[i]);
                }else{
                    break;
                }
            }
        }
    }

}
