package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.*;
/**
 * Created by тимур50 on 13.01.2018.
 */
public class PropertyLoader extends Properties{

    private static PropertyLoader instance = null;
    private String filename;
    private static String DBURL="jdbc:mysql://localhost:3306/univer";

    public static PropertyLoader getInstance()
    {
        if (instance==null)
            instance = new PropertyLoader();
        return instance;
    }


    private PropertyLoader()
    {
        try {
            FileInputStream in = new FileInputStream("E:\\projects\\webapp_main_project\\src\\main\\resources\\webapp.config");
            load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void main(String[] args) throws SQLException {

        String value = getInstance().getProperty("webapp.DBUSER");
        Connection connection= DriverManager.getConnection(DBURL,"root","td58ua");
        Statement smnt = connection.createStatement();
        ResultSet res = smnt.executeQuery("select * from groups");
        while(res.next()) {
            String name = res.getString("g_name");
            System.out.println(name);
        }
    }
}
