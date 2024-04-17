import java.util.NoSuchElementException;

/**
 * This class serves as a driver class to test the code for HW08.
 * @author Gyumin Lee
 * @version 1.0
 */
public class DemoDriver {
    private static final String DIVIDER = "\n==============================\n";

    /**
     * Driver method.
     * @param args String arguments passed to console.
     */
    public static void main(String[] args) {
        System.out.println(DIVIDER);

        // Create an array of type String
        String[] initialArray = {
                "Parcel 1",
                "Parcel 2",
                "Parcel 3",
                "Parcel 4"
        };
        String[] arrayWithNull = {
                "Parcel 5",
                null,
                "Parcel 7",
                "Parcel 8"
        };

        // Constructor tests
        System.out.printf("==========%s==========\n", "Constructor tests");
        Line<String> line1 = new Line<>(initialArray);
        try {
            Line<String> line2 = new Line<>(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }
        try {
            Line<String> line3 = new Line<>(arrayWithNull);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }
        Line<String> emptyLine = new Line<>();

        // Line Iterable tests
        System.out.printf("==========%s==========\n", "For-each loop test");
        for (String s: line1) {
            System.out.println(s);
        }

        System.out.println(DIVIDER);

        // Line instance method tests

        System.out.printf("==========%s==========\n", "toString(), isEmpty(), size(), getFirstPerson(), toArray() tests");
        // 1. toString()
        //     -> this also tests for isEmpty(), size(), getFirstPerson(), toArray()
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 4
        firstPerson: Parcel 1
        : [Parcel 1, Parcel 2, Parcel 3, Parcel 4]
        ============================
         */

        System.out.println(emptyLine);
        /*    Expected output:
        ===== LINE 796533847 =====
        isEmpty: true
        size: 0
        firstPerson: null
        : []
        ============================
         */

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "add(E element) tests");
        // 2. add(E element)
        line1.add("Parcel 6");
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 5
        firstPerson: Parcel 1
        : [Parcel 1, Parcel 2, Parcel 3, Parcel 4, Parcel 6]
        ============================
         */
        try {
            line1.add(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "add(int index, E element) tests");
        // 3. add(int index, E element)
        line1.add(4, "Parcel 5");
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 6
        firstPerson: Parcel 1
        : [Parcel 1, Parcel 2, Parcel 3, Parcel 4, Parcel 5, Parcel 6]
        ============================
         */

        line1.add(0, "Parcel 0");
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 7
        firstPerson: Parcel 0
        : [Parcel 0, Parcel 1, Parcel 2, Parcel 3, Parcel 4, Parcel 5, Parcel 6]
        ============================
         */

        try {
            line1.add(7, "Parcel 7");
            System.out.println(line1);
            /*    Expected output:
            ===== LINE 249515771 =====
            isEmpty: false
            size: 8
            firstPerson: Parcel 0
            : [Parcel 0, Parcel 1, Parcel 2, Parcel 3, Parcel 4, Parcel 5, Parcel 6, Parcel 7]
            ============================
             */
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            line1.add(-1, "Parcel -1");
            System.out.println(line1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            line1.add(null);
            System.out.println(line1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "remove() tests");
        // 4. remove()
        System.out.println(line1.remove()); // Expected output: "Parcel 0"
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 249515771 =====
        isEmpty: false
        size: 7
        firstPerson: Parcel 1
        : [Parcel 1, Parcel 2, Parcel 3, Parcel 4, Parcel 5, Parcel 6, Parcel 7]
        ============================
         */

        try {
            System.out.println(emptyLine.remove());
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "remove(int index) tests");
        // 5. remove(int index)
        System.out.println(line1.remove(2)); // Expected output: "Parcel 3"
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 249515771 =====
        isEmpty: false
        size: 6
        firstPerson: Parcel 1
        : [Parcel 1, Parcel 2, Parcel 4, Parcel 5, Parcel 6, Parcel 7]
        ============================
         */

        System.out.println(line1.remove(0)); // Expected output: "Parcel 1"
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 249515771 =====
        isEmpty: false
        size: 5
        firstPerson: Parcel 2
        : [Parcel 2, Parcel 4, Parcel 5, Parcel 6, Parcel 7]
        ============================
         */

        try {
            System.out.println(line1.remove(-1));
            System.out.println(line1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(line1.remove(4));
            System.out.println(line1);
            /*    Expected output:
            ===== LINE 249515771 =====
            isEmpty: false
            size: 4
            firstPerson: Parcel 2
            : [Parcel 2, Parcel 4, Parcel 5, Parcel 6]
            ============================
             */
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(emptyLine.remove(0));
            System.out.println(emptyLine);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage()); // Expected output
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "remove(E element) tests");
        // 6. remove(E element)
        System.out.println(line1.remove("Parcel 5"));
        // Expected output: "Parcel 5"
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 3
        firstPerson: Parcel 2
        : [Parcel 2, Parcel 4, Parcel 6]
        ============================
         */

        System.out.println(line1.remove("Parcel 2"));
        // Expected output: "Parcel 2"
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 2
        firstPerson: Parcel 4
        : [Parcel 4, Parcel 6]
        ============================
         */

        try {
            System.out.println(line1.remove("Parcel -1"));
            System.out.println(line1);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(line1.remove(null));
            System.out.println(line1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(emptyLine.remove("Parcel 0"));
            System.out.println(emptyLine);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(emptyLine.remove(null));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "set(int index, E element) tests");
        // 7. set(int index, E element)
        System.out.println(line1.set(1, "Parcel 2"));
        // Expected output: "Parcel 6"
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 2
        firstPerson: Parcel 4
        : [Parcel 4, Parcel 2]
        ============================
         */

        System.out.println(line1.set(0, "Parcel 1"));
        // Expected output: "Parcel 4"
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: false
        size: 2
        firstPerson: Parcel 1
        : [Parcel 1, Parcel 2]
        ============================
         */

        try {
            System.out.println(line1.set(-1, "Parcel -1"));
            System.out.println(line1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(line1.set(2, "Parcel 2"));
            System.out.println(line1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(line1.set(0, null));
            System.out.println(line1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(emptyLine.set(0, "Parcel 1"));
            System.out.println(emptyLine);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(emptyLine.set(0, null));
            System.out.println(emptyLine);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "get(int index) tests");
        // 8. get(int index)
        System.out.println(line1.get(0)); // Expected output: "Parcel 1"
        System.out.println(line1.get(1)); // Expected output: "Parcel 2"

        try {
            System.out.println(line1.get(-1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(line1.get(2));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            System.out.println(emptyLine.get(0));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "contains(E element) tests");
        // 9. contains(E element)
        line1.add(1, "Parcel 1");
        line1.add("Parcel 3");
        line1.add("Parcel 5");

        System.out.printf("Line contains Parcel 3: %b\n",
                line1.contains("Parcel 3")); // -> true
        System.out.printf("Line contains Parcel 1: %b\n",
                line1.contains("Parcel 1")); // -> true
        System.out.printf("Line contains Parcel 4: %b\n",
                line1.contains("Parcel 4")); // -> false

        try {
            System.out.printf("Line contains null: %b\n",
                    line1.contains(null));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        System.out.println(DIVIDER);

        System.out.printf("==========%s==========\n", "clear() test");
        // 10. clear()
        System.out.println(line1);
        System.out.println("Clearing all elements...");
        line1.clear();
        System.out.println(line1);
        /*    Expected output:
        ===== LINE 1435804085 =====
        isEmpty: true
        size: 0
        firstPerson: null
        : []
        ============================
         */

        System.out.println(DIVIDER);

        // Person instance method tests

        System.out.printf("==========%s==========\n", "Person class constructor tests");

        // 1. Constructors
        Person<String> person1 = new Person<>("Parcel 1");
        Person<String> person2 = new Person<>("Parcel 2", person1);

        try {
            Person<String> person3 = new Person<>(null, person1);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        try {
            Person<String> person4 = new Person<>(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // Expected output
        }

        System.out.println(DIVIDER);

        System.out.println("Disclaimer: these tests are not exhaustive; there may be edge cases not considered within these tests.");
    }
}