package Peeyade;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EditFile {
    private static String localDir = System.getProperty("user.dir");

    public static User[] readUser(){
        File f = new File(localDir+"\\Peeyade\\users.txt");
        User[] ulist = new User[500];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            String[] favsplit;
            int[] favs = new int[500];
            int counter=0;
            while(input.hasNextLine() && counter<500){
                s = input.nextLine();
                splitted = s.split(" , ");
                try{
                    favsplit = splitted[8].split("-");
                    for(int i=0; i<favsplit.length; i++){
                        favs[i] = Integer.parseInt(favsplit[i]);
                    }
                }catch(ArrayIndexOutOfBoundsException e){

                }
                try{
                ulist[counter] = new User(counter, splitted[1],splitted[2],splitted[3],splitted[4],Integer.parseInt(splitted[5]),splitted[6],Integer.parseInt(splitted[7]), favs);
                }catch(InputMismatchException e){
                    System.out.println("user #"+counter+"om: "+e.getMessage());
                    counter--;
                }
                counter++;
            }
            return ulist;
        }catch(FileNotFoundException e){
            System.out.println("users file not found");
            return ulist;
        }
    }

    public static DiningPlace[] readDiningPlace(){
        File f = new File(localDir+"\\Peeyade\\items.txt");
        DiningPlace[] dlist = new DiningPlace[500];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            int counter=0;
            while(input.hasNextLine() && counter<500){
                s = input.nextLine();
                splitted = s.split(" , ");
                if(splitted[2].equalsIgnoreCase("dining place")){
                    try{
                    dlist[counter] = new DiningPlace(Integer.parseInt(splitted[0]),splitted[1], splitted[3],
                    splitted[4],Integer.parseInt(splitted[5]), splitted[6], splitted[7], splitted[8],Double.parseDouble(splitted[9]),
                    Double.parseDouble(splitted[10]), Double.parseDouble(splitted[11]), Double.parseDouble(splitted[12]),
                    splitted[13], splitted[14], splitted[15], splitted[16], splitted[17], splitted[18], splitted[19], splitted[20]);
                    }catch(InputMismatchException e){
                        System.out.println("diningplace #"+counter+"om: "+e.getMessage());
                        counter--;
                    }
                    counter++;
                }
            }
            return dlist;
        }catch(FileNotFoundException e){
            System.out.println("items file not found");
            return dlist;
        }
    }

    public static Activity[] readActivity(){
        File f = new File(localDir+"\\Peeyade\\items.txt");
        Activity[] alist = new Activity[500];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            int counter=0;
            while(input.hasNextLine() && counter<500){
                s = input.nextLine();
                splitted = s.split(" , ");
                String[] req = splitted[10].split(",");
                if(splitted[2].equalsIgnoreCase("activity")){
                    try{
                    alist[counter] = new Activity(Integer.parseInt(splitted[0]),splitted[1], splitted[3],splitted[4],Integer.parseInt(splitted[5]),
                     splitted[6],Double.parseDouble(splitted[7]),Integer.parseInt(splitted[8]),splitted[9],req,Integer.parseInt(splitted[11]));
                    }catch(InputMismatchException e){
                        System.out.println("activity #"+counter+"om: "+e.getMessage());
                        counter--;
                    }
                     counter++;
                }
            }
            return alist;
        }catch(FileNotFoundException e){
            System.out.println("items file not found");
            return alist;
        }
    }

    public static Schedule[] readSchedule(){
        File f = new File(localDir+"\\Peeyade\\schedules.txt");
        Schedule[] slist = new Schedule[100];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            int counter=0;
            while(input.hasNextLine() && counter<100){
                s = input.nextLine();
                splitted = s.split(" , ");
                try{
                slist[counter] = new Schedule(Integer.parseInt(splitted[0]),splitted[1],splitted[2],splitted[3]);
                }catch(InputMismatchException e){
                    System.out.println("schedule #"+counter+"om: "+e.getMessage());
                    counter--;
                }
                counter++;
            }
            return slist;
        }catch(FileNotFoundException e){
            System.out.println("Schedules file not found");
            return slist;
        }
    }

    public static Coupon[] readCoupon(){
        File f = new File(localDir+"\\Peeyade\\coupons.txt");
        Coupon[] clist = new Coupon[100];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            int counter=0;
            while(input.hasNextLine() && counter<100){
                s = input.nextLine();
                splitted = s.split(" , ");
                try{
                clist[counter] = new Coupon(Integer.parseInt(splitted[0]),splitted[1],Double.parseDouble(splitted[2]));
            }catch(InputMismatchException e){
                System.out.println("coupon #"+counter+"om: "+e.getMessage());
                counter--;
            }
                counter++;
            }
            return clist;
        }catch(FileNotFoundException e){
            System.out.println("coupons file not found");
            return clist;
        }
    }

    public static PurchasedItem[] readPurchasedItems(){
        File f = new File(localDir+"\\Peeyade\\purchasedItems.txt");
        PurchasedItem[] clist = new PurchasedItem[500];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            int counter=0;
            while(input.hasNextLine() && counter<500){
                s = input.nextLine();
                splitted = s.split(" , ");
                try{
                clist[counter] = new PurchasedItem(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]),
                 Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]), Integer.parseInt(splitted[4]));
                }catch(InputMismatchException e){
                    System.out.println("purchased item #"+counter+"om: "+e.getMessage());
                    counter--;
                }
                counter++;
            }
            return clist;
        }catch(FileNotFoundException e){
            System.out.println("purchased Items file not found");
            return clist;
        }
    }

    public static Comment[] readComments(){
        File f = new File(localDir+"\\Peeyade\\comments.txt");
        Comment[] clist = new Comment[500];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            int counter=0;
            while(input.hasNextLine() && counter<500){
                s = input.nextLine();
                splitted = s.split(" , ");
                try{
                clist[counter] = new Comment(Integer.parseInt(splitted[0]),splitted[1],Integer.parseInt(splitted[2]));
            }catch(InputMismatchException e){
                System.out.println("comment #"+counter+"om: "+e.getMessage());
                counter--;
            }
                counter++;
            }
            return clist;
        }catch(FileNotFoundException e){
            System.out.println("comments file not found");
            return clist;
        }
    }

    public static Facility[] readFacilities(){
        File f = new File(localDir+"\\Peeyade\\facilities.txt");
        Facility[] clist = new Facility[500];
        try{
            Scanner input = new Scanner(f);
            String s;
            String[] splitted;
            int counter=0;
            while(input.hasNextLine() && counter<500){
                s = input.nextLine();
                splitted = s.split(" , ");
                try{
                clist[counter] = new Facility(Integer.parseInt(splitted[0]), splitted[1], splitted[2], splitted[3], splitted[4], splitted[5], splitted[6]);
            }catch(InputMismatchException e){
                System.out.println("comment #"+counter+"om: "+e.getMessage());
                counter--;
            }
                counter++;
            }
            return clist;
        }catch(FileNotFoundException e){
            System.out.println("comments file not found");
            return clist;
        }
    }

    public static void writeUsers(User[] ulist){
        try{
            FileWriter f =new FileWriter(localDir+"\\Peeyade\\users.txt");
            for(int i=0; i<ulist.length; i++){
                if(ulist[i]!=null){
                    f.write(ulist[i].getId()+" , ");
                    f.write(ulist[i].getPhoneNumber()+" , ");
                    f.write(ulist[i].getPassword()+" , ");
                    f.write(ulist[i].getFirstname()+" , ");
                    f.write(ulist[i].getLastname()+" , ");
                    f.write(Integer.toString(ulist[i].getDistrict())+" , ");
                    f.write(ulist[i].getEmail()+" , ");
                    f.write(Integer.toString(ulist[i].getGender())+" , ");
                    int c=0;
                    for(int j=0;  j<ulist[i].getFavorites().length;  j++){
                        if(ulist[i].getFavorites()[j]!=0){
                            if(c!=0){
                                f.write("-"+Integer.toString(ulist[i].getFavorites()[j]));
                            }else{
                                f.write(Integer.toString(ulist[i].getFavorites()[j]));
                            }
                            c++;
                        }else{
                            break;
                        }
                    }
                    f.write("\n");
                }
            }
            f.close();
        }catch(IOException e){
            System.out.println("IO expection users.txt");
        }
    }

    public static void writeItems(Activity[] alist , DiningPlace[] dlist){
        try{
            FileWriter f =new FileWriter(localDir+"\\Peeyade\\items.txt");
            for(int i=0; i<alist.length; i++){
                if(alist[i]!=null){
                    f.write(Integer.toString(alist[i].getId())+" , ");
                    f.write(alist[i].getName()+" , ");
                    f.write("activity"+" , ");
                    f.write(alist[i].getDescription()+" , ");
                    f.write(alist[i].getLocation()+" , ");
                    f.write(Integer.toString(alist[i].getDistrict())+" , ");
                    f.write(alist[i].getActCategory()+" , ");
                    f.write(Double.toString(alist[i].getDuration())+" , ");
                    f.write(Integer.toString(alist[i].getprice())+" , ");
                    f.write(alist[i].getInstructorDescreption()+" , ");
                    int c=0;
                    for(int j=0; j<alist[i].getRequirements().length; j++){
                        if(alist[i].getRequirements()[j]!=""){
                            if(c==0){
                                f.write(alist[i].getRequirements()[j]);
                            }else{
                                f.write(","+alist[i].getRequirements()[j]);
                            }
                        }else{
                            break;
                        }
                    }
                    f.write(" , "+Integer.toString(alist[i].getTicketAmount())+"\n");
                }
            }
            for(int i=0; i<dlist.length; i++){
                if(dlist[i]!=null){
                    f.write(Integer.toString(dlist[i].getId())+" , ");
                    f.write(dlist[i].getName()+" , ");
                    f.write("dining place"+" , ");
                    f.write(dlist[i].getDescription()+" , ");
                    f.write(dlist[i].getLocation()+" , ");
                    f.write(Integer.toString(dlist[i].getDistrict())+" , ");
                    f.write(dlist[i].getMenuAndPrice()+" , ");
                    f.write(dlist[i].getAtmAndDecorTxt()+" , ");
                    f.write(dlist[i].getSpecification()+" , ");
                    f.write(Double.toString(dlist[i].getAtmAndDecorScore())+" , ");
                    f.write(Double.toString(dlist[i].getServiceScore())+" , ");
                    f.write(Double.toString(dlist[i].getQualityScore())+" , ");
                    f.write(Double.toString(dlist[i].getPriceScore())+" , ");
                    f.write(dlist[i].getOpeningHour()+" , ");
                    f.write(dlist[i].getClosingHour()+" , ");
                    f.write(dlist[i].getPhoneNumber()+" , ");
                    f.write(dlist[i].getInstagram()+" , ");
                    f.write(dlist[i].getWebsite()+" , ");
                    f.write(Boolean.toString(dlist[i].getHasRestroom())+" , ");
                    f.write(Boolean.toString(dlist[i].getHasDelivery())+" , ");
                    f.write(Boolean.toString(dlist[i].getHasYard())+"\n");
                }else{
                    break;
                }
            }
            f.close();
        }catch(IOException e){
            System.out.println("IO expection items.txt");
        }
    }

    public static void writeSchedule(Schedule[] slist){
        try{
            FileWriter f =new FileWriter(localDir+"\\Peeyade\\schedules.txt");
            for(int i=0; i<slist.length; i++){
                if(slist[i]!=null){
                    f.write(slist[i].getId()+" , ");
                    f.write(slist[i].getisValid()+" , ");
                    f.write(slist[i].getDate()+" , ");
                    f.write(slist[i].getTime()+"\n");
                }else{
                    break;
                }
            }
            f.close();
        }catch(IOException e){
            System.out.println("IO expection schedules.txt");
        }
    }

    public static void writeCoupon(Coupon[] clist){
        try{
            FileWriter f =new FileWriter(localDir+"\\Peeyade\\coupons.txt");
            for(int i=0; i<clist.length; i++){
                if(clist[i]!=null){
                    f.write(clist[i].getId()+" , ");
                    f.write(clist[i].getCode()+" , ");
                    f.write(Double.toString(clist[i].getOffAmount())+"\n");
                }else{
                    break;
                }
            }
            f.close();
        }catch(IOException e){
            System.out.println("IO expection coupons.txt");
        }
    }

    public static void writePurchasedItem(PurchasedItem[] plist){
        try{
            FileWriter f =new FileWriter(localDir+"\\Peeyade\\purchasedItems.txt");
            for(int i=0; i<plist.length; i++){
                if(plist[i]!=null){
                    f.write(Integer.toString(plist[i].getItemId())+" , ");
                    f.write(Integer.toString(plist[i].getAmount())+" , ");
                    f.write(Integer.toString(plist[i].getPrice())+" , ");
                    f.write(Integer.toString(plist[i].getTotalPrice())+" , ");
                    f.write(Integer.toString(plist[i].getUserId())+"\n");
                    
                }else{
                    break;
                }
            }
            f.close();
        }catch(IOException e){
            System.out.println("IO expection purchasedItems.txt");
        }
    }

    public static void writeComments(Comment[] clist){
        try{
            FileWriter f =new FileWriter(localDir+"\\Peeyade\\comments.txt");
            for(int i=0; i<clist.length; i++){
                if(clist[i]!=null){
                    f.write(Integer.toString(clist[i].getUserId())+" , ");
                    f.write(clist[i].getComment()+" , ");
                    f.write(Integer.toString(clist[i].getItemId())+"\n");
                }else{
                    break;
                }
            }
            f.close();
        }catch(IOException e){
            System.out.println("IO expection comments.txt");
        }
    }
}