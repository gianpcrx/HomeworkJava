package it.uniroma1.lcl.studstats;

import java.util.Map;
/**
 * Descrive il risultato dell'Analizzatore tramite una Map.
 * @author gianpcrx
 *
 */
public class Rapporto {
	private Map<?, ?> map;
	public Rapporto(Map<?, ?> map) { this.map = map; }
	
	/**
	 * Restituisce una stringa rappresentante la Map memorizzata.
	 * @return Una stringa rappresentante la Map memorizzata.
	 */
	@Override
	public String toString() {
		return this.map.toString();
	}
}
