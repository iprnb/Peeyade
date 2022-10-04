package Peeyade;

import java.util.InputMismatchException;

public class Item {
    protected int id;
    protected String name;
    protected String category;
    protected String description;
    protected String location;
    protected int district;

    public void setId(int n){
        id = n;
    }

    public void setName(String s){
        name = s;
    }

    public void setDescription(String s){
        description = s;
    }

    public void setCategory(String s){
        if(s.equalsIgnoreCase("activity")||s.equalsIgnoreCase("dining place")){
            category = s;
        }
        else{
            throw new InputMismatchException("Category is not defined");
        }
    }

    public void setLocation(String s){
        location = s;
    }

    public void setDistrict(int n){
        if(n>=0 && n<=22){
            district = n;
        }else{
            throw new InputMismatchException("District is out of range");
        }
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getCategory(){
        return category;
    }

    public String getDescription(){
        return description;
    }

    public String getLocation(){
        return location;
    }

    public int getDistrict(){
        return district;
    }
}