
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Parth
 */
public class CartNxtServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        double cartTotal=0;
        ArrayList<LineItem> cartItems = cart.getItems();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>CartNxtServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div><h4>Your Cart</h4></div>");
            out.println("<table border=1>");
            out.println("<tr><th>Product</th><th>Quantity</th><th>Amount</th></tr>");
            for(LineItem item:cartItems){
                double itemTotal = item.getTotal();
                cartTotal+=itemTotal;
                out.println("<tr>");
                out.println("<td>"+item.getProduct().getDescription()+"</td>");
                //out.println("<td>"+item.getQuantity()+"</td>");
                out.println("<td><form method='POST' action='AddToCart'>");
                out.println("<input type='hidden' name='pCode' value='"+item.getProduct().getCode()+"'/>");
                out.println("<input type='text' name='quantity' value='"+item.getQuantity()+"'/>");
                out.println("<input type='submit' value='submit' name='update'/>");
                out.println("</form></td>");
                out.println("<td>"+itemTotal+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<div><p>Cart Total: "+cartTotal+"</div>");
            out.println("<div><p><button>Check Out</button></p></div>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
