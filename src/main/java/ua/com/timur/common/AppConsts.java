package ua.com.timur.common;

import ua.com.timur.utils.PropertyLoader;

/**
 * Created by тимур50 on 13.01.2018.
 */
public class AppConsts {

    public static final String APP_NAME = getProperty("webapp.name","mywebapp");
    public static final String APP_MOBILE_ID_URL = getProperty("webapp.mobileid.url");
    public static final String APP_MOBILE_ID_AUTHORIZE_URI = getProperty("webapp.mobileid.authorize.uri");
    public static final String APP_MOBILE_ID_TOKEN_GET_URI = getProperty("webapp.mobileid.token.get.uri");
    public static final String APP_MOBILE_ID_USER_DATA_GET_URI = getProperty("webapp.mobileid.user.data.get.uri");
    public static final String APP_MOBILE_ID_CLIENT_ID = getProperty("webapp.mobileid.client.id");
    public static final String APP_MOBILE_ID_CLIENT_SECRET = getProperty("webapp.mobileid.client.secret");
    public static final String APP_DB_URL = getProperty("webapp.URL");
    public static final String APP_DB_USER = getProperty("webapp.DBUSER");
    public static final String APP_DB_USER_PWD = getProperty("webapp.DBUSER.PWD");

    public static String getProperty(String name, String defaultValue)
    {
        return PropertyLoader.getInstance().getProperty(name, defaultValue);
    }

    public static int getProperty(String name, int defaultValue)
    {
        return PropertyLoader.getInstance().getProperty(name, defaultValue);
    }

    public static boolean getProperty(String name, boolean defaultValue)
    {
        return PropertyLoader.getInstance().getProperty(name, defaultValue);
    }

    public static String getProperty(String name)
    {
        return PropertyLoader.getInstance().getProperty(name, (String) null);
    }


}
