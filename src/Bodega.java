
import java.util.concurrent.Semaphore;


public class Bodega {

	private int cant;
	private int cant1;
	private int cant2;
	private Semaphore mutexA;
	private Semaphore mutexB;
	private Semaphore mutexCant;
	private Semaphore articulo1Disponible;
	private Semaphore articulo2Disponible;
	private Semaphore espacioDisponible;
	private Semaphore articuloDisponible;


	public Bodega() {
		cant = 0;
		mutexCant = new Semaphore(1);
		espacioDisponible = new Semaphore(200);
		articuloDisponible = new Semaphore(0);

		cant1 = 0;
		mutexA = new Semaphore(1);
		articulo1Disponible = new Semaphore(0);

		cant2 = 0;
		mutexB = new Semaphore(1);
		articulo2Disponible = new Semaphore(0);
	}

	public void descargar(int tipo) throws InterruptedException {
		if(tipo==1){
			espacioDisponible.acquire(10);

			mutexA.acquire();
			cant1++;
			mutexA.release();

			articulo1Disponible.release();

			mutexCant.acquire();
			cant+=10;
			mutexCant.release();

			articuloDisponible.release(10);
		}else if(tipo==2){
			espacioDisponible.acquire(15);

			mutexB.acquire();
			cant2++;
			mutexB.release();

			articulo2Disponible.release();

			mutexCant.acquire();
			cant+=15;
			mutexCant.release();

			articuloDisponible.release(15);
		} 
		System.out.println("Hay "+cant1+" articulos1 y "+cant2+" articulos2. Un volumen de "+cant);
	}

	public void empacar() throws InterruptedException {
		articulo1Disponible.acquire(3);
		articulo2Disponible.acquire(4);

		articuloDisponible.acquire(90);
		cant-=90;
		espacioDisponible.release(90);

		mutexA.acquire();
		cant1-=3;
		mutexA.release();

		mutexB.acquire();
		cant2-=4;
		mutexB.release();
		System.out.println("Hay "+cant1+" articulos1 y "+cant2+" articulos2. Un volumen de "+cant);
	}    
}
