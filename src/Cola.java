import java.util.ArrayList;

public class Cola {
	
	ArrayList<Pelicula> buffer = new ArrayList<Pelicula>();
	
	public synchronized Pelicula get() {
		while (buffer.isEmpty()) {
			try {
				wait(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Pelicula p= buffer.remove(0);
		notify();
		return p;
	}
	
	public synchronized void put(Pelicula value) {
		buffer.add(value);
		notify();
	}
	
	public synchronized boolean isEmpty() {
		return buffer.isEmpty();
	}
}
