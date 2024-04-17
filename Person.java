/**
 * Generic class representing a person in line. Holds a generic parcel and the
 * next person in line.
 * @param <T> representing the element of generic type T
 * @author mpalucci3
 * @version 1.2
 */
public class Person<T> {
    private T parcel;
    private Person<T> nextPerson;

    /**
     * Constructor taking in a parcel and the next person in line.
     * @param parcel T representing the parcel in line
     * @param nextPerson Person holding a reference to the next person line
     * @throws IllegalArgumentException exception thrown if the parcel passed in is null
     */
    public Person(T parcel, Person<T> nextPerson) throws IllegalArgumentException {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel is set to null and shouldn't be.");
        }
        this.parcel = parcel;
        this.nextPerson = nextPerson;
    }

    /**
     * Constructor taking in a parcel and setting the next person to null.
     * @param parcel T representing the parcel in line
     */
    public Person(T parcel) {
        this(parcel, null);
    }

    /**
     * Getter method returning the parcel element.
     * @return T representing the parcel in line
     */
    public T getParcel() {
        return parcel;
    }

    /**
     * Setter method, setting the parcel.
     * @param parcel T representing the parcel in line
     */
    public void setParcel(T parcel) {
        this.parcel = parcel;
    }

    /**
     * Getter method, returning the next person in line.
     * @return Person holding a reference to the next person line
     */
    public Person<T> getNextPerson() {
        return nextPerson;
    }

    /**
     * Setter method, setting the next person in line.
     * @param nextPerson Person holding a reference to the next person line
     */
    public void setNextPerson(Person<T> nextPerson) {
        this.nextPerson = nextPerson;
    }
}
