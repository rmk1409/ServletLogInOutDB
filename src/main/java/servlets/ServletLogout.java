package servlets;

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
@WebServlet("/ServletLogout")
public class ServletLogout extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("login");
        session.removeAttribute("id");
        session.removeAttribute("password");
        session.removeAttribute("info_1");
        session.removeAttribute("info_2");
        session.removeAttribute("info_3");
        session.removeAttribute("msg");

        response.sendRedirect("/ServletIndex");
    }
}
