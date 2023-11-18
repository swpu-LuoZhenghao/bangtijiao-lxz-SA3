package b_s.Server;

import b_s.Entity.People;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBC {
    private static final String URL = "jdbc:mysql://localhost:3306/software3database";
    private  static  final  String driver = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "123456";

    private static final String tableName = "mytel";
    static Connection connection ;
    static   {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException sqlException) {
            System.out.println(sqlException);
            sqlException.printStackTrace();
        }
    }

    public static int insert(String name,String phone)  {
        String sql="insert into "+tableName+" values(?,?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            int i = preparedStatement.executeUpdate();
            return i;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
    public static int delete(String name)  {
        String sql="delete  from  "+tableName+" where name=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            int i = preparedStatement.executeUpdate();

            return i;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
    public static int update(String name3,String name,String phone)  {
        String sql="update  "+tableName+" set name=?,phone=? where name=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3,name3);
            int i = preparedStatement.executeUpdate();

            return i;
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return 0;
    }
    public static List<People> query() throws SQLException {
        String sql="select * from " + tableName;
        PreparedStatement pre=connection.prepareStatement(sql);
        List<People>list=new ArrayList<>();
        ResultSet resultSet = pre.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            list.add(new People(name,phone));
        }
        return list;
    }
}
