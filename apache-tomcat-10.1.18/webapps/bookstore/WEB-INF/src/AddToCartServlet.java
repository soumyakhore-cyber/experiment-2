import java.io.*; // the first line here its import input and output classes used in file and string handling/ string and file handling
import jakarta.servlet.*;// import general servlet classes
import jakarta.servlet.http.*;// import http specific servlet classes
import java.util.*;// import utility classes like list or array list

import jakarta.servlet.http.HttpServlet; // IT IS A BASE CLASS FOR CREATING THE HTTP SERVLET / helps us to create jakarta servlet
import jakarta.servlet.http.HttpServletRequest;  // IT IS USED TO GET THE DATA FROM THE CLINT / use to get data from the client request
import jakarta.servlet.http.HttpServletResponse;// used to send response back to the clint
import jakarta.servlet.http.HttpSession;// it is used to store user data accross multiple request

public class AddToCartServlet extends HttpServlet{ // class declare 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)// doget method is used to handle the get request
    throws ServletException,IOException{// it is used server related errors or exceptions
        String book = request.getParameter("book");// it help you to get the value of the book from the url or the form

        HttpSession session = request.getSession();// it is used to create a data session

        List<String> cart = (List<String>) session.getAttribute("cart");// it is a typecasting needed because session the stores the object ,
                                                                        //  it retrites the cart from the session
        if(cart == null){ //  theres is no cart , we have to create one
            cart = new ArrayList<>();// create a new empty cart
        }

        cart.add(book);// add the books to the cart

        session.setAttribute("cart",cart);// it is used to store the updated cart back into the sessions
                                          // it helps to create the persistents / consistentsy across the pages       
        response.sendRedirect("index.jsp");// it redirects the user to index.jsp after adding the items
    }    
    }                                  // prevent duplicate submission if page is refreshed