package rekisteri;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Supikset-luokka joka tiet�� montako supista on yms.
 *
 * @author majosalo
 * @version 22.2.2013
 * @version 7.3.2013
 */
public class Supikset {
	private static final int MAX_Supiksia = 100;
	private int montakoSupista = 0;
	private String tiedostonNimi = "";
	private Supersankari[] supikset = new Supersankari[MAX_Supiksia]; // siell�
																		// ne
																		// supikset
																		// sitten
																		// on.
																		// ok,
																		// t�ss�
																		// vaiheessa
																		// viel�
																		// 5
																		// null-viitett�,
																		// mutta
																		// piakkoin.


	/**
	 * Testip��ohjelma
	 *
	 * @param args
	 *            ei k�yt�ss�
	 */
	public static void main(String[] args) {
		Supikset supiksit = new Supikset();

		Supersankari suppe = new Supersankari(), suppe2 = new Supersankari();
		suppe.alustaToimivaksi();
		suppe2.alustaToimivaksi();

		try {
			supiksit.lisaaTyhjaSupis(suppe);
			supiksit.lisaaTyhjaSupis(suppe2);

			System.out.println("============= J�senet testi =================");

			for (int i = 0; i < supiksit.supikset.length; i++) {
				if (supiksit.anna(i) != null) {
					Supersankari jasen = supiksit.anna(i);
					System.out.println("J�sen nro: " + (i + 1)); // ei siis id,
																	// vaan se
																	// mist� ne
																	// l�ytyy
																	// taulukosta
					jasen.tulosta(System.out);
				}
			}

		} catch (SailoException ex) {
			System.out.println(ex.getMessage());
		}
	}





	/**
	 * Palauttaa supersankaritaulukon i. indeksiss� sijaitsevan supersankarin
	 *
	 * @param i
	 *            indeksi jossa etsitty supis sijaitsee
	 * @return supersankari jota etsittiin
	 * @example
	 * @throws IndexOutOfBoundsException
	 *             jos i ei ole sallitulla alueella
	 *
	 *             <pre name="test">
	 * #THROWS SailoException
	 * Supikset supikset = new Supikset();
	 * Supersankari supis1 = new Supersankari(), supis2 = new Supersankari();
	 * supikset.getMontakoSupista() === 0;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 1;
	 * supikset.lisaaTyhjaSupis(supis2); supikset.getMontakoSupista() === 2;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 3;
	 * supikset.anna(0) === supis1;
	 * supikset.anna(1) === supis2;
	 * supikset.anna(2) === supis1;
	 * supikset.anna(1) == supis1 === false;
	 * supikset.anna(1) == supis2 === true;
	 * </pre>
	 */
	public Supersankari anna(int i) throws IndexOutOfBoundsException {

		if (i < 0 || i > supikset.length - 1) {
			throw new IndexOutOfBoundsException("Laiton indeksi: " + i);
		}
		return supikset[i];
	}

	/**
	 * Palauttaa supersankaritaulukosta nimen perusteella supiksen id:n
	 *
	 * @param stageName
	 *            nimi jolla supersankaria etsit��n
	 * @return supersankarin id
	 * @example
	 * <pre name="test">
	 * Supikset supikset = new Supikset();
	 * Supersankari supis1 = new Supersankari(), supis2 = new Supersankari();
	 * supikset.getMontakoSupista() === 0;
	 * String battis = "Batman          | Wayne Bruce        | Kyle Selina   | Gotham City |  1               ";
	 * String captis = "Captain America | Rogers Steve       | Stark Tony    | Brooklyn    |  2               ";
	 * supikset.lisaaSupis(battis) === true;
	 * supikset.lisaaSupis(captis) === true;
	 *    int n1 = supikset.annaNimenId("Batman");
	 *    int n2 = supikset.annaNimenId("Captain America");
	 * n1 === n2-1;
	 * </pre>
	 */
	public int annaNimenId(String stageName)  {
		for (int i = 0; i < supikset.length; i++){
			if (anna(i) != null && anna(i).getStageName().equals(stageName))
				return anna(i).getId();
		}
		return -1;
	}



	/**
	 * Lis�� uuden supiksen tietorakenteeseen. Ottaa supiksen omistukseensa.
	 *
	 * @param supis
	 *            lis�t��v�n j�senen viite. Huom tietorakenne muuttuu
	 *            omistajaksi
	 * @throws SailoException
	 *             jos tietorakenne on jo t�ynn�
	 * @example <pre name="test">
	 * #THROWS SailoException
	 * Supikset supikset = new Supikset();
	 * Supersankari supis1 = new Supersankari(), supis2 = new Supersankari();
	 * supikset.getMontakoSupista() === 0;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 1;
	 * supikset.lisaaTyhjaSupis(supis2); supikset.getMontakoSupista() === 2;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 3;
	 * supikset.anna(0) === supis1;
	 * supikset.anna(1) === supis2;
	 * supikset.anna(2) === supis1;
	 * supikset.anna(1) == supis1 === false;
	 * supikset.anna(1) == supis2 === true;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 4;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 5;
	 * supikset.lisaaTyhjaSupis(supis1);
	 * </pre>
	 */
	public void lisaaTyhjaSupis(Supersankari supis) throws SailoException {
		if (montakoSupista >= supikset.length)
			throw new SailoException("Liikaa alkioita");
		supikset[montakoSupista] = supis;
		montakoSupista++;
	}


