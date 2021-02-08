package dbo;

public class Student {
    private Integer id; // 主键
    private String name;
    private Byte age;
    private Integer udpated_at;
    private Integer created_at;

    public Student() {
    }

    public Student(String name, Byte age, Integer udpated_at, Integer created_at) {
        this.name = name;
        this.age = age;
        this.udpated_at = udpated_at;
        this.created_at = created_at;
    }

    public Student(Integer id, String name, Byte age, Integer udpated_at) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.udpated_at = udpated_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Integer getUdpated_at() {
        return udpated_at;
    }

    public void setUdpated_at(Integer udpated_at) {
        this.udpated_at = udpated_at;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", udpated_at=" + udpated_at +
                ", created_at=" + created_at +
                '}';
    }
}
