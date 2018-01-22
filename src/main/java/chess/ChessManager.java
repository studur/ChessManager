package chess;

import java.util.ArrayList;
import java.util.List;

public class ChessManager {

   public static void main(String[] args) {


      Player player1 = new Player("Jimmy", "Forest", 1809);
      Player player2 = new Player("Roger", "Gendron", 1537);
      Player player3 = new Player("Etienne", "Lavoie", 1351);
      Player player4 = new Player("Robert", "Fortin", 1329);
      Player player5 = new Player("Robert", "Blanchard", 1229);
      Player player6 = new Player("Louis", "Bergeron", 1213);


/*
      Player player1 = new Player("Jean", "Morissette", 1885F);
      Player player4 = new Player("Etienne", "Lavoie", 1363F);
      Player player7 = new Player("Stephane", "Beland", 1601F);
      Player player8 = new Player("Louis", "Bergeron", 1194F);
      Player player5 = new Player("Denis", "Menard", 947F);
      Player player6 = new Player("Pierre", "Boucher", 1142F);
      Player player5 = new Player("Pierre", "Boucher", 1142F);
      Player player6 = new Player("Denis", "Menard", 947F);
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
      Game game1 = new Game(player1, player4, 1);
      Game game2 = new Game(player2, player5, 1);
      Game game3 = new Game(player3, player6, 1);

      Round round1 = new Round();
      round1.addGame(game1);
      round1.addGame(game2);
      round1.addGame(game3);

      tournoi.addRound(round1);

      // round 2

      Game game4 = new Game(player1, player3, 1);
      Game game5 = new Game(player2, player4, 0);
      Game game6 = new Game(player5, player6, 0);

      Round round2 = new Round();
      round2.addGame(game4);
      round2.addGame(game5);
      round2.addGame(game6);

      tournoi.addRound(round2);

      //round 3

      Game game7 = new Game(player1, player2, 1);
      Game game8 = new Game(player3, player5, 0);
      Game game9 = new Game(player4, player6, 1);

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
