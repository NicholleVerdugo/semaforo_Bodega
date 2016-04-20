
public class Descargador extends Thread {

	Bodega bodega;

	public Descargador(Bodega b) {
		this.bodega = b;
	}

	public void run() {

		while (true) {

			int timeDes = (int) (Math.random() * 10);
			int tipo = (int) (Math.random()* 2)+1;

			System.out.println("Descargador descargando paquete " +tipo+ " por " + timeDes + " segundos");

			try {
				sleep(timeDes * 100);
			} catch (InterruptedException e) {
			}

			try {
				bodega.descargar(tipo);
			} catch (InterruptedException ex) {
			}

			System.out.println("Cocinero descargo paquete tipo "+tipo);
		}
	}
}
