
import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author Parth
 */
public class Product implements Serializable{
    private String code;
    private String description;
    private double price;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product() {
        this.code = "";
        this.description = "";
        this.price = 0.0;
    }
    
    public String getPriceCurrencyFormat(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
}
