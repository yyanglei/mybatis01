package net.wanho.test;


import net.wanho.mapper.StudentMapper;
import net.wanho.pojo.Student;
import net.wanho.util.myUtilBaties;
import org.apache.ibatis.session.SqlSession;

import org.junit.Before;
import org.junit.Test;


import java.util.List;

/**
 * Created by Administrator on 2019/6/5.
 */
public class TestMybBatis {


    private SqlSession sqlSession;
    private StudentMapper studentMapper;

    @Before
    public void before() {

     /* InputStream inputStream=TestMybBatis.class.getClassLoader().getResourceAsStream("mybatis-config.xml");

      SqlSessionFactory sf=new SqlSessionFactoryBuilder().build(inputStream);
  // 创建回话
      sqlSession=sf.openSession();*/

        sqlSession = myUtilBaties.getSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    @Test
    public void testAddStudent() {
        Student student = new Student(null, "suhao", 25, "男", "徐州");
    /*  sqlSession.update("net.wanho.mapper.StudentMapper.addStudent",student);
      sqlSession.commit();
      sqlSession.close();*/

        SqlSession session = myUtilBaties.getSession();
        SqlSession session1 = myUtilBaties.getSession();
        System.out.println(session == session1);
        session.update("net.wanho.mapper.StudentMapper.addStudent", student);
        session.commit();
        myUtilBaties.closeSession();
    }

    @Test
    public void testSelectAllStudent() {
        SqlSession session = myUtilBaties.getSession();
        List<Student> students = session.selectList("net.wanho.mapper.StudentMapper.getAllStudents");
        System.out.println(students);
        myUtilBaties.closeSession();
    }


    @Test
    public void testSelectStudentById() {
   /* SqlSession session= myUtilBaties.getSession();
    Student student= session.selectOne("net.wanho.mapper.StudentMapper.selectStudentById",11411);
    System.out.println(student);
    myUtilBaties.closeSession();*/

        Student stu = studentMapper.selectStudentById(11411);
        System.out.println(stu);
        myUtilBaties.closeSession();
    }

    @Test
    public void testSelectStudentByName() {
   /* SqlSession session= myUtilBaties.getSession();
    Student student= session.selectOne("net.wanho.mapper.StudentMapper.selectStudentById",11411);
    System.out.println(student);
    myUtilBaties.closeSession();*/

        List<Student> student = studentMapper.selectStudentByName("su");
        System.out.println(student);
        myUtilBaties.closeSession();
    }

    @Test
    public void testAddStudentReturnKey() {
        Student student = new Student(null, "suhao", 25, "男", "徐州");
       /* studentMapper.addStudentReturnKey(student);*/
        studentMapper.addStudentReturnKey2(student);
        sqlSession.commit();
        System.out.println(student.getId());
        myUtilBaties.closeSession();

    }

    @Test
    public void testupdateStudentbById() {
        Student student = new Student(11420, "liurenjun", 25, "男", "盐城");
        studentMapper.updateStudentbById("liurenjun","盐城",11420);
        sqlSession.commit();
        myUtilBaties.closeSession();
    }
}