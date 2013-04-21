package ohtu.verkkokauppa;

/**
 * @since  24.3.2013
 * @author Nina Bärlund-Vihtola
 */
public interface VarastoIF {

    Tuote haeTuote(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);

    int saldo(int id);
    
}
