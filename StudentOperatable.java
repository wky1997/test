package day18;

import java.util.List;

public interface StudentOperatable {
    /**
     * 查询所有数据
     * @return 将所有数据在集合中返回
     */
    List<Student> findAllStudent();

    /**
     * 修改信息
     * @param student 待修改的对象
     * @return 执行sql后，受影响的行数
     */
    int updateStudentById(Student student);

    /**
     * 添加数据
     * @param student
     * @return 执行sql后，受影响的行数
     */
    int inserStudent(Student student);

    /**
     * 删除数据
     * @param student
     * @return 执行sql后，受影响的行数
     */
    int deleteStudentById(Student student);
}
