package Peeyade;

import java.util.InputMismatchException;

public class User {
    private int id;
    private String phoneNumber;
    private String password;
    private String firstname;
    private String lastname;
    private int district=0;
    private String email;
    private int gender=0; //0:undefined   1:Male  2:Female
    private int[] favorites;

    public void setId(int n){
        id = n;
    }

    public void setPhoneNumber(String s){
        if( (s.length()==13||s.length()==11)){
            phoneNumber =s;
        }else{
            throw new InputMismatchException("Invalid phone number");
        }
    }

    public void setPassword(String s){
        if(s.length()<8){
            throw new InputMismatchException("Password must be at least 8 characters");
        }
        password = s;
    }

    public void setFirstname(String s){

            firstname =s;

    }

    public void setLastname(String s){

            lastname =s;

    }

    public void setDistrict(int n){
        if(n>=0 && n<=22){
            district = n;
        }else{
            throw new InputMismatchException("District is out of range");
        }
    }

    public void setEmail(String s){
        if(s.contains("@")||s.equals("")){
            email =s;
        }else{
            throw new InputMismatchException("Invalid Email");
        }
    }
    
    public void setGender(int n){
        if(n==0 || n==1 || n==2){
            gender = n;
        }else{
            throw new InputMismatchException("Invalid input for gender");
        }
    }

   

    public int getId(){
        return id;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }


    public String getFirstname(){
        return firstname;
    }

    public String getLastname(){
        return lastname;
    }

    public int getDistrict(){
        return district;
    }

    public int getGender(){
        return gender;
    }
    
    public String getEmail(){
        return email;
    }

    public int[] getFavorites(){
        return favorites;
    }
    public String getPassword(){
        return password;
    }

    public User(int i, String ph, String pass, String fn, String ln, int dis, String em, int gen, int[] fav){
        setId(i);
        setPhoneNumber(ph);
        setPassword(pass);
        setFirstname(fn);
        setLastname(ln);
        setDistrict(dis);
        setEmail(em);
        setGender(gen);
        favorites = fav;
    }

    public static int Login(String phone, String pass, User[] u){
        for(int i=0; i<u.length; i++){
            if(u[i]!=null){
                if(u[i].phoneNumber.equals(phone) && u[i].password.equals(pass)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static User[] SignUp(String phone, String pass, User[] u){
        int c=0;
        while(u[c]!=null){
            c++;
        }
        int[] a = new int[500];
        u[c] = new User(c, phone, pass, "", "", 0, "", 0, a);
        return u;
    }
    public void addFavorite(int id){
        int c=0;
        while(favorites[c]!=0){
            c++;
        }
        if(c==500){
            throw new InputMismatchException("Reached the limit for favorites");
        }
        favorites[c] = id;
    }
}