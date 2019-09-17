import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TennisTests {

    private final TennisScore sut = new TennisScore("Ace", "Ben");

    @Test
    public void loveAll() {
        resultShouldBe("Love All");
    }

    @Test
    public void fifteenAll() {
        givenPlayerOneScored(1);
        givenPlayerTwoScored(1);
        resultShouldBe("Fifteen All");
    }

    @Test
    public void fifteenLove() {
        givenPlayerOneScored(1);
        resultShouldBe("Fifteen Love");
    }

    @Test
    public void thirtyLove() {
        givenPlayerOneScored(2);
        resultShouldBe("Thirty Love");
    }

    @Test
    public void loveFifteen() {
        givenPlayerTwoScored(1);
        resultShouldBe("Love Fifteen");
    }

    @Test
    public void loveThirty() {
        givenPlayerTwoScored(2);
        resultShouldBe("Love Thirty");
    }

    @Test
    public void deuce() {
        givenDeuce();
        resultShouldBe("Deuce");
    }

    @Test
    public void playerOneAdv() {
        givenDeuce();
        givenPlayerOneScored(1);
        resultShouldBe("Ace Adv");
    }

    @Test
    public void playerTwoAdv() {
        givenDeuce();
        givenPlayerTwoScored(1);
        resultShouldBe("Ben Adv");
    }

    @Test
    public void playerOneWin_5_3() {
        givenPlayerOneScored(5);
        givenPlayerTwoScored(3);
        resultShouldBe("Ace Win");
    }

    @Test
    public void playerTwoWin_2_4() {
        givenPlayerOneScored(2);
        givenPlayerTwoScored(4);
        resultShouldBe("Ben Win");
    }

    private void givenDeuce() {
        givenPlayerOneScored(3);
        givenPlayerTwoScored(3);
    }

    private void givenPlayerTwoScored(int times) {
        for (int i = 0; i < times; i++) {
            sut.playerTwoScored();
        }
    }

    private void givenPlayerOneScored(int times) {
        for (int i = 0; i < times; i++) {
            sut.playerOneScored();
        }
    }

    private void resultShouldBe(String expected) {
        assertEquals(expected, sut.score());
    }


}