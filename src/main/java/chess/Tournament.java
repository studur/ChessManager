package chess;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is responsible for representing a chess tournament composed of a list of Player and Game.
 */
public class Tournament {


   private List<Player> players = new ArrayList<>();

   private float[][] resultMatrix;

   private Player[] playersStanding;

   public Tournament(List<Player> players) {
      this.players = players;
      this.resultMatrix = new float[players.size()][players.size()];
      this.playersStanding = new Player[players.size()];
   }


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
      resultMatrix[coordPlayer1][coordPlayer2] += game.player1.getDeltaFromGame(game.player2, game.result);
      resultMatrix[coordPlayer2][coordPlayer1] += game.player2.getDeltaFromGame(game.player1, result2);
   }


   public void computeNewRatings() {
      for (Player player : players) {
         float newRating = player.rating;
         for (int i = 0; i < players.size(); i++) {
            newRating += resultMatrix[players.indexOf(player)][i];
         }
         player.oldRating = player.rating;
         player.rating = newRating;
      }
      computePlayerStanding();
   }

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
