import java.util.*;
import java.util.stream.IntStream;

public class Test implements Comparable<Test>{

    private String name;

    public Test(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(name, test.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Test o) {
        return this.name.compareTo(o.name);
    }

    public static void main(String []args) {

        Test t1 = new Test("abc");
        Test t2 = new Test("xyz");
        Test t3 = new Test("def");
        List<Test> testList = new ArrayList<>();
        testList.add(t1);
        testList.add(t2);
        testList.add(t3);

        Set<Test> testSet = new TreeSet<>(testList);
        System.out.println(testSet.size());
        testSet.forEach(test -> System.out.println(test.name));


        Map<String, String> testMap = new LinkedHashMap<>();
        testMap.put("aaa", "111");
        testMap.put("bbb", "222");
        testMap.put("ccc", "333");
        testMap.put("ddd", "444");
        testMap.put("eee", "555");
        testMap.put("fff", "666");
        testMap.put("ggg", "777");
        testMap.put("hhh", "888");


        testMap.forEach((s, s2) -> System.out.println(String.join(":", s, s2)));

    }

}

class RentalGeneric<X> {  // "T" is for the type
    // parameter
    private List<X> rentalPool;   // Use the class type for the
    // List type
    private int maxNum;
    public RentalGeneric(
            int maxNum, List<X> rentalPool) { // constructor takes a
        // List of the class type
        this.maxNum = maxNum;
        this.rentalPool = rentalPool;
    }

    public X getRental() {                    // we rent out a T
        // blocks until there's something available
        return rentalPool.get(0);
    }
    public void returnRental(X returnedThing) { // and the renter
        // returns a T
        rentalPool.add(returnedThing);
    }
}

