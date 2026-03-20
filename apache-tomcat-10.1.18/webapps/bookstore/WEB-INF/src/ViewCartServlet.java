import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;
import jakarta.servlet.http.HttpServlet; // IT IS A BASE CLASS FOR CREATING THE HTTP SERVLET
import jakarta.servlet.http.HttpServletRequest;  // IT IS USED TO GET THE DATA FROM THE CLINT
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ViewCartServlet extends HttpServlet{ // class create
    protected void doGet(HttpServletRequest request, HttpServletResponse response) // 
    throws ServletException,IOException{
        HttpSession session = request.getSession();

        List<String> cart = (List<String>) session.getAttribute("cart");

        response.setContentType("text/html"); // it tells the browser the response is in html content / form
        PrintWriter out = response.getWriter(); // it is used to send html output to the browser

        out.println("<h2>Your Cart</h2>");   // 

        if(cart != null){ // if your cart is empty
            for(String book : cart){ //
                out.println(book + "<br>"); // 
            }
        }else{
            out.println("Cart is empty"); // 
        }
    }
}
