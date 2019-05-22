
import java.util.ArrayList;

/**
 *
 * @author Parth
 */
public class Cart {
    private ArrayList<LineItem> items;

    public Cart() {
        items = new ArrayList<>();
        
    }

    public ArrayList<LineItem> getItems() {
        return items;
    }
    
    public int getCount(){
        return items.size();
    }
    
    public void addItem(LineItem item){
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        if(getCount()>0){
            for(LineItem i:items){
                if(i.getProduct().getCode().equals(code)){
                    i.setQuantity(quantity);
                    return;
                }
            }
        }
        items.add(item);
    }
    
    public void removeItem(LineItem item){
        String code = item.getProduct().getCode();
        for(LineItem i:items){
            if(i.getProduct().getCode().equals(code)){
                items.remove(i);
                return;
            }
        }
    
     }
}
