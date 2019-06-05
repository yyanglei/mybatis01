package net.wanho.mapper;

import net.wanho.pojo.Student;

import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public interface StudentMapper {

    List<Student> getAllStudents();

    void  addStudent(Student student);

    Student selectStudentById(Integer id);

    List<Student> selectStudentByName(String name);

    void  addStudentReturnKey(Student student);

    void  addStudentReturnKey2(Student student);

    void updateStudentbById(String sname,String address,Integer id);
}
