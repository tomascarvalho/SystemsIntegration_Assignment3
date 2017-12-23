package servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by jorgearaujo on 14/11/2017.
 */

@WebFilter("/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);
        String loginService = request.getContextPath() + "/login";
        String registerService = request.getContextPath() + "/register";
        String loginURI = request.getContextPath() + "/login.jsp";
        String registerURI = request.getContextPath() + "/register.jsp";
        String apiService = "rest/api";
        String apiEndpointCars = request.getContextPath() + "/carsJSON.jsp";
        String apiEndpointCustomers = request.getContextPath() + "/customers.jsp";

        boolean loggedIn = session != null && session.getAttribute("userId") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean registerRequest  = request.getRequestURI().equals(registerURI);
        boolean loginTry = request.getRequestURI().equals(loginService);
        boolean registerTry = request.getRequestURI().equals(registerService);
        boolean apiRequest = request.getRequestURI().contains(apiService);
        boolean apiEndpointCarsTry = request.getRequestURI().contains(apiEndpointCars);
        boolean apiEndpointCustomersTry = request.getRequestURI().contains(apiEndpointCustomers);

        if (loggedIn || loginRequest || registerRequest || loginTry || registerTry || apiRequest || apiEndpointCarsTry || apiEndpointCustomersTry) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {

    }
}