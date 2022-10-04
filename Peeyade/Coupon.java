package Peeyade;

import java.util.InputMismatchException;

public class Coupon {
    private int id;
    private String code;
    private double offAmount;

    public void setId(int n){
        id = n;
    }

    public void setCode(String s){
        code = s;
    }

    public void setOffAmount(double d){
        if(d>=0 && d<=100){
            offAmount = d;
        }else{
            throw new InputMismatchException("Discount amount is out of range");
        }
    }

    public int getId(){
        return id;
    }

    public String getCode(){
        return code;
    }

    public double getOffAmount(){
        return offAmount;
    }

    public Coupon(int n, String c, double d){
        setId(n);
        setCode(c);
        setOffAmount(d);
    }
}
