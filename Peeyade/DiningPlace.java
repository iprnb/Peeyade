package Peeyade;

import java.util.InputMismatchException;


public class DiningPlace extends Item {
    private String menuAndPrice;
    private String atmAndDecorTxt;
    private String specification;
    private double atmAndDecorScore;
    private double serviceScore;
    private double qualityScore;
    private double priceScore;
    private String openingHour;
    private String closingHour;
    private String phoneNumber;
    private String instagram;
    private String website;
    private boolean hasRestroom;
    private boolean hasDelivery;
    private boolean hasYard;

    public void setAtmAndDecorTxt(String s){
        atmAndDecorTxt = s;
    }

    public void setMenuAndPrice(String s){
        menuAndPrice = s;
    }

    public void setSpecification(String s){
        specification = s;
    }

    private double checkScore(double f){
        if(f>0 && f<=5){
            double l;
            l=f*100;
            int n=(int)l;
            f=(double)n/100;
            return f;
        }else if(f==0){
            return f;
        }else{
            throw new InputMismatchException();
        }

    }
    public void setAtmAndDecorScore(double f){
        try{
            atmAndDecorScore = checkScore(f) ;
        }catch(InputMismatchException e){
            throw new InputMismatchException("Atmosphere and Decor score out of range");
        }
    }

    public void setServiceScore(double f){
        try{
            serviceScore = checkScore(f) ;
        }catch(InputMismatchException e){
            throw new InputMismatchException("Service score out of range");
        }
    }

    public void setQualityScore(double f){
        try{
            qualityScore = checkScore(f) ;
        }catch(InputMismatchException e){
            throw new InputMismatchException("Quality score out of range");
        }
    }

    public void setPriceScore(double f){
        try{
            priceScore = checkScore(f) ;
        }catch(InputMismatchException e){
            throw new InputMismatchException("Price score out of range");
        }
    }

    public void setOpeningHour(String s){
        if(!s.contains(":")){
            throw new InputMismatchException("Hour format is not valid");
        }
        int hour = Integer.parseInt(s.split(":")[0]);
        int minute = Integer.parseInt(s.split(":")[1]);
        if((hour>=0&&hour<=23)&&(minute>=0&&minute<=59)){
            openingHour = s;
        }else{
            throw new InputMismatchException("Opening Hour is not valid");
        }
    }

    public void setClosingHour(String s){
        if(!s.contains(":")){
            throw new InputMismatchException("Hour format is not valid");
        }
        int hour = Integer.parseInt(s.split(":")[0]);
        int minute = Integer.parseInt(s.split(":")[1]);
        if((hour>=0&&hour<=23)&&(minute>=0&&minute<=59)){
            closingHour = s;
        }else{
            throw new InputMismatchException("Closing Hour is not valid");
        }
    }

    public void setPhone(String s){
        phoneNumber = s;
    }

    public void setInstagram(String s){
        instagram = s;
    }

    public void setWebsite(String s){
        website = s;
    }

    public boolean checkBoolean(String s){
        if(s.equalsIgnoreCase("true")){
            return true;
        }else if(s.equalsIgnoreCase("false")){
            return false;
        }else{
            throw new InputMismatchException();
        }
    }

    public void setHasRestroom(String s){
        try{
            hasRestroom = checkBoolean(s);
        }catch(InputMismatchException e){
            throw new InputMismatchException("Restroom information is not valid");
        }
    }

    public void setHasDelivery(String s){
        try{
            hasDelivery = checkBoolean(s);
        }catch(InputMismatchException e){
            throw new InputMismatchException("Delivery information is not valid");
        }
    }

    public void setHasYard(String s){
        try{
            hasYard = checkBoolean(s);
        }catch(InputMismatchException e){
            throw new InputMismatchException("Yard information is not valid");
        }
    }

    public String getMenuAndPrice(){
        return menuAndPrice;
    }

    public String getAtmAndDecorTxt(){
        return atmAndDecorTxt;
    }

    public String getSpecification(){
        return specification;
    }

    public double getAtmAndDecorScore(){
        return atmAndDecorScore;
    }

    public double getServiceScore(){
        return serviceScore;
    }

    public double getQualityScore(){
        return qualityScore;
    }

    public double getPriceScore(){
        return priceScore;
    }

    public String getOpeningHour(){
        return openingHour;
    }

    public String getClosingHour(){
        return closingHour;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getInstagram(){
        return instagram;
    }

    public String getWebsite(){
        return website;
    }

    public boolean getHasRestroom(){
        return hasRestroom;
    }

    public boolean getHasDelivery(){
        return hasDelivery;
    }

    public boolean getHasYard(){
        return hasYard;
    }

    public DiningPlace(int id, String name, String desc,  String location, int district, String menu, String atmTxt,
                       String spec, double atmScore, double serviceScore, double qualityScore, double priceScore,
                       String openHr, String closeHr, String phone, String insta, String web,
                       String hasRestroom, String hasDelivery, String hasYard){

                        setId(id);
                        setName(name);
                        setDescription(desc);
                        setLocation(location);
                        setDistrict(district);
                        setMenuAndPrice(menu);
                        setAtmAndDecorTxt(atmTxt);
                        setSpecification(spec);
                        setAtmAndDecorScore(atmScore);
                        setServiceScore(serviceScore);
                        setQualityScore(qualityScore);
                        setPriceScore(priceScore);
                        setOpeningHour(openHr);
                        setClosingHour(closeHr);
                        setPhone(phone);
                        setInstagram(insta);
                        setWebsite(web);
                        setHasRestroom(hasRestroom);
                        setHasDelivery(hasDelivery);
                        setHasYard(hasYard);
    }

    public void show(Comment[] comments){
        System.out.println(name);
        System.out.println("About experience: "+description);
        System.out.println("Location: "+location+"   | district: "+district);
        System.out.println("Menu: "+menuAndPrice);
        System.out.println("Ambient: "+atmAndDecorTxt);
        System.out.println("Specifications: "+specification);
        System.out.println("Ambient rating(0-5): "+atmAndDecorScore);
        System.out.println("Service rating(0-5): "+serviceScore);
        System.out.println("The quality of foods rating(0-5): "+qualityScore);
        System.out.println("Price range(0-5): "+priceScore);
        System.out.println("From "+openingHour+" Until "+closingHour);
        System.out.println("Phone number: "+phoneNumber);
        System.out.println("Instagram: "+instagram);
        System.out.println("website: "+website);
        if(hasRestroom){
            System.out.println("It has restrooms.");
        }else{
            System.out.println("It does not have restrooms");
        }
        if(hasDelivery){
            System.out.println("It has delivery");
        }else{
            System.out.println("No delivery");
        }
        if(hasYard){
            System.out.println("It has outdoor tables");
        }else{
            System.out.println("No outdoor table");
        }
        System.out.println("Comments:");
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
        System.out.println("1: add to favorites | 2: post a new comment");
    }

}
