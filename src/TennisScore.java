import java.util.HashMap;

import static java.lang.Math.abs;

public class TennisScore {

    private final String playerOneName;
    private final String playerTwoName;

    private int playerOneScore;
    private int playerTwoScore;

    private HashMap<Integer, String> map = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forth");
    }};

    public String score() {
        if (isSameScore()) {
            if (isDeuce()) {
                return deuceState();
            }
            return sameScoreState();
        }

        if (isReadyForGamePoint()) {
            if (isAdv()) {
                return advPlayer() + " Adv";
            } else {
                return winPlayer();
            }
        }
        return lookupScore();
    }

    private String sameScoreState() {
        return map.get(playerOneScore) + " All";
    }

    private String deuceState() {
        return "Deuce";
    }

    private String winPlayer() {
        return playerOneScore > playerTwoScore ? playerOneName + " Win" : playerTwoName + " Win";
    }

    private String advPlayer() {
        return playerOneScore > playerTwoScore ? playerOneName: playerTwoName;
    }

    private String lookupScore() {
        return map.get(playerOneScore) + " " + map.get(playerTwoScore);
    }

    private boolean isReadyForGamePoint() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }

    private boolean isAdv() {
        return scoreDiff() == 1;
    }

    private int scoreDiff() {
        return abs(playerOneScore - playerTwoScore);
    }

    private boolean isSameScore() {
        return playerOneScore == playerTwoScore;
    }

    private boolean isDeuce() {
        return playerOneScore >= 3 && playerTwoScore >= 3;
    }

    public TennisScore(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void playerOneScored() {
        playerOneScore++;
    }

    public void playerTwoScored() {
        playerTwoScore++;
    }
}