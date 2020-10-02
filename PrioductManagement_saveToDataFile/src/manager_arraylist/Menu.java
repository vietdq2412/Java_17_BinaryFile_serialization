package manager_arraylist;

import product.Product;

import java.io.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu extends ArrayListManager {
    private final String MENU = " ----------Menu----------"
            + "\n| --1.Add product---------|"
            + "\n| --2.Sort product--------|"
            + "\n| --3.Edit product -------|"
            + "\n| --4.Delete product------|"
            + "\n| --5.Search product------|"
            + "\n| --6.Show products list--|"
            + "\n| --7.  exit  ------------|"
            + "\n|_________________________|"
            + "\n| Enter your choice: ";
    private final Scanner sc = new Scanner(System.in);

    ///
    public void run() {
        try {
            getDataFromFile();
            int nextID = products.get(0).getId();
            for (Product ele : products){
                if (nextID < ele.getId()){
                    nextID = ele.getId();
                }
            }
            setId(nextID+1);
        } catch (IOException e) {
            System.out.println("Nothing here!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printMenu();
        int choice = inputInt();
        while (choice != 7) {
            runMenu(choice);
            printMenu();
            choice = inputInt();
        }
    }

    public void printMenu() {
        System.out.println(MENU);
    }

    public void runMenu(int choice) {
        switch (choice) {
            case 1:
                System.out.println("enter name: ");
                sc.nextLine();
                String name = inputString();
                System.out.println("enter price: ");
                int price = inputInt();
                System.out.println("enter brand: ");
                sc.nextLine();
                String brand = inputString();
                System.out.println("enter description: ");
                String description = inputString();
                addProduct(name, price, brand, description);
                updateData();
                break;
            case 2:
                System.out.println("|--1. sort up---|" +
                        "|--2. sort down-|");
                System.out.println("Your choice: ");
                int c = sc.nextInt();
                switch (c) {
                    case 1:
                        sortUp();
                        break;
                    case 2:
                        sortDown();
                        break;
                    default:
                        System.out.println("invalid!");
                }
                updateData();
                break;
            case 3:
                System.out.println("enter ID: ");
                int id = inputInt();
                System.out.println("enter new name: ");
                sc.nextLine();
                name = inputString();
                System.out.println("enter new price: ");
                price = inputInt();
                System.out.println("enter new brand: ");
                sc.nextLine();
                brand = inputString();
                System.out.println("enter new description: ");
                description = inputString();
                editProduct(id, name, price, brand, description);
                updateData();
                break;
            case 4:
                System.out.println("enter product ID: ");
                id = inputInt();
                deleteProduct(id);
                updateData();
                break;
            case 5:
                System.out.println("enter product name: ");
                name = inputString();
                searchProductByName(name);
                break;
            case 6:
                showList();
                break;
            default:
                System.out.println("select an option!");
        }
    }

    public int inputInt() {
        int number = -1;
        boolean check = false;
        do {
            try {
                number = Integer.parseInt(sc.nextLine());
                check = false;
            }catch (NumberFormatException e){
                System.out.println("input a number!");
                check = true;
            }
        }while (check);
        return number;
    }

    public String inputString() {
        String str = sc.nextLine();
        return str;
    }

    public void updateData(){
        try {
            addDataToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addDataToFile() throws IOException {
        FileOutputStream file = new FileOutputStream("data.txt");
        ObjectOutputStream os = new ObjectOutputStream(file);
        os.writeObject(products);
        os.close();
        file.close();
    }

    @Override
    public void getDataFromFile() throws IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("data.txt");
        ObjectInputStream is = new ObjectInputStream(file);
        products = (List<Product>) is.readObject();
        is.close();
        file.close();
    }
}
