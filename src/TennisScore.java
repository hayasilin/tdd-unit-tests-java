import java.util.HashMap;

import static java.lang.Math.abs;

public class TennisScore {

    private final String playerOneName;
    private final String playerTwoName;
    private int playerOneScore;
    private HashMap<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};
    private int playerTwoScore;

    public TennisScore(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String score() {
        return isSamePoint() ?
                isDeuce() ? deuce() : sameScore() :
                isReadyForGamePoint() ? advState() : lookupScore();
    }

    private String sameScore() {
        return map.get(playerOneScore) + " All";
    }

    private String deuce() {
        return "Deuce";
    }

    private String advState() {
        return isAdv() ? String.format("%s Adv", advPlayer()) : String.format("%s Win", advPlayer());
    }

    private boolean isDeuce() {
        return playerOneScore >= 3;
    }

    private boolean isAdv() {
        return scoreDiff() == 1;
    }

    private boolean isReadyForGamePoint() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private String advPlayer() {
        return playerOneScore > playerTwoScore ? playerOneName : playerTwoName;
    }

    private String lookupScore() {
        return map.get(playerOneScore) + " " + map.get(playerTwoScore);
    }

    private boolean isSamePoint() {
        return playerOneScore == playerTwoScore;
    }

    private int scoreDiff() {
        return abs(playerOneScore - playerTwoScore);
    }

    public void playerOneScored() {
        playerOneScore++;
    }

    public void playerTwoScored() {
        playerTwoScore++;
    }
}
