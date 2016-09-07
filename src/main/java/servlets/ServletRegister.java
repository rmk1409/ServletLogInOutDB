package servlets;

import classes.User;
import classes.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Roma on 07.09.2016.
 */
@WebServlet("/ServletRegister")
public class ServletRegister extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        String msg;
        HttpSession session = request.getSession(true);
        session.setMaxInactiveInterval(300);

        //check passwords
        if (request.getParameter("firstUserPassword").equals(request.getParameter("secondUserPassword"))) {

            //check login in DB
            if (UserDAO.validateRegisterData(request.getParameter("userLogin"))) {
                User user = new User(request.getParameter("userLogin"), request.getParameter("firstUserPassword")
                        , request.getParameter("userCitizenship"), request.getParameter("userInterests"), request.getParameter("userMoreInterests"));

                if (UserDAO.addUser(user)) {
                    msg = "You have registered successfully, logout will happen after 5 min without using this site or you can do it yourself, now you can check your profile";
                    session.setAttribute("login", user.getLogin());
                } else {
                    msg = "You couldn't registered";
                }
            } else {
                msg = "this login is already used";
            }
        } else {
            msg = "you have submit different passwords, please try again";
        }

        session.setAttribute("msg", msg);

        response.sendRedirect("/ServletIndex");
    }

}
