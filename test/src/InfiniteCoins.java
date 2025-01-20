import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class InfiniteCoins {
    public static Set<int[]> makeChange(int coins) {
        Set<int[]> result = new HashSet<>();
        getCombinations(coins, 0, 0, 0, coins, result);
        return result;
    }

    private static void getCombinations(int remaining, int quarters, int dimes, int nickels, int pennies,
            Set<int[]> result) {
        if (remaining == 0) {
            result.add(new int[] { quarters, dimes, nickels, pennies });
            return;
        }

        if (remaining >= 25)
            getCombinations(remaining - 25, quarters + 1, dimes, nickels, pennies, result);
        if (remaining >= 10)
            getCombinations(remaining - 10, quarters, dimes + 1, nickels, pennies, result);
        if (remaining >= 5)
            getCombinations(remaining - 5, quarters, dimes, nickels + 1, pennies, result);

        getCombinations(0, quarters, dimes, nickels, remaining, result);
    }

    public static void printCombinations(Set<int[]> combinations) {
        Iterator<int[]> iterator = combinations.iterator();
        System.out.print("["); 

        while (iterator.hasNext()) {
            int[] combo = iterator.next();
            System.out.print("[" + combo[0] + ", " + combo[1] + ", " + combo[2] + ", " + combo[3] + "]");

            if (iterator.hasNext()) { 
                System.out.print(", ");
            }
        }
        System.out.print("]"); 
    }
}
