package dao.impl;

import dao.IStudentDAO;
import domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements IStudentDAO {
    public static Connection connection = null ;

    public void setConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("连接成功");
        }catch (Exception e){
            System.out.println("连接失败");
        }
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/JavaJDBC","root","root");
        }catch (Exception e){
        }
    }

    public void shutdownConnection(){
        try {
            if(connection!=null){
                connection.close();
            }
        }catch (Exception e){
        }
    }
    @Override
    public void save(Student student) {
        setConnection();
        Statement statement = null ;
        try {
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "INSERT INTO t_student(id,name,age) VALUES(" + student.getId()+",'"+student.getName()+"',"+student.getAge()+")";
            statement.executeUpdate(sql);
        }catch (Exception e){
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }
        }
        shutdownConnection();
    }

    @Override
    public void delete(Student student) {
        Long id = student.getId() ;
        delete(id);
    }

    @Override
    public void delete(Long id) {
        setConnection();
        Statement statement = null ;
        try {
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "DELETE FROM t_student WHERE id="+id;
            statement.executeUpdate(sql);
        }catch (Exception e){
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }
        }
        shutdownConnection();
    }

    @Override
    public void update(Long id, Student student) {
        setConnection();
        Statement statement = null ;
        try {
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "UPDATE t_student SET name='"+ student.getName() +"',age="+student.getAge() +" WHERE id="+id;
            statement.executeUpdate(sql);
        }catch (Exception e){
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }
        }

        shutdownConnection();
    }

    @Override
    public void update(Student student) {
        Long id = student.getId() ;
        update(id,student);
    }

    @Override
    public Student get(Long id) {
        setConnection();
        Statement statement = null ;
        ResultSet resultSet = null ;
        Student student = null ;
        try {
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "SELECT * FROM t_student where id="+id ;
            resultSet = statement.executeQuery(sql);
            if(resultSet.next()){
                student = new Student() ;
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getLong("age"));
                return student ;
            }
        }catch (Exception e){
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }finally {
                try{
                    if(resultSet!=null){
                        resultSet.close();
                    }
                }catch (Exception e){
                }
            }
        }
        shutdownConnection();
        return null;
    }

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> list  = new ArrayList<Student>() ;
        setConnection();
        Statement statement = null ;
        ResultSet resultSet = null ;
        Student student = null ;
        try {
            statement = connection.createStatement();
            // sql语句:查询对应id
            String sql = "SELECT * FROM t_student" ;
            resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                student = new Student() ;
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setAge(resultSet.getLong("age"));
                list.add(student) ;
            }
            return list ;
        }catch (Exception e){
        }finally {
            try{
                if (statement!=null){
                    statement.close();
                }
            }catch (Exception e){
            }finally {
                try{
                    if(resultSet!=null){
                        resultSet.close();
                    }
                }catch (Exception e){
                }
            }
        }
        shutdownConnection();
        return list;
    }

}
