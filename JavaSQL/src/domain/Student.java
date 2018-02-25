package domain;

public class Student {
    private long id ;
    private String name ;
    private long age ;
    public void getString(){
        System.out.println("Student(id="+id+",name="+name+",age="+age+")");
    }
    public void setId(long id){
        this.id = id ;
    }
    public void setName(String name){
        this.name = name ;
    }
    public void setAge(long age){
        this.age = age ;
    }

    public long getId() {
        return id;
    }

    public long getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
