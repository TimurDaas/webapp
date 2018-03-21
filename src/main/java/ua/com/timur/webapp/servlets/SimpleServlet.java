package ua.com.timur.webapp.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by тимур50 on 11.01.2018.
 */
@WebServlet(name="simple", urlPatterns = "/simpleservlet")
public class SimpleServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("You are in SimpleServlet");
        resp.setHeader("content-encoding", "daasUTF");
    }
}

/*client_id: oXyIJHyF8P5Jo7ICAL9MkykCU45ATbE5
        client_secret: E8DM3iz15RJ7WWoZqgiT5AvkPHOrjuFr
        URL возврата: https://176.241.109.185

        client_id: 8HyfiUokftWnCO4mV15vcg0d30Jt0939
client_secret: b9yGGSuoK68kz64ehyglrAxwDfkSjAdI
URL1: https://176.241.109.185/oauth
URL2: http://localhost:8080/webapp-1.0-SNAPSHOT/mobileid
*/