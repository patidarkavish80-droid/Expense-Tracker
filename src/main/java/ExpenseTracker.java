import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args){
        System.out.println("====================================");
        System.out.println("      PERSONAL EXPENSE TRACKER      ");
        System.out.println("====================================");
        System.out.println("Welcome!");
        System.out.println();
        System.out.println("========== EXPENSE TRACKER ==========");
        System.out.println("1.Add Expense");
        System.out.println("2.View All Expense");
        System.out.println("view Total Spending");
        System.out.println("Exit");
        System.out.println("======================================");
        System.out.print("Enter your choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

    }
}
