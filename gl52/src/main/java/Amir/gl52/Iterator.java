package Amir.gl51;

public interface Iterator<T> {
	boolean hashNext();
	T next();
	void remove();
}