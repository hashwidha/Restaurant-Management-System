import java.util.*;

// Base class for menu items
class MenuItem {
    protected String name;
    protected double price;
    
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    
    public void display() {
        System.out.println(name + " - Rs." + price);
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getName() {
        return name;
    }
}

// Derived class for food items
class Food extends MenuItem {
    public Food(String name, double price) {
        super(name, price);
    }
}

// Derived class for drinks
class Drink extends MenuItem {
    public Drink(String name, double price) {
        super(name, price);
    }
}

// Restaurant class to manage menu and orders
class Restaurant {
    private List<MenuItem> menu = new ArrayList<>();
    private List<MenuItem> order = new ArrayList<>();
    
    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }
    
    public void displayMenu() {
        System.out.println("\n---- Menu ----");
        int index = 1;
        for (MenuItem item : menu) {
            System.out.println(index + ". " + item.getName() + " - Rs." + item.getPrice());
            index++;
        }
    }
    
    public void placeOrder() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        char more;
        do {
            displayMenu();
            System.out.print("Enter the number of the item you want to order: ");
            choice = scanner.nextInt();
            if (choice > 0 && choice <= menu.size()) {
                order.add(menu.get(choice - 1));
                System.out.println(menu.get(choice - 1).getName() + " added to order.");
            } else {
                System.out.println("Invalid selection. Please choose from the menu.");
            }
            System.out.print("Do you want to add more items? (y/n): ");
            more = scanner.next().charAt(0);
        } while (more == 'y' || more == 'Y');
        scanner.close();  // Closing the scanner to prevent resource leaks
    }
    
    public void generateBill() {
        double total = 0;
        System.out.println("\n---- Bill ----");
        for (MenuItem item : order) {
            item.display();
            total += item.getPrice();
        }
        System.out.println("Total: Rs." + total);
    }
}

public class RestaurantManagement {
    public static void main(String[] args) {
        Restaurant rest = new Restaurant();
        rest.addMenuItem(new Food("Pizza", 250));
        rest.addMenuItem(new Drink("Coke", 50));
        rest.addMenuItem(new Food("Burger", 150));
        rest.addMenuItem(new Drink("Juice", 70));
        
        rest.placeOrder();
        rest.generateBill();
    }
}
