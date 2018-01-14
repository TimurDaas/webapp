package webapp.mobileid;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by тимур50 on 13.01.2018.
 */
@WebServlet(urlPatterns = "/mobileid")
public class MobileIdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("You are in servlet mobileid");
        String code = req.getParameter("code");
    }
}
