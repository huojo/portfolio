package rekisteri;

/**
* Poikkeusluokka tietorakenteesta aiheutuville poikkeuksille.
* @author Vesa Lappalainen
* @majosalo
* @version 1.0, 22.02.2003
* @version 22.2.2013
*/
public class SailoException extends Exception {
  private static final long serialVersionUID = 1L;


  /**
   * Poikkeuksen muodostaja jolle tuodaan poikkeuksessa
   * k�ytett�v� viesti
   * @param viesti Poikkeuksen viesti
   */
  public SailoException(String viesti) {
      super(viesti);
  }
}