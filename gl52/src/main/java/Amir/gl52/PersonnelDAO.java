package Amir.gl51;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

public class PersonnelDAO extends DAO<Personnel> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7493448686678914037L;
	private ArrayList<Personnel> groupe = new ArrayList<Personnel>();
	
	public Personnel create(Personnel per, String path) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		groupe.add(per);
		this.SerialWriter(path);
		
		return null;
	}
	public Personnel read(String path) throws FileNotFoundException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return this.SerialReader(path);
	}
	@SuppressWarnings("unchecked")
	public void update(Personnel p, String path) {
		// TODO Auto-generated method stub
		Personnel p2 = null;
		String nom = p.getNom();
		String prenom = p.getPrenom();
		String fonction = p.getFonction();
		java.time.LocalDate dateN = p.getDate_naissance();
		ArrayList<String> num = p.getNumero_tel();
		groupe.remove(p);
		p2 = (Personnel) new Personnel.Builder(nom, prenom, fonction, dateN).AddAllNum(num).build();
		delete(p, path);
		groupe.add(p2);
		try {
			p2.SerialWriter(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete(Personnel p, String path) {
		groupe.remove(p);
		File f = new File(path);
		f.delete();
		// TODO Auto-generated method stub
	}


}
