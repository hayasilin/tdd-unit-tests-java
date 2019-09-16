import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TennisTests {

    private final TennisScore sut = new TennisScore();
    
    @Test
    public void Love_All() {
        resultsShouldBe("Love All");
    }

    @Test
    public void fifteen_Love() {
        sut.playerOneScored();
        resultsShouldBe("Fifteen Love");
    }

    private void resultsShouldBe(String expected) {
        assertEquals(expected, sut.score());
    }
}
