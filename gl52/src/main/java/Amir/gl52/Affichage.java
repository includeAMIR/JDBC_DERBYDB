package Amir.gl51;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Affichage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 821891992194259070L;
	private ArrayList<InterfacePersonnel> groupe;
	public Affichage(InterfacePersonnel tete) {
		this.groupe = new ArrayList<InterfacePersonnel>();
		groupe.add(tete);
	}
	private class GroupeIterator implements Iterator<Object>{
		private int count = 0;
		
		
		public GroupeIterator() {
			for(int i=0; i<groupe.size();i++) {
				if(groupe.get(i) instanceof CompositePersonnel) {
					/*for(InterfacePersonnel ip : groupe.get(i).getPersonnel()) {
						groupe.add(ip);
					}*/
				}
			}
		}
		public Iterator getIterator() {
			return new GroupeIterator();
		}
		public InterfacePersonnel next() {
			// TODO Auto-generated method stub
			if(this.hashNext()) {
				return groupe.get(count++);
			}
			return null;
		}
		public boolean hashNext() {
			// TODO Auto-generated method stub
			if(count<groupe.size()) return true;
			return false;
		}
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	public Affichage SerialReader(String path) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(path);
		Affichage Aff = null;
		try {
			@SuppressWarnings("resource")
			ObjectInputStream read = new ObjectInputStream(file);
			Aff = (Affichage)read.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Aff;
	}
	public void SerialWriter(String path) throws FileNotFoundException,IOException {
		FileOutputStream file = new FileOutputStream(path);
		try {
			ObjectOutputStream write = new ObjectOutputStream(file);
			write.writeObject(this);
			write.flush();
			write.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
