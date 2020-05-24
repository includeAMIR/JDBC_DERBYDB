package Amir.gl51;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 2888135629406704383L;

	public static void main( String[] args ) throws FileNotFoundException, IOException
    {

    	Personnel marc = new Personnel.Builder("Ilya", "Arshavinn", "batal", LocalDate.of(1991, 9, 12)).Add_num("06 666").build();
    	Personnel doe = new Personnel.Builder("john", "doe", "batal", LocalDate.of(1991, 9, 12)).build();
    	Personnel hoover = new Personnel.Builder("edgar", "hoover", "batal", LocalDate.of(1991, 9, 12)).build();
    	Personnel angleton = new Personnel.Builder("james", "angleton", "batal", LocalDate.of(1991, 9, 12)).Add_num("07 67 54").build();
    	/*CompositePersonnel equipe = new CompositePersonnel();
    	equipe.Add(marc);
    	equipe.Add(doe);
    	equipe.Add(hoover);
    	equipe.Add(angleton);
    	equipe.print();
    	equipe.Add(angleton);
    	Affichage a = new Affichage(equipe);*/
    	marc.SerialWriter("./marc.ser");

    }
}
