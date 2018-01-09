package chess;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * This class is responsible for...
 */
public class Tournament {


   private List<Player> players = new ArrayList<>();

   /** Table for each player that shows Wins-Losses-Ties */
   private int[][] winningReport;

   private float[][] resultMatrix;

   public Tournament(int numberOfPlayers) {
      this.resultMatrix = new float[numberOfPlayers][numberOfPlayers];
      this.winningReport = new int[numberOfPlayers][3];
   }

   public void addPlayer(Player player) {
      this.players.add(player);
   }

   public void addResult(Game game) {
      int coordPlayer1 = players.indexOf(game.player1);
      int coordPlayer2 = players.indexOf(game.player2);
      float result2 = game.result;
      if (game.result == 1F) {
         result2 = 0;
         winningReport[coordPlayer1][0] += 1;
         winningReport[coordPlayer2][1] += 1;
      } else if (game.result == 0F) {
         winningReport[coordPlayer2][0] += 1;
         winningReport[coordPlayer1][1] += 1;
         result2 = 1;
      } else {
         winningReport[coordPlayer1][2] += 1;
         winningReport[coordPlayer2][2] += 1;

      }
      resultMatrix[coordPlayer1][coordPlayer2] += game.player1.getDeltaFromGame(game.player2, game.result);
      resultMatrix[coordPlayer2][coordPlayer1] += game.player2.getDeltaFromGame(game.player1, result2);
   }


   public void computeNewRatings() {
      for (Player player : players) {
         float newRating = player.getRating();
         for (int i = 0; i < players.size(); i++) {
            newRating += resultMatrix[players.indexOf(player)][i];
         }
         player.setRating(newRating);
      }
   }

   public void printNewRatings() {
      for (Player player : players) {

         System.out.println(player.getFullName() + " : " + player.getRating());
      }
   }

   public void printResultMatrix() {
      for (int i = 0; i < players.size(); i++) {
         for (int j = 0; j < players.size(); j++) {
            System.out.print(new DecimalFormat("##.#").format(resultMatrix[i][j]) + "\t\t");
         }
         System.out.println();
      }
   }

   public void printTournamentReport() {
      System.out.println("*********************");
      System.out.println("* Tournament report *");
      System.out.println("*********************");
      for (int i = 0; i < players.size(); i++) {
         System.out.print(players.get(i).getFullName()+" : ");

         System.out.print( winningReport[i][0]+ " wins ");
         System.out.print( winningReport[i][1]+ " losses ");
         System.out.print( winningReport[i][2]+ " ties ");
         System.out.print("New rating is "+new DecimalFormat("##").format(players.get(i).getRating()));

         System.out.println();
      }
   }
}
