package productsalesapp;

import java.util.Scanner;

public class ProductSalesApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of years: ");
        int numYears = input.nextInt();

        System.out.print("Enter number of quarters: ");
        int numQuarters = input.nextInt();

        int[][] salesData = new int[numYears][numQuarters];

        // Inputting the sales data for each year and quarter.
        for (int i = 0; i < numYears; i++) {
            System.out.println("Year " + (i + 1) + ":");
            for (int j = 0; j < numQuarters; j++) {
                System.out.print("Enter sales for Quarter" + (j + 1) + ": ");
                salesData[i][j] = input.nextInt();
            }
        }

        ProductSales sales = new ProductSales();

        // Calculatiions
        int total = sales.TotalSales(salesData);
        double average = sales.AverageSales(salesData);
        int maximum = sales.MaxSale(salesData);
        int minimum = sales.MinSale(salesData);

        // Displaying of the report
        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("-----------------------------");
        System.out.println("Total sales:    " + total);
        System.out.println("Average sales:  " + (int) average);
        System.out.println("Maximum sale:   " + maximum);
        System.out.println("Minimum sale:   " + minimum);
        System.out.println("-----------------------------");

        input.close();
    }
}
