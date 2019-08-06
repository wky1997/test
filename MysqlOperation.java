package day18;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlOperation {
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/train", "root", "123456");
            System.out.println(connection);
            statement = connection.createStatement();
            String sql = "select * from student";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String sno = resultSet.getString(1);
                String sname = resultSet.getString(2);
                String ssex = resultSet.getString(3);
                int sage = resultSet.getInt("sage");
                String sdept = resultSet.getString(5);
                System.out.println(sno + " " + sname + " " + ssex + " " + sage + " " + sdept);

                Student student = new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(sage);
                student.setSdept(sdept);
                System.out.println(student.getSno() + " " + student.getSname() + " " + student.getSsex() + " " + student.getSage() + " " + student.getSdept());
            }
            statement.executeQuery(sql);
        } catch (SQLException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeResource(connection);
            closeResource(resultSet);
            closeResource(statement);

        }
    }

    public static void closeResource(AutoCloseable autoCloseable){
        if (autoCloseable != null){
            try {
                autoCloseable.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
