
public class Comprador extends Thread{
	private Cola cola;
	private int id;

	public Comprador(Cola cola, int id) {
		this.cola = cola;
		this.id = id;
	}

	public void run() {
		System.out.println("El comprador se pone a comprar");

		while (Boolean.TRUE) {
			try {
				Pelicula p = cola.get();
				System.out.println("Soy el comprador " + id + ", y compro la pelicula " + p.getId() + " de "+p.getMinutos()+" minutos");
				Thread.sleep(p.getMinutos());

			} catch (InterruptedException e) {
				System.out.println("Acabo de comprar " + id);
				return;
			}
		}
	}
}