	/**
	 * Lis�� uuden supiksen tietorakenteeseen. Ottaa supiksen omistukseensa.
	 *
	 * @param tiedot
	 *            lis�tt�v�n supiksen tiedot merkkijonona. Huom tietorakenne muuttuu
	 *            omistajaksi
	 * @throws SailoException
	 *             jos tietorakenne on jo t�ynn�
	 * @example <pre name="test">
	 * Supikset supikset = new Supikset();
	 * String supis1 = "Batman          | Wayne Bruce        | Kyle Selina   | Gotham City |  1               ";
	 * String supis2 = "Captain America | Rogers Steve       | Stark Tony    | Brooklyn    |  2               ";
	 * supikset.getMontakoSupista() === 0;
	 * supikset.lisaaSupis(supis1) === true;
	 * supikset.getMontakoSupista() === 1;
	 * supikset.lisaaSupis(supis2) === true;
	 * supikset.getMontakoSupista() === 2;
	 * supikset.lisaaSupis(supis1) === true;
	 * supikset.getMontakoSupista() === 3;
	 * supikset.anna(0).getStageName().equals("Batman") === true;
	 * supikset.anna(1).getStageName().equals("Captain America") === true;
	 * supikset.anna(2).getStageName().equals("Batman") === true;
	 * supikset.anna(1).getStageName().equals("Batman") === false;
	 * supikset.anna(1).getStageName().equals("Captain America") === true;
	 * supikset.lisaaSupis(supis1); supikset.getMontakoSupista() === 4;
	 * supikset.lisaaSupis(supis1); supikset.getMontakoSupista() === 5;
	 * </pre>
	 */
	public boolean lisaaSupis(String tiedot) {
		if (montakoSupista >= supikset.length)
			return false;
		Supersankari suppe = new Supersankari(tiedot);
		supikset[montakoSupista] = suppe;
		montakoSupista++;
		return true;
	}


	/**
	 * Poistaa supiksen stage namen perusteella
	 *
	 * @param stageName
	 *            poistettavan supiksen viite.
	 * @throws SailoException
	 *             jos homma menee vikaan
	 * @example <pre name="test">
	 * #THROWS SailoException
	 * Supikset supikset = new Supikset();
	 * Supersankari supis1 = new Supersankari(), supis2 = new Supersankari();
	 * supis1.alustaToimivaksi(); supis2.alustaToimivaksi();
	 * supikset.getMontakoSupista() === 0;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 1;
	 * supikset.lisaaTyhjaSupis(supis2); supikset.getMontakoSupista() === 2;
	 * supikset.poistaSupis("Captain America"); supikset.getMontakoSupista() === 1;
	 * supikset.poistaSupis("Captain America"); supikset.getMontakoSupista() === 0;
	 * </pre>
	 */
	public void poistaSupis(String stageName) {
		for (int i = 0; i < supikset.length; i++) {
			if (anna(i) != null && anna(i).getStageName() == stageName) {
				supikset[i] = null;
				montakoSupista--;
				break;
			}
		}

	}


	/**
	 * @return supersankarien lukum��r�n taulukossa
	 * @example <pre name="test">
	 * #THROWS SailoException
	 * Supikset supikset = new Supikset();
	 * Supersankari supis1 = new Supersankari(), supis2 = new Supersankari();
	 * supikset.getMontakoSupista() === 0;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 1;
	 * supikset.lisaaTyhjaSupis(supis2); supikset.getMontakoSupista() === 2;
	 * supikset.lisaaTyhjaSupis(supis1); supikset.getMontakoSupista() === 3;
	 * </pre>
	 */
	public int getMontakoSupista() {
		return montakoSupista;
	}


	/**
	 * Lukee supersankarit tiedostosta. Ei toimi viel�!
	 *
	 * @param tiedosto
	 *            tiedoston nimen alkuosa
	 * @throws SailoException
	 *             jos lukeminen ep�onnistuu
	 */
	public void lueTiedostosta(String tiedosto) throws SailoException {
		tiedostonNimi = tiedosto + ".dat";
		throw new SailoException("Ei osata viel� lukea tiedostoa "
				+ tiedostonNimi);
	}


	/**
	 * Tallentaa j�senist�n tiedostoon. Ei toimi viel�!
	 *
	 * @throws SailoException
	 *             jos talletus ep�onnistuu
	 */
	public void talleta() throws SailoException {
		throw new SailoException("Ei osata viel� tallettaa tiedostoa "
				+ tiedostonNimi);
	}

	/**
	 * Vipelt�j�-luokka supiksille
	 *
	 * @author majosalo
	 * @version 28.2.2013
	 *
	 */
	public class SupiksetIterator implements Iterator<Supersankari> {
		private int kohdalla = -1;


		/**
		 * Onko olemassa viel� seuraavaa supista
		 *
		 * @see java.util.Iterator#hasNext()
		 * @return true jos on viel� supiksia
		 */
		public boolean hasNext() {
			// if ( kohdalla + 1 >= lkm ) return false;
			// return true;
			return kohdalla + 1 < supikset.length;
		}


		/**
		 * Annetaan seuraava supis
		 *
		 * @return seuraava supis
		 * @throws NoSuchElementException
		 *             jos seuraava alkiota ei en�� ole
		 * @see java.util.Iterator#next()
		 */
		public Supersankari next() throws NoSuchElementException {
			if (!hasNext())
				throw new NoSuchElementException("Ei oo");
			kohdalla++;
			return supikset[kohdalla];
		}


		/**
		 * Tuhoamista ei ole toteutettu
		 *
		 * @throws UnsupportedOperationException
		 *             aina
		 * @see java.util.Iterator#remove()
		 */
		public void remove() throws UnsupportedOperationException {
			throw new UnsupportedOperationException("My� ei poisteta");
		}
	}


	/**
	 * Palautetaan iteraattori supiksista.
	 *
	 * @return supikset iteraattori
	 */
	public Iterator<Supersankari> iteratorSupiksille() {
		// return alkiot.iterator();
		return new SupiksetIterator();
	}
}
