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
      player1 = new Player("John", "Doe", 1500);
      player2 = new Player("Jane", "Doe", 1800);

      List<Player> players = new ArrayList<>();
      players.add(player1);
      players.add(player2);
      tournament = new Tournament(players);

      game1 = new Game(player1, player2, 0);
      tournament.addResult(game1);
   }

   @Test
   public void getResultMatrix() {
      double[][] result = tournament.getResultMatrix();
      double[][] expected = new double[][]{{0, -4.800000000000001}, {4.800000000000001, 0}};
      assertArrayEquals(expected, result);
   }

   @Test
   public void addResult() throws Exception {
      assertTrue(player1.wins == 0);
      assertTrue(player1.losses == 1);
      assertTrue(player2.wins == 1);
      assertTrue(player2.losses == 0);
      assertTrue(player1.score == 0);
      assertTrue(player2.score == 1);
   }

   @Test
   public void computeNewRatings() throws Exception {
      tournament.computeNewRatings();
      assertTrue(player1.oldRating == 1500);
      assertTrue(player2.oldRating == 1800);
      assertTrue(player1.rating == 1495.2);
      assertTrue(player2.rating == 1804.8);
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