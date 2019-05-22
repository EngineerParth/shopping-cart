
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletContext;

/**
 * Web application lifecycle listener.
 *
 * @author Parth
 */
public class CartContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String productsPath = "C:\\Users\\Parth\\Documents\\NetBeansProjects\\onlineshop\\build\\web\\WEB-INF\\Products.txt";
        
        // This line always returns null and under debugging
        //String productsPath = sc.getRealPath("/Products.txt");
        
        sc.setAttribute("productsPath", productsPath);
        ArrayList<Product> products = ProductIO.getProducts(productsPath);
        sc.setAttribute("products", products);
        String custServEmail = sc.getInitParameter("custServEmail");
        sc.setAttribute("custServEmail", custServEmail);
        GregorianCalendar currentDate = new  GregorianCalendar();
        int currentYear = currentDate.get(Calendar.YEAR);
        sc.setAttribute("currentYear",currentYear);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
