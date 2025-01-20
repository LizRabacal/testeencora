import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        Set<int[]> combinations = InfiniteCoins.makeChange(12);
        InfiniteCoins.printCombinations(combinations);

    }
}
