import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class mysqlJava {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="123456";
        Connection connection=DriverManager.getConnection(url, username, password);
        java.sql.Statement statement=connection.createStatement();
        //增删改
        //int n=statement.executeUpdate("insert into user values(4,'lisi' ,12)");
        //查
        ResultSet resultSet=statement.executeQuery("select * from user");
        while (resultSet.next()) {
            System.out.print("id:" + resultSet.getInt("id")+"\t");
            System.out.print("name:" + resultSet.getString("name")+"\t");
            System.out.println("age:" + resultSet.getInt("age"));
        }
        statement.close();
        connection.close();
    }
}
