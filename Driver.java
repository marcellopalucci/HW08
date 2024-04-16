import java.sql.SQLOutput;

public class Driver {
    public static void main(String[] args) {

//        Person<String> person4 = new Person<>("Mittens");
//        Person<String> person3 = new Person<>("Helmet");
//        Person<String> person2 = new Person<>("Paper");
//        Person<String> person1 = new Person<>("Car");
//        Person<String> person0 = new Person<>("Toy");
//        Person<String> indexPerson = new Person<>("Shoes(add to index 2", null);

        Line<String> line = new Line<>();
        System.out.println("Initial add:");
        line.add("Mittens");
        line.add("Paper");
        line.add("Toy");
        line.add("Socks");
        line.add("Bed sheets");
        System.out.println(line.toString());

        System.out.println("Add @ index: 2");
        line.add(2, "Helmet");
        System.out.println(line.toString());

        System.out.println("Remove parcel: Mittens");
        line.remove("Mittens");
        System.out.println(line.toString());

        System.out.println("Remove index: 1");
        line.remove(1);
        System.out.println(line.toString());

        System.out.println("remove(): removes head:");
        line.remove();
        System.out.println(line.toString());

        System.out.println("Set @ index 2:");
        line.set(2, "T-Shirt");
        System.out.println(line.toString());

        System.out.println("Get index 1:");
        System.out.println(line.get(1));

        System.out.println("Contains Toy");
        System.out.println(line.contains("T-shirt"));



        System.out.println("Clear");
        line.clear();
        System.out.println(line.toString());


    }
}
