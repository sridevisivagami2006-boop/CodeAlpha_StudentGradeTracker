import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 10000.0;
        int shares = 0;
        double stockPrice = 500.0;

        int choice;

        do {
            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Shares");
            System.out.println("3. Sell Shares");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Current Stock Price: ₹" + stockPrice);
                    break;

                case 2:
                    System.out.print("Enter number of shares to buy: ");
                    int buy = sc.nextInt();

                    double buyCost = buy * stockPrice;

                    if (buyCost <= balance) {
                        shares += buy;
                        balance -= buyCost;
                        System.out.println("Shares purchased successfully.");
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;

                case 3:
                    System.out.print("Enter number of shares to sell: ");
                    int sell = sc.nextInt();

                    if (sell <= shares) {
                        shares -= sell;
                        balance += sell * stockPrice;
                        System.out.println("Shares sold successfully.");
                    } else {
                        System.out.println("Not enough shares.");
                    }
                    break;

                case 4:
                    System.out.println("\n===== PORTFOLIO =====");
                    System.out.println("Available Balance: ₹" + balance);
                    System.out.println("Owned Shares: " + shares);
                    System.out.println("Portfolio Value: ₹" + (shares * stockPrice));
                    break;

                case 5:
                    System.out.println("Thank you for using Stock Trading Platform.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}