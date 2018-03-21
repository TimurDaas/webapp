package ua.com.timur.webapp.servlets.mobileid;

import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by тимур50 on 13.01.2018.
 */
public class MobileIdServlet extends HttpServlet{

    private final String token = "https://testua.oauth.avest.org/oauth/token";
    private final String resource = "https://testua.oauth.avest.org/oauth/resource";
    private final String USER_AGENT = "Mozilla/5.0";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("You are in servlet mobileid"+req.getParameter("code"));

        URL tokenUrl = new URL(token);
        HttpURLConnection connection = (HttpURLConnection) tokenUrl.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("User-Agent",USER_AGENT);
        //connection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Bearer "+req.getParameter("code"));
        String params = "client_id=8HyfiUokftWnCO4mV15vcg0d30Jt0939&client_secret=b9yGGSuoK68kz64ehyglrAxwDfkSjAdI&grant_type=authorization_code&code="+req.getParameter("code")+"&redirect_uri="+req.getRequestURL();
        connection.setDoOutput(true);
        DataOutputStream os = new DataOutputStream(connection.getOutputStream());
        os.writeBytes(params);
        os.flush();
        os.close();

        int responceCode=connection.getResponseCode();


        BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = bf.readLine()) != null) {
            response.append(inputLine);
        }
        bf.close();

        //print result
        System.out.println(response.toString());
        JSONObject tokenReqParams = new JSONObject(response.toString());
        String access_token = tokenReqParams.getString("access_token");


        URL resourceUrl = new URL(resource);
        connection = (HttpURLConnection) resourceUrl.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty(HttpHeaders.AUTHORIZATION, "Bearer "+ access_token);
        //connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("User-Agent",USER_AGENT);
        connection.setRequestProperty(HttpHeaders.ACCEPT,"application/json");
        connection.setDoOutput(false);

        responceCode=connection.getResponseCode();


        bf = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        response = new StringBuffer();

        while ((inputLine = bf.readLine()) != null) {
            response.append(inputLine);
        }
        bf.close();

        //print result
        System.out.println(response.toString());
        JSONObject userParams = new JSONObject(response.toString());
        String userName = userParams.getJSONObject("data").getString("name");
        resp.getWriter().append(userParams.toString());

    }

    @Override
    public void init() throws ServletException {
        System.out.println("First Start");
        super.init();
    }
}
