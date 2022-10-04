package Peeyade;

import java.util.InputMismatchException;

public class Comment {
    private int userId;
    private int itemId;
    private String comment;

    public void setUserId(int s){
        if(s>=0){
            userId = s;
        }else{
            throw new InputMismatchException("No user");
        }
    }

    public void setItemId(int s){
        if(s!=0){
            itemId = s;
        }else{
            throw new InputMismatchException("No item");
        }
    }

    public void setComment(String s){
        if(s!=""){
            comment = s;
        }else{
            throw new InputMismatchException("No comment");
        }
    }

    public int getUserId(){
        return userId;
    }

    public int getItemId(){
        return itemId;
    }

    public String getComment(){
        return comment;
    }

    public Comment(int u, String c, int i){
        setUserId(u);
        setComment(c);
        setItemId(i);
    }

}