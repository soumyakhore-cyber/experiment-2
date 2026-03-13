
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.util.*;

import jakarta.servlet.http.HttpServlet; // IT IS A BASE CLASS FOR CREATING THE HTTP SERVLET
import jakarta.servlet.http.HttpServletRequest;  // IT IS USED TO GET THE DATA FROM THE CLINT
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddToCartServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException,IOException{
        String book = request.getParameter("book");

        HttpSession session = request.getSession();

        List<String> cart = (List<String>) session.getAttribute("cart");

        if(cart == null){
            cart = new ArrayList<>();
        }

        cart.add(book);

        session.setAttribute("cart",cart);

        response.sendRedirect("index.jsp");
    }
}