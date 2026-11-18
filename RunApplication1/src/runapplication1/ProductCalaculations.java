
package runapplication1;

/**
 *
 * @author ABUBAKER
 */
  public class ProductCalaculations  implements IProductCalculations{
        private double vat;
        private double commission;
        private double total;
        private double sales;
        
      public ProductCalaculations(double vat, double commission, double total, double sales){
            this.vat=vat;
             this.commission= commission;
            this.total= total;
            this.sales =sales;
           
      }
        
           
    @Override
    public double GetVat() {
      
           
       
       return vat;
    }

    @Override
    public double GetCommission() {
        return commission;
    }

    @Override
    public double GetTotal() {
        int total =0;
        
       
       return total;
    }
    
      
      
      
      

    
}

 
