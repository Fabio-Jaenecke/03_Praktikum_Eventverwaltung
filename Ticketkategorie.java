
/**
 * Hier werden die Ticketkategorien definiert und wie welche Tickets gekauft
 * werden können. Jede Kategorie hat eine Kategoriebezeichnung, einen Ticketpreis,
 * eine Anzahl gekaufter Tickets, ein Limit mit der maximalen Anzahl verfügbarer
 * Tickets und 
 *
 * @author (jaenefab)
 * @version (1.0)
 */
public class Ticketkategorie
{
    private String bezeichnung;
    private int preis;
    private int anzahl;
    private int limit;
    private int einnahmen;

    /**
     * Constructor erstellt das Objekt Ticketkategorie.
     * Dieses Objekt kann eine der 3 Ticketkategorien annehmen.
     */
    public Ticketkategorie(int kategoriepreis, int kategorielimit, String kategoriebezeichnung)
    {
        preis = kategoriepreis;
        limit = kategorielimit;
        bezeichnung = kategoriebezeichnung;
        anzahl = 0;
    }
    
    /**
     * Erlaubt es dem Benutzer eine Anzahl Tickets einzugeben.
     * 
     * Sind keine Tickets mehr verfügbar erhält der Benutzer die Meldung 'Ausverkauft'.
     * Möchte der Benutzer mehr Tickets kaufen als dass verfügbar sind, 
     * erhält er die Meldung das keine Tickets mehr in dieser Anzahl verfügbar sind.
     * 
     * Setze die neue Anzahl verkaufter Tickets, falls keine Limitüberschreitung
     * stattgefunden hat.
     */
    public void setzeAnzahl(int kaufeTicketAnzahl)
    {
        if (anzahl == limit){
           System.out.println("Es sind bereits alle " + bezeichnung + "s ausverkauft.");
        }
        if ((anzahl + kaufeTicketAnzahl) >= limit){
           System.out.println("Es sind leider keine " + bezeichnung + "s in dieser Anzahl verfügbar.");
        }
        else {
           anzahl = anzahl + kaufeTicketAnzahl;
        }
    }
    
    /**
     * Berechnet und gibt die Einnahmen pro Ticketkategorie.
     */
    public int gibEinnahmen()
    {
        einnahmen = anzahl * preis;
        return einnahmen;
    }
    
     /**
     * Gibt die aktuelle Anzahl Tickets pro Ticketkategorie zurück.
     */
        public int gibAnzahl(){
        return anzahl;
    }
    
    /**
     * Gibt das aktuelle Limit verfügbarer Tickets pro Ticketkategorie zurück.
     */
    
    public int gibLimit(){
        return limit;
    }
}
