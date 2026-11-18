
package product.salesreport;

import java.util.Scanner;

/**
 *
 * @author ABUBAKER
 */
public class ProductSalesReport {

    
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       //Declarations of mattress and sales
       String[] mattress = {"Cozy Nights Monarch mattress", "Restonic Barbados mattress", "Sealy Phuket mattress"};
       
       int[][] sales = {{ 25, 15, 18},
                        { 18, 10, 15},
                        { 20, 12, 20}
       };
       
       int total =0;
       int count =0;
       
         //Outer loop 
       for(int i = 0;i< sales.length;i++){
           
            System.out.print("Enter the number of sales for month 1 for " + mattress[i] + ":");
            sales[i][0]= scanner.nextInt();
         
          System.out.print("Enter the number of sales  for month 2 for " + mattress[i] + ":");
         sales[i][1] = scanner.nextInt();
        
        System.out.print("Enter the number of sales for month 3  for " +  mattress[i] + ":");
         sales[i][2] = scanner.nextInt();
         
              //Inner loop
           for(int j =0; j<sales[i].length;j++){
           //add each value to the running total
            int num = sales[i][j];
            
            total+= num;
            count++;
           }
       }
       
       // Calcualtion of average  total divided by count
       double average = (double) total/count;
       
       //Print the report
        System.out.println("PRODUCT SALES REPORT - 2026");
        System.out.println("------------------------------");
         
       System.out.printf("TOTAL PRODUCT SALES      :   %8d%n", total);
       System.out.printf("AVERAGE PRODUCT SALES    :    %10.2f%n", average);
        
       
       
       Product product = new Product();
       
       scanner.close();
    }
    
}
