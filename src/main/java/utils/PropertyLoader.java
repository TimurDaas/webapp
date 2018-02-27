package utils;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;

import com.mysql.jdbc.*;
/**
 * Created by тимур50 on 13.01.2018.
 */
public class PropertyLoader {

    private PropertyLoader instance = null;
    private String filename;
    private static String DBURL="jdbc:mysql://localhost:3306/univer";

    public PropertyLoader getInstance()
    {
        return instance;
    }


    public PropertyLoader(String filename)
    {
        this.filename=filename;
        if (instance==null)
            instance=new PropertyLoader(filename);
    }

    public static String load(String name)
    {
        return "";
    }

    public static void main(String[] args) throws SQLException {
        Connection connection= DriverManager.getConnection(DBURL,"root","td58ua");
        Statement smnt = connection.createStatement();
        ResultSet res = smnt.executeQuery("select * from groups");
        while(res.next()) {
            String name = res.getString("g_name");
            System.out.println(name);
        }
    }
}
