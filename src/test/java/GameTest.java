import main.java.Game;

import org.junit.Before;
import org.junit.Test;
import com.sun.source.tree.AssertTree;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class GameTest {
  private Game game;

  @Before
  public void setup() {
    game = new Game();
  }

  @Test
  public void gutterGameThrowsException() {
    for (int i = 0; i <= 20; i++) {
      game.roll(0);
    }
    assertEquals(0, game.score());
  }
}
