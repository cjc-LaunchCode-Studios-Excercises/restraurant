package restaurant;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //created menuItems
        MenuItem cheesecake = new MenuItem(2.99,"Cheesecake", "dessert");
        MenuItem steak = new MenuItem(15.99, "Steak", "main course", true);

        //created the menu and added previously made items to list
        Menu restaurantMenu = new Menu();
        restaurantMenu.addMenuItem(cheesecake);
        restaurantMenu.addMenuItem(steak);

        //created to allow exiting of program
        boolean exit = false;

        //opened Scanner utility
        Scanner input = new Scanner(System.in);

        //Start of program that will keep running until exit is true
        System.out.println("Welcome to the restraurant!");
        do{
            //Menu Option lists
            System.out.println("Please select a menu option:");
            System.out.println("1: Print Menu");
            System.out.println("2: Add Item");
            System.out.println("3: Remove Item");
            System.out.println("4: Search for Item");
            System.out.println("5: Exit");

            //allows read of input for menu options
            Integer selection = Integer.parseInt(input.nextLine());

            //Menu Options
            if(selection == 1){ //print full menu
                System.out.println(restaurantMenu);
            } else if(selection == 2) { //add menu item
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
            } else if(selection == 3){ //delete item
                System.out.println("Please enter description to delete the item: ");
                String description = input.nextLine();
                restaurantMenu.removeMenuItem(description);
            } else if(selection == 4){ //search option
                System.out.println("Please enter the description to search for an item:");
                String description = input.nextLine().toLowerCase();
                System.out.println(restaurantMenu.search(description));
            } else if(selection == 5){ //exit
                exit = true;
            } else {
                System.out.println("Invalid Input: Try Again");
            }
        } while (!exit);
        input.close();
    }
}
