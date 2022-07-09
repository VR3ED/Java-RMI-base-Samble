import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	//6: si crea il main del client
	public static void main(String[] args) {
		try {
			//7: si inizializza il registro
			Registry registro = LocateRegistry.getRegistry(6969);
			//8: si preleva il servizio dal registry
			ICurrencyConverter skeleton = (ICurrencyConverter) registro.lookup("CurrencyServer");
			//9: si posso usare nel client tutti i metodi dell'implementazione del serve
			System.out.println( skeleton.toEur(1)+"" );
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
