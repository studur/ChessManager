package chess;


/**
 * This class is responsible for representing a chess player.
 */
public class Player implements Comparable<Player> {

   public String prenom;

   public String nom;

   public String fullName;

   public double rating;

   public boolean isRatingPermanent = true;

   public double oldRating;

   public double score = 0;

   public int unratedGamesPlayed = 0;

   public int wins = 0;

   public int losses = 0;

   public int ties = 0;


   public Player(String prenom, String nom, double rating) {
      this.nom = nom;
      this.prenom = prenom;
      this.fullName = prenom + " " + nom;
      this.rating = rating;
      this.oldRating = rating;
   }

   public Player(String prenom, String nom, double rating, int unratedGamesPlayed) {
      this.nom = nom;
      this.prenom = prenom;
      this.fullName = prenom + " " + nom;
      this.rating = rating;
      this.oldRating = rating;
      this.isRatingPermanent = false;
      this.unratedGamesPlayed = unratedGamesPlayed;
   }

   @Override
   public String toString() {
      return "Name=" + fullName + ", rating=" + rating;
   }

   @Override
   public int compareTo(Player otherPlayer) {
      if (this.rating > otherPlayer.rating) {
         return 1;
      } else if (this.rating < otherPlayer.rating) {
         return -1;
      }
      return 0;
   }

}