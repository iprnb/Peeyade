package Peeyade;

import java.util.InputMismatchException;

public class Activity extends Item {
    private String actCategory;
    private double duration;
    private int price;
    private String instructorDesc;
    private String[] requirements;
    private int ticketAmount;

    public void setActCategory(String s){
        actCategory = s;
    }

    public void setDuration(double f){
        if(f>=0.15 && f<=48){
            double l;
            l=f*100;
            int n=(int)l;
            f=(double)n/100;
            duration = f;
        }else{
            throw new InputMismatchException("Duration is out of range");
        }
    }

    public void setPrice(int n){
        if(n>=0 && n<=1000000){
            price = n;
        }else{
            throw new InputMismatchException("Price is out of range");
        }
    }

    public void setInstructorDesc(String s){
        instructorDesc = s;
    }

    public void setRequirements(String[] s){
        if(s.length>10){
            throw new InputMismatchException("Requirements is out of range");
        }else{
            requirements = s;
        }
    }

    public void setTicketAmount(int n){
        if(n>0 && n<=500){
            ticketAmount = n;
        }else{
            throw new InputMismatchException("Ticket Amount is out of range");
        }
    }

    public String getActCategory(){
        return actCategory;
    }

    public double getDuration(){
        return duration;
    }

    public int getprice(){
        return price;
    }

    public String getInstructorDescreption(){
        return instructorDesc;
    }

    public String[] getRequirements(){
        return requirements;
    }

    public int getTicketAmount(){
        return ticketAmount;
    }

    public Activity(int id, String name, String desc,  String location, int district,String actCat, double dur, int price, String instDesc, String[] req, int ticketAmount){
        setId(id);
        setName(name);
        setDescription(desc);
        setLocation(location);
        setDistrict(district);
        setActCategory(actCat);
        setDuration(dur);
        setPrice(price);
        setInstructorDesc(instDesc);
        setRequirements(req);
        setTicketAmount(ticketAmount);
    }

    public void show(Comment[] comments){
        Facility[] facilities = EditFile.readFacilities();
        System.out.println(name);
        System.out.println("About the experience: "+description);
        System.out.println("Location: "+location+"   | district: "+district);
        System.out.println("Category: "+actCategory);
        System.out.println("Duration: "+duration+" Hrs");
        System.out.println("Price : "+price+" Tooman");
        System.out.println("About Instructor: "+instructorDesc);
        System.out.println("Requirements: ");
        for(int i=0; i<requirements.length; i++){
            if(requirements[i]!=""){
                System.out.print(requirements[i]+" , ");
            }
        }
        for(int i=0; i<facilities.length; i++){
            if(facilities[i]!=null){
                if(facilities[i].getId()==id){
                    System.out.println("\nFacilities:");
                    facilities[i].printFacilities();
                }
            }else{
                break;
            }
        }
        System.out.println("\nComments:");
        boolean hasComment = false;
                    for(int i=0; i<comments.length; i++){
                        if(comments[i]!=null){
                            if(comments[i].getItemId()==id){
                                System.out.println(comments[i].getComment());
                                hasComment = true;
                            }
                        }else{
                            break;
                        }
                    }
                    if(!hasComment){
                        System.out.println("No comment has been posted yet.");
                    }
        System.out.println("Please choose an option:");
        System.out.println("1: Add to favorites | 2: Add a new comment  |3: Purchase a ticket");
        
    }
}
