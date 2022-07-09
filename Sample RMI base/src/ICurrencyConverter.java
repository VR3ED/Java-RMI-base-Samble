import java.rmi.Remote;
import java.rmi.RemoteException;

//1 estende remote
public interface ICurrencyConverter extends Remote{
	//2 i metodi fanno throws
	float toEur(float usd) throws RemoteException;
	float toUSD(float eur)  throws RemoteException;
}
