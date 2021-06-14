
package termin1;

import java.util.Scanner;

import termin1.Studenten.Adresse;
/**
 * Klasse um angelegte Studenten in einer Liste mit Objekten der Klasse Studenten zu verwalten
 * @author Tina Höflich
 *
 */
public class StudentenListe extends Studenten{
	
	static final int MAX = 50; //Maximum an Stuudenten in der Liste
	static Studenten list [] = new Studenten [MAX]; 
	/**
	 * Methode, um Studenten anhand der Matrielnummer zu finden
	 * @param verglNummer Matrikelnummer zum abgleichen mit angelegten Studenten
	 * @return student der gesucht wurde
	 */
	public static int getStudent(int verglNummer)
	{
		
		for (int i = 0; i < MAX ; i++)
		{
			int Matrikelnummer = list[i].getMatrnr();
			if (Matrikelnummer ==  verglNummer)
			{
				System.out.println("Matrikelnummer: " + list[i].getMatrnr());
				return i;
			}
			
		}
		return 0;
	}
	/**
	 * 
	 * Methode, um einen Studenten zu finden und dann zu löschen
	 * @param student Stdent der aus der Liste gelöscht werdd
	 */
	public static void studentLoeschen(Studenten student)
	{
		Studenten gefStudent = new Studenten();
		int i = 0;
		while(list[i] != null)
		{
			gefStudent = list[i];
			
			if ((gefStudent.getMatrnr() == student.getMatrnr()) && 
					(gefStudent.getName().equals(student.getName()) == true && 
					(gefStudent.getVorname().equals(student.getVorname()) == true)))
			{
				int j = i; //index auf den Index des zu Löschenden Eintrags
				//wenn letzter Eintrag in der Liste
				if(list[j+1] == null)
				{
					list[j] = null;
				}
				
				while(list[j+1] != null)
				{
					//löschen des Eintrages und verschieben der darauffolgenden Einträge um -1
					list[j] = list[j+1];
					System.out.println(list[j].getVorname() +" wird zu " + list[j+1].getVorname());
					j++;
				}
				System.out.println("Folgender Eintrag wurde geloescht:");
				studentAusgeben(gefStudent);
			}
			else if((gefStudent.getMatrnr() != student.getMatrnr()) && 
					(gefStudent.getName().equals(student.getName()) == false && 
					(gefStudent.getVorname().equals(student.getVorname()) == false) && 
					(gefStudent.adresse.getOrt().equals(student.adresse.getOrt())) == false))
			{
				System.out.println("Student mit diesen Daten konnte nicht gefunden werden:");
				studentAusgeben(student);
			}
			i++;
		}
		

	}
	/**
	 * 
	 * Methode, um
	 * @return gefStudent oder gesStudent, je nach dem ob ein Student mit den eingegebene Staten existiert
	 */
	public static void studentSuchen()
	{
		//Suchobjekt anlegen
		System.out.println("\nBekannte Daten eingeben: \n(wenn unbekanntes Textfeld: Leertaste + Enter bei unbekannter Matrnr: 0 eingeben)" );
		Scanner scan = new Scanner(System.in);
		Studenten gesStudent = new Studenten();
		System.out.println( "Vorname: " );
		String temp =scan.nextLine(); 
		gesStudent.setVorame(temp); 
		System.out.println( "Nachname: " );
		gesStudent.setName(scan.nextLine());
		System.out.println( "Matrikelnummer: " );
		gesStudent.setMatrnr(Integer.parseInt(scan.nextLine()));
		System.out.println( "Ort:" );
		Studenten.Adresse adr= new Adresse ();
		gesStudent.adresse = adr;
		adr.setOrt(scan.nextLine());
		scan.close();
		Studenten gefStudent;
		int i = 0;
		while(list[i] != null)
		{
			gefStudent = list[i];
			if ((gefStudent.getMatrnr() == gesStudent.getMatrnr()) || 
					(gefStudent.getName().equals(gesStudent.getName()) == true || 
					(gefStudent.getVorname().equals(gesStudent.getVorname()) == true) ||
					gefStudent.adresse.getOrt().equals(gesStudent.adresse.getOrt()) == true))
			{
				System.out.println("gefunden: \n " );
				studentAusgeben(gefStudent);
				
			}
			else if((gefStudent.getMatrnr() != gesStudent.getMatrnr()) && 
					(gefStudent.getName().equals(gesStudent.getName()) == false && 
					(gefStudent.getVorname().equals(gesStudent.getVorname()) == false) && 
					(gefStudent.adresse.getOrt().equals(gesStudent.adresse.getOrt())) == false))
			{
				System.out.println("Student mit diesen Daten konnte nicht gefunden werden:");
				studentAusgeben(gesStudent);
			}
			i++;
		}
	}
	/**
	 * 
	 * Methode, um zu überpruefn, ob ein Student schon existiert
	 * @param gesStudent
	 * @return true wenn er schon existiert
	 */
	public static boolean studentUeberpruefen(Studenten gesStudent)
	{
		System.out.println("Student/in " + gesStudent.getVorname() +" "+ gesStudent.getName() + " wird überprueft");
		Studenten gefStudent;
		for (int i = 0; i < MAX ; i++)
		{
			
			gefStudent = list[i];
			if ((gefStudent.getMatrnr() == gesStudent.getMatrnr()) && 
					(gefStudent.getName().equals(gesStudent.getName()) == true && 
					(gefStudent.getVorname().equals(gesStudent.getVorname()) == true)))
			{
				System.out.println("Student/in existiert ");
				return true; //wenn er schon existeirt
				
			}
		}

		System.out.println("Student/in existiert noch nicht");
		return false;
	}
	/**
	 * 
	 * Methode, um einen neuen Studenten aufzunehmen in die Liste
	 * @pre der Student darf so noch nicht vorhanden sein
	 * @param student der aufgenommen werden soll
	 * @post der Student wurde in die Liste aufgenommen
	 */
	public static void studentAufnehmen(Studenten student)
	{
		assert ( studentUeberpruefen(student) == false) : "Existiert schon";
		
		list[studentenZaehler] = student;
		studentenZaehler += 1;
		
	}
		
	
	
}
