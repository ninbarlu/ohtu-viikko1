package ohtu.verkkokauppa;

/**
 * @since  24.3.2013
 * @author Nina Bärlund-Vihtola
 */
public interface PankkiIF {

    boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa);
    
}
