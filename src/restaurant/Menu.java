package restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> appetizers = new ArrayList<>();
    private ArrayList<MenuItem> mainCourses = new ArrayList<>();
    private ArrayList<MenuItem> desserts = new ArrayList<>();
    private LocalDateTime lastUpdated;

    public void addMenuItem(MenuItem menuItem1){
        if(menuItem1.getCategory() =="appetizer"){
            appetizers.add(menuItem1);
        }
        if(menuItem1.getCategory() =="main course"){
            mainCourses.add(menuItem1);
        }
        if(menuItem1.getCategory() =="dessert"){
            desserts.add(menuItem1);
        }
        lastUpdated = LocalDateTime.now();
    }
    public void removeMenuItem(String menuItemDescription){
        for(int i = 0; i < appetizers.size(); i++){
            if(appetizers.get(i).getDescription().toLowerCase().contains(menuItemDescription)){
                appetizers.remove(i);
            }
        }
        for(int i = 0; i < desserts.size(); i++){
            if(desserts.get(i).getDescription().toLowerCase().contains(menuItemDescription)){
                desserts.remove(i);
            }
        }
        for(int i = 0; i < mainCourses.size(); i++){
            if(mainCourses.get(i).getDescription().toLowerCase().contains(menuItemDescription)){
                mainCourses.remove(i);
            }
        }
        lastUpdated = LocalDateTime.now();
    }

    @Override
    public String toString(){
        String displayList = "***Appetizers***";
        displayList += displayCategory(appetizers);
        displayList += "\n\n***Main Courses***";
        displayList += displayCategory(mainCourses);
        displayList += "\n\n***Desserts***";
        displayList += displayCategory(desserts);
        displayList += "\nLast Updated: " + lastUpdated;

        return displayList;
    }

    public String displayCategory(ArrayList category){
        String displayCategoryList="";
        if(category==appetizers){
            if(appetizers.size()>0){
                for(int i = 0; i<appetizers.size();i++){
                    displayCategoryList += "\n" + appetizers.get(i).toStringWithNew();
                }
            } else {
                displayCategoryList += "\nCheck back later!";
            }
        }
        if(category==mainCourses){
            if(mainCourses.size()>0){
                for(int i = 0; i<mainCourses.size();i++){
                    displayCategoryList += "\n" + mainCourses.get(i).toStringWithNew();
                }
            } else {
                displayCategoryList += "\nCheck back later!";
            }
        }
        if(category==desserts){
            if(desserts.size()>0){
                for(int i = 0; i<desserts.size();i++){
                    displayCategoryList += "\n" + desserts.get(i).toStringWithNew();
                }
            } else {
                displayCategoryList += "\nCheck back later!";
            }
        }
        return displayCategoryList;
    }

    public String search(String menuItemDescription){
        boolean itemFound = false;
        String foundItem = "";
        for(int i = 0; i < appetizers.size(); i++){
            if(appetizers.get(i).getDescription().toLowerCase().contains(menuItemDescription)){
                itemFound = true;
                foundItem = appetizers.get(i).toString();
            }
        }
        for(int i = 0; i < desserts.size(); i++){
            if(desserts.get(i).getDescription().toLowerCase().contains(menuItemDescription)){
                itemFound = true;
                foundItem = desserts.get(i).toString();
            }
        }
        for(int i = 0; i < mainCourses.size(); i++){
            if(mainCourses.get(i).getDescription().toLowerCase().contains(menuItemDescription)){
                itemFound = true;
                foundItem = mainCourses.get(i).toString();
            }
        }
        if(itemFound){
            return foundItem;
        } else {
            return "Item not found";
        }
    }

//Getters and Setters
    public ArrayList<MenuItem> getAppetizers(){
        return this.appetizers;
    }
    public ArrayList<MenuItem> getMainCourses(){
        return this.mainCourses;
    }
    public ArrayList<MenuItem> getDesserts(){
        return this.desserts;
    }
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setAppetizers(ArrayList<MenuItem> appetizers){
        this.appetizers = appetizers;
    }
    public void setMainCourses(ArrayList<MenuItem> mainCourses){
        this.mainCourses = mainCourses;
    }
    public void setDesserts(ArrayList<MenuItem> desserts){
        this.desserts = desserts;
    }
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
