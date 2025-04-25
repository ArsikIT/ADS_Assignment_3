public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {   // simple hash function based on id
        return id % 11;       // this is a division by 11 for an even distribution across buckets
    }

    @Override
    public String toString() {
        return "ID: " + id;
    }
}


