package Amir.gl51;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

public abstract class  DAO<T> {
	public abstract T create(T obj, String path) throws FileNotFoundException, IOException;
	public abstract T read(String path) throws FileNotFoundException, ClassNotFoundException;
	public abstract void update(T obj, String path);
	public abstract void delete(T obj, String path);
	@SuppressWarnings("unchecked")
	public T SerialReader(String path) throws FileNotFoundException, ClassNotFoundException {
		FileInputStream file = new FileInputStream(path);
		T obj = null;
		try {
			@SuppressWarnings("resource")
			ObjectInputStream read = new ObjectInputStream(file);
			obj = (T)read.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
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
