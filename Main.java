import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;


class Main {

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        return IntStream.range(2, n).noneMatch(x -> n % x == 0);
    }

   public static int[] twinPrimes(int input) {
       List<Integer> result = new ArrayList<>();
       IntStream.rangeClosed(2,input).filter(d -> isPrime(d) && (isPrime(d+2) || isPrime(d-2)) ).forEach(d -> result.add(d));
       int[] end = new int[result.size()];
       IntStream.range(0, result.size()).forEach(d -> end[d] = result.get(d));
       return end;
   }


   public static int gcd(int first, int second) {
       Helper initial = new Helper(first, second);
       return Stream.iterate(initial, d -> d.smaller() != 0, d-> d.euclid()).
        map(d-> d.euclid()).
            reduce(initial, (m,n) -> n).larger();
    }

    public static long countRepeats(int...array) {
        long count = IntStream.range(1, array.length-1).filter(d -> array[d] != array[d-1] && array[d] == array[d+1]).count();
        if (array[0] == array[1]) {
            count ++;
        }
        return count;
    }

    /**public static double normalizedMean(Stream<Integer> in) {
        wasteTime ded = new wasteTime();
        try {
            return in.map(d-> d+0.0).map(d -> new wasteTime(d)).reduce(ded, (x,y)-> x.update(y)).soMean();
        } catch (IndexOutOfBoundsException e) {
            return 0;
        }   
    }**/

}

