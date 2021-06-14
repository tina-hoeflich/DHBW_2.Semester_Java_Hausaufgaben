
package termin1;

import java.util.Scanner;
/**
 * Anwendung um die Klasse Studenten zu testen
 *
 * @author Tina Höflich
 *
 */
public class TestStudenten extends Studenten {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Test der Studentenklasse, indem mehrere Studenten angelegt werden
		
			String abfrage ="";
			Scanner scan = new Scanner(System.in);
			while (abfrage != " ") 
			{
				int vergleichnummer;
				Studenten gesStudent;
				
				System.out.println("\n\nMenue: \n a.Student anlegen \n b.Student exmatrikulieren \n Leertaste: Abbruch\n ");
				
				abfrage = scan.nextLine();
				
				switch(abfrage)
				{
				case "a":
					Studenten student = new Studenten();
					student = studentAnlegen(); 
					break;
				case "b":
					Scanner scan1 = new Scanner(System.in);
					System.out.println("Matrikelnummer: ");
					vergleichnummer = scan1.nextShort();
					int arrayindex =  StudentenListe.getStudent(vergleichnummer);
					gesStudent = StudentenListe.list[arrayindex];
					assert( gesStudent.getExmatrikulationsDat() == "") : "Nicht immatrikuliert";
					exmatrikulieren(gesStudent);
					
					break;
				case " ":
					return ;
				default:
					break;
					
				}
			}
			
			
		}
	}


