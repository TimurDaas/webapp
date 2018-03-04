package webapp.actions;


import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by тимур50 on 05.03.2018.
 */
public class FirstAction extends ActionSupport{

    private String name;

    public String execute()
    {
        return SUCCESS;
        //return "success";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
