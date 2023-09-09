import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("----------Online Retail System----------");
        System.out.print("Enter User Id: ");
        int userId = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter User Name: ");
        String userName = scan.nextLine();
        System.out.print("Enter Email Address: ");
        String email = scan.nextLine();

        User user = new User(userId, userName, email);
        System.out.println("----------User Information----------");
        user.login();

        System.out.println("1. Customer\n2. Admin");
        System.out.print("Please Enter Your Choice: ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter Customer Id: ");
                int customerId = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter Address: ");
                String address = scan.nextLine();

                Customer customer = new Customer(userId, userName, email, customerId, address);
                System.out.println("1. Place Order\n2. View Order History");
                System.out.print("Please Enter Your Choice: ");
                int ch = scan.nextInt();

                switch (ch) {
                    case 1:
                        customer.placeOrder();
                        break;
                    case 2:
                        customer.viewOrderHistory();
                        break;
                }
                break;
            case 2:
                // Add admin functionality if needed
                System.out.print("Enter Your Admin Id: ");
                int adminId = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter Which Department: ");
                String department = scan.nextLine();
                
                Admin admin = new Admin(userId, userName, email, adminId, department);
                
                System.out.println("1.Add Product\n2.Remove Products\n3.Manage Inventory");
                System.out.print("Please Enter Your Choice: ");
                int c = scan.nextInt();
                
                switch(c){
                    case 1:
                        admin.AddProduct();
                        break;
                    case 2:
                        admin.RemoveProduct();
                        break;
                    case 3:
                        admin.ManageInventory();
                        break;
                }
                break;
        }
    }
}

class User {
    private int userId;
    private String userName;
    private String email;

    User(int userId, String userName, String email) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
    }

    public void login() {
        System.out.println("User Id: " + userId);
        System.out.println("User Name: " + userName);
        System.out.println("Email Address: " + email);
        System.out.println("------------------------------------");
        System.out.println();
    }

    public void logout() {
        System.out.println("You are Logged Out");
    }
}

class Customer extends User {
    private int customerId;
    private String address;
    private ArrayList<Order> orderHistory;

    Customer(int userId, String userName, String email, int customerId, String address) {
        super(userId, userName, email);
        this.customerId = customerId;
        this.address = address;
        this.orderHistory = new ArrayList<>();
    }

    public void placeOrder() {
        Scanner scan = new Scanner(System.in);
        ArrayList<Order> orders = new ArrayList<>();

        Product p1 = new Product(1, "Piatos", 15, 10);
        Product p2 = new Product(2, "Nova", 15, 10);
        Product p3 = new Product(3, "Oreo", 10, 10);
        System.out.println("----------Products----------");
        p1.showProducts();
        p2.showProducts();
        p3.showProducts();

        do {
            System.out.print("Please Enter The Product Id to order (Enter '0' if you are finished): ");
            int prodId = scan.nextInt();
            if (prodId == 0) {
                break;
            }

            Product product = getProductById(prodId);
            if (product != null) {
                System.out.print("Enter Quantity: ");
                int quantity = scan.nextInt();

                if (quantity <= product.getStockQuantity()) {
                    Order order = new Order(customerId, product, quantity);
                    orders.add(order);
                    System.out.println("Added " + quantity + " " + product.getName() + "(s) to your order.");
                } else {
                    System.out.println("Sorry, there is not enough stock for " + product.getName());
                }
            } else {
                System.out.println("Invalid Product Id. Please try again.");
            }
        } while (true);

        if (!orders.isEmpty()) {
            System.out.println("\nOrder confirmed!");
            System.out.println("Ordered products:");
            for (Order order : orders) {
                order.orderDetails();
                addOrderToHistory(order);
            }
        }
    }

    public void viewOrderHistory() {
        System.out.println("----------Order History----------");
        if (orderHistory.isEmpty()) {
            System.out.println("No order history available.");
        } else {
            for (Order order : orderHistory) {
                order.orderDetails();
            }
        }
    }

    public void addOrderToHistory(Order order) {
        orderHistory.add(order);
    }

    private Product getProductById(int productId) {
        Product p1 = new Product(1, "Piatos", 15, 10);
        Product p2 = new Product(2, "Nova", 15, 10);
        Product p3 = new Product(3, "Oreo", 10, 10);

        switch (productId) {
            case 1:
                return p1;
            case 2:
                return p2;
            case 3:
                return p3;
            default:
                return null;
        }
    }
}
class Admin extends User{
    Scanner scan = new Scanner(System.in);
    int AdminId;
    String Department;
    
    Admin(int UserId, String UserName, String Email, int AdminId, String Department){
        super(UserId, UserName, Email);
        this.AdminId = AdminId;
        this.Department = Department;
    }
    public void AddProduct(){
        System.out.println("----------Adding Products----------");
        do{
            System.out.print("Enter Product's Id(Enter '0' to Stop): ");
            int ProId = scan.nextInt();
            scan.nextLine();
            if(ProId == 0){
                break;
            }
            System.out.print("Enter Product Name: ");
            String Pname = scan.nextLine();
            System.out.print("Enter Product's price: ");
            double price = scan.nextDouble();
            System.out.print("Enter Product's Quantity: ");
            int Quan = scan.nextInt();
        }
        while(true);
        System.out.println("----------Product's Successfully Added----------");
    }
    public void RemoveProduct(){
        do{
            System.out.print("Enter Product's Id(Enter '0' to Stop): ");
            int ProId = scan.nextInt();
            scan.nextLine();
            if(ProId == 0){
                break;
            }
            System.out.print("Enter Product Name: ");
            String Pname = scan.nextLine();
        }
        while(true);
        System.out.println("----------Product's Successfully Remove----------");
    }
    public void ManageInventory(){
        
    }
}

class Product {
    private int productId;
    private String name;
    private double price;
    private int stockQuantity;

    Product(int productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void showProducts() {
        System.out.println("Product Id: " + productId + "| " + "Product: " + name + "| " + "Price: " + price + "| " + "Stock Quantity: " + stockQuantity);
        System.out.println("-------------------------------------------------------------");
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }
}

class Order {
    private int customerId;
    private Product product;
    private int quantity;

    Order(int customerId, Product product, int quantity) {
        this.customerId = customerId;
        this.product = product;
        this.quantity = quantity;
    }

    public void orderDetails() {
        System.out.println("Customer Id: " + customerId + "| " + "Product: " + product.getName() + "| " + "Quantity: " + quantity + "| " + "Total Price: " + (quantity * product.getPrice()));
    }
}

