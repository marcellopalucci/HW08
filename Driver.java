public class Driver {
    public static void main(String[] args) {

        Person<String> person4 = new Person<>("Mittens", null);
        Person<String> person3 = new Person<>("Helmet", person4);
        Person<String> person2 = new Person<>("Paper", person3);
        Person<String> person1 = new Person<>("Car", person2);
        Person<String> person0 = new Person<>("Toy", person1);
        Person<String> indexPerson = new Person<>("Shoes(add to index 2", null);

        Line<Person> line = new Line<>();
        line.add(person0);
        line.add(person1);
        line.add(person2);
        line.add(person3);
        line.add(person4);
//        System.out.println(line.toString());

        System.out.println("Before");
        for (Person p : line) {
            System.out.println(p.getParcel());
        }
        System.out.println(line.getFirstPerson());
        line.remove(person2);
        System.out.println("After:");
        for (Person p : line) {
            System.out.println(p.getParcel());
        }

        System.out.println("Element at index 2:");
        System.out.println(line.get(2));
    }
}
