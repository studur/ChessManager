package chess;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * This class is responsible for representing a chess tournament composed of a list of Player and Game.
 */
public class Tournament {

   private List<Player> players = new ArrayList<>();

   private List<Round> rounds = new ArrayList<>();

   private float[][] resultMatrix;

   private Player[] playersStanding;

   public Tournament(List<Player> players) {
      this.players = players;
      this.resultMatrix = new float[players.size()][players.size()];
      this.playersStanding = new Player[players.size()];
   }

   public float[][] getResultMatrix() {
      float[][] copy = new float[resultMatrix.length][resultMatrix[0].length];
      System.arraycopy(resultMatrix, 0, copy, 0, resultMatrix.length);
      return copy;
   }

   public Player[] getPlayersStanding() {
      return Arrays.copyOf(playersStanding, playersStanding.length);
   }


   public void addRound(Round round) {
      rounds.add(round);
   }

   /**
    * Method used to add a game result to each player metrics and the computed rating adjustments for the
    * respective players in the resultMatrix of the tournament.
    * @param game The added game.
    */
   public void addResult(Game game) {
      int coordPlayer1 = players.indexOf(game.player1);
      int coordPlayer2 = players.indexOf(game.player2);
      float result2 = game.result;

      if (game.result == 1F) {
         result2 = 0;
         game.player1.wins += 1;
         game.player2.losses += 1;
         game.player1.score += 1F;

      } else if (game.result == 0F) {
         game.player1.losses += 1;
         game.player2.wins += 1;
         game.player2.score += 1F;
         result2 = 1;

      } else {
         game.player1.ties += 1;
         game.player2.ties += 1;
         game.player1.score += 0.5F;
         game.player2.score += 0.5F;
      }

      resultMatrix[coordPlayer1][coordPlayer2] += Game.getDeltaFromGame(game.player1, game.player2, game.result);
      resultMatrix[coordPlayer2][coordPlayer1] += Game.getDeltaFromGame(game.player2, game.player1, result2);
   }

   /**
    * Method used to aggregate all the rating adjustments for each player and compute the final rating after
    * a completed tournament. The bonus is also calculated based on the number of rounds played.
    */
   public void computeNewRatings() {

      for (Round round : rounds) {
         for (Game game : round.getGames()) {
            addResult(game);
         }
      }

      for (Player player : players) {
         float newRating = player.rating;
         for (int i = 0; i < players.size(); i++) {
            newRating += resultMatrix[players.indexOf(player)][i];
         }

         // Calculate bonus if 4 rounds or more were played

         player.oldRating = player.rating;
         float delta = newRating - player.oldRating;
         float bonus = 0;
         if (rounds.size() > 3) {
            bonus = delta - (float)(24 + 2 * (rounds.size() - 4));
            if (bonus < 0F) {
               bonus = 0F;
            }
         }
         player.rating = newRating + bonus;
      }
      computePlayerStanding();
   }

   /**
    * Method used to compute the standing of the player and sort the list.
    */
   public void computePlayerStanding() {
      for (int i = 0; i < players.size(); i++) {
         playersStanding[i] = players.get(i);
      }
      insertionsortOnScore(playersStanding);
   }

    public void printTournamentReport() {
      System.out.println("*********************");
      System.out.println("* Tournament report *");
      System.out.println("*********************");
      for (int i = 0; i < playersStanding.length; i++) {
         System.out.print(playersStanding[i].fullName + " : ");
         System.out.print(playersStanding[i].wins + " wins ");
         System.out.print(playersStanding[i].losses + " losses ");
         System.out.print(playersStanding[i].ties + " ties ");
         System.out.print("New rating is " + new DecimalFormat("##").format(playersStanding[i].rating));
         System.out.println();
      }
   }

   /**
    *
    * @param fileName
    * @throws IOException
    */
   public void printTournamentReportToCsvFile(String fileName) throws IOException {

      try (BufferedWriter bufferedWriter = new BufferedWriter(
            new FileWriter("./" + fileName + ".csv"))) {
         bufferedWriter.write("Nom;Ancienne cote;Gains;Nulles;Pertes;Nouvelle cote");
         bufferedWriter.newLine();
         for (int i = 0; i < playersStanding.length; i++) {
            bufferedWriter.write(playersStanding[i].fullName + ";");
            bufferedWriter.write(new DecimalFormat("##").format(playersStanding[i].oldRating) + ";");
            bufferedWriter.write(playersStanding[i].wins + ";");
            bufferedWriter.write(playersStanding[i].ties + ";");
            bufferedWriter.write(playersStanding[i].losses + ";");
            bufferedWriter.write(new DecimalFormat("##").format(playersStanding[i].rating));
            bufferedWriter.newLine();
         }
      }
   }

   /**
    *
    * @param players
    */
   public static void insertionsortOnScore(Player[] players) {
      int n = players.length;
      for (int k = 1; k < n; k++) {
         Player key = players[k];
         int l = k - 1;
         while ((l >= 0) && (players[l].score < key.score)) {
            players[l + 1] = players[l];
            l--;
         }
         players[l + 1] = key;
      }
   }

}
