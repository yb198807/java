package mysqlJava;

import java.beans.Statement;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static{
        Properties properties=new Properties();
        try {
            properties.load(new FileInputStream("mysqlJava\\mysql.properties"));
            driver = properties.getProperty(driver);
            url = properties.getProperty(url);
            username = properties.getProperty(username);
            password = properties.getProperty(password);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url, username, password);
    }
    public static void close(ResultSet rs,Statement sm,Connection cn) throws SQLException, IOException{
        if(rs!=null){
            rs.close();
        }
        if(sm!=null){
            ((Closeable) sm).close();
        }
        if(cn!=null){
            cn.close();
        }
    }
}
