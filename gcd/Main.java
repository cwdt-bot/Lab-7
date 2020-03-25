import java.util.stream.Stream;

class Main {
    public static int gcd2(int first, int second) {
        return Stream.iterate(new Helper(first, second), d -> d.smaller() != 0, d-> d.euclid()).map(d-> d.euclid()).
        reduce(new Helper(first, second), (m,n) -> n).larger();
     }

     public static int gcd(int first, int second) {
        return Stream.iterate(new Helper(first, second), d -> d.smaller() != 0, d-> d.euclid()).map(d-> d.euclid()).
        map(d -> d.larger()).reduce(0, (x,y)-> y);
     }
}