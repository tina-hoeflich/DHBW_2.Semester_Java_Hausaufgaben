
package termin1;
/**
 * 
 * Anwendung, um die Klasse Studenten Liste auf Ihre Funktionablität zu testen
 * 
 * @author Tina Höflich
 *
 */
public class StudentenListeTest extends StudentenListe {

	/**
	 * Methode, um die Liste mit Einträgen zum Testen befüllen
	 * Dafür werden konstruktoren aufgerufen der Klasse Adresse und Studenten
	 */
	public static void listeBefuellen()
	{
		Adresse adr1 = new Adresse(70327, "Mozartstraße", "Stuttgart");
		Studenten student1  = new Studenten("Karl","Gustav", generateMatrnr(studentenZaehler), setDatum(),"", adr1);
		studentAufnehmen(student1);
		studentAusgeben(student1);
		Adresse adr2 = new Adresse(70327, "Ludwigstraße", "Stuttgart");
		Studenten student2  = new Studenten("Hannah","Muelller", generateMatrnr(studentenZaehler), setDatum(),"", adr2);
		studentAufnehmen(student2);
		studentAusgeben(student2);
		
		
	}
	/**
	 * 
	 * Methode, um die Klasse StudentenListe zu testen
	 * @param args keine
	 */
	public static void main(String[] args) 
	{
		System.out.println("Liste wird mit 2 Einträgen befüllt: ");
		listeBefuellen();
		System.out.println("\nEs wird überprueft ob ein Student existiert. In dem Fall der zweite Eintrag in der Liste");
		studentUeberpruefen(list[1]);
		System.out.println("\nSuchen eines Eintrages in der Liste:");
		studentSuchen();
		System.out.println("\nStudent löschen: ");
		studentLoeschen(list[1]);
		System.out.println("Ausgaben der Liste an der Stelle des gelöschten Eintrags: ");
		studentAusgeben(list[1]);
		
	}

}
