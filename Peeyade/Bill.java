package Peeyade;

import java.util.InputMismatchException;

public class Bill {
    private int itemId;
    private String buyerName;
    private String BuyerLastname;
    private String BuyerPhoneNumber;
    private int amount;
    private int price;
    private int totalPrice;

    public void setItemId(int n){
        itemId = n;
    }

    public void setBuyerName(String s){
        if(s!=""){
            buyerName = s;
        }
    }

    public void setBuyerLastname(String s){
        if(s!=""){
            BuyerLastname = s;
        }
    }

    public void setBuyerPhoneNumber(String s){
        if(s!=""){
            BuyerPhoneNumber = s;
        }
    }

    public void setAmount(int n){
        if(n>0 &&n<=10){
            amount = n;
        }else{
            throw new InputMismatchException("Selected Amount is out of range");
        }
    }

    public void setPrice(int n){
        price = n;
    }

    public int getId(){
        return itemId;
    }

    public String getBuyerName(){
        return buyerName;
    }

    public String getBuyerLastname(){
        return BuyerLastname;
    }

    public String getBuyerPhone(){
        return BuyerPhoneNumber;
    }

    public int getAmount(){
        return amount;
    }

    public int getPrice(){
        return price;
    }

    public void calculateTotalPrice(double off){
        totalPrice = amount*price;
        totalPrice = (int)(totalPrice*(100-off)/100);
    }

    public int getTotalPrice(){
        return totalPrice;
    }

    public Bill(int itemid , String buyername , String buyerlastname, String buyerphone, int amont, int p,double off){
        itemId = itemid;
        buyerName = buyername;
        BuyerLastname = buyerlastname;
        BuyerPhoneNumber = buyerphone;
        amount = amont;
        price = p;
        calculateTotalPrice(off);
    }
    public void printBill(){
        System.out.println("ٔCustomer Name: "+buyerName+" "+BuyerLastname);
        System.out.println("Customer Phone Number: "+BuyerPhoneNumber);
        System.out.println("Amount: "+amount);
        System.out.println("Price Per Item: "+price);
        System.out.println("Total Price: "+totalPrice);
    }

}