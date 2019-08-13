import  org.junit.*;
import java.util.ArrayList;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class testing {
    Game game;
  private final String xWin="Player X wins";
  private final String oWin="Player O wins";
  private final char[][] testCase1={{'X','X','X'},{'O','O','X'},{'O','X','O'}};
    private final char[][] testCase2={{'O','X','X'},{'O','O','O'},{'X','X','O'}};

    @Test
    public void testWin(){
         game=new Player();
        assertEquals(true,game.win('X',testCase1));
        assertEquals(true,game.win('O',testCase2));
    }

    @Test
    public void testVerdict(){
        game=new Player();
        assertEquals(xWin,game.verdict(testCase1));
        assertEquals(oWin,game.verdict(testCase2));
    }
}