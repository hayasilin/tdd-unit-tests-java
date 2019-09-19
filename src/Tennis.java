import java.util.HashMap;

import static java.lang.Math.abs;

public class Tennis {

    private final String secondPlayerName;
    private final String firstPlayerName;
    public int firstPlayerScore;
    public int secondPlayerScore;

    HashMap<Integer, String> scoreLookup = new HashMap<Integer, String>() {{
        put(0, "Love");
        put(1, "Fifteen");
        put(2, "Thirty");
        put(3, "Forty");
    }};

    public Tennis(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public String score() {
        if (scoreDiff()) {
            if (isGamePointReady()) {
                if (isAdv()) {
                    return advState();
                } else {
                    return winState();
                }
            }
            return lookupScore();
        }
        if (isDeuce()) {
            return Deuce();
        }
        return sameScore();
    }

    private String winState() {
        return advPlayer() + " Win";
    }

    private String advState() {
        return advPlayer() + " Adv";
    }

    private boolean isAdv() {
        return abs(firstPlayerScore - secondPlayerScore) == 1;
    }

    private boolean isGamePointReady() {
        return firstPlayerScore > 3 || secondPlayerScore > 3;
    }

    private String advPlayer() {
        return firstPlayerScore > secondPlayerScore ? firstPlayerName : secondPlayerName;
    }

    private String Deuce() {
        return "Deuce";
    }

    private boolean isDeuce() {
        return firstPlayerScore >= 3 && secondPlayerScore >=3;
    }

    private String lookupScore() {
        return scoreLookup.get(firstPlayerScore) + " " + scoreLookup.get(secondPlayerScore);
    }

    private String sameScore() {
        return scoreLookup.get(firstPlayerScore) + " All";
    }

    private boolean scoreDiff() {
        return firstPlayerScore != secondPlayerScore;
    }
}