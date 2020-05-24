package Amir.gl51;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class CompositePersonnelDAO extends DAO<CompositePersonnel> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4167312234762053696L;
	private ArrayList<CompositePersonnel> composite = new ArrayList<CompositePersonnel>();
	@Override
	public CompositePersonnel create(CompositePersonnel obj, String path) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		composite.add(obj);
		this.SerialWriter(path);
		return obj;
	}

	@Override
	public CompositePersonnel read(String path) throws FileNotFoundException, ClassNotFoundException {
		return this.SerialReader(path);
	}

	@Override
	public void update(CompositePersonnel obj, String path) {
		// TODO Auto-generated method stub
		if(!composite.isEmpty()) {
			@SuppressWarnings("unchecked")
			ArrayList<CompositePersonnel> cp = composite;
			for(CompositePersonnel p : cp) {
				obj.Add(p.getGroupePersonnel());
				try {
					SerialWriter(path);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delete(CompositePersonnel cp, String path) {
		// TODO Auto-generated method stub
		composite.remove(cp);
		File f = new File(path);
		f.delete();	
	}

}
