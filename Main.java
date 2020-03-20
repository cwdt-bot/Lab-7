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

   public static int[] euclid(int first, int second) {
       int currMax = Math.max(first, second);
       int currMin = Math.min(first, second);
       return new int[]{currMin, currMax%currMin};

   }

   public static int gcd(int first, int second) {
       int[] initial = euclid(first, second);
       return Stream.iterate(initial, d -> d[1] != 0, d-> euclid(d[0],d[1])).
        map(d-> euclid(d[0],d[1])).
            reduce(new int[]{1}, (m,n) -> n)[0];
    }

    public static long countRepeats(int...array) {
        long count = IntStream.range(1, array.length-1).filter(d -> array[d] != array[d-1] && array[d] == array[d+1]).count();
        if (array[0] == array[1]) {
            count ++;
        }
        return count;
    }

    public static double normalizedMean(Stream<Integer> in) {
        wasteTime why = new wasteTime();
        in.map(d-> d+0.0).forEach(d->why.update(d));
        return why.soMean();
    }

}

