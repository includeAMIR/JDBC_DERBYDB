package Amir.gl51;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class CompositePersonnel implements InterfacePersonnel,  Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4936862728143092331L;
	/**
	 * 
	 */
	private double ID;
	public CompositePersonnel(double ID) {
		this.ID = ID;
	}
	public CompositePersonnel() {
		// TODO Auto-generated constructor stub
	}
	private final ArrayList<InterfacePersonnel> groupe_personnel = new ArrayList<InterfacePersonnel>();
	
	public CompositePersonnel getGroupePersonnel() {
		return this;
	}
	public void print() {
		for(InterfacePersonnel groupe : this.groupe_personnel) {
			groupe.print();
		}
	}
	public void Add(InterfacePersonnel groupe) {
		if(groupe_personnel.contains(groupe)) 
			System.out.println("Already exist");
		else groupe_personnel.add(groupe);
	}
	public void Remove(InterfacePersonnel groupe) {
		if(groupe_personnel.contains(groupe)) 
			groupe_personnel.remove(groupe);
		else 
			System.out.println("not exist");
	}
	public double getId() {
		// TODO Auto-generated method stub
		return this.ID;
	}
	public CompositePersonnel SerialReader(String path) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(path);
		CompositePersonnel Composite = null;
		try {
			@SuppressWarnings("resource")
			ObjectInputStream read = new ObjectInputStream(file);
			Composite = (CompositePersonnel)read.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Composite;
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
