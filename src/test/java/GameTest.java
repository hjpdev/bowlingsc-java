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

  private void rollManySame(int n, int pins) {
    for (int i = 0; i < n; i++) {
      game.roll(pins);
    }
  }

  @Test
  public void gutterGame() {
    rollManySame(20, 0);
    assertEquals(0, game.score());
  }

  @Test
  public void allOnes() {
    rollManySame(20, 1);
    assertEquals(20, game.score());
  }
}
