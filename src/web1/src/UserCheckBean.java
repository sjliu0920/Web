package web1.src;

import javax.naming.NamingException;
import java.sql.SQLException;

/**
 * Created by double on 8/29/16.
 */
public class UserCheckBean {

    protected UserBean user;

    public UserCheckBean()
    {
    }

    public UserCheckBean(UserBean user)
    {
        this.user = user;
    }

    public UserBean getUser()
    {
        return user;
    }

    public void setUser(UserBean user)
    {
        this.user = user;
    }

    public boolean validate() throws NamingException, SQLException {
        String name = user.getName();
        String password = user.getPassword();

        DBBean db = new DBBean();
        return db.searchUser(name, password);
    }
}
