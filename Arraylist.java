import java.util.ArrayList;
public class Arraylist
{
	public static void main(String[] args) {
		
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(3);
		nums.add(5);
		
		System.out.println(nums.get(0));
		
		ArrayList<Person> person = new ArrayList<Person>();
		person.add(new Person("Evan", 19));
		person.add(new Person("Gab", 20));
		
		for(Person p : person){
		    p.print();
		}
	}
}
class Person{
    String name;
    int age;
    
    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void print(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
