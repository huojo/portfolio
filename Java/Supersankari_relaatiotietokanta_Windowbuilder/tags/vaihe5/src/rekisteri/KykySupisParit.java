package rekisteri;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import rekisteri.Supikset.SupiksetIterator;

/**
 * KykySupisParit-luokka, jossa asuu kokoelma KykySupisPari-olioita
 *
 * @author majosalo
 * @version 5.3.2013
 * @version 7.3.2013
 */
public class KykySupisParit {
	private List<KykySupisPari> parit = new ArrayList<KykySupisPari>();


	/**
	 * Aliohjelma joka lis�� uuden kykysupisparin. Jos voimakkuus on 0, ei
	 * lis�t�.
	 *
	 * @param kenelle
	 *            mille supersankarille, eli idnumeroa kaivataan
	 * @param mikaKyky
	 *            mik� kyky lis�t��n, eli idnumeroa kaivataan
	 * @param voimakkuus
	 *            mik� voimakkuus supiksella on kyvyss�
	 * @return onnistuiko lis�ys
	 * @example <pre name="test">
	 * KykySupisParit parit = new KykySupisParit();
	 * parit.lisaaPari(2, 3, 300) === true;
	 * parit.getParienLkm() === 1;
	 * parit.poistaPariSupiksenPerusteella(2) === true;
	 * parit.getParienLkm() === 0;
	 * </pre>
	 */
	public boolean lisaaPari(int kenelle, int mikaKyky, int voimakkuus) {
		if (voimakkuus <= 0)
			return false;
		KykySupisPari pari = new KykySupisPari(kenelle, mikaKyky, voimakkuus);
		parit.add(pari);
		return true;
	}


	/**
	 * Aliohjelma joka poistaa tietty� supista koskevat parit
	 * @param supiksenId supis jonka id:t� etsit��n
	 * @return totuustiedon siit� poistettiinko yht��n paria
	 * @example
	 * <pre name="test">
	 * KykySupisParit parit = new KykySupisParit();
	 * parit.lisaaPari(2, 3, 300) === true;
	 * parit.getParienLkm() === 1;
	 * parit.poistaPariSupiksenPerusteella(2) === true;
	 * parit.getParienLkm() === 0;
	 * </pre>
	 */
	public boolean poistaPariSupiksenPerusteella(int supiksenId) {
		int poistettuja = 0;
		for (int i = 0; i < parit.size(); i++) {
			if (anna(i).getSupisId() == supiksenId) {
				parit.remove(i);
				poistettuja++;
			}
		}
		if (poistettuja > 0)
			return true;
		return false;
	}

	/**
	 * Aliohjelma joka poistaa tietylt� supikselt� kyvyn
	 * @param supiksenId supis jolta poistetaan
	 * @param kykyId kyky joka silt� poistetaan
	 * @return totuustieto siit� poistettiinko kyky (eli l�ytyik� sit�)
	 * @example
	 * <pre name="test">
	 * KykySupisParit parit = new KykySupisParit();
	 * parit.lisaaPari(2, 3, 300) === true;
	 * parit.lisaaPari(2, 1, 300) === true;
	 * parit.getParienLkm() === 2;
	 * parit.poistaKykySupikselta(2,3) === true;
	 * parit.getParienLkm() === 1;
	 * </pre>
	 */
	public boolean poistaKykySupikselta(int supiksenId, int kykyId){
		int poistettuja = 0;
		for (int i = 0; i < parit.size(); i++) {
			if (anna(i).getSupisId() == supiksenId && anna(i).getKykyId() == kykyId) {
				parit.remove(i);
				poistettuja++;
				break;
			}
		}
		if (poistettuja > 0)
			return true;
		return false;
	}

	/**
	 * @return montako paria on
	 * @example <pre name="test">
	 * KykySupisParit parit = new KykySupisParit();
	 * parit.lisaaPari(2, 3, 300) === true;
	 * parit.getParienLkm() === 1;
	 * </pre>
	 */
	public int getParienLkm() {
		return parit.size();
	}


	/**
	 * Palauttaa parin tietyst� indeksist�
	 *
	 * @param i
	 *            indeksi joka kohdalta l�ytyv� olio halutaan
	 * @return olio halutusta paikasta
	 * @example <pre name="test">
	 * KykySupisParit parit = new KykySupisParit();
	 * parit.lisaaPari(2, 3, 300) === true;
	 * parit.anna(0).getVoimakkuus() === 300;
	 * </pre>
	 */
	public KykySupisPari anna(int i) {
		return parit.get(i);
	}

	/**
	 * Vipelt�j�-luokka pareille
	 *
	 * @author majosalo
	 * @version 28.2.2013
	 *
	 */
	public class KykySupisParitIterator implements Iterator<KykySupisPari> {
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
			return kohdalla + 1 < parit.size();
		}


		/**
		 * Annetaan seuraava supis
		 *
		 * @return seuraava supis
		 * @throws NoSuchElementException
		 *             jos seuraava alkiota ei en�� ole
		 * @see java.util.Iterator#next()
		 */
		public KykySupisPari next() throws NoSuchElementException {
			if (!hasNext())
				throw new NoSuchElementException("Ei oo");
			kohdalla++;
			return parit.get(kohdalla);
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
	 * Palautetaan iteraattori pareista
	 *
	 * @return parit iteraattori
	 */
	public Iterator<KykySupisPari> iteratorPareille() {
		// return alkiot.iterator();
		return new KykySupisParitIterator();
	}
	/**
	 * Testip��ohjelma
	 *
	 * @param args
	 *            ei k�yt�ss�
	 */
	public static void main(String[] args) {
		KykySupisParit parit = new KykySupisParit();
		parit.lisaaPari(3, 6, 335);
		parit.lisaaPari(4, 3, 45);
		for (KykySupisPari pari : parit.parit) {
			pari.tulosta(System.out);
		}

	}

}
