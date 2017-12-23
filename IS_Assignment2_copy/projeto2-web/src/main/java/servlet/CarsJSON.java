package servlet;

import ejb.CarEJBRemote;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;



/**
 * Created by jorgearaujo on 14/11/2017.
 */
@WebServlet("/rest/api/cars")
public class CarsJSON extends HttpServlet{

    @EJB
    private CarEJBRemote carEJBRemote;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String customers_json = carEJBRemote.getAllCarsJSON();


        System.out.println(customers_json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(customers_json);

        session.setAttribute("results", customers_json);
        response.sendRedirect(request.getContextPath() + "/carsJSON.jsp");

    }

}