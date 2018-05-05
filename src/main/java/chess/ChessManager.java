package chess;

import java.util.ArrayList;
import java.util.List;

public class ChessManager {

   public static void main(String[] args) {



      Player player1 = new Player("Jimmy", "Forest", 1788);
      Player player2 = new Player("Roger", "Gendron", 1586);
      Player player3 = new Player("Robert", "Fortin", 1372);
      Player player4 = new Player("Etienne", "Lavoie", 1322);
      Player player5 = new Player("Robert", "Blanchard", 1231);
      Player player6 = new Player("Yves", "Gosselin", 1190);
      Player player7 = new Player("Pierre", "Boucher", 1136);
      Player player8 = new Player("Guillaume", "Lefebvre", 1372);
      Player player9 = new Player("Jean", "Morissette", 1861);

      List<Player> players = new ArrayList<>();

      players.add(player1);
      players.add(player2);
      players.add(player3);
      players.add(player4);
      players.add(player5);
      players.add(player6);
      players.add(player7);
      players.add(player8);
      players.add(player9);

      Tournament tournoi = new Tournament(players);


      // round 1
      Game game1 = new Game(player1, player5, 0.5);
      Game game2 = new Game(player2, player6, 1);
      Game game3 = new Game(player3, player7, 0.5);
      Game game4 = new Game(player4, player8, 0);

      Round round1 = new Round();
      round1.addGame(game1);
      round1.addGame(game2);
      round1.addGame(game3);
      round1.addGame(game4);

      tournoi.addRound(round1);

      // round 2

      Game game5 = new Game(player1, player2, 1);
      Game game6 = new Game(player3, player5, 1);
      Game game7 = new Game(player4, player7, 0.5);
      Game game8 = new Game(player8, player9, 0);


      Round round2 = new Round();


      round2.addGame(game5);
      round2.addGame(game6);
      round2.addGame(game7);
      round2.addGame(game8);

      tournoi.addRound(round2);

      //round 3

      Game game9 = new Game(player1, player8, 1);
      Game game10 = new Game(player2, player9, 1);
      Game game11 = new Game(player3, player4, 0);
      Game game12 = new Game(player6, player7, 1);

      Round round3 = new Round();

      round3.addGame(game9);
      round3.addGame(game10);
      round3.addGame(game11);
      round3.addGame(game12);


      tournoi.addRound(round3);

      tournoi.computeNewRatings();
      tournoi.printTournamentReport();

      try {
         String filename = "result-2";
         tournoi.printTournamentReportToCsvFile(filename);
         Cevtables.convertCsvToXml(filename);
      } catch (Exception e) {
         e.printStackTrace();
      }

   }
}
