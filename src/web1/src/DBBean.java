/**
 * Created by double on 8/29/16.
 */

package web1.src;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.sql.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBBean extends HttpServlet implements Serializable{
    private DataSource ds = null;
    private String url;
    private String user;
    private String password;

    public DBBean() throws NamingException
    {
        Context ctx = new InitialContext();
        ds = (DataSource) ctx.lookup("java:comp/env/jdbc/costco");
    }

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        return ds.getConnection();
    }

    protected void closeConnection(Connection conn)
    {
        if(conn != null)
        {
            try {
                conn.close();
                conn = null;
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void closeStatement(Statement stmt)
    {
       if(stmt != null)
       {
           try {
               stmt.close();
               stmt = null;
           }
           catch (SQLException ex)
           {
               // ex.printStackTrace();
           }
       }
    }

    protected void closePrepareStatement(PreparedStatement pstmt)
    {
        if(pstmt != null)
        {
            try
            {
                pstmt.close();
                pstmt = null;
            }
            catch (SQLException ex)
            {

            }
        }
    }

    protected void closeResultSet(ResultSet rs)
    {
        if(rs != null)
        {
            try
            {
               rs.close();
                rs = null;
            }
            catch (SQLException ex)
            {

            }
        }
    }

    public Collection getBook() throws SQLException
    {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Statement stmt = null;

        ArrayList<BookBean> bookList = new ArrayList<BookBean>();

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from item_table");

            while (rs.next())
            {
                // item_id | type_id | type_name    | price | star
                BookBean book = new BookBean(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getDouble(4), rs.getInt(5));
                bookList.add(book);
            }

            return bookList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }

        return null;
    }

    public boolean searchUser(String name, String password) throws SQLException
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user_table WHERE account = \'" + name + "\' AND passwd = \'" + password + "\' ";
            rs = stmt.executeQuery(sql);

            while (rs.next())
            {
                return true;
            }

            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return false;
    }

    public Collection searchBook(String keyword) throws SQLException
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        ArrayList<BookBean> bookList = new ArrayList<BookBean>();

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from item_table WHERE type_name LIKE '%"+keyword+"%'");

            while (rs.next())
            {
                // item_id | type_id | type_name    | price | star
                BookBean book = new BookBean(rs.getInt(1), rs.getInt(2),
                        rs.getString(3), rs.getDouble(4), rs.getInt(5));
                bookList.add(book);
            }

            return bookList;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(conn);
        }
        return null;
    }


    public void insertItem(ItemBean item) throws SQLException
    {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            String sql = "INSERT INTO item_table(type_id, item_name, price, star) VALUES (" +
                    item.getLevel_1_id() + ",\'" +
                    item.getItem_name() +"\'," +
                    item.getItem_price() + "," +
                    item.getItem_star() + ")";

            stmt.execute(sql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStatement(stmt);
            closeConnection(conn);
        }
    }
}
