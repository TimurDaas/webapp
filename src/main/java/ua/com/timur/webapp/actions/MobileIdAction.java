package ua.com.timur.webapp.actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by тимур50 on 09.03.2018.
 */
public class MobileIdAction extends ActionSupport {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String execute()
    {
        return SUCCESS;
        //return "success";
    }
}
