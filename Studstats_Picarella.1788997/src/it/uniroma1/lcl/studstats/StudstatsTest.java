package it.uniroma1.lcl.studstats;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreSesso;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreStudentiVotoMaggiore;
import it.uniroma1.lcl.studstats.dati.Analizzatori;
import it.uniroma1.lcl.studstats.analizzatori.AnalizzatoreSegretoSegretissimo;
// Studente -> dati
// Rapporto -> dati
// Aggregatore -> studstats
// Tipo rapporto -> dati
// Analizzatore -> dati
// Analizzatori -> dati
// AnalizzatoreSegretoseg -> dati
// tutti analizzatori -> dati
// Aggreg statistico -> studstats
// Studstats -> studstats

class StudstatsTest {
	    public static final String PERCORSO = "IMMATRICOLATI_INFORMATICA_SAPIENZA_2018_randomizzato.csv";
	    
	    private Studstats stats;
	    
	    @BeforeEach
	    void setUp() throws Exception
	    {
	   	 	stats = Studstats.fromFile(PERCORSO);
	   	 	//Studstats stats = Studstats.fromFile(Paths.get(PERCORSO));
	   	 	stats.addAll(Analizzatori.allBasic());
	    }

	    @Test
	    void testAdd()
	    {
		   	 stats.add(new AnalizzatoreStudentiVotoMaggiore(80));
		   	 stats.add(new AnalizzatoreStudentiVotoMaggiore(80, new AnalizzatoreSesso()));
		   	 assertEquals(stats.numeroAnalizzatori(), 7);
	    }
	    
	    @Test
	    void testGeneraRapporti1()
	    {
		   	 System.out.println("=== testGeneraRapporti1 ===");
		   	 for (Rapporto r : stats.generaRapporti())
		   		 System.out.println(r);
	    }
	    
	    @Test
	    void testGeneraRapporti2()
	    {
		   	 System.out.println("=== testGeneraRapporti2 ===");
		   	 Rapporto r = stats.generaRapporti(new AnalizzatoreSesso().getTipo()).get(0);
		   	 System.out.println(r);
		   	 assertEquals(r.toString(), "{SESSO={F=26, M=288}}");
	    }

	    @Test
	    void testGeneraRapporti3()
	    {
	   	 	System.out.println("=== testGeneraRapporti3 ===");
	        // questa classe sara’ creata da me (createne una semplice)
	   	 	stats.add(new AnalizzatoreSegretoSegretissimo());
	   	 	for (Rapporto r : stats.generaRapporti(new AnalizzatoreSegretoSegretissimo().getTipo(), new AnalizzatoreSegretoSegretissimo().getTipo()))
	   	 		System.out.println(r);
	    }

}
