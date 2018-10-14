import main.java.Game;

import org.junit.Before;
import org.junit.Test;

import com.sun.source.tree.AssertTree;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

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

  private void rollSpare() {
    game.roll(5);
    game.roll(5);
  }

  private void rollStrike() {
    game.roll(10);
    game.roll(0);
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

  @Test
  public void oneSpare() {
    rollSpare();
    game.roll(2);
    rollManySame(17, 0);
    assertEquals(14, game.score());
  }

  @Test
  public void oneStrike() {
    rollStrike();
    game.roll(1);
    game.roll(1);
    rollManySame(16, 0);
    assertEquals(14, game.score());
  }

  @Test
  public void oneDouble() {
    rollStrike();
    rollStrike();
    game.roll(1);
    game.roll(1);
    rollManySame(14, 0);
    assertEquals(35, game.score());
  }

  @Test
  public void oneTriple() {
    rollStrike();
    rollStrike();
    rollStrike();
    game.roll(1);
    game.roll(1);
    rollManySame(12, 0);
    assertEquals(65, game.score());
  }

  @Test
  public void perfectGame() {
    for (int i = 0; i < 9; i++) {
      rollStrike();
    }
    for (int i = 0; i < 3; i++) {
      game.roll(10);
    }
    assertEquals(300, game.score());
  }

  @Test
  public void exampleGame() {
    game.roll(1);
    game.roll(4);
    game.roll(4);
    game.roll(5);
    game.roll(6);
    game.roll(4);
    game.roll(5);
    game.roll(5);
    game.roll(10);
    game.roll(0);
    game.roll(0);
    game.roll(1);
    game.roll(7);
    game.roll(3);
    game.roll(6);
    game.roll(4);
    game.roll(10);
    game.roll(0);
    game.roll(2);
    game.roll(8);
    game.roll(6);
    assertEquals(133, game.score());
  }
}
