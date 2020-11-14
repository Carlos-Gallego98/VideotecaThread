import java.util.Random;

public class Vendedor extends Thread {
	public Cola cola;
	private Random aleatorio=new Random();
	
	public Vendedor(Cola cola) {
		this.cola = cola;
	}
	
	public void run() {
		
		System.out.println("VENDEDOR INICIO");
		for (int i=0; i<100; i++) {
			int minutos=aleatorio.nextInt(320);
			Pelicula p = new Pelicula(i,minutos);
			System.out.println("He creado la pelicula "+p.getId());
			cola.put(p);
		}
		System.out.println("VENDEDOR FIN");
	}
}
