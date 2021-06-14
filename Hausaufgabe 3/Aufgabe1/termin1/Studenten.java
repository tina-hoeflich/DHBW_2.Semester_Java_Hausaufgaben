
package termin1;

/**
 * @author Tina Höflich
 *Klasse, um Studenten anhand von persönlicher Daten zu verwalten
 */
import java.time.LocalDate; //Für das aktuelle Datum
import java.util.Scanner; //Scanner um Eingaben einzulesen

/**
 * Klasse für Studentendaten
 * @author Tina Höflich
 *
 */
public class Studenten {

	/**
	 * @param args keine
	 * @param studentenZaehler zaehlt die Studenten, um die Martikelnummer zu generieren
	 * @param name Nachname des Studenten
	 * @param vorname Vorname des studenten
	 * @param matrnr Martikelnummer
	 * @param immatrikulationsDat Datum der Immatrikulation
	 * @param exmatrikulationsDat Datum der Exmatrikulation
	 * @param adresse Adresse bestehend aus Straße Or und Postleitzahl
	 * @param list Liste der angelegten Studenten
	 * 
	 */
	 
	static int studentenZaehler = 0;
	public Studenten() {
	}
	private String name;
	private String vorname;
	private int matrnr = 000000000;
	private String immatrikulationsDat;
	private String exmatrikulationsDat = "";
	Adresse adresse;
	/**
	 * Konstruktor der Klasse Studenten
	 * @param name
	 * @param vorname
	 * @param matrnr
	 * @param immatrikulationsDat
	 * @param exmatrikulationsDat
	 * @param adresse
	 */
	public Studenten (String name, String vorname, int matrnr, String immatrikulationsDat, String exmatrikulationsDat , Adresse adresse)
	{
		
		this.name = name;
		this.vorname = vorname;
		this.matrnr = matrnr;
		this.immatrikulationsDat= immatrikulationsDat;
		this.exmatrikulationsDat = exmatrikulationsDat;
		this.adresse = adresse;
		
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getVorname()
	{
		return vorname;
	}
	public void setVorame(String vorname)
	{
		this.vorname = vorname;
	}
	public int getMatrnr()
	{
		return matrnr;
	}
	public void setMatrnr(int matrnr)
	{
		this.matrnr = matrnr;
	}
	/**
	 * Methode, um eine neunstellige Matrikelnumemr zu generieren, diese beginnt bei eins und zählt immer weiter hoch
	 * @param Nummer Zahl an studenten die bis jetzt angelegt wurden
	 * @return Matrikelnummer 
	 */
	public static int generateMatrnr(int Nummer)
	{
		int matrnr = Nummer + 1;
		return matrnr;
	}
	public void setImmatrikulationsDat()
	{
		immatrikulationsDat = setDatum();
	}
	public String getImmatrikulationsDat()
	{
		return immatrikulationsDat;
	}
	public String getExmatrikulationsDat()
	{
		return exmatrikulationsDat;
	}
	/**
	 * 
	 * Klasse für adressen bestehend aus Plz, Straße und Wohnort
	 *
	 */
	public static class Adresse 
	{
		private int plz;
		private String straße;
		private String ort;
		/**
		 * Konstruktor der Klasse adresse 
		 * @param plz
		 * @param straße
		 * @param ort
		 */
		public Adresse ( int plz,  String straße,  String ort)
		{
			this.plz = plz;
			this.straße = straße;
			this.ort = ort;
			
		}
		
		public Adresse() {
			// TODO Auto-generated constructor stub
		}
		public int getplz()
		{
			return plz;
		}
		public void setPlz(int plz)
		{
			this.plz = plz;
		}
		public String getStraße()
		{
			return straße;
		}
		public void setStraße(String straße)
		{
			this.straße = straße;
		}
		public String getOrt()
		{
			return ort;
		}
		public void setOrt(String ort)
		{
			this.ort = ort;
		}
	}
	/**
	 * Methode, um das Aktuelle Datum auszugeben
	 * @return date
	 */
	public static String setDatum()
	{
		LocalDate datetemp = LocalDate.now();
		String date = datetemp.toString();
        return date;
	}
	/**
	 * Methode, um das Datum bei Exmatirikulation zu setzen
	 * @param student student der exmatrikuliert werden soll
	 * @return student mit eingetragnenm datum
	 */
	public static Studenten exmatrikulieren(Studenten student)
	{
		student.exmatrikulationsDat = setDatum();
		System.out.println("Exmatrikulationsdatum: " + student.immatrikulationsDat);
		return student;
	}
	
	/**
	 * Mathode um einen Studenten anzulegen. Daten werden durch einlesen erfasst
	 * @return Student 
	 */
	public static Studenten studentAnlegen()
	{
		 //Daten einscannen
		Scanner scan = new Scanner(System.in);
		Studenten student1 = new Studenten();
		System.out.println( "Vorname: " );
		student1.vorname = scan.nextLine();
		System.out.println( "Nachname: " );
		student1.name = scan.nextLine();
		System.out.println( "Adresse:  Straße:" );
		Studenten.Adresse adr= new Adresse ();
		adr.straße = scan.nextLine();
		System.out.println( "Adresse: Ort:" );
		adr.ort = scan.nextLine();
		System.out.println( "Adresse:  Plz:" );
		adr.plz = scan.nextInt();
		student1.adresse = adr;
		student1.immatrikulationsDat = setDatum();
		System.out.println("Immatrikulationsdatum: " + student1.immatrikulationsDat);
		student1.matrnr = Studenten.generateMatrnr(studentenZaehler);
		
		System.out.println("Neue/r Student/ Studentin: ");//ausgeben 		
		studentAusgeben( student1); 
		StudentenListe.list[studentenZaehler] = student1;
		studentenZaehler += 1;
		return student1;
	}
	/**
	 * Methoder um Daten eines Studenten auf einer Konsole auszugeben
	 * @param student
	 */
	public static void studentAusgeben(Studenten student)
	{
		if (student == null)
		{
			System.out.println("Liste ist an dieser Stelle leer");
		}
		else
		{
		System.out.println(student.vorname +" "+ student.name +"\n" + student.adresse.straße +"\n" +student.adresse.plz +" " +  student.adresse.ort );
		System.out.println("Immatrikulationsdatum: " + student.immatrikulationsDat);
		
		System.out.printf("Matrikelnummer: %09d: ", student.matrnr);
		System.out.println("\n");
		}
	}
	
}


