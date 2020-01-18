package restaurant;

import java.time.LocalDate;
import java.time.Period;


public class MenuItem {
    private Double price;
    private String description;
    private String category;
    private Boolean newStatus;


    public MenuItem(Double price, String description, String category, Boolean newStatus){
        this.price = price;
        this.description = description;
        this.category = category;
        this.newStatus = newStatus;

    }

    public MenuItem(Double price, String description, String category){
        this(price, description, category, false);
    }
    @Override
    public String toString(){
        return  this.description + " " + this.price + " " + this.category + " " + this.newStatus;
    }


    public String toStringWithNew(){
        if(newStatus){
            return "*New* " + this.description + " " + this.price;
        } else {
            return this.description + " " + this.price;
        }
    }

   @Override
       public boolean equals(Object toBeCompared) {
       if (toBeCompared == this) {
           return true;
       }

       if (toBeCompared == null) {
           return false;
       }

       if (toBeCompared.getClass() != getClass()) {
           return false;
       }

       MenuItem theMenuItem = (MenuItem) toBeCompared;
       if (theMenuItem.getCategory() == getCategory()) {
           if (theMenuItem.getDescription() == getDescription()) {
               return true;
           } else {
               return false;
           }
       } else {
           return false;
       }
   }


    public static String setCategoryUsingNum (Integer num){
        String categoryString = "";
        switch (num) {
            case 1:
                categoryString = "appetizer";
                break;
            case 2:
                categoryString = "main course";
                break;
            case 3:
                categoryString = "dessert";
                break;
            default:
                categoryString = "Invalid Number";
        }
        return categoryString;
    }



    public Double getPrice(){
        return this.price;
    }
    public  String getDescription (){
        return this.description;
    }
    public String getCategory(){
        return this.category;
    }
    public boolean getNewStatus(){
        return this.newStatus;
    }


    public void setPrice(Double price){
        this.price = price;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setNewStatus(Boolean newStatus){
        this.newStatus = newStatus;
    }

}
