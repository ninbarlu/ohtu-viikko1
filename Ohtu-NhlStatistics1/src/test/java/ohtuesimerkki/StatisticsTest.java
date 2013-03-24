package ohtuesimerkki;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

/**
 * @since  24.3.2013
 * @author Nina Bärlund-Vihtola
 */
public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
            return players;
        }
    };
    
    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }
    
    @Test
    public void pelaajaLoytyy() {
        Player pelaaja = stats.search("Kurri");
        assertEquals("Kurri", pelaaja.getName());
    }

    @Test
    public void pelaajaEiLoydy() {
        assertEquals(null, stats.search("Siili"));
    }

    @Test
    public void joukkueenPelaajatLoytyy() {
        List<Player> joukkueenPelaajat = stats.team("EDM");
        assertEquals("Kurri", joukkueenPelaajat.get(1).getName());
    }

    @Test
    public void topMaalintekijatLoytyy() {
        List<Player> joukkueenPelaajat = stats.topScorers(3);
        assertEquals(35, joukkueenPelaajat.get(0).getGoals());
    }
    
}