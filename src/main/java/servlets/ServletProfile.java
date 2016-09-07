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
@WebServlet("/ServletProfile")
public class ServletProfile extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print("<a href='/ServletLogout'><b>Logout</b></a><br>");

        HttpSession session = request.getSession();
        //check and put attributes into session
        if (session.getAttribute("id") == null) {
            User user = UserDAO.getUser((String) session.getAttribute("login"));
            session.setAttribute("id", user.getId());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("info_1", user.getCitizenship());
            session.setAttribute("info_2", user.getInterests());
            session.setAttribute("info_3", user.getMoreInterests());

            writer.print("Get data from DB<br>");
        }

        writer.print("<b>Your profile:</b><hr>");
        writer.print("<table>");
        writer.printf("<tr><td>Your login: </td><td>%s</td></tr>", session.getAttribute("login"));
        writer.printf("<tr><td>Your password: </td><td>%s</td></tr>", session.getAttribute("password"));
        writer.printf("<tr><td>Your citizenship: </td><td>%s</td></tr>", session.getAttribute("info_1"));
        writer.printf("<tr><td>Your interests: </td><td>%s</td></tr>", session.getAttribute("info_2") == null
                || ((String) session.getAttribute("info_2")).trim().isEmpty() ? "no interests" : session.getAttribute("info_2"));
        writer.printf("<tr><td>Your other interests: </td><td>%s</td></tr>", session.getAttribute("info_3") == null
                || ((String) session.getAttribute("info_3")).trim().isEmpty() ? "no interests" : session.getAttribute("info_3"));
        writer.print("</table>");

        writer.close();
    }
}
