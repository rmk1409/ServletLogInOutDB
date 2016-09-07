package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Roma on 07.09.2016.
 */
@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession(false);
        String login = null;
        String msg = null;

        if (session != null) {
            login = (String) session.getAttribute("login");
            msg = (String) session.getAttribute("msg");
        }
        PrintWriter writer = response.getWriter();

        if (login != null) {
            //connection
            //welcome
            writer.println("<b><a href='/ServletLogout'>Logout</a><br></b>");
            writer.println("<b><a href='/ServletProfile'>Profile</a><br></b>");
            writer.printf("Hello, %s<br>", login);
        } else {
            //register or login
            writer.println("<b><a href='loginForm.html'>Login</a></b><br>");
            writer.println("<b><a href='registerForm.html'>Register</a></b><br>");
        }

        if (msg != null) {
            writer.printf("%s", msg);
        }

        writer.close();
    }
}