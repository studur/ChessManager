package chess;

import java.util.ArrayList;
import java.util.List;

public class ChessManager {

   public static void main(String[] args) {


      Player player1 = new Player("Jimmy", "Forest", 1794F);
      Player player2 = new Player("Roger", "Gendron", 1530F);
      Player player3 = new Player("Robert", "Fortin", 1347F);
      Player player4 = new Player("Robert", "Blanchard", 1242F);
      Player player5 = new Player("Pierre", "Boucher", 1142F);
      Player player6 = new Player("Denis", "Menard", 947F);

/*
      Player player1 = new Player("Jean", "Morissette", 1885F);
      Player player4 = new Player("Etienne", "Lavoie", 1363F);
      Player player7 = new Player("Stephane", "Beland", 1601F);
      Player player8 = new Player("Louis", "Bergeron", 1194F);
      Player player5 = new Player("Denis", "Menard", 947F);
      Player player6 = new Player("Pierre", "Boucher", 1142F);
*/
      List<Player> players = new ArrayList<>();

      players.add(player1);
      players.add(player2);
      players.add(player3);
      players.add(player4);
      players.add(player5);
      players.add(player6);

      Tournament tournoi = new Tournament(players);


      // round 1
      Game game1 = new Game(player1, player4, 1F);
      Game game2 = new Game(player5, player2, 1F);
      Game game3 = new Game(player3, player6, 0F);

      Round round1 = new Round();
      round1.addGame(game1);
      round1.addGame(game2);
      round1.addGame(game3);

      tournoi.addRound(round1);

      // round 2

      Game game4 = new Game(player6, player1, 0F);
      Game game5 = new Game(player2, player3, 0F);
      Game game6 = new Game(player4, player5, 1F);

      Round round2 = new Round();
      round2.addGame(game4);
      round2.addGame(game5);
      round2.addGame(game6);

      tournoi.addRound(round2);

      //round 3

      Game game7 = new Game(player1, player2, 1F);
      Game game8 = new Game(player3, player4, 1F);
      Game game9 = new Game(player5, player6, 0F);

      Round round3 = new Round();
      round3.addGame(game7);
      round3.addGame(game8);
      round3.addGame(game9);

      tournoi.addRound(round3);

      tournoi.computeNewRatings();
      tournoi.printTournamentReport();

      try {
         String filename = "result";
         tournoi.printTournamentReportToCsvFile(filename);
         Cevtables.convertCsvToXml(filename);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
