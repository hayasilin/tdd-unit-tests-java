import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TennisTests {

    Tennis tennis = new Tennis("Ace", "Ben");

    @Test
    public void loveAll() {
        scoreShouldBe("Love All");
    }

    @Test
    public void fifteenLove() {
        givenFirstPlayerScore(1);
        scoreShouldBe("Fifteen Love");
    }

    @Test
    public void thirtyLove() {
        givenFirstPlayerScore(2);
        scoreShouldBe("Thirty Love");
    }

    @Test
    public void fortyLove() {
        givenFirstPlayerScore(3);
        scoreShouldBe("Forty Love");
    }

    @Test
    public void loveFifteen() {
        givenSecondPlayerScore(1);
        scoreShouldBe("Love Fifteen");
    }

    @Test
    public void loveThirty() {
        givenSecondPlayerScore(2);
        scoreShouldBe("Love Thirty");
    }

    @Test
    public void loveForty() {
        givenSecondPlayerScore(3);
        scoreShouldBe("Love Forty");
    }

    @Test
    public void deuce() {
        givenDeuce();
        scoreShouldBe("Deuce");
    }

    private void givenDeuce() {
        givenFirstPlayerScore(3);
        givenSecondPlayerScore(3);
    }

    @Test
    public void firstPlayerAdv() {
        givenDeuce();
        givenFirstPlayerScore(1);
        scoreShouldBe("Ace Adv");
    }

    @Test
    public void secondPlayerAdv() {
        givenDeuce();
        givenSecondPlayerScore(1);
        scoreShouldBe("Ben Adv");
    }

    @Test
    public void firstPlayerWin() {
        givenDeuce();
        givenFirstPlayerScore(2);
        scoreShouldBe("Ace Win");
    }

    @Test
    public void secondPlayerWin() {
        givenFirstPlayerScore(1);
        givenSecondPlayerScore(4);
        scoreShouldBe("Ben Win");
    }

    private void givenSecondPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennis.secondPlayerScore++;
        }
    }

    private void givenFirstPlayerScore(int times) {
        for (int i = 0; i < times; i++) {
            tennis.firstPlayerScore++;
        }
    }

    private void scoreShouldBe(String expecte) {
        assertEquals(expecte, tennis.score());
    }
}