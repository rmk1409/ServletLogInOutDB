package servlets;

import classes.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Roma on 07.09.2016.
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //check
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(300);
        String msg;

        if (UserDAO.validateLoginData(request.getParameter("userLogin"), request.getParameter("userPassword"))) {
            session.setAttribute("login", request.getParameter("userLogin"));
            msg = "You have logined";
        } else {
            msg = "You haven't logined";
        }

        session.setAttribute("msg", msg);
        response.sendRedirect("ServletIndex");
    }
}