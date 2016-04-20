

public class Programa {

	public static void main(String main[]) {

		Bodega bodega = new Bodega();

		Descargador pEmpacador = new Descargador(bodega);
		Empacador pMensajero = new Empacador(bodega);


		pEmpacador.start();
		pMensajero.start();

	}
}
