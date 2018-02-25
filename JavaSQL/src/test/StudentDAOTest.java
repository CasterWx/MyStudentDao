package test;

import dao.IStudentDAO;
import dao.impl.StudentDAOImpl;
import domain.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDAOTest {
    IStudentDAO iStudentDAO = new StudentDAOImpl();
    @Test
    public void testSave() {
        Student student = new Student() ;
        student.setId(164L);
        student.setName("Wber");
        student.setAge(100L);
        iStudentDAO.save(student);
    }
    @Test
    public void testDelete() {
        iStudentDAO.delete(161L);
    }
    @Test
    public void testUpdate() {
        Student student = new Student() ;
        student.setId(161L);
        student.setName("wa");
        student.setAge(15L);
        iStudentDAO.update(161L,student);
    }
    @Test
    public void testGet() {
        iStudentDAO.get(162L).getString();
    }
    @Test
    public void testList() {
        ArrayList<Student> list = iStudentDAO.list() ;
        for(int i=0;i<list.size();i++){
            list.get(i).getString();
        }
    }
}
