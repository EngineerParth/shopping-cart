
import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author Parth
 */
public class LineItem implements Serializable{
    
    private Product product;
    private int quantity;

    /**
     * Get the value of product
     *
     * @return the value of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Set the value of product
     *
     * @param product new value of product
     */
    public void setProduct(Product product) {
        this.product = product;
    }
    
   

    /**
     * Get the value of quantity
     *
     * @return the value of quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the value of quantity
     *
     * @param quantity new value of quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getTotal(){
        double total = product.getPrice()*quantity;
        return total;
    }
    
    public String getTotalCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
               
    }


}
