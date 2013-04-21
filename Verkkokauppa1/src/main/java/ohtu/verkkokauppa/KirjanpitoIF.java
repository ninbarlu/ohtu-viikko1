package ohtu.verkkokauppa;

import java.util.ArrayList;

/**
 * @since  24.3.2013
 * @author Nina Bärlund-Vihtola
 */
public interface KirjanpitoIF {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
