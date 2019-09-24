package rekisteri;

import java.io.PrintStream;

/**
 * KykySupisPari-luokka joka ei paljoa muuta tied� kuin supiksen ja kyvyn id:t
 * ja kuinka hyv� supis on siin� kyvyss�. Ei tied� mik� on supis tai kyky. getit
 * kaikille attribuuteille koska jokaista tarvitsee KykySupisParit-luokka kysy�
 * olioiltaan
 *
 * @author majosalo
 * @version 5.3.2013
 * @version 22.4.2013
 */
public class KykySupisPari {
	private int supisId;
	private int kykyId;
	private int voimakkuus;


	/**
	 * Muodostetaan KykySupisPari
	 *
	 * @param supiksenId
	 *            supiksen id
	 * @param kyvynId
	 *            kyvyn id
	 * @param supiksenVoimakkuus
	 *            kuinka voimakas supis on siin� kyvyss�
	 * @example <pre name="test">
	 * KykySupisPari pari = new KykySupisPari(3, 2, 300);
	 * pari.getSupisId() === 3;
	 * pari.getKykyId() === 2;
	 * pari.getVoimakkuus() === 300;
	 * </pre>
	 */
	public KykySupisPari(int supiksenId, int kyvynId, int supiksenVoimakkuus) {
		supisId = supiksenId;
		kykyId = kyvynId;
		voimakkuus = supiksenVoimakkuus;
	}


	/**
	 * @return parin merkkijonona. T�m� pistet��n tiedostoon
	 */
	public String merkkijonoksi() {
		return supisId + "|" + kykyId + "|" + voimakkuus;
	}


	/**
	 * @return mik� on oliossa s�ilytetyn kyvyn id
	 * @example <pre name="test">
	 * KykySupisPari pari = new KykySupisPari(3, 2, 300);
	 * pari.getKykyId() === 2;
	 * </pre>
	 */
	public int getKykyId() {
		return kykyId;
	}


	/**
	 * @return mik� on oliossa s�ilytetyn supiksen id
	 * @example <pre name="test">
	 * KykySupisPari pari = new KykySupisPari(3, 2, 300);
	 * pari.getSupisId() === 3;
	 * </pre>
	 */
	public int getSupisId() {
		return supisId;
	}


	/**
	 * @return mik� on oliossa s�ilytetyn voimakkuuden arvo
	 * @example <pre name="test">
	 * KykySupisPari pari = new KykySupisPari(3, 2, 300);
	 * pari.getVoimakkuus() === 300;
	 * </pre>
	 */
	public int getVoimakkuus() {
		return voimakkuus;
	}


	/**
	 * Tulostetaan Kyvyn tiedot
	 *
	 * @param out
	 *            tietovirta johon tulostetaan
	 */
	public void tulosta(PrintStream out) {
		out.println(getSupisId() + " " + getKykyId() + " " + getVoimakkuus());
	}


	/**
	 * Testip��ohjelma
	 *
	 * @param args
	 *            ei k�yt�ss�
	 */
	public static void main(String[] args) {
		KykySupisPari pari = new KykySupisPari(3, 2, 300);
		System.out.println(pari.getSupisId());
		System.out.println(pari.getKykyId());
		System.out.println(pari.getVoimakkuus());
		pari.tulosta(System.out);
	}

}
