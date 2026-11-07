public class Student {

    int id;
    String name;
    int age;
    String department;

    Student(int id, String name, int age, String department) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    void display() {

        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Department: " + department);

        System.out.println("-------------------");
    }
}