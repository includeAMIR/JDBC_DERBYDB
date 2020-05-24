package Amir.gl51;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public final class Personnel implements InterfacePersonnel, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3346618793526508976L;
	/**
	 * 
	 */
	private final String nom;
	private final String prenom;
	private final String fonction;
	private final LocalDate date_naissance;
	private final ArrayList<String>numero_tel;
	public Personnel getPersonnel() {
		return this;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public LocalDate getDate_naissance() {
		return date_naissance;
	}
	public ArrayList<String> getNumero_tel() {
		return numero_tel;
	}
	
	public static class Builder{
		private final String nom;
		private final String prenom;
		private final String fonction;
		private final LocalDate date_naissance;
		private final ArrayList<String>numero_tel = new ArrayList<String>();
		
		public Builder(String nom, String prenom, String fonction, LocalDate date_naissance){
			this.nom = nom;
			this.prenom = prenom;
			this.fonction = fonction;
			this.date_naissance = date_naissance;
		}
		public Builder Add_num(String nouveau_num) {
			this.numero_tel.add(nouveau_num);
			return this;
		}
		public Builder AddAllNum(ArrayList<String> nouveau_num) {
			this.numero_tel.addAll(nouveau_num);
			return this;
		}
		public Personnel build() {
			return new Personnel(this);
		}
	}
	public Personnel(Builder build) {
		this.nom = build.nom;
		this.prenom = build.prenom;
		this.fonction = build.fonction;
		this.date_naissance = build.date_naissance;
		this.numero_tel = build.numero_tel;
	}
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("	nom: "+ this.nom+"\n	prenom: "+this.prenom+"\n	fonction: "+this.fonction+"\n	date_naissance: "+this.date_naissance);
		System.out.println("	contact :");
		for(String num : this.numero_tel) {
			System.out.println("	"+num);
		}
		System.out.println("****************************************************");
	}
	public Personnel SerialReader(String path) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(path);
		Personnel p = null;
		try {
			@SuppressWarnings("resource")
			ObjectInputStream read = new ObjectInputStream(file);
			p = (Personnel)read.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
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
