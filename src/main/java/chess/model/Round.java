package chess.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is responsible for representing a chess {@link Tournament} round. A round is composed of {@link Game}.
 * A {@link Tournament} typically contains several rounds.
 */
public class Round {

   private final List<Game> games;

   /**
    * Default constructor which supplies an empty ArrayList for the games list.
    */
   public Round() {
      this.games = new ArrayList<>();
   }

   /**
    * Constructor which uses a supplied games ArrayList.
    *
    * @param games List of {@link Game}
    */
   public Round(List<Game> games) {
      this.games = games;
   }

   public void addGame(Game game) {
      games.add(game);
   }

   public int getSize() {
      return games.size();
   }

   public List<Game> getGames() {
      return Collections.unmodifiableList(games);
   }
}
