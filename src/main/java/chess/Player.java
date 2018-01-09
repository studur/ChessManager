package chess;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * This class is responsible for representing a chess player.
 */
public class Player {

   /**
    * This map is used to fetch the probability value based on the rating difference between two chess players.
    */
   private final static NavigableMap<Integer, Float> map;

   static {
      map = new TreeMap<Integer, Float>();
      map.put(0, 0.50F);
      map.put(4, 0.51F);
      map.put(11, 0.52F);
      map.put(18, 0.53F);
      map.put(26, 0.54F);
      map.put(33, 0.55F);
      map.put(40, 0.56F);
      map.put(47, 0.57F);
      map.put(54, 0.58F);
      map.put(62, 0.59F);
      map.put(69, 0.60F);
      map.put(77, 0.61F);
      map.put(84, 0.62F);
      map.put(92, 0.63F);
      map.put(99, 0.64F);
      map.put(107, 0.65F);
      map.put(114, 0.66F);
      map.put(122, 0.67F);
      map.put(130, 0.68F);
      map.put(138, 0.69F);
      map.put(146, 0.70F);
      map.put(154, 0.71F);
      map.put(163, 0.72F);
      map.put(171, 0.73F);
      map.put(180, 0.74F);
      map.put(189, 0.75F);
      map.put(198, 0.76F);
      map.put(207, 0.77F);
      map.put(216, 0.78F);
      map.put(226, 0.79F);
      map.put(236, 0.80F);
      map.put(246, 0.81F);
      map.put(257, 0.82F);
      map.put(268, 0.83F);
      map.put(279, 0.84F);
      map.put(291, 0.85F);
      map.put(303, 0.86F);
      map.put(316, 0.87F);
      map.put(329, 0.88F);
      map.put(345, 0.89F);
      map.put(358, 0.90F);
      map.put(375, 0.91F);
      map.put(392, 0.92F);
      map.put(412, 0.93F);
      map.put(433, 0.94F);
      map.put(457, 0.95F);
      map.put(485, 0.96F);
      map.put(518, 0.97F);
      map.put(560, 0.98F);
      map.put(620, 0.99F);
      map.put(735, 1.00F);
   }


   public String prenom;

   public String nom;

   public String fullName;

   public float rating;

   public Player(String prenom, String nom, float rating) {
      this.nom = nom;
      this.prenom = prenom;
      this.fullName = prenom + " " + nom;
      this.rating = rating;
   }

   /**
    * This method is used to calculate a rating adjustment (delta) based on the result from a game
    * between two chess players.
    *
    * @param opponent     Player instance.
    * @param actualResult Result : 1F win, 0F loss, 0.5F tie
    * @return The rating variation.
    */
   public float getDeltaFromGame(Player opponent, float actualResult) {

      Integer diff = Math.round(this.rating - opponent.rating);
      float expectedResult = 0;

      // To do a lookup for some value in 'key'
      if (diff < 0) {
         expectedResult = 1 - map.floorEntry(Math.abs(diff)).getValue();
      } else {
         expectedResult = map.floorEntry(diff).getValue();
      }

      float delta = 32 * (actualResult - expectedResult);

      return delta;
   }


}