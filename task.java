import java.util.*;

// Variables 
int num = 120;
String college = "aagac";
// 1.Local variable  
public class Main() {
    public static void main(String [] args) {
        String name = "Ayyanar";
    }
}
// 2.instance variable
class student() {
    String name1 = "Akash";
    int age =19;
}
// 3.static variable

class parent() {
    static String pname = "Muthu";
}

// Data types

// 1.premitive data type
byte a =10;
short b = 100;
int c = 200;
long d = 700000;
float e = 30.5;
double f = 200.6;
char g = "A";
boolean = true;
// 2.Non-premitive data type

String shop = "Computer Shop";
int[] Arrays = {1,2,3,4,5};
Class memo() {
    System.out.print("Class Data type");
}

// Operators

// Arithmetic operator
+,-,*,/,%
// Relational Operator
==,!=,>,<,>=,<=
// Logical OPerator
&&,||,!
// Assignment OPerator
+=,-=,*=
// Increment And Decremeant Operator
++,--

// Conditions

// if,if-else,else-if condition
int a = 50;

if(a>=90) {
    System.out.print("Grade A");
}
else if(a>=60) {
    System.out.print("Grade B");
}
else if(a<=35) {
    System.out.print("Grade C");
}
else {
    System.out.print("Fail");
}

// Switch

int num = 3;

switch(num) 
case 1 :
    System.out.print("one");
    break;
case 2 :
    Sysem.out.print("Two");
    break;
case 3 :
    System.out.print("Three");
    break;
case 4 :
    Sysem.out.print("Four");
    break;
default : 
System.out.print("Nothing");

// loops

// for loop
for(int i = 0 ; i<=5; i++) 
{
    System.out.print(i);
}

int i = 0;

// while loop
while(i<=5) {
    System.out.print(i);
    i++;
}

// do-while loop
int i = 0;
do 
{
    System.out.print("Hello !!");
    i++;
}
while(i<=5);

// Enhanced for loop
int[] marks = {10,20,30,40}

for(int mark : marks) 
{
    System.out.print(mark);
}

// Array

String[] names = {"Akash","Ranjith","Bharath","Parthi"};
int[] num2 = {10,20,30,40,50};

// String

String Name ="Akash";

// .length, toUpper,toLower,charAt,contain,substring
System.out.println(Name.length());
System.out.println(Name.toUpper());
System.out.println(Name.toLower());
System.out.println(Name.charAt(0));
System.out.println(Name.contain("Kumar"));
System.out.println(Name.substring(0,3));

// == vs equals()

String a = new String("Java Program");
String b = new String("Java Program");

System.out.print(a==b);
System.out.print(a.equals(b));

Methods , Parameters , Return , Method Overloading

class shop() {
    void work(String sname,int years) {
        String sname;
        int years;
        System.out.print("Shop Details");
        return {
            System.out.println("Shop Name :" + sname);
            System.out.println("Years of Experience :" + years);
        };
    }

   void work(String Address) 
    {
        String Address;
        return Address;
    }
}

// OOPS Conceps

// Classes,constructers,Abstract,interface and object

// Abstraction
abstract class Car() {
    String name;
    int model;
    car(String name,int model) {
        this.name = name ;
        this.model = model ;
    }

    abstract void purchase();
}

class customer extends car() {
    // override
    void purchase() {
        System.out.print("Select Car name and model :");
    }
}

interface Animal() {
    void sound();
}

class dog implements Animal() {
    void sound() {
        System.out.print(" Dog Barking");
    }
}

// Encapsulation

class Student() {
    private String name ;
    private int Age ;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

     public void setAge(int Age) {
        this.age = age;
    }
    public String getAge() {
        return age;
    }
}

// inheritance

class Car() {
    String name;
    int model;
    car(String name,int model) {
        this.name = name ;
        this.model = model ;
    }

    void purchase();
}

class customer extends car() {
    // override
    void purchase() {
        System.out.print("Select Car name and model :");
    }
}

//single ,multilevel,hyrarchical

// ploymorphism

// 1.compile-time -overloading
// 2.run-time - overriding

// exception Handling

try {
    int num = 10/0;
    System.out.print(num);
}
catch(Error e) {
    System.out.print(e);
    throw new error("Error :" + e);
}
finally {
    System.out.print("Program Suucessfull");
}

// throws

// packages
package day1-task;

// build-in

// java.lang,java.util,java.io,java.time,java.sql

// List

List<String> names = new ArrayList<>();

names.add("Akash");
names.add("Ranjith");
names.add("Bharath");
names.add("Parthi");

Sysem.out.print(names);

// Set

List<int> num = new Hashset<>();

names.add(10);
names.add(10);
names.add(20);
names.add(20);

Sysem.out.print(num);

// Map

Map<int , String> Students = new HashMap<>();

Students.put(101,"Akash");
Students.put(102,"Bharath");

// Queue

Queue<int> id = new LinkedList<>();

Students.offer(1);
Students.offer(2);
Students.offer(3);

// Generics

class box<T> {
    private T item;

    public void set(T item) {
        this.item = item ;
    }
    public void get() {
        return item;
    }
}

public class main() {
    public static void(String[] args) {
        box<String> box1 = new box<>();
        box1.set("Akash");
        String s =box1.get();

        box<int> box2 = new box<>();
        box2.set(10);
        int num =box2.get();
    }
}

// Lambda Expression

ADD c = (a,b) -> {
    int sum = a + b;
    return sum;
}

// Stream API

// filter
// map
// sorted
// forEach
// collect
// count
// reduce

