import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution_Word_Ladder_I sl = new Solution_Word_Ladder_I();
        int shortest = sl.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println("shortest = " + shortest);

        /*Solution_Word_Ladder_I sl = new Solution_Word_Ladder_I();
        int shortest = sl.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log"));
        System.out.println("shortest = " + shortest);*/

    }
}