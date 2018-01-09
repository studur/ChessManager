package chess;

public class ChessManager {

   public static void main(String[] args) {


      Player player1 = new Player("Jimmy", "Forest", 1801F);
      Player player2 = new Player("Roger", "Gendron", 1530F);
      Player player3 = new Player("Etienne", "Lavoie", 1337F);
      Player player4 = new Player("Robert ", "Fortin", 1358F);
      Player player5 = new Player("Robert", "Blanchard", 1234F);
      Player player6 = new Player("Louis", "Bergeron", 1218F);


/*
      Player player1 = new Player("Jean", "Morissette", 1885F);
      Player player4 = new Player("Etienne", "Lavoie", 1363F);
      Player player7 = new Player("Stephane", "Beland", 1601F);
      Player player8 = new Player("Louis", "Bergeron", 1194F);
      Player player5 = new Player("Denis", "Menard", 947F);
      Player player6 = new Player("Pierre", "Boucher", 1142F);
*/
      Tournament tournoi = new Tournament(6);

      tournoi.addPlayer(player1);
      tournoi.addPlayer(player2);
      tournoi.addPlayer(player3);
      tournoi.addPlayer(player4);
      tournoi.addPlayer(player5);
      tournoi.addPlayer(player6);


      // round 1
      Game game1 = new Game(player1, player4, 1F);
      Game game2 = new Game(player5, player2, 0F);
      Game game3 = new Game(player3, player6, 1F);


      // round 2
      Game game4 = new Game(player6, player1, 0F);
      Game game5 = new Game(player2, player3, 1F);
      Game game6 = new Game(player4, player5, 0F);


      //round 3
      Game game7 = new Game(player1, player2, 1F);
      Game game8 = new Game(player3, player5, 1F);
      Game game9 = new Game(player6, player4, 0.5F);



      tournoi.addResult(game1);
      tournoi.addResult(game2);
      tournoi.addResult(game3);
      tournoi.addResult(game4);
      tournoi.addResult(game5);
      tournoi.addResult(game6);
      tournoi.addResult(game7);
      tournoi.addResult(game8);
      tournoi.addResult(game9);

      tournoi.computeNewRatings();
      tournoi.printTournamentReport();



   }
}
