package Peeyade;

public class PurchasedItem {
    private int itemId;
    private int amount;
    private int price;
    private int totalPrice;
    private int userId;

    public PurchasedItem(int id, int am, int p, int tp, int uid){
        itemId =id;
        amount = am;
        price = p; 
        totalPrice = tp;
        userId = uid;
    }

    public int getUserId(){
        return userId;
    }

    public int getItemId(){
        return itemId;
    }
    public int getAmount(){
        return amount;
    }
    public int getPrice(){
        return price;
    }
    public int getTotalPrice(){
        return totalPrice;
    }

    public void printItem(){
        System.out.println("Item ID: "+itemId+"; Amount: "+amount+"; Price: "+price+"; Total Price: "+totalPrice);
    }
}