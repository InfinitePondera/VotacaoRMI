package Runnable;

import Impl.ServerImpl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ElectionServer {
    public static void main(String[] args) {
        try {
            ServerImpl server = new ServerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("ElectionServer", server);
            System.out.println("Servidor RMI iniciado.");
            while (true) {
                Thread.sleep(5000);
                server.displayVoteCount(server.countVotes());
            }
        } catch (Exception e) {
            System.err.println("Erro no servidor: " + e);
            e.printStackTrace();
        }
    }
}
