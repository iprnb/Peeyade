package Peeyade;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        User[] users = EditFile.readUser();
        Activity[] activities = EditFile.readActivity();
        DiningPlace[] diningPlaces = EditFile.readDiningPlace();
        Schedule[] schedules = EditFile.readSchedule();
        Coupon[] coupons = EditFile.readCoupon();
        PurchasedItem[] purchasedItems = EditFile.readPurchasedItems();
        Comment[] comments = EditFile.readComments();
        
        boolean logedin = false;
        int userId= 0;
        Scanner in = new Scanner(System.in);
        String input;

        System.out.println("----------- PEEYADE -----------");
        //Sign-in And Sign-Up
        while(!logedin){
            System.out.println("Hi! Please choose one of the following options:");
            System.out.println("1: Sign in | 2: Sign up");
            input= in.nextLine();
            if(input.equals("1")){
                System.out.print("Enter your phone number: ");
                String phone = in.nextLine();
                System.out.print("Enter your password: ");
                String pass = in.nextLine();
                userId = User.Login(phone, pass, users);
                if(userId!=-1){
                    System.out.println("Welcome!");
                    logedin = true;
                }else{
                    System.out.println("Phone number or password in not correct.");
                }
            }else if(input.equals("2")){
                System.out.print("Enter your phone number: ");
                String phone = in.nextLine();
                System.out.print("Enter your password: ");
                String pass = in.nextLine();
                try{
                    users = User.SignUp(phone, pass, users);

                    while(users[userId]!=null){
                        userId++;
                        if(userId==500){
                            break;
                        }
                    }
                    userId--;
                    logedin = true;
                    System.out.println("Your account has been created! welcome!");
                }catch(InputMismatchException e){
                    System.out.println(e.getMessage());
                }
            }else{
                System.out.println("Undefined command");
            }
        }

        //Pages
        while(logedin){
            System.out.println("Please choose one of the following options:");
            System.out.println("1: Main page | 2: Profile | 3: Item categories | 4:Sign out");
            input = in.nextLine();
            if(input.equals("1")){
                //MAIN PAGE
                int[] ids = new int[500];
                int counter = 0, counter2=0;
                System.out.println("Free-of-charge Activities");
                for(int i=0; i<activities.length; i++){
                    if(activities[i]!=null && counter2<=5){
                        if(activities[i].getprice()==0){
                            System.out.println("#"+counter+": "+activities[i].getName());
                            ids[counter] = activities[i].getId();
                            counter++;
                            counter2++;
                        }
                    }else{
                        break;
                    }
                }
                if(counter2==0){
                    System.out.println("No free-of-charge activity is available");
                }
                counter2 = 0;
                for(int i=0; i<activities.length; i++){
                    if(activities[i]!=null && counter2<=5){
                        if(activities[i].getLocation().equalsIgnoreCase("online")){
                            System.out.println("#"+counter+": "+activities[i].getName());
                            ids[counter] = activities[i].getId();
                            counter++;
                            counter2++;
                        }
                    }else{
                        break;
                    }
                }
                if(counter2==0){
                    System.out.println("No online activity is available");
                }
                counter2 = 0;
                for(int i=0; i<activities.length; i++){
                    if(activities[i]!=null && counter2<=5){
                        if(activities[i].getActCategory().equalsIgnoreCase("Sports and entertainment")){
                            System.out.println("#"+counter+": "+activities[i].getName());
                            ids[counter] = activities[i].getId();
                            counter++;
                            counter2++;
                        }
                    }else{
                        break;
                    }
                }
                if(counter2==0){
                    System.out.println("No sport is available");
                }
                counter2 = 0;
                for(int i=0; i<diningPlaces.length; i++){
                    if(diningPlaces[i]!=null && counter2<=5){
                            System.out.println("#"+counter+": "+diningPlaces[i].getName());
                            ids[counter] = diningPlaces[i].getId();
                            counter++;
                            counter2++;
                    }else{
                        break;
                    }
                }
                if(counter2==0){
                    System.out.println("No resturant or cafe is available");
                }
                counter2 = 0;

                System.out.println("For viewing the chosen option please enter its number (For exiting the page enter -1)");
                String num = in.nextLine();
                if(Integer.parseInt(num)>=0 && Integer.parseInt(num)<counter){
                    for(int i=0; i<activities.length; i++){
                        if(activities[i]!=null&&(activities[i].getId() == ids[Integer.parseInt(num)])){
                            activities[i].show(comments);
                            String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(activities[i].getId());
                                System.out.println("Added to the favorites");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter the comment:");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[count]!=null){
                                    count++;
                                }
                                try{
                                comments[count] = new Comment(userId, c, activities[i].getId());
                                System.out.println("Comment posted.");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("3")){
                                int ticket = 0;
                                boolean valid = false;
                                while(!valid){
                                    System.out.println("Enter the quantity of tickets(remaining: "+activities[i].getTicketAmount()+"): ");
                                    ticket = Integer.parseInt(in.nextLine());
                                    if(ticket>activities[i].getTicketAmount()|| ticket<0){
                                        System.out.println("The entered amount is not available");
                                    }else{
                                        activities[i].setTicketAmount(activities[i].getTicketAmount()-ticket);
                                        valid = true;
                                    }
                                }
                                valid = false;
                                while(!valid){
                                        int[] schedId = new int[100];
                                        int c=0;
                                        System.out.println("Choose the time:");
                                        for(int j=0;j<schedules.length; j++){
                                            if(schedules[i]!=null){
                                                if(schedules[j].getId()==activities[i].getId() && schedules[j].isAvailabe){
                                                    System.out.print("#"+c+": ");
                                                    schedules[j].printSchedule();
                                                    schedId[c] = j;
                                                    c++;
                                                }
                                            }else{
                                                break;
                                            }
                                        }
                                        int sch =Integer.parseInt(in.nextLine());
                                        if(sch>=0 && sch<c){
                                            schedules[schedId[sch]].isAvailabe = false;
                                            valid = true;
                                        }else{
                                            System.out.println("Invalid input");
                                        }
                                    }
                                    valid = false;
                                
                                    double offAmount =0;
                                    while(!valid){
                                        System.out.println("If you have a discount code, enter it here(if you do not have one, just press Enter): ");
                                        String coupon = in.nextLine();
                                        if(coupon.equals("")){
                                            valid = true;
                                        }else{
                                            for(int j=0; j<coupons.length;j++){
                                                if(coupons[j]!=null){
                                                    if(coupons[j].getId()==activities[i].getId() && coupons[j].getCode().equals(coupon)){
                                                        offAmount = coupons[j].getOffAmount();
                                                        
                                                        valid =true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    try{
                                    Bill b = new Bill(activities[i].getId(),users[userId].getFirstname(), users[userId].getLastname(), users[userId].getPhoneNumber(), ticket,activities[i].getprice() , offAmount);
                                    int x=0;
                                    while(purchasedItems[x]!=null){
                                        x++;
                                    }
                                    purchasedItems[x] = new PurchasedItem(activities[i].getId(), ticket, activities[i].getprice() ,b.getTotalPrice(), users[userId].getId());
                                    System.out.println("Summary of purchase:");
                                    b.printBill();
                                    }catch(InputMismatchException e){
                                        System.out.println(e.getMessage());
                                    }
                                
                                
                            }
                            break;
                        }
                    }
                    for(int i=0; i<diningPlaces.length; i++){
                        if(diningPlaces[i]!=null&&(diningPlaces[i].getId() == ids[Integer.parseInt(num)])){
                            diningPlaces[i].show(comments);
                            String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(diningPlaces[i].getId());
                                System.out.println("Added to the favorites.");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter your comment:");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[i]!=null){
                                    count++;
                                }
                                try{
                                comments[count] = new Comment(userId, c,diningPlaces[i].getId());
                                System.out.println("Comment posted.");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }
                            break;
                        }
                    }
                }else if(Integer.parseInt(num)!=-1){
                    System.out.println("The entered option in invalid");
                }
            }else if(input.equals("2")){
                //PERSONAL PAGE
                System.out.println("Please choose an option:");
                System.out.println("1: Edit personal information | 2: view favorites | 3: View purchases | 4: View posted comments");
                String num = in.nextLine();
                if(num.equals("1")){
                    String in2;
                    System.out.println("If you want nothing to change, just press Enter.");
                    System.out.println("The corrent information is written in front of every field");
                    System.out.print("Name:"+"["+users[userId].getFirstname()+"]");
                    in2 = in.nextLine();
                    if(!in2.equals("")){
                        users[userId].setFirstname(in2);
                    }
                    System.out.print("Surname:" +"["+users[userId].getLastname()+"]");
                    in2 = in.nextLine();
                    if(!in2.equals("")){
                        users[userId].setLastname(in2);
                    }
                    System.out.print("Phone number:"+"["+users[userId].getPhoneNumber()+"]" );
                    in2 = in.nextLine();
                    if(!in2.equals("")){
                        users[userId].setPhoneNumber(in2);
                    }
                    System.out.print("Password(At least 8 characters):" );
                    in2 = in.nextLine();
                    if(!in2.equals("")){
                        users[userId].setPassword(in2);
                    }
                    System.out.print("Home Address:"+"["+users[userId].getDistrict()+"]" );
                    in2 = in.nextLine();
                    if(!in2.equals("")){
                        users[userId].setDistrict(Integer.parseInt(in2));
                    }
                    System.out.print("Email:" +"["+users[userId].getEmail()+"]");
                    in2 = in.nextLine();
                    if(!in2.equals("")){
                        users[userId].setEmail(in2);
                    }
                    System.out.print("Gender(1:Male | 2:Female):"+"["+users[userId].getGender()+"]" );
                    in2 = in.nextLine();
                    if(!in2.equals("")){
                        users[userId].setGender(Integer.parseInt(in2));
                    }

                }else if(num.equals("2")){
                    int[] favs = users[userId].getFavorites();
                    String[] favsCat = new String[500];
                    System.out.println("For viewing the chosen option please enter its number (For exiting the page enter -1)");
                    for(int i=0; i<favs.length; i++){
                        if(favs!=null&&favs[i]!=0){
                            for(int j=0; j<activities.length; j++){
                                if(activities[j]!=null&&favs[i]==activities[j].getId()){
                                    favsCat[i] = "activity";
                                    System.out.println("#"+i+": "+activities[j].getName());
                                    break;
                                }
                            }
                            for(int j=0; j<diningPlaces.length; j++){
                                if(diningPlaces[j]!=null&&favs[i]==diningPlaces[j].getId()){
                                    favsCat[i] = "dining place";
                                    System.out.println("#"+i+": "+diningPlaces[j].getName());
                                    break;
                                }
                            }
                        }
                    }
                    int num2 = Integer.parseInt(in.nextLine());
                    if(num2>=0 && num2<500){
                        if(favsCat[num2].equals("activity")){
                            for(int i=0; i<activities.length; i++){
                                if(activities[i]!=null){
                                    if(activities[i].getId()==favs[num2]){
                                        activities[i].show(comments);
                                    }
                                }
                            }
                            
                            int i = favs[num2];
                            String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(activities[i].getId());
                                System.out.println("Added to favorites");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter comment:");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[count]!=null){
                                    count++;
                                }
                                try{
                                comments[count] = new Comment(userId, c, activities[i].getId());
                                System.out.println("Comment posted");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("3")){
                                int ticket = 0;
                                boolean valid = false;
                                while(!valid){
                                    System.out.println("Enter the quantity of tickets(remaining: "+activities[i].getTicketAmount()+"): ");
                                    ticket = Integer.parseInt(in.nextLine());
                                    if(ticket>activities[i].getTicketAmount()|| ticket<0){
                                        System.out.println("The entered amount is not available");
                                    }else{
                                        activities[i].setTicketAmount(activities[i].getTicketAmount()-ticket);
                                        valid = true;
                                    }
                                }
                                valid = false;
                                while(!valid){
                                        int[] schedId = new int[100];
                                        int c=0;
                                        System.out.println("Choose the time:");
                                        for(int j=0;j<schedules.length; j++){
                                            if(schedules[i]!=null){
                                                if(schedules[j].getId()==activities[i].getId() && schedules[j].isAvailabe){
                                                    System.out.print("#"+c+": ");
                                                    schedules[j].printSchedule();
                                                    schedId[c] = j;
                                                    c++;
                                                }
                                            }else{
                                                break;
                                            }
                                        }
                                        int sch =Integer.parseInt(in.nextLine());
                                        if(sch>=0 && sch<c){
                                            schedules[schedId[sch]].isAvailabe = false;
                                            valid = true;
                                        }else{
                                            System.out.println("Invalid input");
                                        }
                                    }
                                    valid = false;
                                    double offAmount =0;
                                    while(!valid){
                                        System.out.println("If you have a discount code, enter it here(if you do not have one, just press Enter): ");
                                        String coupon = in.nextLine();
                                        if(coupon.equals("")){
                                            valid = true;
                                        }else{
                                            for(int j=0; j<coupons.length;j++){
                                                if(coupons[j]!=null){
                                                    if(coupons[j].getId()==activities[i].getId() && coupons[j].getCode().equals(coupon)){
                                                        offAmount = coupons[j].getOffAmount();
                                                        valid =true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    try{
                                    Bill b = new Bill(activities[i].getId(),users[userId].getFirstname(), users[userId].getLastname(), users[userId].getPhoneNumber(), ticket,activities[i].getprice() , offAmount);
                                    System.out.println("Summary of purchase:");
                                    b.printBill();
                                    int x=0;
                                    while(purchasedItems[x]!=null){
                                        x++;
                                    }
                                    purchasedItems[x] = new PurchasedItem(activities[i].getId(), ticket, activities[i].getprice() ,b.getTotalPrice(), users[userId].getId());
                                   
                                    }catch(InputMismatchException e){
                                        System.out.println(e.getMessage());
                                    }
                                
                                
                            }
                        }else{
                           
                            for(int i=0; i<diningPlaces.length; i++){
                                if(diningPlaces[i]!=null){
                                    if(diningPlaces[i].getId()==favs[num2]){
                                        diningPlaces[i].show(comments);
                                    }
                                }
                            }
                            int i = favs[num2];
                            String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(activities[i].getId());
                                System.out.println("Added to favorites");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter comment:");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[count]!=null){
                                    count++;
                                }try{
                                comments[count] = new Comment(userId, c, activities[i].getId());
                                System.out.println("Comment posted.");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    }else if(num2!=-1){
                        System.out.println("Undefined command");
                    }
                }else if(num.equals("3")){
                    for(int i=0; i<purchasedItems.length; i++){
                        if(purchasedItems[i]!=null){
                            if(purchasedItems[i].getUserId()==userId){
                                purchasedItems[i].printItem();
                                System.out.println();
                            }
                        }else{
                            break;
                        }
                    }
                }else if(num.equals("4")){
                    boolean hasComment = false;
                    for(int i=0; i<comments.length; i++){
                        if(comments[i]!=null){
                            if(comments[i].getUserId()==userId){
                                System.out.println(comments[i].getComment());
                                hasComment = true;
                            }
                        }else{
                            break;
                        }
                    }
                    if(!hasComment){
                        System.out.println("You have not posted any comments");
                    }
                }else{
                    System.out.println("Undefined command");
                }
            }else if(input.equals("3")){
                //ITEM CATEGORY AND SEARCH
                System.out.println("Please choose on of the options:");
                System.out.println("1: View activites | 2: View resturants and cafes | 3:Search");
                String n = in.nextLine();
                if(n.equals("1")){
                    System.out.println("For viewing the chosen option please enter its number (For exiting the page enter -1)");
                    for(int i=0; i<activities.length; i++){
                        if(activities[i]!=null){
                            System.out.println("#"+i+": "+activities[i].getName());
                        }
                    }
                    int num = Integer.parseInt(in.nextLine());
                    if(num!=-1&&(num<0 || num>500)){
                        System.out.println("Invalid Input");
                    }else if(num==-1){}
                    else{
                        activities[num].show(comments);
                        int i = num;
                        String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(activities[i].getId());
                                System.out.println("Added to favorites");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter comment:");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[count]!=null){
                                    count++;
                                }
                                try{
                                comments[count] = new Comment(userId, c, activities[i].getId());
                                System.out.println("Comment posted");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("3")){
                                int ticket = 0;
                                boolean valid = false;
                                while(!valid){
                                    System.out.println("Enter the quantity of tickets(remaining:  "+activities[i].getTicketAmount()+"): ");
                                    ticket = Integer.parseInt(in.nextLine());
                                    if(ticket>activities[i].getTicketAmount()|| ticket<0){
                                        System.out.println("The entered amount is not available");
                                    }else{
                                        activities[i].setTicketAmount(activities[i].getTicketAmount()-ticket);
                                        valid = true;
                                    }
                                }
                                valid = false;
                                while(!valid){
                                        int[] schedId = new int[100];
                                        int c=0;
                                        System.out.println("Choose the time:");
                                        for(int j=0;j<schedules.length; j++){
                                            if(schedules[j]!=null){
                                                if(schedules[j].getId()==activities[i].getId()&&schedules[j].isAvailabe){
                                                    
                                                    System.out.print("#"+c+": ");
                                                    schedules[j].printSchedule();
                                                    schedId[c] = j;
                                                    c++;
                                                }
                                            }else{
                                                break;
                                            }
                                        }
                                        int sch =Integer.parseInt(in.nextLine());
                                        if(sch>=0 && sch<c){
                                            schedules[schedId[sch]].isAvailabe = false;
                                            valid = true;
                                        }else{
                                            System.out.println("Invalid Input");
                                        }
                                }
                                    valid = false;
                                    double offAmount =0;
                                    while(!valid){
                                        System.out.println("If you have a discount code, enter it here(if you do not have one, just press Enter): ");
                                        String coupon = in.nextLine();
                                        if(coupon.equals("")){
                                            valid = true;
                                        }else{
                                            for(int j=0; j<coupons.length;j++){
                                                if(coupons[j]!=null){
                                                    if(coupons[j].getId()==activities[i].getId() && coupons[j].getCode().equals(coupon)){
                                                        offAmount = coupons[j].getOffAmount();
                                                        valid =true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    try{
                                    Bill b = new Bill(activities[i].getId(),users[userId].getFirstname(), users[userId].getLastname(), users[userId].getPhoneNumber(), ticket,activities[i].getprice() , offAmount);
                                    System.out.println("Summary of purchase:");
                                    b.printBill();
                                    int x=0;
                                    while(purchasedItems[x]!=null){
                                        x++;
                                    }
                                    purchasedItems[x] = new PurchasedItem(activities[i].getId(), ticket, activities[i].getprice() ,b.getTotalPrice(), users[userId].getId());
                                   
                                    }catch(InputMismatchException e){
                                        System.out.println(e.getMessage());
                                    }
                                
                                
                            }
                    }
                    
                }else if(n.equals("2")){
                    System.out.println("For viewing the chosen option please enter its number (For exiting the page enter -1)");
                    for(int i=0; i<diningPlaces.length; i++){
                        if(diningPlaces[i]!=null){
                            System.out.println("#"+i+": "+diningPlaces[i].getName());
                        }
                    }
                    int num = Integer.parseInt(in.nextLine());
                    if(num!=-1&&(num<0 || num>500)){
                        System.out.println("Undefined input");
                    }else if(num==-1){}
                    else{
                        diningPlaces[num].show(comments);
                        int i = num;
                        String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(diningPlaces[i].getId());
                                System.out.println("Added to favorites");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter comment:");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[count]!=null){
                                    count++;
                                }try{
                                comments[count] = new Comment(userId, c, activities[i].getId());
                                System.out.println("Comment posted");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }
                    }
                }else if(n.equals("3")){
                    boolean isfound = false;
                    System.out.println("Enter the text:");
                    String search = in.nextLine();
                    for(int i=0; i<activities.length; i++){
                        if(activities[i]!=null){
                            if(activities[i].getName().equalsIgnoreCase(search)){
                                activities[i].show(comments);
                                String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(activities[i].getId());
                                System.out.println("Added to favorites");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter comment");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[count]!=null){
                                    count++;
                                }try{
                                comments[count] = new Comment(userId, c, activities[i].getId());
                                System.out.println("Comment posted");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("3")){
                                int ticket = 0;
                                boolean valid = false;
                                while(!valid){
                                    System.out.println("Enter the quantity of tickets(remaining: "+activities[i].getTicketAmount()+"): ");
                                    ticket = Integer.parseInt(in.nextLine());
                                    if(ticket>activities[i].getTicketAmount()|| ticket<0){
                                        System.out.println("The entered amount is not available");
                                    }else{
                                        activities[i].setTicketAmount(activities[i].getTicketAmount()-ticket);
                                        valid = true;
                                    }
                                }
                                valid = false;
                                while(!valid){
                                        int[] schedId = new int[100];
                                        int c=0;
                                        System.out.println("Choose the time");
                                        for(int j=0;j<schedules.length; j++){
                                            if(schedules[i]!=null){
                                                if(schedules[j].getId()==activities[i].getId() && schedules[j].isAvailabe){
                                                    System.out.print("#"+c+": ");
                                                    schedules[j].printSchedule();
                                                    schedId[c] = j;
                                                    c++;
                                                }
                                            }else{
                                                break;
                                            }
                                        }
                                        int sch =Integer.parseInt(in.nextLine());
                                        if(sch>=0 && sch<c){
                                            schedules[schedId[sch]].isAvailabe = false;
                                            valid = true;
                                        }else{
                                            System.out.println("Invalid Input.");
                                        }
                                }
                                    valid = false;
                                    double offAmount =0;
                                    while(!valid){
                                        System.out.println("If you have a discount code, enter it here(if you do not have one, just press Enter): ");
                                        String coupon = in.nextLine();
                                        if(coupon.equals("")){
                                            valid = true;
                                        }else{
                                            for(int j=0; j<coupons.length;j++){
                                                if(coupons[j]!=null){
                                                    if(coupons[j].getId()==activities[i].getId() && coupons[j].getCode().equals(coupon)){
                                                        offAmount = coupons[j].getOffAmount();
                                                        valid =true;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    try{
                                    Bill b = new Bill(activities[i].getId(),users[userId].getFirstname(), users[userId].getLastname(), users[userId].getPhoneNumber(), ticket,activities[i].getprice() , offAmount);
                                    System.out.println("Summary of purchase:");
                                    b.printBill();
                                    int x=0;
                                    while(purchasedItems[x]!=null){
                                        x++;
                                    }
                                    purchasedItems[x] = new PurchasedItem(activities[i].getId(), ticket, activities[i].getprice() ,b.getTotalPrice(), users[userId].getId());
                                   
                                    }catch(InputMismatchException e){
                                        System.out.println(e.getMessage());
                                    }
                                
                                
                            }
                                isfound = true;
                                break;
                            }
                        }
                    }
                    if(!isfound){
                        for(int i=0; i<diningPlaces.length; i++){
                            if(diningPlaces[i]!=null){
                                if(diningPlaces[i].getName().equalsIgnoreCase(search)){
                                    diningPlaces[i].show(comments);
                                    String num3 = in.nextLine();
                            if(num3.equals("1")){
                                try{
                                users[userId].addFavorite(activities[i].getId());
                                System.out.println("Added to favorites");
                                }catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }else if(num3.equals("2")){
                                System.out.println("Enter comment:");
                                String c = in.nextLine();
                                int count=0;
                                while(comments[count]!=null){
                                    count++;
                                }
                                try{
                                comments[count] = new Comment(userId, c, activities[i].getId());
                                System.out.println("Comment posted.");
                            }
                                catch(InputMismatchException e){
                                    System.out.println(e.getMessage());
                                }
                            }
                                    isfound = true;
                                    break;
                                }
                            }else{
                                break;
                            }
                        }
                    }
                    if(!isfound){
                        System.out.println("Nothing was found");
                    }
                }
            }else if(input.equals("4")){
                System.out.println("See you soon!");
                EditFile.writeComments(comments);
                EditFile.writeCoupon(coupons);
                EditFile.writeItems(activities, diningPlaces);
                EditFile.writePurchasedItem(purchasedItems);
                EditFile.writeSchedule(schedules);
                EditFile.writeUsers(users);
                logedin = false;
            }

            
        }
    }

}
