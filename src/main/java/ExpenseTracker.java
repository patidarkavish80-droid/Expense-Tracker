import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

class Expense{
    double amount ;
    String category ;
    String description ;
    Expense(double amount , String category,String description){
        this.amount=amount;
        this.category=category;
        this.description=description;
    }
    void Display(){
        System.out.println("Amount : "+amount);
        System.out.println("Category : "+category);
        System.out.println("Description : "+description);
    }
}

public class ExpenseTracker {
    static ArrayList<Expense> num = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void Add_Expense() {
        System.out.print("Enter Amount :");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("invalid amount");
        } else {
            sc.nextLine();
            System.out.print("Enter Category :");
            String category = sc.nextLine();
            System.out.print("Add Description :");
            String Description = sc.nextLine();
            Expense e = new Expense(amount, category, Description);
            num.add(e);
            Save_Expenses();
        }
    }

    static void View_All_Expenses() {

        if (num.isEmpty()) {
            System.out.println("No expenses found");
        } else {
            for (int i = 0; i < num.size(); i++) {
                num.get(i).Display();
                System.out.println();
            }
        }
    }

    static void View_Total_spending() {
        double sum = 0;

        for (int i = 0; i < num.size(); i++) {
            sum += num.get(i).amount;}

        System.out.println("Total Spending amount : " + sum);

    }static void Save_Expenses(){
        try (
            BufferedWriter w =
                    new BufferedWriter(new FileWriter("expense.txt"))) {

            for(int i = 0; i<num.size();i++) {

                    w.write(String.valueOf(num.get(i).amount));
                    w.newLine();

                    w.write(num.get(i).category);
                    w.newLine();

                    w.write(num.get(i).description);
                    w.newLine();
                    w.newLine();
                }
            } catch(Exception e){
                System.out.println("Error saving expenses: " + e.getMessage());
            }
        }
    static void Load_Expenses() {
        try (BufferedReader r =
                     new BufferedReader(new FileReader("expense.txt"))) {

            String amountLine;

            while ((amountLine = r.readLine()) != null) {
                if (amountLine.isBlank()) {
                    continue;
                }

                String category = r.readLine();
                String description = r.readLine();

                double amount = Double.parseDouble(amountLine);

                Expense e = new Expense(amount, category, description);
                num.add(e);

                r.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error loading expenses: " + e.getMessage());
        }
    }
    public static void main(String[] args) throws IOException {
Load_Expenses();
        System.out.println("====================================");
        System.out.println("      PERSONAL EXPENSE TRACKER      ");
        System.out.println("====================================");
        System.out.println("Welcome!");

        while (true) {
            System.out.println();
            System.out.println("========== EXPENSE TRACKER ==========");
            System.out.println("1.Add Expense");
            System.out.println("2.View All Expense");
            System.out.println("3.view Total Spending");
            System.out.println("4.Exit");
            System.out.println("======================================");
            System.out.print("Enter your choice : ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            System.out.println();

            switch (choice) {
                case 1:
                    Add_Expense();
                    break;
                case 2:
                    View_All_Expenses();
                    break;
                case 3:
                    View_Total_spending();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice !!");
            }
        }

        }
    }

