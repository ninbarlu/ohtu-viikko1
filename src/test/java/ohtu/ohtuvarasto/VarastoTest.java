package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisääLiikaa() {
        varasto.lisaaVarastoon(12);

        // varastoon ei mahdu, palauttaa täyden varaston
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void otaLiikaa() {
        varasto.otaVarastosta(12);

        // varastossa ei tarpeeksi, palauttaa tyhjän varaston
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void lisääNegatiivinen() {
        // varasto nyt tyhjä, lisätään ensin vähän saldoa
        varasto.lisaaVarastoon(4);

        // lisätään -1, palauttaa saman kuin oli
        varasto.lisaaVarastoon(-1);
        assertEquals(6, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void otaNegatiivinen() {

        // otetaan -1, palauttaa 0.0
        assertEquals(0.0, varasto.otaVarastosta(-1), vertailuTarkkuus);
    }

    @Test
    public void konstr() {
        varasto = new Varasto(-1);
        varasto = new Varasto(0);
        varasto = new Varasto(1,1);
        varasto = new Varasto(1,2);
        varasto = new Varasto(-1,2);
        varasto = new Varasto(-1,-1);
        varasto.toString();
    }
}