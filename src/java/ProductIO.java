
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;




/**
 *
 * @author Parth
 */
public class ProductIO {
    public static Product getProduct(String code, String filePath){
        BufferedReader br = null;
        try {
            File file = new File(filePath);
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while(line!=null){
                StringTokenizer t = new StringTokenizer(line,"|");
                String productCode = t.nextToken();
                if(productCode.equals(code)){
                    String description = t.nextToken();
                    double price = Double.parseDouble(t.nextToken());
                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);
                    br.close();
                    return p;
                }
                line = br.readLine();
            }
            br.close();
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static ArrayList<Product> getProducts(String filePath){
        BufferedReader br = null;
        ArrayList<Product> products = new ArrayList<>();
        try {
            File file = new File(filePath);
            br = new BufferedReader(new FileReader(file));
            String line = br.readLine();
            while(line!=null){
                StringTokenizer t = new StringTokenizer(line,"|");
                String productCode = t.nextToken();
                String description = t.nextToken();
                double price = Double.parseDouble(t.nextToken());
                Product p = new Product();
                p.setCode(productCode);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
                line = br.readLine();
            }
            br.close();
            return products;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(ProductIO.class.getName()).log(Level.SEVERE, null, ex);
            }
            //return null;
        }
    }
}
