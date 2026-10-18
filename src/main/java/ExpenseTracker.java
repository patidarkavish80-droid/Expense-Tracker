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
        double amount = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Category :");
        String category = sc.nextLine();
        System.out.print("Add Description :");
        String Description = sc.nextLine();
        Expense e = new Expense(amount, category, Description);
        num.add(e);
    }
    static void View_All_Expenses(){
        if(num.isEmpty()){
            System.out.println("No expenses found");
        }else {
            for (int i = 0; i < num.size(); i++) {
                System.out.println();
                num.get(i).Display();
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
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
            switch (choice) {
                case 1:
                    Add_Expense();
                    break;
                case 2:
                    View_All_Expenses();
                    break;

                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid choice !!");
            }

        }
    }
}
