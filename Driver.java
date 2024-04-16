import java.sql.SQLOutput;

public class Driver {
    public static void main(String[] args) {

        Line<String> line = new Line<>();
        System.out.println("Initial add:");
        line.add("Mittens");
        line.add("Paper");
        line.add("Toy");
        line.add("Socks");
        line.add("Bed sheets");
        line.add("Bing bong");
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

        System.out.println("Get index 0:");
        System.out.println(line.get(0));

        System.out.println("Contains Toy");
        System.out.println(line.contains("T-shirt"));

//        System.out.println("Clear");
//        line.clear();
//        System.out.println(line.toString());

//        add(T element) element is null
//        line.add(null);

//        add(int index, T element) - invalid index
//        line.add(100, "Pitbull");

//        add(int index, T element) element is null
//        line.add(2, null);

//        Remove first element of and empty line
//        line.clear();
//        line.remove();

//        remove invalid index
//        line.remove(-1);
//        line.remove(50);

//        remove with size zero
//        line.clear();
//        line.remove(3);

//        remove null element
//        line.remove(null);

//        remove parcel not in the line
//        line.remove("I DONT EXIST");

//        set invalid index
//        line.set(100, "Invalid Index Parcel");

//        set null element but valid index
//        line.set(2, null);

//        set null element and invalid index
//        line.set(100, null);

//        get invalid index
//        line.get(100);

//        contains passing null value
//        line.contains(null);








    }

}
