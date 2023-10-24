import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class XandOTest {
    private XandO game;

    @Before
    public void setUp() {
        game = new XandO();
    }

    @Test
    public void testCheckWinHorizontal() {
        game.play(0, 0);
        game.play(1, 1);
        game.play(0, 1);
        game.play(1, 2);
        game.play(0, 2);
        assertEquals('X', game.checkWin());
    }

    @Test
    public void testCheckWinVertical() {
        game.play(0, 0);
        game.play(1, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(2, 2);
        game.play(1, 2);
        assertEquals('O', game.checkWin());
    }

    @Test
    public void testCheckWinDiagonal() {
        game.play(0, 0);
        game.play(0, 1);
        game.play(1, 1);
        game.play(0, 2);
        game.play(2, 2);
        assertEquals('X', game.checkWin());
    }

    @Test
    public void testDraw() {
        game.play(0, 0);
        game.play(0, 1);
        game.play(0, 2);
        game.play(1, 0);
        game.play(1, 1);
        game.play(2, 0);
        game.play(1, 2);
        game.play(2, 1);
        game.play(2, 2);
        assertTrue(game.draw());
    }

    @Test
    public void testReset() {
        game.play(0, 0);
        game.play(0, 1);
        game.reset();
        assertEquals(0, game.checkWin());
        assertFalse(game.draw());
    }
}
