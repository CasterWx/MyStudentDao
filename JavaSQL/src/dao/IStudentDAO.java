package dao;

import domain.Student;

import java.util.ArrayList;
import java.util.List;

/**
 *  Student对象的CRUD操作
 * */
public interface IStudentDAO {
    // ----------------------------------增--------------------------------------------

    /**
     * 保存学生对象
     * @param student
     * */
    void save(Student student);

    // ----------------------------------删--------------------------------------------

    /**
     *  根据删除指定学生
     *  @param student 学生对象
     * */

    void delete(Student student) ;
    /**
     *  根据主键删除指定学生
     *  @param id    学生对象主键
     * */
    void delete(Long id) ;

    // ----------------------------------改--------------------------------------------
    /**
     *  更新指定学生信息
     *  @param id  学生对象主键
     *  @param student  学生对象
     * */
    void update(Long id,Student student) ;
    /**
     *  根据主键删除指定学生
     *  @param student 学生对象
     * */
    void update(Student student);

    // ----------------------------------查--------------------------------------------

    /**
     *  查询指定id的学生对象
     *  @param id  学生对象主键
     *  @return Student if id存在,返回Student对象,否则返回null
     */
    Student get(Long id) ;
    /**
     *  查询所有学生对象
     *  @return 所有学生对象
     * */
    ArrayList<Student> list() ;
}
