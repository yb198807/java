package mysqlJava;
import java.beans.Transient;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mysqlJava {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        //注册驱动
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //创建连接
        //String url="jdbc:mysql://localhost:3306/test";
        //String username="root";
        //String password="123456";
        //Connection connection=DriverManager.getConnection(url, username, password);
        Connection connection = JdbcUtil.getConnection();
        ////创建代理
        //java.sql.Statement statement=connection.createStatement();
        ////执行sql语句
        //int n=statement.executeUpdate("update user set name='liudehua' where id=2");//增删改
        //System.out.println(n);
        //ResultSet resultSet=statement.executeQuery("select * from user");//查
        //while (resultSet.next()) {
        //    System.out.print("id:" + resultSet.getInt("id")+"\t");
        //    System.out.print("name:" + resultSet.getString("name")+"\t");
        //    System.out.println("age:" + resultSet.getInt("age"));
        //}
        //创建代理
        PreparedStatement statement = connection.prepareStatement("update user set name=? where id=2");
        statement.setString(1, "zhaowei");
        //执行sql语句
        statement.executeUpdate();
        statement=connection.prepareStatement("select * from user");
        ResultSet executeQuery = statement.executeQuery();
        while(executeQuery.next()){
            System.out.println(executeQuery.getInt("id")+executeQuery.getString("name")+executeQuery.getInt("age"));
        }
        //释放资源
        //executeQuery.close();
        //statement.close();
        //connection.close();
        JdbcUtil.close(executeQuery, null, connection);
    }

}
