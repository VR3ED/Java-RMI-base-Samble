import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements ICurrencyConverter{

	public Server() throws RemoteException {
		super();
	}

	//3: implementare metodi 
	@Override
	public float toEur(float usd) throws RemoteException {
		return usd*0.95f;
	}

	@Override
	public float toUSD(float eur) throws RemoteException {
		return eur*1.06f;
	}
	
	public static void main(String[] args) {
		try {
			Server obj = new Server();
			//4: nel try inizializzare stub e registry (qeusto va' fatto se volgiamo avere una classe server separate dall'oggetto che implementa l'interfaccia)
			//ICurrencyConverter stub = (ICurrencyConverter) UnicastRemoteObject.exportObject(obj,6969);
			Registry registro = LocateRegistry.createRegistry(6969);
			
			//5: fai il rebind per registrare il servizio online 
			registro.rebind("CurrencyServer",obj); //il secondo parametro sarebbe stub  se volgiamo avere una classe server separate dall'oggetto che implementa l'interfaccia
			System.out.println("servizio online");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}


}
