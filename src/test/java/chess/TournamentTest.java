package chess;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TournamentTest {

   private static Tournament tournament;
   private static Player player1;
   private static Player player2;
   private static Game game1;

   @Before
   public void setUp() {
      player1 = new Player("John", "Doe", 1500F);
      player2 = new Player("Jane", "Doe", 1800F);

      List<Player> players = new ArrayList<>();
      players.add(player1);
      players.add(player2);
      tournament = new Tournament(players);

      game1 = new Game(player1, player2, 0F);
      tournament.addResult(game1);
   }

   @Test
   public void getResultMatrix() {
      float[][] result = tournament.getResultMatrix();
      float[][] expected = new float[][]{{0F, -4.799999F}, {4.799999F, 0F}};
      assertArrayEquals(expected, result);
   }

   @Test
   public void addResult() throws Exception {
      assertTrue(player1.wins == 0F);
      assertTrue(player1.losses == 1F);
      assertTrue(player2.wins == 1F);
      assertTrue(player2.losses == 0F);
      assertTrue(player1.score == 0F);
      assertTrue(player2.score == 1F);
   }

   @Test
   public void computeNewRatings() throws Exception {
      tournament.computeNewRatings();
      assertTrue(player1.oldRating == 1500F);
      assertTrue(player2.oldRating == 1800F);
      assertTrue(player1.rating == 1495.2F);
      assertTrue(player2.rating == 1804.8F);
   }

   @Test
   public void computePlayerStanding() throws Exception {

      Player[] expectedBefore = new Player[]{null, null};
      Player[] expectedAfter = new Player[]{player2, player1};

      assertArrayEquals(expectedBefore, tournament.getPlayersStanding());

      tournament.computeNewRatings();
      assertArrayEquals(expectedAfter, tournament.getPlayersStanding());
   }

}