import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TennisTests {

    private final TennisScore sut = new TennisScore("Ace", "Ron");

    @Test
    public void Love_All() {
        resultsShouldBe("Love All");
    }

    @Test
    public void fifteen_Love() {
        givenPlayerOneScored(1);
        resultsShouldBe("Fifteen Love");
    }

    @Test
    public void thirty_Love() {
        givenPlayerOneScored(2);
        resultShouldBe("Thirty Love");
    }

    @Test
    public void fourty_Love() {
        givenPlayerOneScored(3);
        resultShouldBe("Forty Love");
    }

    @Test
    public void love_Fifteen() {
        givenPlayerTwoScored(1);
        resultShouldBe("Love Fifteen");
    }

    @Test
    public void love_Thirty() {
        givenPlayerTwoScored(2);
        resultShouldBe("Love Thirty");
    }

    @Test
    public void fifteenAll() {
        givenPlayerOneScored(1);
        givenPlayerTwoScored(1);
        resultShouldBe("Fifteen All");
    }

    @Test
    public void deuce_3_3() {
        givenDeuce();
        resultShouldBe("Deuce");
    }

    @Test
    public void deuce_4_4() {
        givenDeuce();
        givenPlayerOneScored(1);
        givenPlayerTwoScored(1);
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
        resultsShouldBe("Ron Adv");
    }

    @Test
    public void score_is_5_3() {
        givenDeuce();
        givenPlayerOneScored(2);
        resultsShouldBe("Ace Win");
    }

    @Test
    public void score_is_2_4() {
        givenPlayerOneScored(2);
        givenPlayerTwoScored(4);
        resultsShouldBe("Ron Win");
    }

    @Test
    public void Deuce_3_3() {
        sut.playerOneScored();
        sut.playerOneScored();
        sut.playerOneScored();

        sut.playerTwoScored();
        sut.playerTwoScored();
        sut.playerTwoScored();

        resultsShouldBe("Deuce");

    }

    private void resultsShouldBe(String expected) {
        assertEquals(expected, sut.score());
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

    private void resultShouldBe(String expected) {
        assertEquals(expected, sut.score());
    }

    private void givenPlayerOneScored(int times) {
        for (int i = 0; i < times; i++) {
            sut.playerOneScored();
        }
    }
}