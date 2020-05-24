package Amir.gl52;

public interface Iterator<T> {
	boolean hashNext();
	T next();
	void remove();
}