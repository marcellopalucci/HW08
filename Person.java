public class Person<T>{
    private T parcel;
    private Person nextPerson;
    public Person(T parcel, Person nextPerson) throws IllegalArgumentException {
        if (parcel == null) {
            throw new IllegalArgumentException("Parcel is set to null and shouldn't be.");
        }
        this.parcel = parcel;
        this.nextPerson = nextPerson;
    }
    public Person(T parcel) {
        this(parcel, null);
    }
    public T getParcel() {
        return parcel;
    }
    public void setParcel(T parcel) {
        this.parcel = parcel;
    }

    public Person getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }
}
