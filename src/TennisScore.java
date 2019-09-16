import java.util.HashMap;

public class TennisScore {

    private int playerOneScore;
    private HashMap<Integer, String> map = new HashMap<Integer, String>() {{
       put(0, "Love");
       put(1, "Fifteen");
       put(2, "Thirty");
       put(3, "Forty");
    }};
    private int playerTwoScre;

    public String score() {
        if (playerOneScore == playerTwoScre) {
            return map.get(playerTwoScre) + " All";
        }

        if (playerOneScore > 0) {
            return map.get(playerOneScore) + " Love";
        }

        return "";
    }

    public void playerOneScored() {
        playerOneScore++;
    }

    public void playerTwoScored() {
        playerTwoScre++;
    }
}
