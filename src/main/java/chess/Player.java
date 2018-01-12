package chess;


/**
 * This class is responsible for representing a chess player.
 */
public class Player {

   public String prenom;

   public String nom;

   public String fullName;

   public float rating;

   public float oldRating;

   public float score = 0;

   public int wins = 0;

   public int losses = 0;

   public int ties = 0;


   public Player(String prenom, String nom, float rating) {
      this.nom = nom;
      this.prenom = prenom;
      this.fullName = prenom + " " + nom;
      this.rating = rating;
      this.oldRating = rating;
   }

}