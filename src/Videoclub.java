
public class Videoclub {
	// Declaracion de variables
    // tipos de personas
    public static final int NUMERO_COMPRADORES=8;
    public static final int NUMERO_VENDEDORES=1;
    public static Thread [] compradores=new Thread[NUMERO_COMPRADORES];
    public static Thread [] vendedores=new Thread[NUMERO_VENDEDORES];
    
    // las colas
    private static Cola cola;
    
	public static void main(String[] args) throws InterruptedException {
		System.out.println("VIDEOTECA INICIO");
		cola=new Cola();
		
    	System.out.println("INICIO VENDEDORES");
    	for (int i=0; i<NUMERO_VENDEDORES; i++) {
    		vendedores[i]=new Vendedor(cola);
    		vendedores[i].start();
    	}
    	
    	System.out.println("INICIO COMPRADORES");
    	for (int i=0; i<NUMERO_COMPRADORES; i++) {
    		compradores[i]=new Comprador(cola,i);
    		compradores[i].start();
    	} 
    	
    	System.out.println("VIDEOTECA ESPERO A QUE ACABEN LOS VENDEDORES");
    	for (int i=0; i<NUMERO_VENDEDORES; i++) {
    		vendedores[i].join();
    	}
    	
    	System.out.println("VIDEOTECA ESPERO A QUE ACABEN LAS PELICULAS");
    	
    	while (!cola.isEmpty()) {
    		Thread.sleep(1);
    	}
    	System.out.println("VIDEOTECA ESPERO A QUE ACABEN LOS COMPRADORES");
    	 	
    	for (int i=0; i<NUMERO_COMPRADORES; i++) {
    		compradores[i].interrupt();
    		compradores[i].join();
    	}    	
    	System.out.println("VIDEOTECA FIN");

	}

}
