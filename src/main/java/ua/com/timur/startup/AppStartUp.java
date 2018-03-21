package ua.com.timur.startup;

import org.apache.log4j.Logger;
import ua.com.timur.utils.PropertyLoader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * Created by тимур50 on 21.03.2018.
 */
public class AppStartUp extends HttpServlet{

    private static Logger logger = Logger.getLogger(AppStartUp.class);

    @Override
    public void init() throws ServletException {
        super.init();
        if(!PropertyLoader.read())
            logger.info("Error during loading properties");

    }
}
