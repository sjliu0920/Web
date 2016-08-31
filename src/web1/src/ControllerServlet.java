
package web1.src;

/**
 * Created by double on 8/29/16.
 */

import java.io.*;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;

public class ControllerServlet extends HttpServlet{
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(!isValidated(req) && !("login".equals(action)))
        {
            gotoPage("login.html", req, res);
            return;
        }

        if("login".equals(action))
        {
            UserBean user = new UserBean();
            user.setName(req.getParameter("name"));
            user.setPassword(req.getParameter("password"));

            UserCheckBean uc = new UserCheckBean(user);
            try {
                if(uc.validate())
                {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", user);

                    gotoPage("firstPage.html", req, res);
                }
                else {
                    gotoPage("loginerr.jsp", req, res);
                }
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if("insertItem".equals(action)) {
            req.setCharacterEncoding("UTF-8");
            ItemBean item = new ItemBean();
            int level_1_id = Integer.parseInt(req.getParameter("level_1_id"));
            int level_2_id = Integer.parseInt(req.getParameter("level_2_id"));
            int item_star = Integer.parseInt(req.getParameter("item_star"));
            double item_price = Double.parseDouble(req.getParameter("item_price"));
            // String item_name = req.getParameter("item_name");

            String item_name  = new String(req.getParameter("item_name").getBytes("ISO-8859-1"));

            item.setLevel_1_id(level_1_id);
            item.setLevel_2_id(level_2_id);
            item.setItem_star(item_star);
            item.setItem_price(item_price);
            item.setItem_name(item_name);

            try {
                DBBean db = null;
                db = new DBBean();
                db.insertItem(item);
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isValidated(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if(session.getAttribute("user") != null)
            return true;
        else
            return false;
    }

    private void gotoPage(String targetUrl, HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException
    {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(targetUrl);
        rd.forward(request, response);
    }
}
