package restaurant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        MenuItem cheesecake = new MenuItem(2.99,"Cheesecake", "dessert");
        MenuItem steak = new MenuItem(15.99, "Steak", "main course", true);
        System.out.println(cheesecake);

        Menu restaurantMenu = new Menu();
        restaurantMenu.addMenuItem(cheesecake);
        restaurantMenu.addMenuItem(steak);

        boolean exit = false;
        System.out.println(restaurantMenu);
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the restraurant!");
        do{
            System.out.println("Please select a menu option:");
            System.out.println("1: Print Menu");
            System.out.println("2: Add Item");
            System.out.println("3: Remove Item");
            System.out.println("4: Search for Item");
            System.out.println("5: Exit");
            Integer selection = Integer.parseInt(input.nextLine());
            if(selection == 1){
                System.out.println(restaurantMenu);
            } else if(selection == 2) {
                System.out.println("Please enter name/description: ");
                String descriptionAdd = input.nextLine();

                System.out.println("Please enter price: ");
                Double price = Double.parseDouble(input.nextLine());

                Integer categoryNum;
                String categoryString = "";
                do {
                    System.out.println("Please enter category: \n1: Appetizer \n2: Main Course \n3: Dessert");
                    categoryNum = Integer.parseInt(input.nextLine());
                    categoryString = MenuItem.setCategoryUsingNum(categoryNum);
                } while (categoryNum>3);
                System.out.println("Is it a new item? true or false");
                Boolean newItemBoolean = Boolean.parseBoolean(input.nextLine());

                MenuItem newMenuItemCreated = new MenuItem(price, descriptionAdd, categoryString, newItemBoolean);
                restaurantMenu.addMenuItem(newMenuItemCreated);
            } else if(selection == 3){
                System.out.println("Please enter description to delete the item: ");
                String description = input.nextLine();
                restaurantMenu.removeMenuItem(description);
            } else if(selection == 4){
                System.out.println("Please enter the description to search for an item:");
                String description = input.nextLine().toLowerCase();
                System.out.println(restaurantMenu.search(description));
            } else if(selection == 5){
                exit = false;
            } else {
                System.out.println("Invalid Input: Try Again");
            }
        } while (!exit);
        input.close();
    }
}
