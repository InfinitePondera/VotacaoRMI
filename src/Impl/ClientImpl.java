package Impl;
import Interface.ClientInterface;
import Interface.ServerInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {
    private ServerInterface server;

    public ClientImpl(ServerInterface server) throws RemoteException {
        super();
        this.server = server;
    }

    public void sendVote(String candidateName, int numVotes) throws RemoteException {
        server.receiveVote(candidateName, numVotes);
    }

}

