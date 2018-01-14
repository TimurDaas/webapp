package utils;

/**
 * Created by тимур50 on 13.01.2018.
 */
public class PropertyLoader {

    private PropertyLoader instance = null;
    private String filename;

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


}
