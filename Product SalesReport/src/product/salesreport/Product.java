
package product.salesreport;

/**
 *
 * @author ABUBAKER
 */
  class Product implements IProduct {
   private int totalProductsSold;
   private int averageProductsSold;
   private String mostPopularProduct;
      
      
      
    @Override
    public int GetTotalProductsSold() {
        
       return totalProductsSold;
        
    }

    @Override
    public double GetAverageProductsSold() {
        return averageProductsSold;
    }

    @Override
    public String GetMostPopularProduct() {
       
       return mostPopularProduct;
       
    }
    
}
