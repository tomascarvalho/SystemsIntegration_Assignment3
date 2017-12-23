package servlet;

import ejb.CustomerEJBRemote;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * Created by jorgearaujo on 14/11/2017.
 */
@WebServlet("/rest/api/customers")
public class Customers extends HttpServlet{

    @EJB
    private CustomerEJBRemote customerEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String customers_xml = customerEJB.getAllCustomersXML();


        System.out.println(customers_xml);
        response.setContentType("text/xml");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(customers_xml);

        session.setAttribute("results", customers_xml);
        response.sendRedirect(request.getContextPath() + "/customers.jsp");

    }

}