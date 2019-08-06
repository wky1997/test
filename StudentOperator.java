package day18;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentOperator implements StudentOperatable {
    @Override
    public List<Student> findAllStudent() {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            String sql = "select * from student";
            rs = statement.executeQuery(sql);

            while (rs.next()) {
                String sno = rs.getString(1);
                String sname = rs.getString(2);
                String ssex = rs.getString(3);
                int sage = rs.getInt("sage");
                String sdept = rs.getString(5);
                Student student = new Student();
                student.setSno(sno);
                student.setSname(sname);
                student.setSsex(ssex);
                student.setSage(sage);
                student.setSdept(sdept);
                studentList.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(rs);
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return studentList;
    }

    @Override
    public int updateStudentById(Student student) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("update student set sname ='");
            stringBuffer.append(student.getSname());
            stringBuffer.append("',ssex ='");
            stringBuffer.append(student.getSsex());
            stringBuffer.append("',sage =");
            stringBuffer.append(student.getSage());
            stringBuffer.append(",sdept ='");
            stringBuffer.append(student.getSdept());
            stringBuffer.append("'where sno ='");
            stringBuffer.append(student.getSno());
            stringBuffer.append("'");
            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }

    @Override
    public int inserStudent(Student student) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("insert into student values('");
            stringBuffer.append(student.getSno());
            stringBuffer.append("','");
            stringBuffer.append(student.getSname());
            stringBuffer.append("','");
            stringBuffer.append(student.getSsex());
            stringBuffer.append("',");
            stringBuffer.append(student.getSage());
            stringBuffer.append(",'");
            stringBuffer.append(student.getSdept());
            stringBuffer.append("')");

            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }

    @Override
    public int deleteStudentById(Student student) {
        Connection connection = JdbcUtil.getInstance().getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Student> studentList = new ArrayList<>();
        try {
            statement = connection.createStatement();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("delete from student where '");
            stringBuffer.append(student.getSno());
            stringBuffer.append("'");
            System.out.println(stringBuffer.toString());

            int affectedRows = statement.executeUpdate(stringBuffer.toString());

            return affectedRows;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.getInstance().closeResource(statement);
            JdbcUtil.getInstance().closeResource(connection);
        }
        return 0;
    }
}
