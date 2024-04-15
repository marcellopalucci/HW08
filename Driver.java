public class Driver {
    public static void main(String[] args) {

        Person<String> person4 = new Person<>("Mittens", null);
        Person<String> person3 = new Person<>("What?", person4);
        Person<String> person2 = new Person<>("Paper", person3);
        Person<String> person1 = new Person<>("Car", person2);
        Person<String> person0 = new Person<>("Toy", person1);
        Person<String> indexPerson = new Person<>("Shoes", null);

        Line<Person> line = new Line<>();
        line.add(person0);
        line.add(person1);
        line.add(person2);
        line.add(person3);
        line.add(person4);
//        System.out.println(line.toString());
        line.add(2, indexPerson);
//        System.out.println(line.toString());
    }
}
