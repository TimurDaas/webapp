package ua.com.timur.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.*;
import java.util.Properties;
import org.apache.log4j.Logger;


/**
 * Created by тимур50 on 13.01.2018.
 */
public class PropertyLoader extends Properties{

    private static Logger logger = Logger.getLogger(PropertyLoader.class);
    private static PropertyLoader instance = null;

    public static PropertyLoader getInstance()
    {
        if (instance==null)
            try {
                instance = new PropertyLoader();
            } catch (IOException e) {
                e.printStackTrace();
            }
        return instance;
    }

    public static boolean read()
    {
        getInstance();
        logger.info("Properties has been loaded");
        return true;
    }

    private PropertyLoader() throws IOException {
            FileInputStream in = new FileInputStream("E:\\projects\\webapp_main_project\\src\\main\\resources\\webapp.config");
            load(in);
    }

    public boolean getProperty(String name, boolean defaultValue)
    {
        String value = getProperty(name);
        return value.isEmpty() ? defaultValue : Boolean.valueOf(value);
    }

    public String getProperty(String name, String defaultValue)
    {
        return getProperty(name,defaultValue);
    }

    public int getProperty(String name, int defaultValue)
    {
        String value = getProperty(name);
        return value.isEmpty() ? defaultValue : Integer.parseInt(value);
    }

    public static void main1(String[] args) throws SQLException, IOException {

        String value = getInstance().getProperty("ua.com.timur.webapp.DBUSER");
        String miu =getInstance().getProperty("ua.com.timur.webapp.servlets.mobileid.url","testUrl");
//        //Connection connection= DriverManager.getConnection(DBURL,"root","td58ua");
//        //Statement smnt = connection.createStatement();
//        //ResultSet res = smnt.executeQuery("select * from groups");
//        HttpURLConnection con;
//        URL url = new URL("http://google.com.ua");
//        con = (HttpURLConnection) url.openConnection();
//        con.setRequestMethod("GET");
//        con.setDoOutput(true);
//        final OutputStream out = con.getOutputStream();
//        final DataOutputStream dataOut = new DataOutputStream(new BufferedOutputStream(out));
//
        URL tokenUrl = new URL("https://testua.oauth.avest.org/oauth/token");
        HttpURLConnection connection = (HttpURLConnection) tokenUrl.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("User-Agent","Mozilla/5.0");
        String params = "login=timurka&password=td58ua&remember=1";//"client_id=8HyfiUokftWnCO4mV15vcg0d30Jt0939&client_secret=b9yGGSuoK68kz64ehyglrAxwDfkSjAdI&grand_type=authorization_code&code="+req.getParameter("code")+"&redirect_uri="+req.getRequestURL();
        connection.setDoOutput(true);
        DataOutputStream os = new DataOutputStream(connection.getOutputStream());
        os.writeBytes(URLEncoder.encode(params,"UTF-8"));
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

    }
}
