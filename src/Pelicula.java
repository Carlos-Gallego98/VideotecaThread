
public class Pelicula {
	private int id;
	private int minutos;
	
	public Pelicula(int id, int minutos) {
		this.id=id;
		this.minutos=minutos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMinutos() {
		return minutos;
	}

	public void setMinutos(int minutos) {
		this.minutos = minutos;
	}
}
