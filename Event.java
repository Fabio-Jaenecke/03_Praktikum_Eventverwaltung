
/**
 * Die Klasse erstellt ein Event mit der Möglichkeit Eventtickets zu kaufen.
 * Das Event enthält einen Künstler und dessen Gage, 3 Ticketkategorien und
 * Berechnungen zur Bilanz.
 *
 * @author (jaenefab)
 * @version (1.0)
 */
public class Event
{
    private String bezeichnung;
    private int gage;
    private int gesamteinnahme; //benötigt für die Berechnung der Gesamteinnahmen.
    private int gewinn; //benötigt für die Berechnung des Gewinns.
    private Ticketkategorie kategorie1; 
    private Ticketkategorie kategorie2;
    private Ticketkategorie kategorie3;

    /**
     * Constructor erstellt ein Event.
     */
    public Event()
    {
        kategorie1 = new Ticketkategorie(1000, 25, "VIPticket");
        kategorie2 = new Ticketkategorie(95, 1000, "Tribuenenticket");
        kategorie3 = new Ticketkategorie(49, 500, "Innenraumticket");
    }
    
    /**
     * Constructor erstellt ein Event mit Künstler und dessen Gage.
     */
    public Event(String kuenstlerbezeichnung, int gagenbetrag)
    {
        bezeichnung = kuenstlerbezeichnung;
        gage = gagenbetrag;
        kategorie1 = new Ticketkategorie(1000, 25, "VIPticket");
        kategorie2 = new Ticketkategorie(95, 1000, "Tribuenenticket");
        kategorie3 = new Ticketkategorie(49, 500, "Innenraumticket");
    }

    /**
     * Ermöglicht das hinzufügen oder ändern des Künstlers und dessen Gage.
     */
    public void setzeKuenstler(String kuenstlerbezeichnung, int gagenbetrag){
        bezeichnung = kuenstlerbezeichnung;
        gage = gagenbetrag;
    }
    
    /**
     * Gibt dem Benutzer die Möglichkeit tickets aller 3 Kategorien zu kaufen.
     */
    public void kaufeTickets(int anzahlVIPTickets, int anzahlTribuenenTickets, int anzahlInnenRaumTickets){
        kategorie1.setzeAnzahl(anzahlVIPTickets);
        kategorie2.setzeAnzahl(anzahlTribuenenTickets);
        kategorie3.setzeAnzahl(anzahlInnenRaumTickets);
    }
    
    
    /**
     * Berechnet und gibt die Gesamteinnahmen des Events
     */
    private int gibGesamtEinnahme(){
        gesamteinnahme = kategorie1.gibEinnahmen() + kategorie2.gibEinnahmen() + kategorie3.gibEinnahmen();
        return gesamteinnahme;
    }
    
    /**
     * Berechnet und gibt den Gesamtgewinn des Events
     */
    private int gibGesamtGewinn(){
        gewinn = gesamteinnahme - gage;
        return gewinn;
    }
    
     /**
     * Output der Eventbilanz
     */
    public void output(){
        System.out.println("Künstler: " + bezeichnung + ", Gage: CHF " + gage);
        System.out.println("VIP-Tickets: " + kategorie1.gibAnzahl() + " von " + kategorie1.gibLimit() + " verkauft, Einnahmen: CHF " + kategorie1.gibEinnahmen());
        System.out.println("Tribuene-Tickets: " + kategorie2.gibAnzahl() + " von " + kategorie2.gibLimit() + " verkauft, Einnahmen: CHF " + kategorie2.gibEinnahmen());
        System.out.println("Innenraum-Tickets: " + kategorie3.gibAnzahl() + " von " + kategorie3.gibLimit() + " verkauft, Einnahmen: CHF " + kategorie3.gibEinnahmen());    
        System.out.println("Gesamteinnahmen: CHF " + gibGesamtEinnahme());
        System.out.println("Gewinn: CHF " + gibGesamtGewinn());
    }
}
