
public class Empacador extends Thread {

	Bodega bodega;

	public Empacador(Bodega b){
		this.bodega = b;
	}

	public void run(){

		while(true){

			int timeEntre = (int) (Math.random() * 10);
			System.out.println("Empacador  empacando paquete por " + timeEntre + " segundos");

			try {
				bodega.empacar();
			}catch (InterruptedException ex) {
			}

			try {
				sleep(timeEntre * 100);
			} catch (InterruptedException e) {
			}

			System.out.println("Empacador  empaco paquete exitosamente");
		}

	}

}
